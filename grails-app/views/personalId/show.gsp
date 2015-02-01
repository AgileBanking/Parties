
<%@ page import="entities.PersonalId" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personalId.label', default: 'PersonalId')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-personalId" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-personalId" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list personalId">
			
				<g:if test="${personalIdInstance?.person}">
				<li class="fieldcontain">
					<span id="person-label" class="property-label"><g:message code="personalId.person.label" default="Person" /></span>
					
						<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="show" id="${personalIdInstance?.person?.id}">${personalIdInstance?.person?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.idType}">
				<li class="fieldcontain">
					<span id="idType-label" class="property-label"><g:message code="personalId.idType.label" default="Id Type" /></span>
					
						<span class="property-value" aria-labelledby="idType-label"><g:link controller="personalIdType" action="show" id="${personalIdInstance?.idType?.id}">${personalIdInstance?.idType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.idCode}">
				<li class="fieldcontain">
					<span id="idCode-label" class="property-label"><g:message code="personalId.idCode.label" default="Id Code" /></span>
					
						<span class="property-value" aria-labelledby="idCode-label"><g:fieldValue bean="${personalIdInstance}" field="idCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.issueDate}">
				<li class="fieldcontain">
					<span id="issueDate-label" class="property-label"><g:message code="personalId.issueDate.label" default="Issue Date" /></span>
					
						<span class="property-value" aria-labelledby="issueDate-label"><g:formatDate date="${personalIdInstance?.issueDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.validUntil}">
				<li class="fieldcontain">
					<span id="validUntil-label" class="property-label"><g:message code="personalId.validUntil.label" default="Valid Until" /></span>
					
						<span class="property-value" aria-labelledby="validUntil-label"><g:formatDate date="${personalIdInstance?.validUntil}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.issuedBy}">
				<li class="fieldcontain">
					<span id="issuedBy-label" class="property-label"><g:message code="personalId.issuedBy.label" default="Issued By" /></span>
					
						<span class="property-value" aria-labelledby="issuedBy-label"><g:fieldValue bean="${personalIdInstance}" field="issuedBy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.countryCode2}">
				<li class="fieldcontain">
					<span id="countryCode2-label" class="property-label"><g:message code="personalId.countryCode2.label" default="Country Code2" /></span>
					
						<span class="property-value" aria-labelledby="countryCode2-label"><g:fieldValue bean="${personalIdInstance}" field="countryCode2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.idStatus}">
				<li class="fieldcontain">
					<span id="idStatus-label" class="property-label"><g:message code="personalId.idStatus.label" default="Id Status" /></span>
					
						<span class="property-value" aria-labelledby="idStatus-label"><g:link controller="idStatus" action="show" id="${personalIdInstance?.idStatus?.id}">${personalIdInstance?.idStatus?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="personalId.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${personalIdInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="personalId.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${personalIdInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="personalId.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${personalIdInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personalIdInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="personalId.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${personalIdInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:personalIdInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${personalIdInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
