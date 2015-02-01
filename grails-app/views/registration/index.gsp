
<%@ page import="entities.Registration" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registration.label', default: 'Registration')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-registration" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-registration" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="registration.legalEntity.label" default="Legal Entity" /></th>
					
						<th><g:message code="registration.register.label" default="Register" /></th>
					
						<g:sortableColumn property="regId" title="${message(code: 'registration.regId.label', default: 'Reg Id')}" />
					
						<g:sortableColumn property="regDate" title="${message(code: 'registration.regDate.label', default: 'Reg Date')}" />
					
						<g:sortableColumn property="expDate" title="${message(code: 'registration.expDate.label', default: 'Exp Date')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'registration.notes.label', default: 'Notes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${registrationInstanceList}" status="i" var="registrationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${registrationInstance.id}">${fieldValue(bean: registrationInstance, field: "legalEntity")}</g:link></td>
					
						<td>${fieldValue(bean: registrationInstance, field: "register")}</td>
					
						<td>${fieldValue(bean: registrationInstance, field: "regId")}</td>
					
						<td><g:formatDate date="${registrationInstance.regDate}" /></td>
					
						<td><g:formatDate date="${registrationInstance.expDate}" /></td>
					
						<td>${fieldValue(bean: registrationInstance, field: "notes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${registrationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
