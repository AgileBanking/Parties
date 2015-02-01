
<%@ page import="entities.Register" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'register.label', default: 'Register')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-register" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-register" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list register">
			
				<g:if test="${registerInstance?.authority}">
				<li class="fieldcontain">
					<span id="authority-label" class="property-label"><g:message code="register.authority.label" default="Authority" /></span>
					
						<span class="property-value" aria-labelledby="authority-label"><g:fieldValue bean="${registerInstance}" field="authority"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.authorityInt}">
				<li class="fieldcontain">
					<span id="authorityInt-label" class="property-label"><g:message code="register.authorityInt.label" default="Authority Int" /></span>
					
						<span class="property-value" aria-labelledby="authorityInt-label"><g:fieldValue bean="${registerInstance}" field="authorityInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.countryCode}">
				<li class="fieldcontain">
					<span id="countryCode-label" class="property-label"><g:message code="register.countryCode.label" default="Country Code" /></span>
					
						<span class="property-value" aria-labelledby="countryCode-label"><g:fieldValue bean="${registerInstance}" field="countryCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.webAddress}">
				<li class="fieldcontain">
					<span id="webAddress-label" class="property-label"><g:message code="register.webAddress.label" default="Web Address" /></span>
					
						<span class="property-value" aria-labelledby="webAddress-label"><g:fieldValue bean="${registerInstance}" field="webAddress"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="register.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${registerInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.registrations}">
				<li class="fieldcontain">
					<span id="registrations-label" class="property-label"><g:message code="register.registrations.label" default="Registrations" /></span>
					
						<g:each in="${registerInstance.registrations}" var="r">
						<span class="property-value" aria-labelledby="registrations-label"><g:link controller="registration" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="register.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${registerInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="register.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${registerInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="register.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${registerInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registerInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="register.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${registerInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:registerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${registerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
