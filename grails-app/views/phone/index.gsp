
<%@ page import="entities.Phone" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'phone.label', default: 'Phone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-phone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-phone" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="phone.person.label" default="Person" /></th>
					
						<g:sortableColumn property="phone" title="${message(code: 'phone.phone.label', default: 'Phone')}" />
					
						<th><g:message code="phone.phoneType.label" default="Phone Type" /></th>
					
						<g:sortableColumn property="notes" title="${message(code: 'phone.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'phone.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'phone.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${phoneInstanceList}" status="i" var="phoneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${phoneInstance.id}">${fieldValue(bean: phoneInstance, field: "person")}</g:link></td>
					
						<td>${fieldValue(bean: phoneInstance, field: "phone")}</td>
					
						<td>${fieldValue(bean: phoneInstance, field: "phoneType")}</td>
					
						<td>${fieldValue(bean: phoneInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: phoneInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${phoneInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${phoneInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
