
<%@ page import="entities.PhoneType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'phoneType.label', default: 'PhoneType')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-phoneType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-phoneType" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list phoneType">
			
				<g:if test="${phoneTypeInstance?.phoneType}">
				<li class="fieldcontain">
					<span id="phoneType-label" class="property-label"><g:message code="phoneType.phoneType.label" default="Phone Type" /></span>
					
						<span class="property-value" aria-labelledby="phoneType-label"><g:fieldValue bean="${phoneTypeInstance}" field="phoneType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${phoneTypeInstance?.phoneTypeInt}">
				<li class="fieldcontain">
					<span id="phoneTypeInt-label" class="property-label"><g:message code="phoneType.phoneTypeInt.label" default="Phone Type Int" /></span>
					
						<span class="property-value" aria-labelledby="phoneTypeInt-label"><g:fieldValue bean="${phoneTypeInstance}" field="phoneTypeInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${phoneTypeInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="phoneType.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${phoneTypeInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${phoneTypeInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="phoneType.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${phoneTypeInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${phoneTypeInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="phoneType.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${phoneTypeInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${phoneTypeInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="phoneType.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${phoneTypeInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:phoneTypeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${phoneTypeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
