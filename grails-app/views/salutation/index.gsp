
<%@ page import="entities.Salutation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'salutation.label', default: 'Salutation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-salutation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-salutation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'salutation.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'salutation.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'salutation.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'salutation.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'salutation.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'salutation.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${salutationInstanceList}" status="i" var="salutationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${salutationInstance.id}">${fieldValue(bean: salutationInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: salutationInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: salutationInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: salutationInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${salutationInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${salutationInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${salutationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
