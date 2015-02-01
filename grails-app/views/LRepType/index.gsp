
<%@ page import="entities.LRepType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'LRepType.label', default: 'LRepType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-LRepType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-LRepType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'LRepType.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'LRepType.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'LRepType.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'LRepType.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'LRepType.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'LRepType.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${LRepTypeInstanceList}" status="i" var="LRepTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${LRepTypeInstance.id}">${fieldValue(bean: LRepTypeInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: LRepTypeInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: LRepTypeInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: LRepTypeInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${LRepTypeInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${LRepTypeInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${LRepTypeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
