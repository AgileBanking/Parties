package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class ContractualAbilityController extends BaseController {

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
            respond ContractualAbility.list(params), model:[contractualAbilityInstanceCount: ContractualAbility.count()]
        } 
        else {
            respond ContractualAbility.findAllByRecStatus(params.recStatus, params), model:[contractualAbilityInstanceCount: ContractualAbility.count()] 
        } 
    }
    
    def show(ContractualAbility contractualAbilityInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && contractualAbilityInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond contractualAbilityInstance
    }

    def create() {
        respond new ContractualAbility(params)
    }

    @Transactional
    def save(ContractualAbility contractualAbilityInstance) {
        if (contractualAbilityInstance == null) {
            notFound()
            return
        }

        if (contractualAbilityInstance.hasErrors()) {
            respond contractualAbilityInstance.errors, view:'create'
            return
        }

        contractualAbilityInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'contractualAbilityInstance.label', default: 'ContractualAbility'), contractualAbilityInstance.id])
                redirect contractualAbilityInstance
            }
            '*' { respond contractualAbilityInstance, [status: CREATED] }
        }
    }

    def edit(ContractualAbility contractualAbilityInstance) {
        respond contractualAbilityInstance
    }

    @Transactional
    def update(ContractualAbility contractualAbilityInstance) {
        if (contractualAbilityInstance == null) {
            notFound()
            return
        }

        if (contractualAbilityInstance.hasErrors()) {
            respond contractualAbilityInstance.errors, view:'edit'
            return
        }

        contractualAbilityInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ContractualAbility.label', default: 'ContractualAbility'), contractualAbilityInstance.id])
                redirect contractualAbilityInstance
            }
            '*'{ respond contractualAbilityInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ContractualAbility contractualAbilityInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/contractualAbility/delete/2
        if (contractualAbilityInstance == null) {
            notFound()
            return
        }
        contractualAbilityInstance.recStatus="Deleted"
        contractualAbilityInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ContractualAbility.label', default: 'ContractualAbility'), contractualAbilityInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond contractualAbilityInstance //, [status: NO_CONTENT] 
            }
//             '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional 
    def undelete(ContractualAbility contractualAbilityInstance) { 
        // example: http://localhost:9991/Commons/contractualAbility/undelete/2
        if (contractualAbilityInstance == null) {
            notFound()
            return
        }
        contractualAbilityInstance.recStatus="Active"
        contractualAbilityInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'ContractualAbility.label', default: 'ContractualAbility'), contractualAbilityInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond contractualAbilityInstance //, [status: NO_CONTENT] 
//              render status: NO_CONTENT 
            }
        }
    }        
    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contractualAbilityInstance.label', default: 'ContractualAbility'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
}
