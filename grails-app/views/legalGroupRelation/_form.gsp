<%@ page import="entities.LegalGroupRelation" %>



<div class="fieldcontain ${hasErrors(bean: legalGroupRelationInstance, field: 'legalEntityGroup', 'error')} required">
	<label for="legalEntityGroup">
		<g:message code="legalGroupRelation.legalEntityGroup.label" default="Legal Entity Group" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="legalEntityGroup" name="legalEntityGroup.id" from="${entities.LegalGroup.list()}" optionKey="id" required="" value="${legalGroupRelationInstance?.legalEntityGroup?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupRelationInstance, field: 'member1', 'error')} required">
	<label for="member1">
		<g:message code="legalGroupRelation.member1.label" default="Member1" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="member1" name="member1.id" from="${entities.LegalEntity.list()}" optionKey="id" required="" value="${legalGroupRelationInstance?.member1?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupRelationInstance, field: 'member2', 'error')} required">
	<label for="member2">
		<g:message code="legalGroupRelation.member2.label" default="Member2" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="member2" name="member2.id" from="${entities.LegalEntity.list()}" optionKey="id" required="" value="${legalGroupRelationInstance?.member2?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupRelationInstance, field: 'lastRevision', 'error')} required">
	<label for="lastRevision">
		<g:message code="legalGroupRelation.lastRevision.label" default="Last Revision" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastRevision" precision="day"  value="${legalGroupRelationInstance?.lastRevision}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupRelationInstance, field: 'nextRevision', 'error')} ">
	<label for="nextRevision">
		<g:message code="legalGroupRelation.nextRevision.label" default="Next Revision" />
		
	</label>
	<g:datePicker name="nextRevision" precision="day"  value="${legalGroupRelationInstance?.nextRevision}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: legalGroupRelationInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="legalGroupRelation.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${legalGroupRelationInstance?.notes}"/>
</div>

