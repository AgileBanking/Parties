
<%@ page import="entities.LegalGroupRelation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalGroupRelation.label', default: 'LegalGroupRelation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-legalGroupRelation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-legalGroupRelation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list legalGroupRelation">
			
				<g:if test="${legalGroupRelationInstance?.legalEntityGroup}">
				<li class="fieldcontain">
					<span id="legalEntityGroup-label" class="property-label"><g:message code="legalGroupRelation.legalEntityGroup.label" default="Legal Entity Group" /></span>
					
						<span class="property-value" aria-labelledby="legalEntityGroup-label"><g:link controller="legalGroup" action="show" id="${legalGroupRelationInstance?.legalEntityGroup?.id}">${legalGroupRelationInstance?.legalEntityGroup?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.member1}">
				<li class="fieldcontain">
					<span id="member1-label" class="property-label"><g:message code="legalGroupRelation.member1.label" default="Member1" /></span>
					
						<span class="property-value" aria-labelledby="member1-label"><g:link controller="legalEntity" action="show" id="${legalGroupRelationInstance?.member1?.id}">${legalGroupRelationInstance?.member1?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.member2}">
				<li class="fieldcontain">
					<span id="member2-label" class="property-label"><g:message code="legalGroupRelation.member2.label" default="Member2" /></span>
					
						<span class="property-value" aria-labelledby="member2-label"><g:link controller="legalEntity" action="show" id="${legalGroupRelationInstance?.member2?.id}">${legalGroupRelationInstance?.member2?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.lastRevision}">
				<li class="fieldcontain">
					<span id="lastRevision-label" class="property-label"><g:message code="legalGroupRelation.lastRevision.label" default="Last Revision" /></span>
					
						<span class="property-value" aria-labelledby="lastRevision-label"><g:formatDate date="${legalGroupRelationInstance?.lastRevision}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.nextRevision}">
				<li class="fieldcontain">
					<span id="nextRevision-label" class="property-label"><g:message code="legalGroupRelation.nextRevision.label" default="Next Revision" /></span>
					
						<span class="property-value" aria-labelledby="nextRevision-label"><g:formatDate date="${legalGroupRelationInstance?.nextRevision}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="legalGroupRelation.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${legalGroupRelationInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="legalGroupRelation.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${legalGroupRelationInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="legalGroupRelation.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${legalGroupRelationInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${legalGroupRelationInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="legalGroupRelation.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${legalGroupRelationInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:legalGroupRelationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${legalGroupRelationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
