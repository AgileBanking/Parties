package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class PhoneController extends BaseController {

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
            respond Phone.list(params), model:[phoneInstanceCount: Phone.count()]
        } 
        else {
            respond Phone.findAllByRecStatus(params.recStatus, params), model:[phoneInstanceCount: Phone.count()] 
        } 
    }
    
    def show(Phone phoneInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && phoneInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond phoneInstance
    }

    def create() {
        respond new Phone(params)
    }

    @Transactional
    def save(Phone phoneInstance) {
        if (phoneInstance == null) {
            notFound()
            return
        }

        if (phoneInstance.hasErrors()) {
            respond phoneInstance.errors, view:'create'
            return
        }

        phoneInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'phoneInstance.label', default: 'Phone'), phoneInstance.id])
                redirect phoneInstance
            }
            '*' { respond phoneInstance, [status: CREATED] }
        }
    }

    def edit(Phone phoneInstance) {
        respond phoneInstance
    }

    @Transactional
    def update(Phone phoneInstance) {
        if (phoneInstance == null) {
            notFound()
            return
        }

        if (phoneInstance.hasErrors()) {
            respond phoneInstance.errors, view:'edit'
            return
        }

        phoneInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Phone.label', default: 'Phone'), phoneInstance.id])
                redirect phoneInstance
            }
            '*'{ respond phoneInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Phone phoneInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/phone/delete/2
        if (phoneInstance == null) {
            notFound()
            return
        }
        phoneInstance.recStatus="Deleted"
        phoneInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Phone.label', default: 'Phone'), phoneInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond phoneInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Phone phoneInstance) { 
        // example: http://localhost:9991/Commons/phone/undelete/2
        if (phoneInstance == null) {
            notFound()
            return
        }
        phoneInstance.recStatus="Active"
        phoneInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Phone.label', default: 'Phone'), phoneInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond phoneInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'phoneInstance.label', default: 'Phone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
