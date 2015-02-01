
<%@ page import="entities.RelationWithUs" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'relationWithUs.label', default: 'RelationWithUs')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-relationWithUs" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-relationWithUs" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'relationWithUs.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'relationWithUs.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'relationWithUs.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'relationWithUs.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'relationWithUs.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'relationWithUs.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${relationWithUsInstanceList}" status="i" var="relationWithUsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${relationWithUsInstance.id}">${fieldValue(bean: relationWithUsInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: relationWithUsInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: relationWithUsInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: relationWithUsInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${relationWithUsInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${relationWithUsInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${relationWithUsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
