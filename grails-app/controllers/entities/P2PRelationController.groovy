package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class P2PRelationController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond P2PRelation.list(params), model:[p2PRelationInstanceCount: P2PRelation.count()]
        } 
        else {
            respond P2PRelation.findAllByRecStatus(params.recStatus, params), model:[p2PRelationInstanceCount: P2PRelation.count()] 
        } 
    }
    
    def show(P2PRelation p2PRelationInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && p2PRelationInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond p2PRelationInstance
    }

    def create() {
        respond new P2PRelation(params)
    }

    @Transactional
    def save(P2PRelation p2PRelationInstance) {
        if (p2PRelationInstance == null) {
            notFound()
            return
        }

        if (p2PRelationInstance.hasErrors()) {
            respond p2PRelationInstance.errors, view:'create'
            return
        }

        p2PRelationInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'p2PRelationInstance.label', default: 'P2PRelation'), p2PRelationInstance.id])
                redirect p2PRelationInstance
            }
            '*' { respond p2PRelationInstance, [status: CREATED] }
        }
    }

    def edit(P2PRelation p2PRelationInstance) {
        respond p2PRelationInstance
    }

    @Transactional
    def update(P2PRelation p2PRelationInstance) {
        if (p2PRelationInstance == null) {
            notFound()
            return
        }

        if (p2PRelationInstance.hasErrors()) {
            respond p2PRelationInstance.errors, view:'edit'
            return
        }

        p2PRelationInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'P2PRelation.label', default: 'P2PRelation'), p2PRelationInstance.id])
                redirect p2PRelationInstance
            }
            '*'{ respond p2PRelationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(P2PRelation p2PRelationInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/p2PRelation/delete/2
        if (p2PRelationInstance == null) {
            notFound()
            return
        }
        p2PRelationInstance.recStatus="Deleted"
        p2PRelationInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'P2PRelation.label', default: 'P2PRelation'), p2PRelationInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond p2PRelationInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(P2PRelation p2PRelationInstance) { 
        // example: http://localhost:9991/Commons/p2PRelation/undelete/2
        if (p2PRelationInstance == null) {
            notFound()
            return
        }
        p2PRelationInstance.recStatus="Active"
        p2PRelationInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'P2PRelation.label', default: 'P2PRelation'), p2PRelationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond p2PRelationInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'p2PRelationInstance.label', default: 'P2PRelation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
