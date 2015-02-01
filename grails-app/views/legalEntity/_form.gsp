<%@ page import="entities.LegalEntity" %>



<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'marketName', 'error')} required">
	<label for="marketName">
		<g:message code="legalEntity.marketName.label" default="Market Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="marketName" maxlength="40" required="" value="${legalEntityInstance?.marketName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'registeredName', 'error')} required">
	<label for="registeredName">
		<g:message code="legalEntity.registeredName.label" default="Registered Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="registeredName" maxlength="100" required="" value="${legalEntityInstance?.registeredName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'legalType', 'error')} required">
	<label for="legalType">
		<g:message code="legalEntity.legalType.label" default="Legal Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="legalType" name="legalType.id" from="${entities.LegalEntityType.list()}" optionKey="id" required="" value="${legalEntityInstance?.legalType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'hQAddress', 'error')} required">
	<label for="hQAddress">
		<g:message code="legalEntity.hQAddress.label" default="HQA ddress" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="hQAddress" name="hQAddress.id" from="${entities.Address.list()}" optionKey="id" required="" value="${legalEntityInstance?.hQAddress?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'language', 'error')} ">
	<label for="language">
		<g:message code="legalEntity.language.label" default="Language" />
		
	</label>
	<g:textField name="language" value="${legalEntityInstance?.language}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'marketSegment', 'error')} required">
	<label for="marketSegment">
		<g:message code="legalEntity.marketSegment.label" default="Market Segment" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="marketSegment" name="marketSegment.id" from="${entities.MarketSegment.list()}" optionKey="id" required="" value="${legalEntityInstance?.marketSegment?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'corporateRate', 'error')} ">
	<label for="corporateRate">
		<g:message code="legalEntity.corporateRate.label" default="Corporate Rate" />
		
	</label>
	<g:textField name="corporateRate" value="${legalEntityInstance?.corporateRate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'listingStatus', 'error')} required">
	<label for="listingStatus">
		<g:message code="legalEntity.listingStatus.label" default="Listing Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="listingStatus" required="" value="${legalEntityInstance?.listingStatus}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'registration', 'error')} ">
	<label for="registration">
		<g:message code="legalEntity.registration.label" default="Registration" />
		
	</label>
	<g:select id="registration" name="registration.id" from="${entities.Registration.list()}" optionKey="id" value="${legalEntityInstance?.registration?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'relWithUs', 'error')} ">
	<label for="relWithUs">
		<g:message code="legalEntity.relWithUs.label" default="Rel With Us" />
		
	</label>
	<g:select name="relWithUs" from="${entities.RelationWithUs.list()}" multiple="multiple" optionKey="id" size="5" value="${legalEntityInstance?.relWithUs*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'legalPersons', 'error')} ">
	<label for="legalPersons">
		<g:message code="legalEntity.legalPersons.label" default="Legal Persons" />
		
	</label>
	<g:select name="legalPersons" from="${entities.LegalPerson.list()}" multiple="multiple" optionKey="id" size="5" value="${legalEntityInstance?.legalPersons*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'taxID', 'error')} required">
	<label for="taxID">
		<g:message code="legalEntity.taxID.label" default="Tax ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="taxID" maxlength="15" required="" value="${legalEntityInstance?.taxID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'webSite', 'error')} ">
	<label for="webSite">
		<g:message code="legalEntity.webSite.label" default="Web Site" />
		
	</label>
	<g:field type="url" name="webSite" value="${legalEntityInstance?.webSite}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="legalEntity.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="status" name="status.id" from="${entities.Status.list()}" optionKey="id" required="" value="${legalEntityInstance?.status?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'oldSysId', 'error')} ">
	<label for="oldSysId">
		<g:message code="legalEntity.oldSysId.label" default="Old Sys Id" />
		
	</label>
	<g:textField name="oldSysId" value="${legalEntityInstance?.oldSysId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="legalEntity.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${legalEntityInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalEntityInstance, field: 'businessAddress', 'error')} required">
	<label for="businessAddress">
		<g:message code="legalEntity.businessAddress.label" default="Business Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="businessAddress" name="businessAddress.id" from="${entities.Address.list()}" optionKey="id" required="" value="${legalEntityInstance?.businessAddress?.id}" class="many-to-one"/>
</div>

