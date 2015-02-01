package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class RegisterController extends BaseController {

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
            respond Register.list(params), model:[registerInstanceCount: Register.count()]
        } 
        else {
            respond Register.findAllByRecStatus(params.recStatus, params), model:[registerInstanceCount: Register.count()] 
        } 
    }
    
    def show(Register registerInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && registerInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond registerInstance
    }

    def create() {
        respond new Register(params)
    }

    @Transactional
    def save(Register registerInstance) {
        if (registerInstance == null) {
            notFound()
            return
        }

        if (registerInstance.hasErrors()) {
            respond registerInstance.errors, view:'create'
            return
        }

        registerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'registerInstance.label', default: 'Register'), registerInstance.id])
                redirect registerInstance
            }
            '*' { respond registerInstance, [status: CREATED] }
        }
    }

    def edit(Register registerInstance) {
        respond registerInstance
    }

    @Transactional
    def update(Register registerInstance) {
        if (registerInstance == null) {
            notFound()
            return
        }

        if (registerInstance.hasErrors()) {
            respond registerInstance.errors, view:'edit'
            return
        }

        registerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Register.label', default: 'Register'), registerInstance.id])
                redirect registerInstance
            }
            '*'{ respond registerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Register registerInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/register/delete/2
        if (registerInstance == null) {
            notFound()
            return
        }
        registerInstance.recStatus="Deleted"
        registerInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Register.label', default: 'Register'), registerInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond registerInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Register registerInstance) { 
        // example: http://localhost:9991/Commons/register/undelete/2
        if (registerInstance == null) {
            notFound()
            return
        }
        registerInstance.recStatus="Active"
        registerInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Register.label', default: 'Register'), registerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond registerInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerInstance.label', default: 'Register'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
