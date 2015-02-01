
<%@ page import="entities.LegalGroupType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalGroupType.label', default: 'LegalGroupType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-legalGroupType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-legalGroupType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'legalGroupType.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'legalGroupType.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'legalGroupType.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'legalGroupType.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'legalGroupType.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'legalGroupType.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${legalGroupTypeInstanceList}" status="i" var="legalGroupTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${legalGroupTypeInstance.id}">${fieldValue(bean: legalGroupTypeInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: legalGroupTypeInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: legalGroupTypeInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: legalGroupTypeInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${legalGroupTypeInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${legalGroupTypeInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${legalGroupTypeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
