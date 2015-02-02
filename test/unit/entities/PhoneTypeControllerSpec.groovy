package entities

import grails.test.mixin.*
import spock.lang.*

@TestFor(PhoneTypeController)
@Mock(PhoneType)
class PhoneTypeControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.phoneTypeInstanceList
            model.phoneTypeInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.phoneTypeInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def phoneType = new PhoneType()
            phoneType.validate()
            controller.save(phoneType)

        then:"The create view is rendered again with the correct model"
            model.phoneTypeInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            phoneType = new PhoneType(params)

            controller.save(phoneType)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/phoneType/show/1'
            controller.flash.message != null
            PhoneType.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def phoneType = new PhoneType(params)
            controller.show(phoneType)

        then:"A model is populated containing the domain instance"
            model.phoneTypeInstance == phoneType
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def phoneType = new PhoneType(params)
            controller.edit(phoneType)

        then:"A model is populated containing the domain instance"
            model.phoneTypeInstance == phoneType
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/phoneType/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def phoneType = new PhoneType()
            phoneType.validate()
            controller.update(phoneType)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.phoneTypeInstance == phoneType

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            phoneType = new PhoneType(params).save(flush: true)
            controller.update(phoneType)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/phoneType/show/$phoneType.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/phoneType/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def phoneType = new PhoneType(params).save(flush: true)

        then:"It exists"
            PhoneType.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(phoneType)

        then:"The instance is deleted"
            PhoneType.count() == 0
            response.redirectedUrl == '/phoneType/index'
            flash.message != null
    }
}
