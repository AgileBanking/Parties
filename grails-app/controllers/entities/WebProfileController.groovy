package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class WebProfileController extends BaseController {

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
            respond WebProfile.list(params), model:[webProfileInstanceCount: WebProfile.count()]
        } 
        else {
            respond WebProfile.findAllByRecStatus(params.recStatus, params), model:[webProfileInstanceCount: WebProfile.count()] 
        } 
    }
    
    def show(WebProfile webProfileInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && webProfileInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond webProfileInstance
    }

    def create() {
        respond new WebProfile(params)
    }

    @Transactional
    def save(WebProfile webProfileInstance) {
        if (webProfileInstance == null) {
            notFound()
            return
        }

        if (webProfileInstance.hasErrors()) {
            respond webProfileInstance.errors, view:'create'
            return
        }

        webProfileInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'webProfileInstance.label', default: 'WebProfile'), webProfileInstance.id])
                redirect webProfileInstance
            }
            '*' { respond webProfileInstance, [status: CREATED] }
        }
    }

    def edit(WebProfile webProfileInstance) {
        respond webProfileInstance
    }

    @Transactional
    def update(WebProfile webProfileInstance) {
        if (webProfileInstance == null) {
            notFound()
            return
        }

        if (webProfileInstance.hasErrors()) {
            respond webProfileInstance.errors, view:'edit'
            return
        }

        webProfileInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'WebProfile.label', default: 'WebProfile'), webProfileInstance.id])
                redirect webProfileInstance
            }
            '*'{ respond webProfileInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(WebProfile webProfileInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/webProfile/delete/2
        if (webProfileInstance == null) {
            notFound()
            return
        }
        webProfileInstance.recStatus="Deleted"
        webProfileInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'WebProfile.label', default: 'WebProfile'), webProfileInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond webProfileInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(WebProfile webProfileInstance) { 
        // example: http://localhost:9991/Commons/webProfile/undelete/2
        if (webProfileInstance == null) {
            notFound()
            return
        }
        webProfileInstance.recStatus="Active"
        webProfileInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'WebProfile.label', default: 'WebProfile'), webProfileInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond webProfileInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'webProfileInstance.label', default: 'WebProfile'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
