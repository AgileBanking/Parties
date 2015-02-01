<%@ page import="entities.RelationWithUs" %>



<div class="fieldcontain ${hasErrors(bean: relationWithUsInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="relationWithUs.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${relationWithUsInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: relationWithUsInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="relationWithUs.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${relationWithUsInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: relationWithUsInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="relationWithUs.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${relationWithUsInstance?.notes}"/>
</div>

