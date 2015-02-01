
<%@ page import="entities.P2PRelationType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'p2PRelationType.label', default: 'P2PRelationType')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-p2PRelationType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-p2PRelationType" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list p2PRelationType">
			
				<g:if test="${p2PRelationTypeInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="p2PRelationType.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${p2PRelationTypeInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationTypeInstance?.titleInt}">
				<li class="fieldcontain">
					<span id="titleInt-label" class="property-label"><g:message code="p2PRelationType.titleInt.label" default="Title Int" /></span>
					
						<span class="property-value" aria-labelledby="titleInt-label"><g:fieldValue bean="${p2PRelationTypeInstance}" field="titleInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationTypeInstance?.fromPart}">
				<li class="fieldcontain">
					<span id="fromPart-label" class="property-label"><g:message code="p2PRelationType.fromPart.label" default="From Part" /></span>
					
						<span class="property-value" aria-labelledby="fromPart-label"><g:fieldValue bean="${p2PRelationTypeInstance}" field="fromPart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationTypeInstance?.toPart}">
				<li class="fieldcontain">
					<span id="toPart-label" class="property-label"><g:message code="p2PRelationType.toPart.label" default="To Part" /></span>
					
						<span class="property-value" aria-labelledby="toPart-label"><g:fieldValue bean="${p2PRelationTypeInstance}" field="toPart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationTypeInstance?.isReflective}">
				<li class="fieldcontain">
					<span id="isReflective-label" class="property-label"><g:message code="p2PRelationType.isReflective.label" default="Is Reflective" /></span>
					
						<span class="property-value" aria-labelledby="isReflective-label"><g:formatBoolean boolean="${p2PRelationTypeInstance?.isReflective}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationTypeInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="p2PRelationType.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${p2PRelationTypeInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${p2PRelationTypeInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="p2PRelationType.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${p2PRelationTypeInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:p2PRelationTypeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${p2PRelationTypeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
