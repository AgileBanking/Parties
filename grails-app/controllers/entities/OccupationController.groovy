package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class OccupationController extends BaseController {

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
            respond Occupation.list(params), model:[occupationInstanceCount: Occupation.count()]
        } 
        else {
            respond Occupation.findAllByRecStatus(params.recStatus, params), model:[occupationInstanceCount: Occupation.count()] 
        } 
    }
    
    def show(Occupation occupationInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && occupationInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond occupationInstance
    }


    def create() {
        respond new Occupation(params)
    }

    @Transactional
    def save(Occupation occupationInstance) {
        if (occupationInstance == null) {
            notFound()
            return
        }

        if (occupationInstance.hasErrors()) {
            respond occupationInstance.errors, view:'create'
            return
        }

        occupationInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'occupationInstance.label', default: 'Occupation'), occupationInstance.id])
                redirect occupationInstance
            }
            '*' { respond occupationInstance, [status: CREATED] }
        }
    }

    def edit(Occupation occupationInstance) {
        respond occupationInstance
    }

    @Transactional
    def update(Occupation occupationInstance) {
        if (occupationInstance == null) {
            notFound()
            return
        }

        if (occupationInstance.hasErrors()) {
            respond occupationInstance.errors, view:'edit'
            return
        }

        occupationInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Occupation.label', default: 'Occupation'), occupationInstance.id])
                redirect occupationInstance
            }
            '*'{ respond occupationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Occupation occupationInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/occupation/delete/2
        if (occupationInstance == null) {
            notFound()
            return
        }
        occupationInstance.recStatus="Deleted"
        occupationInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Occupation.label', default: 'Occupation'), occupationInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond occupationInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Occupation occupationInstance) { 
        // example: http://localhost:9991/Commons/occupation/undelete/2
        if (occupationInstance == null) {
            notFound()
            return
        }
        occupationInstance.recStatus="Active"
        occupationInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Occupation.label', default: 'Occupation'), occupationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond occupationInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'occupationInstance.label', default: 'Occupation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
