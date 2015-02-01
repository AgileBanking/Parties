<%@ page import="entities.Salutation" %>



<div class="fieldcontain ${hasErrors(bean: salutationInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="salutation.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${salutationInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: salutationInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="salutation.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${salutationInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: salutationInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="salutation.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${salutationInstance?.notes}"/>
</div>

