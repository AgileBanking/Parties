<%@ page import="entities.LegalEntityType" %>



<div class="fieldcontain ${hasErrors(bean: legalEntityTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="legalEntityType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${legalEntityTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityTypeInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="legalEntityType.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${legalEntityTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="legalEntityType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${legalEntityTypeInstance?.notes}"/>
</div>

