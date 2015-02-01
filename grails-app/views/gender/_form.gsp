<%@ page import="entities.Gender" %>



<div class="fieldcontain ${hasErrors(bean: genderInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="gender.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="20" required="" value="${genderInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: genderInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="gender.titleInt.label" default="Title Int" />
		
	</label>
	<g:select name="titleInt" from="${genderInstance.constraints.titleInt.inList}" value="${genderInstance?.titleInt}" valueMessagePrefix="gender.titleInt" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: genderInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="gender.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${genderInstance?.notes}"/>
</div>

