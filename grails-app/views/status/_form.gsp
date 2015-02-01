<%@ page import="entities.Status" %>



<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="status.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="20" required="" value="${statusInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="status.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" maxlength="20" required="" value="${statusInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statusInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="status.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${statusInstance?.notes}"/>
</div>

