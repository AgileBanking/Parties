
<%@ page import="entities.LegalPerson" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalPerson.label', default: 'LegalPerson')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-legalPerson" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-legalPerson" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list legalPerson">
			
				<g:if test="${legalPersonInstance?.person}">
				<li class="fieldcontain">
					<span id="person-label" class="property-label"><g:message code="legalPerson.person.label" default="Person" /></span>
					
						<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="show" id="${legalPersonInstance?.person?.id}">${legalPersonInstance?.person?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalPersonInstance?.repType}">
				<li class="fieldcontain">
					<span id="repType-label" class="property-label"><g:message code="legalPerson.repType.label" default="Rep Type" /></span>
					
						<span class="property-value" aria-labelledby="repType-label"><g:link controller="LRepType" action="show" id="${legalPersonInstance?.repType?.id}">${legalPersonInstance?.repType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalPersonInstance?.expdate}">
				<li class="fieldcontain">
					<span id="expdate-label" class="property-label"><g:message code="legalPerson.expdate.label" default="Expdate" /></span>
					
						<span class="property-value" aria-labelledby="expdate-label"><g:formatDate date="${legalPersonInstance?.expdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalPersonInstance?.terms}">
				<li class="fieldcontain">
					<span id="terms-label" class="property-label"><g:message code="legalPerson.terms.label" default="Terms" /></span>
					
						<span class="property-value" aria-labelledby="terms-label"><g:fieldValue bean="${legalPersonInstance}" field="terms"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalPersonInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="legalPerson.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${legalPersonInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:legalPersonInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${legalPersonInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
