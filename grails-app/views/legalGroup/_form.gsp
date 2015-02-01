<%@ page import="entities.LegalGroup" %>



<div class="fieldcontain ${hasErrors(bean: legalGroupInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="legalGroup.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="40" required="" value="${legalGroupInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="legalGroup.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" maxlength="40" value="${legalGroupInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="legalGroup.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${legalGroupInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupInstance, field: 'legalGroupType', 'error')} required">
	<label for="legalGroupType">
		<g:message code="legalGroup.legalGroupType.label" default="Legal Group Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="legalGroupType" name="legalGroupType.id" from="${entities.LegalGroupType.list()}" optionKey="id" required="" value="${legalGroupInstance?.legalGroupType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupInstance, field: 'relatedEntities', 'error')} ">
	<label for="relatedEntities">
		<g:message code="legalGroup.relatedEntities.label" default="Related Entities" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${legalGroupInstance?.relatedEntities?}" var="r">
    <li><g:link controller="legalGroupRelation" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="legalGroupRelation" action="create" params="['legalGroup.id': legalGroupInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'legalGroupRelation.label', default: 'LegalGroupRelation')])}</g:link>
</li>
</ul>

</div>

