package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LegalGroupController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        delete:'POST',
        undelete:'POST',
        undelete:'POST',
        shortList: 'GET',
        customeQuery: 'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond LegalGroup.list(params), model:[legalGroupInstanceCount: LegalGroup.count()]
        } 
        else {
            respond LegalGroup.findAllByRecStatus(params.recStatus, params), model:[legalGroupInstanceCount: LegalGroup.count()] 
        } 
    }
    
    def show(LegalGroup legalGroupInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && legalGroupInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond legalGroupInstance
    }

    def create() {
        respond new LegalGroup(params)
    }

    @Transactional
    def save(LegalGroup LegalGroupInstance) {
        if (LegalGroupInstance == null) {
            notFound()
            return
        }

        if (LegalGroupInstance.hasErrors()) {
            respond LegalGroupInstance.errors, view:'create'
            return
        }

        LegalGroupInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'LegalGroupInstance.label', default: 'LegalGroup'), LegalGroupInstance.id])
                redirect LegalGroupInstance
            }
            '*' { respond LegalGroupInstance, [status: CREATED] }
        }
    }

    def edit(LegalGroup LegalGroupInstance) {
        respond LegalGroupInstance
    }

    @Transactional
    def update(LegalGroup LegalGroupInstance) {
        if (LegalGroupInstance == null) {
            notFound()
            return
        }

        if (LegalGroupInstance.hasErrors()) {
            respond LegalGroupInstance.errors, view:'edit'
            return
        }

        LegalGroupInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LegalGroup.label', default: 'LegalGroup'), LegalGroupInstance.id])
                redirect LegalGroupInstance
            }
            '*'{ respond LegalGroupInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LegalGroup legalGroupInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/legalGroup/delete/2
        if (legalGroupInstance == null) {
            notFound()
            return
        }
        legalGroupInstance.recStatus="Deleted"
        legalGroupInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LegalGroup.label', default: 'LegalGroup'), legalGroupInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond legalGroupInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(LegalGroup legalGroupInstance) { 
        // example: http://localhost:9991/Commons/legalGroup/undelete/2
        if (legalGroupInstance == null) {
            notFound()
            return
        }
        legalGroupInstance.recStatus="Active"
        legalGroupInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LegalGroup.label', default: 'LegalGroup'), legalGroupInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond legalGroupInstance //, [status: NO_CONTENT] 
            }
        }
    }    
    
    def shortList() {
        // example: <server:port>/Commons/legalGroup/shortList
        def legalGroupInstance =  LegalGroup.findAll()
        if (legalGroupInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        legalGroupInstance.each {
            result["$it.id"] = [ title:"$it.title", titleInt:"$it.titleInt",  id:"$it.id", notes:"$it.notes"] 
        }
        withFormat{       
            html {render result as JSON}
            xml  {render  result as XML}
            '*' {render result as JSON}    
        }  
    }     

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'LegalGroupInstance.label', default: 'LegalGroup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
