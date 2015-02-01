package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class SignatureController extends BaseController {

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
            respond Signature.list(params), model:[signatureInstanceCount: Signature.count()]
        } 
        else {
            respond Signature.findAllByRecStatus(params.recStatus, params), model:[signatureInstanceCount: Signature.count()] 
        } 
    }
    
    def show(Signature signatureInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && signatureInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond signatureInstance
    }

    def create() {
        respond new Signature(params)
    }

    @Transactional
    def save(Signature signatureInstance) {
        if (signatureInstance == null) {
            notFound()
            return
        }

        if (signatureInstance.hasErrors()) {
            respond signatureInstance.errors, view:'create'
            return
        }

        signatureInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'signatureInstance.label', default: 'Signature'), signatureInstance.id])
                redirect signatureInstance
            }
            '*' { respond signatureInstance, [status: CREATED] }
        }
    }

    def edit(Signature signatureInstance) {
        respond signatureInstance
    }

    @Transactional
    def update(Signature signatureInstance) {
        if (signatureInstance == null) {
            notFound()
            return
        }

        if (signatureInstance.hasErrors()) {
            respond signatureInstance.errors, view:'edit'
            return
        }

        signatureInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Signature.label', default: 'Signature'), signatureInstance.id])
                redirect signatureInstance
            }
            '*'{ respond signatureInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Signature signatureInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/signature/delete/2
        if (signatureInstance == null) {
            notFound()
            return
        }
        signatureInstance.recStatus="Deleted"
        signatureInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Signature.label', default: 'Signature'), signatureInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond signatureInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Signature signatureInstance) { 
        // example: http://localhost:9991/Commons/signature/undelete/2
        if (signatureInstance == null) {
            notFound()
            return
        }
        signatureInstance.recStatus="Active"
        signatureInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Signature.label', default: 'Signature'), signatureInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond signatureInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'signatureInstance.label', default: 'Signature'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
