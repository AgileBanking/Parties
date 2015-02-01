<%@ page import="entities.LRepType" %>



<div class="fieldcontain ${hasErrors(bean: LRepTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="LRepType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${LRepTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: LRepTypeInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="LRepType.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${LRepTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: LRepTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="LRepType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${LRepTypeInstance?.notes}"/>
</div>

