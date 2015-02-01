package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class WebProfileTypeController extends BaseController {

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
            respond WebProfileType.list(params), model:[webProfileTypeInstanceCount: WebProfileType.count()]
        } 
        else {
            respond WebProfileType.findAllByRecStatus(params.recStatus, params), model:[webProfileTypeInstanceCount: WebProfileType.count()] 
        } 
    }
    
    def show(WebProfileType webProfileTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && webProfileTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond webProfileTypeInstance
    }

    def create() {
        respond new WebProfileType(params)
    }

    @Transactional
    def save(WebProfileType webProfileTypeInstance) {
        if (webProfileTypeInstance == null) {
            notFound()
            return
        }

        if (webProfileTypeInstance.hasErrors()) {
            respond webProfileTypeInstance.errors, view:'create'
            return
        }

        webProfileTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'webProfileTypeInstance.label', default: 'WebProfileType'), webProfileTypeInstance.id])
                redirect webProfileTypeInstance
            }
            '*' { respond webProfileTypeInstance, [status: CREATED] }
        }
    }

    def edit(WebProfileType webProfileTypeInstance) {
        respond webProfileTypeInstance
    }

    @Transactional
    def update(WebProfileType webProfileTypeInstance) {
        if (webProfileTypeInstance == null) {
            notFound()
            return
        }

        if (webProfileTypeInstance.hasErrors()) {
            respond webProfileTypeInstance.errors, view:'edit'
            return
        }

        webProfileTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'WebProfileType.label', default: 'WebProfileType'), webProfileTypeInstance.id])
                redirect webProfileTypeInstance
            }
            '*'{ respond webProfileTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(WebProfileType webProfileTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/webProfileType/delete/2
        if (webProfileTypeInstance == null) {
            notFound()
            return
        }
        webProfileTypeInstance.recStatus="Deleted"
        webProfileTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'WebProfileType.label', default: 'WebProfileType'), webProfileTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond webProfileTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(WebProfileType webProfileTypeInstance) { 
        // example: http://localhost:9991/Commons/webProfileType/undelete/2
        if (webProfileTypeInstance == null) {
            notFound()
            return
        }
        webProfileTypeInstance.recStatus="Active"
        webProfileTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'WebProfileType.label', default: 'WebProfileType'), webProfileTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond webProfileTypeInstance //, [status: NO_CONTENT] 
            }
        }
    } 

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'webProfileTypeInstance.label', default: 'WebProfileType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
