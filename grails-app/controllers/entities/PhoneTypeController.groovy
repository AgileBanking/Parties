package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class PhoneTypeController extends BaseController {

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
            respond PhoneType.list(params), model:[phoneTypeInstanceCount: PhoneType.count()]
        } 
        else {
            respond PhoneType.findAllByRecStatus(params.recStatus, params), model:[phoneTypeInstanceCount: PhoneType.count()] 
        } 
    }
    
    def show(PhoneType phoneTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && phoneTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond phoneTypeInstance
    }

    def create() {
        respond new PhoneType(params)
    }

    @Transactional
    def save(PhoneType phoneTypeInstance) {
        if (phoneTypeInstance == null) {
            notFound()
            return
        }

        if (phoneTypeInstance.hasErrors()) {
            respond phoneTypeInstance.errors, view:'create'
            return
        }

        phoneTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'phoneTypeInstance.label', default: 'PhoneType'), phoneTypeInstance.id])
                redirect phoneTypeInstance
            }
            '*' { respond phoneTypeInstance, [status: CREATED] }
        }
    }

    def edit(PhoneType phoneTypeInstance) {
        respond phoneTypeInstance
    }

    @Transactional
    def update(PhoneType phoneTypeInstance) {
        if (phoneTypeInstance == null) {
            notFound()
            return
        }

        if (phoneTypeInstance.hasErrors()) {
            respond phoneTypeInstance.errors, view:'edit'
            return
        }

        phoneTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PhoneType.label', default: 'PhoneType'), phoneTypeInstance.id])
                redirect phoneTypeInstance
            }
            '*'{ respond phoneTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PhoneType phoneTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/phoneType/delete/2
        if (phoneTypeInstance == null) {
            notFound()
            return
        }
        phoneTypeInstance.recStatus="Deleted"
        phoneTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PhoneType.label', default: 'PhoneType'), phoneTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond phoneTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(PhoneType phoneTypeInstance) { 
        // example: http://localhost:9991/Commons/phoneType/undelete/2
        if (phoneTypeInstance == null) {
            notFound()
            return
        }
        phoneTypeInstance.recStatus="Active"
        phoneTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'PhoneType.label', default: 'PhoneType'), phoneTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond phoneTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'phoneTypeInstance.label', default: 'PhoneType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
