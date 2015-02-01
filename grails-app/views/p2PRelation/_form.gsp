<%@ page import="entities.P2PRelation" %>



<div class="fieldcontain ${hasErrors(bean: p2PRelationInstance, field: 'p2pRelation', 'error')} required">
	<label for="p2pRelation">
		<g:message code="p2PRelation.p2pRelation.label" default="P2p Relation" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="p2pRelation" name="p2pRelation.id" from="${entities.P2PRelationType.list()}" optionKey="id" required="" value="${p2PRelationInstance?.p2pRelation?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationInstance, field: 'fromPerson', 'error')} required">
	<label for="fromPerson">
		<g:message code="p2PRelation.fromPerson.label" default="From Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fromPerson" name="fromPerson.id" from="${entities.Person.list()}" optionKey="id" required="" value="${p2PRelationInstance?.fromPerson?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationInstance, field: 'toPerson', 'error')} required">
	<label for="toPerson">
		<g:message code="p2PRelation.toPerson.label" default="To Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="toPerson" name="toPerson.id" from="${entities.Person.list()}" optionKey="id" required="" value="${p2PRelationInstance?.toPerson?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="p2PRelation.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${p2PRelationInstance?.notes}"/>
</div>

