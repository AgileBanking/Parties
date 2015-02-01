package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class PersonalIdController extends BaseController {

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
            respond PersonalId.list(params), model:[personalIdInstanceCount: PersonalId.count()]
        } 
        else {
            respond PersonalId.findAllByRecStatus(params.recStatus, params), model:[personalIdInstanceCount: PersonalId.count()] 
        } 
    }
    
    def show(PersonalId personalIdInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && personalIdInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond personalIdInstance
    }

    def create() {
        respond new PersonalId(params)
    }

    @Transactional
    def save(PersonalId personalIdInstance) {
        if (personalIdInstance == null) {
            notFound()
            return
        }

        if (personalIdInstance.hasErrors()) {
            respond personalIdInstance.errors, view:'create'
            return
        }

        personalIdInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'personalIdInstance.label', default: 'PersonalId'), personalIdInstance.id])
                redirect personalIdInstance
            }
            '*' { respond personalIdInstance, [status: CREATED] }
        }
    }

    def edit(PersonalId personalIdInstance) {
        respond personalIdInstance
    }

    @Transactional
    def update(PersonalId personalIdInstance) {
        if (personalIdInstance == null) {
            notFound()
            return
        }

        if (personalIdInstance.hasErrors()) {
            respond personalIdInstance.errors, view:'edit'
            return
        }

        personalIdInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PersonalId.label', default: 'PersonalId'), personalIdInstance.id])
                redirect personalIdInstance
            }
            '*'{ respond personalIdInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PersonalId personalIdInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/personalId/delete/2
        if (personalIdInstance == null) {
            notFound()
            return
        }
        personalIdInstance.recStatus="Deleted"
        personalIdInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PersonalId.label', default: 'PersonalId'), personalIdInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond personalIdInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(PersonalId personalIdInstance) { 
        // example: http://localhost:9991/Commons/personalId/undelete/2
        if (personalIdInstance == null) {
            notFound()
            return
        }
        personalIdInstance.recStatus="Active"
        personalIdInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'PersonalId.label', default: 'PersonalId'), personalIdInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond personalIdInstance //, [status: NO_CONTENT] 
            }
        }
    } 

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personalIdInstance.label', default: 'PersonalId'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
