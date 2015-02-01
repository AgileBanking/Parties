package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LRepTypeController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        shortList: 'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond LRepType.list(params), model:[lRepTypeInstanceCount: LRepType.count()]
        } 
        else {
            respond LRepType.findAllByRecStatus(params.recStatus, params), model:[lRepTypeInstanceCount: LRepType.count()] 
        } 
    }
    
    def show(LRepType lRepTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && lRepTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond lRepTypeInstance
    }

    def create() {
        respond new LRepType(params)
    }

    @Transactional
    def save(LRepType LRepTypeInstance) {
        if (LRepTypeInstance == null) {
            notFound()
            return
        }

        if (LRepTypeInstance.hasErrors()) {
            respond LRepTypeInstance.errors, view:'create'
            return
        }

        LRepTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'LRepTypeInstance.label', default: 'LRepType'), LRepTypeInstance.id])
                redirect LRepTypeInstance
            }
            '*' { respond LRepTypeInstance, [status: CREATED] }
        }
    }

    def edit(LRepType LRepTypeInstance) {
        respond LRepTypeInstance
    }

    @Transactional
    def update(LRepType LRepTypeInstance) {
        if (LRepTypeInstance == null) {
            notFound()
            return
        }

        if (LRepTypeInstance.hasErrors()) {
            respond LRepTypeInstance.errors, view:'edit'
            return
        }

        LRepTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LRepType.label', default: 'LRepType'), LRepTypeInstance.id])
                redirect LRepTypeInstance
            }
            '*'{ respond LRepTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LRepType lRepTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/lRepType/delete/2
        if (lRepTypeInstance == null) {
            notFound()
            return
        }
        lRepTypeInstance.recStatus="Deleted"
        lRepTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LRepType.label', default: 'LRepType'), lRepTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond lRepTypeInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(LRepType lRepTypeInstance) { 
        // example: http://localhost:9991/Commons/lRepType/undelete/2
        if (lRepTypeInstance == null) {
            notFound()
            return
        }
        lRepTypeInstance.recStatus="Active"
        lRepTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LRepType.label', default: 'LRepType'), lRepTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond lRepTypeInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'LRepTypeInstance.label', default: 'LRepType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
