<%@ page import="entities.WebProfileType" %>



<div class="fieldcontain ${hasErrors(bean: webProfileTypeInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="webProfileType.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${webProfileTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: webProfileTypeInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="webProfileType.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${webProfileTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: webProfileTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="webProfileType.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" value="${webProfileTypeInstance?.notes}"/>
</div>

