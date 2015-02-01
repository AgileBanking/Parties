
<%@ page import="entities.LegalGroupType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalGroupType.label', default: 'LegalGroupType')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-legalGroupType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-legalGroupType" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list legalGroupType">
			
				<g:if test="${legalGroupTypeInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="legalGroupType.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${legalGroupTypeInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupTypeInstance?.titleInt}">
				<li class="fieldcontain">
					<span id="titleInt-label" class="property-label"><g:message code="legalGroupType.titleInt.label" default="Title Int" /></span>
					
						<span class="property-value" aria-labelledby="titleInt-label"><g:fieldValue bean="${legalGroupTypeInstance}" field="titleInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupTypeInstance?.legalGroups}">
				<li class="fieldcontain">
					<span id="legalGroups-label" class="property-label"><g:message code="legalGroupType.legalGroups.label" default="Legal Groups" /></span>
					
						<g:each in="${legalGroupTypeInstance.legalGroups}" var="l">
						<span class="property-value" aria-labelledby="legalGroups-label"><g:link controller="legalGroup" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupTypeInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="legalGroupType.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${legalGroupTypeInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupTypeInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="legalGroupType.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${legalGroupTypeInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupTypeInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="legalGroupType.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${legalGroupTypeInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupTypeInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="legalGroupType.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${legalGroupTypeInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:legalGroupTypeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${legalGroupTypeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
