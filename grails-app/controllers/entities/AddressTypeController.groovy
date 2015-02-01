package entities
  
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AddressTypeController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:'POST',
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
            respond AddressType.list(params), model:[addressTypeInstanceCount: AddressType.count()]
        } 
        else {
            respond AddressType.findAllByRecStatus(params.recStatus, params), model:[addressTypeInstanceCount: AddressType.count()] 
        } 
    }


    def show(AddressType addressTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && addressTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond addressTypeInstance
    }

    def create() {
        respond new AddressType(params)
    }

    @Transactional
    def save(AddressType addressTypeInstance) {
        if (addressTypeInstance == null) {
            notFound()
            return
        }

        if (addressTypeInstance.hasErrors()) {
            respond addressTypeInstance.errors, view:'create'
            return
        }

        addressTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'addressTypeInstance.label', default: 'AddressType'), addressTypeInstance.id])
                redirect addressTypeInstance
            }
            '*' { respond addressTypeInstance, [status: CREATED] }
        }
    }

    def edit(AddressType addressTypeInstance) {
        respond addressTypeInstance
    }

    @Transactional
    def update(AddressType addressTypeInstance) {
        if (addressTypeInstance == null) {
            notFound()
            return
        }

        if (addressTypeInstance.hasErrors()) {
            respond addressTypeInstance.errors, view:'edit'
            return
        }

        addressTypeInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AddressType.label', default: 'AddressType'), addressTypeInstance.id])
                redirect addressTypeInstance
            }
            '*'{ respond addressTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AddressType addressTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/addressType/delete/2
        if (addressTypeInstance == null) {
            notFound()
            return
        }
        addressTypeInstance.recStatus="Deleted"
        addressTypeInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AddressType.label', default: 'AddressType'), addressTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond addressTypeInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(AddressType addressTypeInstance) { 
        // example: http://localhost:9991/Commons/addressType/undelete/2
        if (addressTypeInstance == null) {
            notFound()
            return
        }
        addressTypeInstance.recStatus="Active"
        addressTypeInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'AddressType.label', default: 'AddressType'), addressTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond addressTypeInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'addressTypeInstance.label', default: 'AddressType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }   
    
    def shortList() {
        // example: <server:port>/Commons/addressType/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def addressTypeInstance 
        if (params.recStatus == "All" ) { 
            addressTypeInstance = AddressType.list(params)
        } 
        else {
            addressTypeInstance = AddressType.findAllByRecStatus(params.recStatus, params)
        } 
        if (addressTypeInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        addressTypeInstance.each {
            result["$it.id"] = [ title:"$it.title", titleInt:"$it.titleInt", id:"$it.id", notes:"$it.notes"] 
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*' {render result as JSON}    
        }  
    }    
}
