<%@ page import="entities.PRelationWithUs" %>



<div class="fieldcontain ${hasErrors(bean: PRelationWithUsInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="PRelationWithUs.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${PRelationWithUsInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PRelationWithUsInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="PRelationWithUs.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${PRelationWithUsInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PRelationWithUsInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="PRelationWithUs.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${PRelationWithUsInstance?.notes}"/>
</div>

