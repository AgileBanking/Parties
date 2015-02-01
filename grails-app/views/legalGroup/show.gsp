
<%@ page import="entities.LegalGroup" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalGroup.label', default: 'LegalGroup')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-legalGroup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-legalGroup" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list legalGroup">
			
				<g:if test="${legalGroupInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="legalGroup.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${legalGroupInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupInstance?.titleInt}">
				<li class="fieldcontain">
					<span id="titleInt-label" class="property-label"><g:message code="legalGroup.titleInt.label" default="Title Int" /></span>
					
						<span class="property-value" aria-labelledby="titleInt-label"><g:fieldValue bean="${legalGroupInstance}" field="titleInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="legalGroup.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${legalGroupInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupInstance?.legalGroupType}">
				<li class="fieldcontain">
					<span id="legalGroupType-label" class="property-label"><g:message code="legalGroup.legalGroupType.label" default="Legal Group Type" /></span>
					
						<span class="property-value" aria-labelledby="legalGroupType-label"><g:link controller="legalGroupType" action="show" id="${legalGroupInstance?.legalGroupType?.id}">${legalGroupInstance?.legalGroupType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupInstance?.relatedEntities}">
				<li class="fieldcontain">
					<span id="relatedEntities-label" class="property-label"><g:message code="legalGroup.relatedEntities.label" default="Related Entities" /></span>
					
						<g:each in="${legalGroupInstance.relatedEntities}" var="r">
						<span class="property-value" aria-labelledby="relatedEntities-label"><g:link controller="legalGroupRelation" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="legalGroup.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${legalGroupInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:legalGroupInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${legalGroupInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
