<%@ page import="entities.ContractualAbility" %>



<div class="fieldcontain ${hasErrors(bean: contractualAbilityInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="contractualAbility.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${contractualAbilityInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractualAbilityInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="contractualAbility.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${contractualAbilityInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractualAbilityInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="contractualAbility.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${contractualAbilityInstance?.notes}"/>
</div>

