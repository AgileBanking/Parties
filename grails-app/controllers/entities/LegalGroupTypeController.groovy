package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class LegalGroupTypeController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        delete:'POST',
        undelete:'POST',
        undelete:'POST',
        customQuery: 'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond LegalGroupType.list(params), model:[legalGroupTypeInstanceCount: LegalGroupType.count()]
        } 
        else {
            respond LegalGroupType.findAllByRecStatus(params.recStatus, params), model:[legalGroupTypeInstanceCount: LegalGroupType.count()] 
        } 
    }
    
    def show(LegalGroupType legalGroupTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && legalGroupTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond legalGroupTypeInstance
    }

    def create() {
        respond new LegalGroupType(params)
    }

    @Transactional
    def save(LegalGroupType LegalGroupTypeInstance) {
        if (LegalGroupTypeInstance == null) {
            notFound()
            return
        }

        if (LegalGroupTypeInstance.hasErrors()) {
            respond LegalGroupTypeInstance.errors, view:'create'
            return
        }

        LegalGroupTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'LegalGroupTypeInstance.label', default: 'LegalGroupType'), LegalGroupTypeInstance.id])
                redirect LegalGroupTypeInstance
            }
            '*' { respond LegalGroupTypeInstance, [status: CREATED] }
        }
    }

    def edit(LegalGroupType LegalGroupTypeInstance) {
        respond LegalGroupTypeInstance
    }
    
    @Transactional
    def update(LegalGroupType LegalGroupTypeInstance) {
        if (LegalGroupTypeInstance == null) {
            notFound()
            return
        }

        if (LegalGroupTypeInstance.hasErrors()) {
            respond LegalGroupTypeInstance.errors, view:'edit'
            return
        }

        LegalGroupTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LegalGroupType.label', default: 'LegalGroupType'), LegalGroupTypeInstance.id])
                redirect LegalGroupTypeInstance
            }
            '*'{ respond LegalGroupTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LegalGroupType legalGroupTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/legalGroupType/delete/2
        if (legalGroupTypeInstance == null) {
            notFound()
            return
        }
        legalGroupTypeInstance.recStatus="Deleted"
        legalGroupTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LegalGroupType.label', default: 'LegalGroupType'), legalGroupTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond legalGroupTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(LegalGroupType legalGroupTypeInstance) { 
        // example: http://localhost:9991/Commons/legalGroupType/undelete/2
        if (legalGroupTypeInstance == null) {
            notFound()
            return
        }
        legalGroupTypeInstance.recStatus="Active"
        legalGroupTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'LegalGroupType.label', default: 'LegalGroupType'), legalGroupTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond legalGroupTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'LegalGroupTypeInstance.label', default: 'LegalGroupType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
    // Extentions
    def listMyLegalGroups(Long id) {
        def legalGroups = LegalGroupType.findById(id).legalGroups
        render legalGroups as JSON
    }    
}
