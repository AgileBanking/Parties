
<%@ page import="entities.LegalGroup" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalGroup.label', default: 'LegalGroup')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-legalGroup" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-legalGroup" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'legalGroup.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'legalGroup.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'legalGroup.notes.label', default: 'Notes')}" />
					
						<th><g:message code="legalGroup.legalGroupType.label" default="Legal Group Type" /></th>
					
						<g:sortableColumn property="recStatus" title="${message(code: 'legalGroup.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${legalGroupInstanceList}" status="i" var="legalGroupInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${legalGroupInstance.id}">${fieldValue(bean: legalGroupInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: legalGroupInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: legalGroupInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: legalGroupInstance, field: "legalGroupType")}</td>
					
						<td>${fieldValue(bean: legalGroupInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${legalGroupInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
