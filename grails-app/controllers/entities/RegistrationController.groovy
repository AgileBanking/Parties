package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class RegistrationController extends BaseController {

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
            respond Registration.list(params), model:[registrationInstanceCount: Registration.count()]
        } 
        else {
            respond Registration.findAllByRecStatus(params.recStatus, params), model:[registrationInstanceCount: Registration.count()] 
        } 
    }
    
    def show(Registration registrationInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && registrationInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond registrationInstance
    }

    def create() {
        respond new Registration(params)
    }

    @Transactional
    def save(Registration registrationInstance) {
        if (registrationInstance == null) {
            notFound()
            return
        }

        if (registrationInstance.hasErrors()) {
            respond registrationInstance.errors, view:'create'
            return
        }

        registrationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'registrationInstance.label', default: 'Registration'), registrationInstance.id])
                redirect registrationInstance
            }
            '*' { respond registrationInstance, [status: CREATED] }
        }
    }

    def edit(Registration registrationInstance) {
        respond registrationInstance
    }

    @Transactional
    def update(Registration registrationInstance) {
        if (registrationInstance == null) {
            notFound()
            return
        }

        if (registrationInstance.hasErrors()) {
            respond registrationInstance.errors, view:'edit'
            return
        }

        registrationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Registration.label', default: 'Registration'), registrationInstance.id])
                redirect registrationInstance
            }
            '*'{ respond registrationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Registration registrationInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/registration/delete/2
        if (registrationInstance == null) {
            notFound()
            return
        }
        registrationInstance.recStatus="Deleted"
        registrationInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Registration.label', default: 'Registration'), registrationInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond registrationInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Registration registrationInstance) { 
        // example: http://localhost:9991/Commons/registration/undelete/2
        if (registrationInstance == null) {
            notFound()
            return
        }
        registrationInstance.recStatus="Active"
        registrationInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Registration.label', default: 'Registration'), registrationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond registrationInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'registrationInstance.label', default: 'Registration'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
