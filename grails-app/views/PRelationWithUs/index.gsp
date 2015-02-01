
<%@ page import="entities.PRelationWithUs" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PRelationWithUs.label', default: 'PRelationWithUs')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PRelationWithUs" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PRelationWithUs" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'PRelationWithUs.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'PRelationWithUs.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'PRelationWithUs.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'PRelationWithUs.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PRelationWithUsInstanceList}" status="i" var="PRelationWithUsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PRelationWithUsInstance.id}">${fieldValue(bean: PRelationWithUsInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: PRelationWithUsInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: PRelationWithUsInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: PRelationWithUsInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PRelationWithUsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
