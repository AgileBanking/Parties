package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LegalPersonController extends BaseController {

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
            respond LegalPerson.list(params), model:[legalPersonInstanceCount: LegalPerson.count()]
        } 
        else {
            respond LegalPerson.findAllByRecStatus(params.recStatus, params), model:[legalPersonInstanceCount: LegalPerson.count()] 
        } 
    }
    
    def show(LegalPerson legalPersonInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && legalPersonInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond legalPersonInstance
    }

    def create() {
        respond new LegalPerson(params)
    }

    @Transactional
    def save(LegalPerson LegalPersonInstance) {
        if (LegalPersonInstance == null) {
            notFound()
            return
        }

        if (LegalPersonInstance.hasErrors()) {
            respond LegalPersonInstance.errors, view:'create'
            return
        }

        LegalPersonInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'LegalPersonInstance.label', default: 'LegalPerson'), LegalPersonInstance.id])
                redirect LegalPersonInstance
            }
            '*' { respond LegalPersonInstance, [status: CREATED] }
        }
    }

    def edit(LegalPerson LegalPersonInstance) {
        respond LegalPersonInstance
    }

    @Transactional
    def update(LegalPerson LegalPersonInstance) {
        if (LegalPersonInstance == null) {
            notFound()
            return
        }

        if (LegalPersonInstance.hasErrors()) {
            respond LegalPersonInstance.errors, view:'edit'
            return
        }

        LegalPersonInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LegalPerson.label', default: 'LegalPerson'), LegalPersonInstance.id])
                redirect LegalPersonInstance
            }
            '*'{ respond LegalPersonInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LegalPerson legalPersonInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/legalPerson/delete/2
        if (legalPersonInstance == null) {
            notFound()
            return
        }
        legalPersonInstance.recStatus="Deleted"
        legalPersonInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LegalPerson.label', default: 'LegalPerson'), legalPersonInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond legalPersonInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(LegalPerson legalPersonInstance) { 
        // example: http://localhost:9991/Commons/legalPerson/undelete/2
        if (legalPersonInstance == null) {
            notFound()
            return
        }
        legalPersonInstance.recStatus="Active"
        legalPersonInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LegalPerson.label', default: 'LegalPerson'), legalPersonInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond legalPersonInstance //, [status: NO_CONTENT] 
            }
        }
    } 

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'LegalPersonInstance.label', default: 'LegalPerson'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
