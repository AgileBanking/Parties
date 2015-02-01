<%@ page import="entities.WebProfile" %>



<div class="fieldcontain ${hasErrors(bean: webProfileInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="webProfile.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${entities.Person.list()}" optionKey="id" required="" value="${webProfileInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: webProfileInstance, field: 'webProfileType', 'error')} required">
	<label for="webProfileType">
		<g:message code="webProfile.webProfileType.label" default="Web Profile Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="webProfileType" name="webProfileType.id" from="${entities.WebProfileType.list()}" optionKey="id" required="" value="${webProfileInstance?.webProfileType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: webProfileInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="webProfile.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" value="${webProfileInstance?.notes}"/>
</div>

