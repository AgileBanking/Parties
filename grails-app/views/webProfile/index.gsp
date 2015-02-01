
<%@ page import="entities.WebProfile" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'webProfile.label', default: 'WebProfile')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-webProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-webProfile" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="webProfile.person.label" default="Person" /></th>
					
						<th><g:message code="webProfile.webProfileType.label" default="Web Profile Type" /></th>
					
						<g:sortableColumn property="notes" title="${message(code: 'webProfile.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'webProfile.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${webProfileInstanceList}" status="i" var="webProfileInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${webProfileInstance.id}">${fieldValue(bean: webProfileInstance, field: "person")}</g:link></td>
					
						<td>${fieldValue(bean: webProfileInstance, field: "webProfileType")}</td>
					
						<td>${fieldValue(bean: webProfileInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: webProfileInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${webProfileInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
