
<%@ page import="entities.Registration" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registration.label', default: 'Registration')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-registration" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-registration" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list registration">
			
				<g:if test="${registrationInstance?.legalEntity}">
				<li class="fieldcontain">
					<span id="legalEntity-label" class="property-label"><g:message code="registration.legalEntity.label" default="Legal Entity" /></span>
					
						<span class="property-value" aria-labelledby="legalEntity-label"><g:link controller="legalEntity" action="show" id="${registrationInstance?.legalEntity?.id}">${registrationInstance?.legalEntity?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.register}">
				<li class="fieldcontain">
					<span id="register-label" class="property-label"><g:message code="registration.register.label" default="Register" /></span>
					
						<span class="property-value" aria-labelledby="register-label"><g:link controller="register" action="show" id="${registrationInstance?.register?.id}">${registrationInstance?.register?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.regId}">
				<li class="fieldcontain">
					<span id="regId-label" class="property-label"><g:message code="registration.regId.label" default="Reg Id" /></span>
					
						<span class="property-value" aria-labelledby="regId-label"><g:fieldValue bean="${registrationInstance}" field="regId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.regDate}">
				<li class="fieldcontain">
					<span id="regDate-label" class="property-label"><g:message code="registration.regDate.label" default="Reg Date" /></span>
					
						<span class="property-value" aria-labelledby="regDate-label"><g:formatDate date="${registrationInstance?.regDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.expDate}">
				<li class="fieldcontain">
					<span id="expDate-label" class="property-label"><g:message code="registration.expDate.label" default="Exp Date" /></span>
					
						<span class="property-value" aria-labelledby="expDate-label"><g:formatDate date="${registrationInstance?.expDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="registration.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${registrationInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="registration.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${registrationInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="registration.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${registrationInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="registration.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${registrationInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:registrationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${registrationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
