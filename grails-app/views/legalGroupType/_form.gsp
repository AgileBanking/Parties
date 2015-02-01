<%@ page import="entities.LegalGroupType" %>



<div class="fieldcontain ${hasErrors(bean: legalGroupTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="legalGroupType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="40" required="" value="${legalGroupTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupTypeInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="legalGroupType.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" maxlength="40" value="${legalGroupTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupTypeInstance, field: 'legalGroups', 'error')} ">
	<label for="legalGroups">
		<g:message code="legalGroupType.legalGroups.label" default="Legal Groups" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${legalGroupTypeInstance?.legalGroups?}" var="l">
    <li><g:link controller="legalGroup" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="legalGroup" action="create" params="['legalGroupType.id': legalGroupTypeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'legalGroup.label', default: 'LegalGroup')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="legalGroupType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${legalGroupTypeInstance?.notes}"/>
</div>

