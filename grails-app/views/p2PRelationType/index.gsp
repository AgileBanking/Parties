
<%@ page import="entities.P2PRelationType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'p2PRelationType.label', default: 'P2PRelationType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-p2PRelationType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-p2PRelationType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'p2PRelationType.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'p2PRelationType.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="fromPart" title="${message(code: 'p2PRelationType.fromPart.label', default: 'From Part')}" />
					
						<g:sortableColumn property="toPart" title="${message(code: 'p2PRelationType.toPart.label', default: 'To Part')}" />
					
						<g:sortableColumn property="isReflective" title="${message(code: 'p2PRelationType.isReflective.label', default: 'Is Reflective')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'p2PRelationType.notes.label', default: 'Notes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${p2PRelationTypeInstanceList}" status="i" var="p2PRelationTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${p2PRelationTypeInstance.id}">${fieldValue(bean: p2PRelationTypeInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: p2PRelationTypeInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: p2PRelationTypeInstance, field: "fromPart")}</td>
					
						<td>${fieldValue(bean: p2PRelationTypeInstance, field: "toPart")}</td>
					
						<td><g:formatBoolean boolean="${p2PRelationTypeInstance.isReflective}" /></td>
					
						<td>${fieldValue(bean: p2PRelationTypeInstance, field: "notes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${p2PRelationTypeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
