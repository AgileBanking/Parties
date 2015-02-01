<%@ page import="entities.Phone" %>



<div class="fieldcontain ${hasErrors(bean: phoneInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="phone.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${entities.Person.list()}" optionKey="id" required="" value="${phoneInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: phoneInstance, field: 'phone', 'error')} required">
	<label for="phone">
		<g:message code="phone.phone.label" default="Phone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phone" maxlength="20" required="" value="${phoneInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: phoneInstance, field: 'phoneType', 'error')} required">
	<label for="phoneType">
		<g:message code="phone.phoneType.label" default="Phone Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="phoneType" name="phoneType.id" from="${entities.PhoneType.list()}" optionKey="id" required="" value="${phoneInstance?.phoneType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: phoneInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="phone.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" maxlength="250" value="${phoneInstance?.notes}"/>
</div>

