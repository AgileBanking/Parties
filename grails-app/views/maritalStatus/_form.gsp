<%@ page import="entities.MaritalStatus" %>



<div class="fieldcontain ${hasErrors(bean: maritalStatusInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="maritalStatus.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${maritalStatusInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: maritalStatusInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="maritalStatus.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${maritalStatusInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: maritalStatusInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="maritalStatus.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${maritalStatusInstance?.notes}"/>
</div>

