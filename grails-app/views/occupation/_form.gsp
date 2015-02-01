<%@ page import="entities.Occupation" %>



<div class="fieldcontain ${hasErrors(bean: occupationInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="occupation.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${occupationInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: occupationInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="occupation.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${occupationInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: occupationInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="occupation.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${occupationInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: occupationInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="occupation.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${occupationInstance?.notes}"/>
</div>

