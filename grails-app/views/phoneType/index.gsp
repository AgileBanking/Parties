
<%@ page import="entities.PhoneType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'phoneType.label', default: 'PhoneType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-phoneType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-phoneType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="phoneType" title="${message(code: 'phoneType.phoneType.label', default: 'Phone Type')}" />
					
						<g:sortableColumn property="phoneTypeInt" title="${message(code: 'phoneType.phoneTypeInt.label', default: 'Phone Type Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'phoneType.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'phoneType.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'phoneType.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'phoneType.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${phoneTypeInstanceList}" status="i" var="phoneTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${phoneTypeInstance.id}">${fieldValue(bean: phoneTypeInstance, field: "phoneType")}</g:link></td>
					
						<td>${fieldValue(bean: phoneTypeInstance, field: "phoneTypeInt")}</td>
					
						<td>${fieldValue(bean: phoneTypeInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: phoneTypeInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${phoneTypeInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${phoneTypeInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${phoneTypeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
