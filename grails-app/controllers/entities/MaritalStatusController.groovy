package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class MaritalStatusController extends BaseController {

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
            respond MaritalStatus.list(params), model:[maritalStatusInstanceCount: MaritalStatus.count()]
        } 
        else {
            respond MaritalStatus.findAllByRecStatus(params.recStatus, params), model:[maritalStatusInstanceCount: MaritalStatus.count()] 
        } 
    }
    
    def show(MaritalStatus maritalStatusInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && maritalStatusInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond maritalStatusInstance
    }

    def create() {
        respond new MaritalStatus(params)
    }

    @Transactional
    def save(MaritalStatus maritalStatusInstance) {
        if (maritalStatusInstance == null) {
            notFound()
            return
        }

        if (maritalStatusInstance.hasErrors()) {
            respond maritalStatusInstance.errors, view:'create'
            return
        }

        maritalStatusInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'maritalStatusInstance.label', default: 'MaritalStatus'), maritalStatusInstance.id])
                redirect maritalStatusInstance
            }
            '*' { respond maritalStatusInstance, [status: CREATED] }
        }
    }

    def edit(MaritalStatus maritalStatusInstance) {
        respond maritalStatusInstance
    }

    @Transactional
    def update(MaritalStatus maritalStatusInstance) {
        if (maritalStatusInstance == null) {
            notFound()
            return
        }

        if (maritalStatusInstance.hasErrors()) {
            respond maritalStatusInstance.errors, view:'edit'
            return
        }

        maritalStatusInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MaritalStatus.label', default: 'MaritalStatus'), maritalStatusInstance.id])
                redirect maritalStatusInstance
            }
            '*'{ respond maritalStatusInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MaritalStatus maritalStatusInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/maritalStatus/delete/2
        if (maritalStatusInstance == null) {
            notFound()
            return
        }
        maritalStatusInstance.recStatus="Deleted"
        maritalStatusInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MaritalStatus.label', default: 'MaritalStatus'), maritalStatusInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond maritalStatusInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(MaritalStatus maritalStatusInstance) { 
        // example: http://localhost:9991/Commons/maritalStatus/undelete/2
        if (maritalStatusInstance == null) {
            notFound()
            return
        }
        maritalStatusInstance.recStatus="Active"
        maritalStatusInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'MaritalStatus.label', default: 'MaritalStatus'), maritalStatusInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond maritalStatusInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'maritalStatusInstance.label', default: 'MaritalStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
