package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class GenderController extends BaseController {

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
            respond Gender.list(params), model:[genderInstanceCount: Gender.count()]
        } 
        else {
            respond Gender.findAllByRecStatus(params.recStatus, params), model:[genderInstanceCount: Gender.count()] 
        } 
    }
    
    def show(Gender genderInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && genderInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond genderInstance
    }

    def create() {
        respond new Gender(params)
    }

    @Transactional
    def save(Gender genderInstance) {
        if (genderInstance == null) {
            notFound()
            return
        }

        if (genderInstance.hasErrors()) {
            respond genderInstance.errors, view:'create'
            return
        }

        genderInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'genderInstance.label', default: 'Gender'), genderInstance.id])
                redirect genderInstance
            }
            '*' { respond genderInstance, [status: CREATED] }
        }
    }

    def edit(Gender genderInstance) {
        respond genderInstance
    }

    @Transactional
    def update(Gender genderInstance) {
        if (genderInstance == null) {
            notFound()
            return
        }

        if (genderInstance.hasErrors()) {
            respond genderInstance.errors, view:'edit'
            return
        }

        genderInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Gender.label', default: 'Gender'), genderInstance.id])
                redirect genderInstance
            }
            '*'{ respond genderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Gender genderInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/gender/delete/2
        if (genderInstance == null) {
            notFound()
            return
        }
        genderInstance.recStatus="Deleted"
        genderInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Gender.label', default: 'Gender'), genderInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond genderInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(Gender genderInstance) { 
        // example: http://localhost:9991/Commons/gender/undelete/2
        if (genderInstance == null) {
            notFound()
            return
        }
        genderInstance.recStatus="Active"
        genderInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Gender.label', default: 'Gender'), genderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond genderInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    }    

    
    def shortList() {
        // example: <server:port>/Commons/gender/shortList
        def genderInstance =  Gender.findAll()
        if (genderInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        genderInstance.each {
            result["$it.id"] = [ title:"$it.title", titleInt:"$it.titleInt", id:"$it.id", notes:"$it.notes"] 
        }
        withFormat{       
            html {render result as JSON}
            xml  {render  result as XML}
            '*' {render result as JSON}    
        }  
    }      

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'genderInstance.label', default: 'Gender'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
