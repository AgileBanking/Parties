<%@ page import="entities.IdStatus" %>



<div class="fieldcontain ${hasErrors(bean: idStatusInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="idStatus.title.label" default="Title" />
		
	</label>
	<g:textField name="title" maxlength="20" value="${idStatusInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: idStatusInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="idStatus.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" maxlength="20" value="${idStatusInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: idStatusInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="idStatus.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${idStatusInstance?.notes}"/>
</div>

