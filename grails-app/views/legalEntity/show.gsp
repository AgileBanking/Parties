
<%@ page import="entities.LegalEntity" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalEntity.label', default: 'LegalEntity')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-legalEntity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-legalEntity" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list legalEntity">
			
				<g:if test="${legalEntityInstance?.marketName}">
				<li class="fieldcontain">
					<span id="marketName-label" class="property-label"><g:message code="legalEntity.marketName.label" default="Market Name" /></span>
					
						<span class="property-value" aria-labelledby="marketName-label"><g:fieldValue bean="${legalEntityInstance}" field="marketName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.registeredName}">
				<li class="fieldcontain">
					<span id="registeredName-label" class="property-label"><g:message code="legalEntity.registeredName.label" default="Registered Name" /></span>
					
						<span class="property-value" aria-labelledby="registeredName-label"><g:fieldValue bean="${legalEntityInstance}" field="registeredName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.legalType}">
				<li class="fieldcontain">
					<span id="legalType-label" class="property-label"><g:message code="legalEntity.legalType.label" default="Legal Type" /></span>
					
						<span class="property-value" aria-labelledby="legalType-label"><g:link controller="legalEntityType" action="show" id="${legalEntityInstance?.legalType?.id}">${legalEntityInstance?.legalType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.hQAddress}">
				<li class="fieldcontain">
					<span id="hQAddress-label" class="property-label"><g:message code="legalEntity.hQAddress.label" default="HQA ddress" /></span>
					
						<span class="property-value" aria-labelledby="hQAddress-label"><g:link controller="address" action="show" id="${legalEntityInstance?.hQAddress?.id}">${legalEntityInstance?.hQAddress?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.language}">
				<li class="fieldcontain">
					<span id="language-label" class="property-label"><g:message code="legalEntity.language.label" default="Language" /></span>
					
						<span class="property-value" aria-labelledby="language-label"><g:fieldValue bean="${legalEntityInstance}" field="language"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.marketSegment}">
				<li class="fieldcontain">
					<span id="marketSegment-label" class="property-label"><g:message code="legalEntity.marketSegment.label" default="Market Segment" /></span>
					
						<span class="property-value" aria-labelledby="marketSegment-label"><g:link controller="marketSegment" action="show" id="${legalEntityInstance?.marketSegment?.id}">${legalEntityInstance?.marketSegment?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.corporateRate}">
				<li class="fieldcontain">
					<span id="corporateRate-label" class="property-label"><g:message code="legalEntity.corporateRate.label" default="Corporate Rate" /></span>
					
						<span class="property-value" aria-labelledby="corporateRate-label"><g:fieldValue bean="${legalEntityInstance}" field="corporateRate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.listingStatus}">
				<li class="fieldcontain">
					<span id="listingStatus-label" class="property-label"><g:message code="legalEntity.listingStatus.label" default="Listing Status" /></span>
					
						<span class="property-value" aria-labelledby="listingStatus-label"><g:fieldValue bean="${legalEntityInstance}" field="listingStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.registration}">
				<li class="fieldcontain">
					<span id="registration-label" class="property-label"><g:message code="legalEntity.registration.label" default="Registration" /></span>
					
						<span class="property-value" aria-labelledby="registration-label"><g:link controller="registration" action="show" id="${legalEntityInstance?.registration?.id}">${legalEntityInstance?.registration?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.relWithUs}">
				<li class="fieldcontain">
					<span id="relWithUs-label" class="property-label"><g:message code="legalEntity.relWithUs.label" default="Rel With Us" /></span>
					
						<g:each in="${legalEntityInstance.relWithUs}" var="r">
						<span class="property-value" aria-labelledby="relWithUs-label"><g:link controller="relationWithUs" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.legalPersons}">
				<li class="fieldcontain">
					<span id="legalPersons-label" class="property-label"><g:message code="legalEntity.legalPersons.label" default="Legal Persons" /></span>
					
						<g:each in="${legalEntityInstance.legalPersons}" var="l">
						<span class="property-value" aria-labelledby="legalPersons-label"><g:link controller="legalPerson" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.taxID}">
				<li class="fieldcontain">
					<span id="taxID-label" class="property-label"><g:message code="legalEntity.taxID.label" default="Tax ID" /></span>
					
						<span class="property-value" aria-labelledby="taxID-label"><g:fieldValue bean="${legalEntityInstance}" field="taxID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.webSite}">
				<li class="fieldcontain">
					<span id="webSite-label" class="property-label"><g:message code="legalEntity.webSite.label" default="Web Site" /></span>
					
						<span class="property-value" aria-labelledby="webSite-label"><g:fieldValue bean="${legalEntityInstance}" field="webSite"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="legalEntity.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:link controller="status" action="show" id="${legalEntityInstance?.status?.id}">${legalEntityInstance?.status?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.oldSysId}">
				<li class="fieldcontain">
					<span id="oldSysId-label" class="property-label"><g:message code="legalEntity.oldSysId.label" default="Old Sys Id" /></span>
					
						<span class="property-value" aria-labelledby="oldSysId-label"><g:fieldValue bean="${legalEntityInstance}" field="oldSysId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="legalEntity.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${legalEntityInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="legalEntity.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${legalEntityInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.businessAddress}">
				<li class="fieldcontain">
					<span id="businessAddress-label" class="property-label"><g:message code="legalEntity.businessAddress.label" default="Business Address" /></span>
					
						<span class="property-value" aria-labelledby="businessAddress-label"><g:link controller="address" action="show" id="${legalEntityInstance?.businessAddress?.id}">${legalEntityInstance?.businessAddress?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="legalEntity.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${legalEntityInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalEntityInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="legalEntity.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${legalEntityInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:legalEntityInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${legalEntityInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
