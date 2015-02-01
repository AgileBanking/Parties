package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AddressController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        shortList: 'GET',
        customQuery: 'GET',
        delete:'POST',
        undelete:'POST'
    ]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond Address.list(params), model:[addressInstanceCount: Address.count()]
        } 
        else {
            respond Address.findAllByRecStatus(params.recStatus, params), model:[addressInstanceCount: Address.count()] 
        }     }

    def show(Address addressInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && addressInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond addressInstance
    }

    def create() {
        respond new Address(params)
    }

    @Transactional
    def save(Address addressInstance) {
        if (addressInstance == null) {
            notFound()
            return
        }

        if (addressInstance.hasErrors()) {
            respond addressInstance.errors, view:'create'
            return
        }

        addressInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'addressInstance.label', default: 'Address'), addressInstance.id])
                redirect addressInstance
            }
            '*' { respond addressInstance, [status: CREATED] }
        }
    }

    def edit(Address addressInstance) {
        respond addressInstance
    }

    @Transactional
    def update(Address addressInstance) {
        if (addressInstance == null) {
            notFound()
            return
        }

        if (addressInstance.hasErrors()) {
            respond addressInstance.errors, view:'edit'
            return
        }

        addressInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Address.label', default: 'Address'), addressInstance.id])
                redirect addressInstance
            }
            '*'{ respond addressInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Address addressInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/address/delete/2
        if (addressInstance == null) {
            notFound()
            return
        }
        addressInstance.recStatus="Deleted"
        addressInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Address.label', default: 'Address'), addressInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond addressInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(Address addressInstance) { 
        // example: http://localhost:9991/Commons/address/undelete/2
        if (addressInstance == null) {
            notFound()
            return
        }
        addressInstance.recStatus="Active"
        addressInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Address.label', default: 'Address'), addressInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond addressInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    } 
    
    def shortList() {
        // example: <server:port>/Commons/address/shortList
        def addressInstance =  Address.findAll()
        if (addressInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result = [:] 
        addressInstance.each {
            if (it.recStatus == "All" || it.recStatus == params.recStatus) {
                result["$it.street $it.streetNumber, $it.city"] = [ addressType:"$it.addressType", country:"$it.countryCode2", id:"$it.notes", recStatus:"$it.recStatus"]
            }
        }
        respond result
    }    
    
    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'addressInstance.label', default: 'Address'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
