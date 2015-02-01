package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class PersonalIdTypeController extends BaseController {

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
            respond PersonalIdType.list(params), model:[personalIdTypeInstanceCount: PersonalIdType.count()]
        } 
        else {
            respond PersonalIdType.findAllByRecStatus(params.recStatus, params), model:[personalIdTypeInstanceCount: PersonalIdType.count()] 
        } 
    }
    
    def show(PersonalIdType personalIdTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && personalIdTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond personalIdTypeInstance
    }

    def create() {
        respond new PersonalIdType(params)
    }

    @Transactional
    def save(PersonalIdType personalIdTypeInstance) {
        if (personalIdTypeInstance == null) {
            notFound()
            return
        }

        if (personalIdTypeInstance.hasErrors()) {
            respond personalIdTypeInstance.errors, view:'create'
            return
        }

        personalIdTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'personalIdTypeInstance.label', default: 'PersonalIdType'), personalIdTypeInstance.id])
                redirect personalIdTypeInstance
            }
            '*' { respond personalIdTypeInstance, [status: CREATED] }
        }
    }

    def edit(PersonalIdType personalIdTypeInstance) {
        respond personalIdTypeInstance
    }

    @Transactional
    def update(PersonalIdType personalIdTypeInstance) {
        if (personalIdTypeInstance == null) {
            notFound()
            return
        }

        if (personalIdTypeInstance.hasErrors()) {
            respond personalIdTypeInstance.errors, view:'edit'
            return
        }

        personalIdTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PersonalIdType.label', default: 'PersonalIdType'), personalIdTypeInstance.id])
                redirect personalIdTypeInstance
            }
            '*'{ respond personalIdTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PersonalIdType personalIdTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/personalIdType/delete/2
        if (personalIdTypeInstance == null) {
            notFound()
            return
        }
        personalIdTypeInstance.recStatus="Deleted"
        personalIdTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PersonalIdType.label', default: 'PersonalIdType'), personalIdTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond personalIdTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(PersonalIdType personalIdTypeInstance) { 
        // example: http://localhost:9991/Commons/personalIdType/undelete/2
        if (personalIdTypeInstance == null) {
            notFound()
            return
        }
        personalIdTypeInstance.recStatus="Active"
        personalIdTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'PersonalIdType.label', default: 'PersonalIdType'), personalIdTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond personalIdTypeInstance //, [status: NO_CONTENT] 
            }
        }
    } 

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personalIdTypeInstance.label', default: 'PersonalIdType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
