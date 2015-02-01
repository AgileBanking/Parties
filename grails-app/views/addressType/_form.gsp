<%@ page import="entities.AddressType" %>



<div class="fieldcontain ${hasErrors(bean: addressTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="addressType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="30" required="" value="${addressTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressTypeInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="addressType.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" maxlength="30" value="${addressTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="addressType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${addressTypeInstance?.notes}"/>
</div>

