<%@ page import="entities.Signature" %>



<div class="fieldcontain ${hasErrors(bean: signatureInstance, field: 'image', 'error')} ">
	<label for="image">
		<g:message code="signature.image.label" default="Image" />
		
	</label>
	<input type="file" id="image" name="image" />
</div>

<div class="fieldcontain ${hasErrors(bean: signatureInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="signature.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${signatureInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: signatureInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="signature.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${entities.Person.list()}" optionKey="id" required="" value="${signatureInstance?.person?.id}" class="many-to-one"/>
</div>

