package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class IdStatusController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete: 'POST',
        shortList: 'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond IdStatus.list(params), model:[idStatusInstanceCount: IdStatus.count()]
        } 
        else {
            respond IdStatus.findAllByRecStatus(params.recStatus, params), model:[idStatusInstanceCount: IdStatus.count()] 
        } 
    }
    
    def show(IdStatus idStatusInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && idStatusInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond idStatusInstance
    }

    def create() {
        respond new IdStatus(params)
    }

    @Transactional
    def save(IdStatus idStatusInstance) {
        if (idStatusInstance == null) {
            notFound()
            return
        }

        if (idStatusInstance.hasErrors()) {
            respond idStatusInstance.errors, view:'create'
            return
        }

        idStatusInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'idStatusInstance.label', default: 'IdStatus'), idStatusInstance.id])
                redirect idStatusInstance
            }
            '*' { respond idStatusInstance, [status: CREATED] }
        }
    }

    def edit(IdStatus idStatusInstance) {
        respond idStatusInstance
    }

    @Transactional
    def update(IdStatus idStatusInstance) {
        if (idStatusInstance == null) {
            notFound()
            return
        }

        if (idStatusInstance.hasErrors()) {
            respond idStatusInstance.errors, view:'edit'
            return
        }

        idStatusInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IdStatus.label', default: 'IdStatus'), idStatusInstance.id])
                redirect idStatusInstance
            }
            '*'{ respond idStatusInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(IdStatus idStatusInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/idStatus/delete/2
        if (idStatusInstance == null) {
            notFound()
            return
        }
        idStatusInstance.recStatus="Deleted"
        idStatusInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'IdStatus.label', default: 'IdStatus'), idStatusInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond idStatusInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(IdStatus idStatusInstance) { 
        // example: http://localhost:9991/Commons/idStatus/undelete/2
        if (idStatusInstance == null) {
            notFound()
            return
        }
        idStatusInstance.recStatus="Active"
        idStatusInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'IdStatus.label', default: 'IdStatus'), idStatusInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond idStatusInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'idStatusInstance.label', default: 'IdStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
