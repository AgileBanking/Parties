package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LegalEntityController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        shortList:'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond LegalEntity.list(params), model:[legalEntityInstanceCount: LegalEntity.count()]
        } 
        else {
            respond LegalEntity.findAllByRecStatus(params.recStatus, params), model:[legalEntityInstanceCount: LegalEntity.count()] 
        } 
    }
    
    def show(LegalEntity legalEntityInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && legalEntityInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond legalEntityInstance
    }

    def create() {
        respond new LegalEntity(params)
    }

    @Transactional
    def save(LegalEntity legalEntityInstance) {
        if (legalEntityInstance == null) {
            notFound()
            return
        }

        if (legalEntityInstance.hasErrors()) {
            respond legalEntityInstance.errors, view:'create'
            return
        }

        legalEntityInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'legalEntityInstance.label', default: 'LegalEntity'), legalEntityInstance.id])
                redirect legalEntityInstance
            }
            '*' { respond legalEntityInstance, [status: CREATED] }
        }
    }

    def edit(LegalEntity legalEntityInstance) {
        respond legalEntityInstance
    }

    @Transactional
    def update(LegalEntity legalEntityInstance) {
        if (legalEntityInstance == null) {
            notFound()
            return
        }

        if (legalEntityInstance.hasErrors()) {
            respond legalEntityInstance.errors, view:'edit'
            return
        }

        legalEntityInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LegalEntity.label', default: 'LegalEntity'), legalEntityInstance.id])
                redirect legalEntityInstance
            }
            '*'{ respond legalEntityInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LegalEntity legalEntityInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/legalEntity/delete/2
        if (legalEntityInstance == null) {
            notFound()
            return
        }
        legalEntityInstance.recStatus="Deleted"
        legalEntityInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LegalEntity.label', default: 'LegalEntity'), legalEntityInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond legalEntityInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(LegalEntity legalEntityInstance) { 
        // example: http://localhost:9991/Commons/legalEntity/undelete/2
        if (legalEntityInstance == null) {
            notFound()
            return
        }
        legalEntityInstance.recStatus="Active"
        legalEntityInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LegalEntity.label', default: 'LegalEntity'), legalEntityInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond legalEntityInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    }    

    def shortList() {
        // example: <server:port>/Parties/legaEntity/shortList
        def legalEntityInstance =  LegalEntity.findAll()
        if (legalEntityInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        legalEntityInstance.each {
            result["$it.id"] = [ title:"$it.marketName", notes:"$it.notes"] 
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
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityInstance.label', default: 'LegalEntity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
