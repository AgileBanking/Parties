
<%@ page import="entities.P2PRelation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'p2PRelation.label', default: 'P2PRelation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-p2PRelation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-p2PRelation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list p2PRelation">
			
				<g:if test="${p2PRelationInstance?.p2pRelation}">
				<li class="fieldcontain">
					<span id="p2pRelation-label" class="property-label"><g:message code="p2PRelation.p2pRelation.label" default="P2p Relation" /></span>
					
						<span class="property-value" aria-labelledby="p2pRelation-label"><g:link controller="p2PRelationType" action="show" id="${p2PRelationInstance?.p2pRelation?.id}">${p2PRelationInstance?.p2pRelation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationInstance?.fromPerson}">
				<li class="fieldcontain">
					<span id="fromPerson-label" class="property-label"><g:message code="p2PRelation.fromPerson.label" default="From Person" /></span>
					
						<span class="property-value" aria-labelledby="fromPerson-label"><g:link controller="person" action="show" id="${p2PRelationInstance?.fromPerson?.id}">${p2PRelationInstance?.fromPerson?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationInstance?.toPerson}">
				<li class="fieldcontain">
					<span id="toPerson-label" class="property-label"><g:message code="p2PRelation.toPerson.label" default="To Person" /></span>
					
						<span class="property-value" aria-labelledby="toPerson-label"><g:link controller="person" action="show" id="${p2PRelationInstance?.toPerson?.id}">${p2PRelationInstance?.toPerson?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="p2PRelation.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${p2PRelationInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="p2PRelation.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${p2PRelationInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:p2PRelationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${p2PRelationInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
