
<%@ page import="entities.MarketSegment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'marketSegment.label', default: 'MarketSegment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-marketSegment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-marketSegment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list marketSegment">
			
				<g:if test="${marketSegmentInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="marketSegment.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${marketSegmentInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="marketSegment.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${marketSegmentInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.titleInt}">
				<li class="fieldcontain">
					<span id="titleInt-label" class="property-label"><g:message code="marketSegment.titleInt.label" default="Title Int" /></span>
					
						<span class="property-value" aria-labelledby="titleInt-label"><g:fieldValue bean="${marketSegmentInstance}" field="titleInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.parent}">
				<li class="fieldcontain">
					<span id="parent-label" class="property-label"><g:message code="marketSegment.parent.label" default="Parent" /></span>
					
						<span class="property-value" aria-labelledby="parent-label"><g:link controller="marketSegment" action="show" id="${marketSegmentInstance?.parent?.id}">${marketSegmentInstance?.parent?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="marketSegment.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${marketSegmentInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="marketSegment.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${marketSegmentInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.children}">
				<li class="fieldcontain">
					<span id="children-label" class="property-label"><g:message code="marketSegment.children.label" default="Children" /></span>
					
						<g:each in="${marketSegmentInstance.children}" var="c">
						<span class="property-value" aria-labelledby="children-label"><g:link controller="marketSegment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="marketSegment.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${marketSegmentInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${marketSegmentInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="marketSegment.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${marketSegmentInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:marketSegmentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${marketSegmentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
