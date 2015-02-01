
<%@ page import="entities.LegalPerson" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalPerson.label', default: 'LegalPerson')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-legalPerson" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-legalPerson" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="legalPerson.person.label" default="Person" /></th>
					
						<th><g:message code="legalPerson.repType.label" default="Rep Type" /></th>
					
						<g:sortableColumn property="expdate" title="${message(code: 'legalPerson.expdate.label', default: 'Expdate')}" />
					
						<g:sortableColumn property="terms" title="${message(code: 'legalPerson.terms.label', default: 'Terms')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'legalPerson.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${legalPersonInstanceList}" status="i" var="legalPersonInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${legalPersonInstance.id}">${fieldValue(bean: legalPersonInstance, field: "person")}</g:link></td>
					
						<td>${fieldValue(bean: legalPersonInstance, field: "repType")}</td>
					
						<td><g:formatDate date="${legalPersonInstance.expdate}" /></td>
					
						<td>${fieldValue(bean: legalPersonInstance, field: "terms")}</td>
					
						<td>${fieldValue(bean: legalPersonInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${legalPersonInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
