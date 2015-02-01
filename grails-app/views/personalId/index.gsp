
<%@ page import="entities.PersonalId" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personalId.label', default: 'PersonalId')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-personalId" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-personalId" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="personalId.person.label" default="Person" /></th>
					
						<th><g:message code="personalId.idType.label" default="Id Type" /></th>
					
						<g:sortableColumn property="idCode" title="${message(code: 'personalId.idCode.label', default: 'Id Code')}" />
					
						<g:sortableColumn property="issueDate" title="${message(code: 'personalId.issueDate.label', default: 'Issue Date')}" />
					
						<g:sortableColumn property="validUntil" title="${message(code: 'personalId.validUntil.label', default: 'Valid Until')}" />
					
						<g:sortableColumn property="issuedBy" title="${message(code: 'personalId.issuedBy.label', default: 'Issued By')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personalIdInstanceList}" status="i" var="personalIdInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personalIdInstance.id}">${fieldValue(bean: personalIdInstance, field: "person")}</g:link></td>
					
						<td>${fieldValue(bean: personalIdInstance, field: "idType")}</td>
					
						<td>${fieldValue(bean: personalIdInstance, field: "idCode")}</td>
					
						<td><g:formatDate date="${personalIdInstance.issueDate}" /></td>
					
						<td><g:formatDate date="${personalIdInstance.validUntil}" /></td>
					
						<td>${fieldValue(bean: personalIdInstance, field: "issuedBy")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personalIdInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
