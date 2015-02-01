package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class PersonController extends BaseController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        isIdValid:'GET',
        getBySSN:'GET',
        getByTaxId:'GET',
        getByEMail:'GET',
        shortList:'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond Person.list(params), model:[personInstanceCount: Person.count()]
        } 
        else {
            respond Person.findAllByRecStatus(params.recStatus, params), model:[personInstanceCount: Person.count()] 
        } 
    }
    
    def show(Person personInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && personInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond personInstance
    }

    def create() {
        respond new Person(params)
    }

    @Transactional
    def save(Person personInstance) {
        if (personInstance == null) {
            notFound()
            return
        }
        println personInstance
        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'create'
            return
        }

        personInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'personInstance.label', default: 'Person'), personInstance.id])
                redirect personInstance
            }
            '*' { respond personInstance, [status: CREATED] }
        }
    }

    def edit(Person personInstance) {
        respond personInstance
    }

    @Transactional
    def update(Person personInstance) {
        if (personInstance == null) {
            notFound()
            return
        }

        if (personInstance.hasErrors()) {
            respond personInstance.errors, view:'edit'
            return
        }

        personInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect personInstance
            }
            '*'{ respond personInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Person personInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/person/delete/2
        if (personInstance == null) {
            notFound()
            return
        }
        personInstance.recStatus="Deleted"
        personInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond personInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Person personInstance) { 
        // example: http://localhost:9991/Commons/person/undelete/2
        if (personInstance == null) {
            notFound()
            return
        }
        personInstance.recStatus="Active"
        personInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond personInstance //, [status: NO_CONTENT] 
            }
        }
    } 

    def shortList() {
        render status:405
    }
    
    def getBySSN(String ssn ) {
        def personInstance = Person.findBySsn(ssn)
        if (!personInstance){
            notFound()
            return
        }
        render personInstance   as JSON
    }
    
    def isIdValid(String id ) { 
        def personInstance = Person.get(id)
        if (!personInstance){
            notFound()
            return
        }
        render status:200
    }    
    
    def getByTaxId(String taxid) { 
        def personInstance = Person.findByTaxID(taxid)
        if (!personInstance){
            notFound()
            return
        }
        render personInstance as JSON
    }

    def getByEmail(String email ) {
        def personInstance = Person.findByEmail(email)
        if (!personInstance){
            notFound()
            return
        }
        render personInstance as JSON
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personInstance.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
