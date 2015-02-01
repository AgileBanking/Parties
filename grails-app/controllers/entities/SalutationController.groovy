package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class SalutationController extends BaseController {

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
            respond Salutation.list(params), model:[salutationInstanceCount: Salutation.count()]
        } 
        else {
            respond Salutation.findAllByRecStatus(params.recStatus, params), model:[salutationInstanceCount: Salutation.count()] 
        } 
    }
    
    def show(Salutation salutationInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && salutationInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond salutationInstance
    }

    def create() {
        respond new Salutation(params)
    }

    @Transactional
    def save(Salutation salutationInstance) {
        if (salutationInstance == null) {
            notFound()
            return
        }

        if (salutationInstance.hasErrors()) {
            respond salutationInstance.errors, view:'create'
            return
        }

        salutationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'salutationInstance.label', default: 'Salutation'), salutationInstance.id])
                redirect salutationInstance
            }
            '*' { respond salutationInstance, [status: CREATED] }
        }
    }

    def edit(Salutation salutationInstance) {
        respond salutationInstance
    }

    @Transactional
    def update(Salutation salutationInstance) {
        if (salutationInstance == null) {
            notFound()
            return
        }

        if (salutationInstance.hasErrors()) {
            respond salutationInstance.errors, view:'edit'
            return
        }

        salutationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Salutation.label', default: 'Salutation'), salutationInstance.id])
                redirect salutationInstance
            }
            '*'{ respond salutationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Salutation salutationInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/salutation/delete/2
        if (salutationInstance == null) {
            notFound()
            return
        }
        salutationInstance.recStatus="Deleted"
        salutationInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Salutation.label', default: 'Salutation'), salutationInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond salutationInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Salutation salutationInstance) { 
        // example: http://localhost:9991/Commons/salutation/undelete/2
        if (salutationInstance == null) {
            notFound()
            return
        }
        salutationInstance.recStatus="Active"
        salutationInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Salutation.label', default: 'Salutation'), salutationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond salutationInstance //, [status: NO_CONTENT] 
            }
        }
    }  

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'salutationInstance.label', default: 'Salutation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
