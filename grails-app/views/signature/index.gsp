
<%@ page import="entities.Signature" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'signature.label', default: 'Signature')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-signature" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-signature" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="image" title="${message(code: 'signature.image.label', default: 'Image')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'signature.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'signature.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'signature.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'signature.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="signature.person.label" default="Person" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${signatureInstanceList}" status="i" var="signatureInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${signatureInstance.id}">${fieldValue(bean: signatureInstance, field: "image")}</g:link></td>
					
						<td>${fieldValue(bean: signatureInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: signatureInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${signatureInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${signatureInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: signatureInstance, field: "person")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${signatureInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
