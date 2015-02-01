package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class MarketSegmentController extends BaseController {

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
            respond MarketSegment.list(params), model:[marketSegmentInstanceCount: MarketSegment.count()]
        } 
        else {
            respond MarketSegment.findAllByRecStatus(params.recStatus, params), model:[marketSegmentInstanceCount: MarketSegment.count()] 
        } 
    }
    
    def show(MarketSegment marketSegmentInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && marketSegmentInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond marketSegmentInstance
    }

    def create() {
        respond new MarketSegment(params)
    }

    @Transactional
    def save(MarketSegment marketSegmentInstance) {
        if (marketSegmentInstance == null) {
            notFound()
            return
        }

        if (marketSegmentInstance.hasErrors()) {
            respond marketSegmentInstance.errors, view:'create'
            return
        }

        marketSegmentInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'marketSegmentInstance.label', default: 'MarketSegment'), marketSegmentInstance.id])
                redirect marketSegmentInstance
            }
            '*' { respond marketSegmentInstance, [status: CREATED] }
        }
    }

    def edit(MarketSegment marketSegmentInstance) {
        respond marketSegmentInstance
    }

    @Transactional
    def update(MarketSegment marketSegmentInstance) {
        if (marketSegmentInstance == null) {
            notFound()
            return
        }

        if (marketSegmentInstance.hasErrors()) {
            respond marketSegmentInstance.errors, view:'edit'
            return
        }

        marketSegmentInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MarketSegment.label', default: 'MarketSegment'), marketSegmentInstance.id])
                redirect marketSegmentInstance
            }
            '*'{ respond marketSegmentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MarketSegment marketSegmentInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/marketSegment/delete/2
        if (marketSegmentInstance == null) {
            notFound()
            return
        }
        marketSegmentInstance.recStatus="Deleted"
        marketSegmentInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MarketSegment.label', default: 'MarketSegment'), marketSegmentInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond marketSegmentInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(MarketSegment marketSegmentInstance) { 
        // example: http://localhost:9991/Commons/marketSegment/undelete/2
        if (marketSegmentInstance == null) {
            notFound()
            return
        }
        marketSegmentInstance.recStatus="Active"
        marketSegmentInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'MarketSegment.label', default: 'MarketSegment'), marketSegmentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond marketSegmentInstance //, [status: NO_CONTENT] 
            }
        }
    }    


    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'marketSegmentInstance.label', default: 'MarketSegment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
