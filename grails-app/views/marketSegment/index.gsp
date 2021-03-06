
<%@ page import="entities.MarketSegment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'marketSegment.label', default: 'MarketSegment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-marketSegment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-marketSegment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'marketSegment.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'marketSegment.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'marketSegment.titleInt.label', default: 'Title Int')}" />
					
						<th><g:message code="marketSegment.parent.label" default="Parent" /></th>
					
						<g:sortableColumn property="notes" title="${message(code: 'marketSegment.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'marketSegment.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${marketSegmentInstanceList}" status="i" var="marketSegmentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${marketSegmentInstance.id}">${fieldValue(bean: marketSegmentInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: marketSegmentInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: marketSegmentInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: marketSegmentInstance, field: "parent")}</td>
					
						<td>${fieldValue(bean: marketSegmentInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: marketSegmentInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${marketSegmentInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
