<%@ page import="entities.PhoneType" %>



<div class="fieldcontain ${hasErrors(bean: phoneTypeInstance, field: 'phoneType', 'error')} required">
	<label for="phoneType">
		<g:message code="phoneType.phoneType.label" default="Phone Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phoneType" maxlength="30" required="" value="${phoneTypeInstance?.phoneType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: phoneTypeInstance, field: 'phoneTypeInt', 'error')} ">
	<label for="phoneTypeInt">
		<g:message code="phoneType.phoneTypeInt.label" default="Phone Type Int" />
		
	</label>
	<g:textField name="phoneTypeInt" maxlength="30" value="${phoneTypeInstance?.phoneTypeInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: phoneTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="phoneType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${phoneTypeInstance?.notes}"/>
</div>

