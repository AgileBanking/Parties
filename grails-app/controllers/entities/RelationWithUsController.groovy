package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class RelationWithUsController extends BaseController {

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
            respond RelationWithUs.list(params), model:[relationWithUsInstanceCount: RelationWithUs.count()]
        } 
        else {
            respond RelationWithUs.findAllByRecStatus(params.recStatus, params), model:[relationWithUsInstanceCount: RelationWithUs.count()] 
        } 
    }
    
    def show(RelationWithUs relationWithUsInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && relationWithUsInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond relationWithUsInstance
    }

    def create() {
        respond new RelationWithUs(params)
    }

    @Transactional
    def save(RelationWithUs RelationWithUsInstance) {
        if ( RelationWithUsInstance == null) {
            notFound()
            return
        }

        if ( RelationWithUsInstance.hasErrors()) {
            respond  RelationWithUsInstance.errors, view:'create'
            return
        }

         RelationWithUsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: ' RelationWithUsInstance.label', default: ' RelationWithUs'),  RelationWithUsInstance.id])
                redirect  RelationWithUsInstance
            }
            '*' { respond  RelationWithUsInstance, [status: CREATED] }
        }
    }

    def edit( RelationWithUs  RelationWithUsInstance) {
        respond  RelationWithUsInstance
    }

    @Transactional
    def update( RelationWithUs  RelationWithUsInstance) {
        if ( RelationWithUsInstance == null) {
            notFound()
            return
        }

        if ( RelationWithUsInstance.hasErrors()) {
            respond  RelationWithUsInstance.errors, view:'edit'
            return
        }

         RelationWithUsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: ' RelationWithUs.label', default: ' RelationWithUs'),  RelationWithUsInstance.id])
                redirect  RelationWithUsInstance
            }
            '*'{ respond  RelationWithUsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RelationWithUs relationWithUsInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/relationWithUs/delete/2
        if (relationWithUsInstance == null) {
            notFound()
            return
        }
        relationWithUsInstance.recStatus="Deleted"
        relationWithUsInstance.save flush:true
    
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RelationWithUs.label', default: 'RelationWithUs'), relationWithUsInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond relationWithUsInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(RelationWithUs relationWithUsInstance) { 
        // example: http://localhost:9991/Commons/relationWithUs/undelete/2
        if (relationWithUsInstance == null) {
            notFound()
            return
        }
        relationWithUsInstance.recStatus="Active"
        relationWithUsInstance.save flush:true 

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'RelationWithUs.label', default: 'RelationWithUs'), relationWithUsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond relationWithUsInstance //, [status: NO_CONTENT] 
            }
        }
    }  

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: ' RelationWithUsInstance.label', default: ' RelationWithUs'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
