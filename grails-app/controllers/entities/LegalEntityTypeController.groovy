package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LegalEntityTypeController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        shortList: 'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond LegalEntityType.list(params), model:[legalEntityTypeInstanceCount: LegalEntityType.count()]
        } 
        else {
            respond LegalEntityType.findAllByRecStatus(params.recStatus, params), model:[legalEntityTypeInstanceCount: LegalEntityType.count()] 
        } 
    }
    
    def show(LegalEntityType legalEntityTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && legalEntityTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond legalEntityTypeInstance
    }

    def create() {
        respond new LegalEntityType(params)
    }

    @Transactional
    def save(LegalEntityType legalEntityTypeInstance) {
        if (legalEntityTypeInstance == null) {
            notFound()
            return
        }

        if (legalEntityTypeInstance.hasErrors()) {
            respond legalEntityTypeInstance.errors, view:'create'
            return
        }

        legalEntityTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'legalEntityTypeInstance.label', default: 'LegalEntityType'), legalEntityTypeInstance.id])
                redirect legalEntityTypeInstance
            }
            '*' { respond legalEntityTypeInstance, [status: CREATED] }
        }
    }

    def edit(LegalEntityType legalEntityTypeInstance) {
        respond legalEntityTypeInstance
    }

    @Transactional
    def update(LegalEntityType legalEntityTypeInstance) {
        if (legalEntityTypeInstance == null) {
            notFound()
            return
        }

        if (legalEntityTypeInstance.hasErrors()) {
            respond legalEntityTypeInstance.errors, view:'edit'
            return
        }

        legalEntityTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LegalEntityType.label', default: 'LegalEntityType'), legalEntityTypeInstance.id])
                redirect legalEntityTypeInstance
            }
            '*'{ respond legalEntityTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LegalEntityType legalEntityTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/legalEntityType/delete/2
        if (legalEntityTypeInstance == null) {
            notFound()
            return
        }
        legalEntityTypeInstance.recStatus="Deleted"
        legalEntityTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LegalEntityType.label', default: 'LegalEntityType'), legalEntityTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond legalEntityTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(LegalEntityType legalEntityTypeInstance) { 
        // example: http://localhost:9991/Commons/legalEntityType/undelete/2
        if (legalEntityTypeInstance == null) {
            notFound()
            return
        }
        legalEntityTypeInstance.recStatus="Active"
        legalEntityTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LegalEntityType.label', default: 'LegalEntityType'), legalEntityTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond legalEntityTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityTypeInstance.label', default: 'LegalEntityType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }  

    def shortList() {
        // example: <server:port>/Parties/legaEntity/shortList
        def legalEntityTypeInstance =  LegalEntityType.findAll()
        if (legalEntityTypeInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        legalEntityTypeInstance.each {
            result["$it.id"] = [ title:"$it.title", titleInt:"$it.titleInt", notes:"$it.notes"] 
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*' {render result as JSON}    
        }  
    }     
}
