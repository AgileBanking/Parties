package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class P2PRelationTypeController extends BaseController {

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
            respond P2PRelationType.list(params), model:[p2PRelationTypeInstanceCount: P2PRelationType.count()]
        } 
        else {
            respond P2PRelationType.findAllByRecStatus(params.recStatus, params), model:[p2PRelationTypeInstanceCount: P2PRelationType.count()] 
        } 
    }
    
    def show(P2PRelationType p2PRelationTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && p2PRelationTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond p2PRelationTypeInstance
    }
    def create() {
        respond new P2PRelationType(params)
    }

    @Transactional
    def save(P2PRelationType p2PRelationTypeInstance) {
        if (p2PRelationTypeInstance == null) {
            notFound()
            return
        }

        if (p2PRelationTypeInstance.hasErrors()) {
            respond p2PRelationTypeInstance.errors, view:'create'
            return
        }

        p2PRelationTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'p2PRelationTypeInstance.label', default: 'P2PRelationType'), p2PRelationTypeInstance.id])
                redirect p2PRelationTypeInstance
            }
            '*' { respond p2PRelationTypeInstance, [status: CREATED] }
        }
    }

    def edit(P2PRelationType p2PRelationTypeInstance) {
        respond p2PRelationTypeInstance
    }

    @Transactional
    def update(P2PRelationType p2PRelationTypeInstance) {
        if (p2PRelationTypeInstance == null) {
            notFound()
            return
        }

        if (p2PRelationTypeInstance.hasErrors()) {
            respond p2PRelationTypeInstance.errors, view:'edit'
            return
        }

        p2PRelationTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'P2PRelationType.label', default: 'P2PRelationType'), p2PRelationTypeInstance.id])
                redirect p2PRelationTypeInstance
            }
            '*'{ respond p2PRelationTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(P2PRelationType p2PRelationTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/p2PRelationType/delete/2
        if (p2PRelationTypeInstance == null) {
            notFound()
            return
        }
        p2PRelationTypeInstance.recStatus="Deleted"
        p2PRelationTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'P2PRelationType.label', default: 'P2PRelationType'), p2PRelationTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond p2PRelationTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'p2PRelationTypeInstance.label', default: 'P2PRelationType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
