package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class StatusController extends BaseController {

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
            respond Status.list(params), model:[statusInstanceCount: Status.count()]
        } 
        else {
            respond Status.findAllByRecStatus(params.recStatus, params), model:[statusInstanceCount: Status.count()] 
        } 
    }
    
    def show(Status statusInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && statusInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond statusInstance
    }

    def create() {
        respond new Status(params)
    }

    @Transactional
    def save(Status statusInstance) {
        if (statusInstance == null) {
            notFound()
            return
        }

        if (statusInstance.hasErrors()) {
            respond statusInstance.errors, view:'create'
            return
        }

        statusInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statusInstance.label', default: 'Status'), statusInstance.id])
                redirect statusInstance
            }
            '*' { respond statusInstance, [status: CREATED] }
        }
    }

    def edit(Status statusInstance) {
        respond statusInstance
    }

    @Transactional
    def update(Status statusInstance) {
        if (statusInstance == null) {
            notFound()
            return
        }

        if (statusInstance.hasErrors()) {
            respond statusInstance.errors, view:'edit'
            return
        }

        statusInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Status.label', default: 'Status'), statusInstance.id])
                redirect statusInstance
            }
            '*'{ respond statusInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Status statusInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/channel/delete/2
        if (statusInstance == null) {
            notFound()
            return
        }
        statusInstance.recStatus="Deleted"
        statusInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Status.label', default: 'Status'), statusInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond statusInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Status statusInstance) { 
        // example: http://localhost:9991/Commons/channel/undelete/2
        if (statusInstance == null) {
            notFound()
            return
        }
        statusInstance.recStatus="Active"
        statusInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Status.label', default: 'Status'), statusInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond statusInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusInstance.label', default: 'Status'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
