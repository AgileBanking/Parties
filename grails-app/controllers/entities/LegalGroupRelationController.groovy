package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LegalGroupRelationController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        shortList:'GET',
        customQuery: 'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond LegalGroupRelation.list(params), model:[legalGroupRelationInstanceCount: LegalGroupRelation.count()]
        } 
        else {
            respond LegalGroupRelation.findAllByRecStatus(params.recStatus, params), model:[legalGroupRelationInstanceCount: LegalGroupRelation.count()] 
        } 
    }
    
    def show(LegalGroupRelation legalGroupRelationInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && legalGroupRelationInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond legalGroupRelationInstance
    }

    def create() {
        respond new LegalGroupRelation(params)
    }

    @Transactional
    def save(LegalGroupRelation LegalGroupRelationInstance) {
        if (LegalGroupRelationInstance == null) {
            notFound()
            return
        }

        if (LegalGroupRelationInstance.hasErrors()) {
            respond LegalGroupRelationInstance.errors, view:'create'
            return
        }

        LegalGroupRelationInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'LegalGroupRelationInstance.label', default: 'LegalGroupRelation'), LegalGroupRelationInstance.id])
                redirect LegalGroupRelationInstance
            }
            '*' { respond LegalGroupRelationInstance, [status: CREATED] }
        }
    }

    def edit(LegalGroupRelation LegalGroupRelationInstance) {
        respond LegalGroupRelationInstance
    }

    @Transactional
    def update(LegalGroupRelation LegalGroupRelationInstance) {
        if (LegalGroupRelationInstance == null) {
            notFound()
            return
        }

        if (LegalGroupRelationInstance.hasErrors()) {
            respond LegalGroupRelationInstance.errors, view:'edit'
            return
        }

        LegalGroupRelationInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LegalGroupRelation.label', default: 'LegalGroupRelation'), LegalGroupRelationInstance.id])
                redirect LegalGroupRelationInstance
            }
            '*'{ respond LegalGroupRelationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LegalGroupRelation legalGroupRelationInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/legalGroupRelation/delete/2
        if (legalGroupRelationInstance == null) {
            notFound()
            return
        }
        legalGroupRelationInstance.recStatus="Deleted"
        legalGroupRelationInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LegalGroupRelation.label', default: 'LegalGroupRelation'), legalGroupRelationInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond legalGroupRelationInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(LegalGroupRelation legalGroupRelationInstance) { 
        // example: http://localhost:9991/Commons/legalGroupRelation/undelete/2
        if (legalGroupRelationInstance == null) {
            notFound()
            return
        }
        legalGroupRelationInstance.recStatus="Active"
        legalGroupRelationInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LegalGroupRelation.label', default: 'LegalGroupRelation'), legalGroupRelationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond legalGroupRelationInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'LegalGroupRelationInstance.label', default: 'LegalGroupRelation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
