<%@ page import="entities.PersonalId" %>



<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="personalId.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${entities.Person.list()}" optionKey="id" required="" value="${personalIdInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'idType', 'error')} required">
	<label for="idType">
		<g:message code="personalId.idType.label" default="Id Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="idType" name="idType.id" from="${entities.PersonalIdType.list()}" optionKey="id" required="" value="${personalIdInstance?.idType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'idCode', 'error')} required">
	<label for="idCode">
		<g:message code="personalId.idCode.label" default="Id Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idCode" maxlength="20" required="" value="${personalIdInstance?.idCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'issueDate', 'error')} required">
	<label for="issueDate">
		<g:message code="personalId.issueDate.label" default="Issue Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="issueDate" precision="day"  value="${personalIdInstance?.issueDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'validUntil', 'error')} required">
	<label for="validUntil">
		<g:message code="personalId.validUntil.label" default="Valid Until" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="validUntil" precision="day"  value="${personalIdInstance?.validUntil}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'issuedBy', 'error')} required">
	<label for="issuedBy">
		<g:message code="personalId.issuedBy.label" default="Issued By" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="issuedBy" required="" value="${personalIdInstance?.issuedBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'countryCode2', 'error')} required">
	<label for="countryCode2">
		<g:message code="personalId.countryCode2.label" default="Country Code2" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="countryCode2" maxlength="2" required="" value="${personalIdInstance?.countryCode2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'idStatus', 'error')} ">
	<label for="idStatus">
		<g:message code="personalId.idStatus.label" default="Id Status" />
		
	</label>
	<g:select id="idStatus" name="idStatus.id" from="${entities.IdStatus.list()}" optionKey="id" value="${personalIdInstance?.idStatus?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="personalId.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${personalIdInstance?.notes}"/>
</div>

