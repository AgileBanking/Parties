
<%@ page import="entities.LegalEntity" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalEntity.label', default: 'LegalEntity')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-legalEntity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-legalEntity" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="marketName" title="${message(code: 'legalEntity.marketName.label', default: 'Market Name')}" />
					
						<g:sortableColumn property="registeredName" title="${message(code: 'legalEntity.registeredName.label', default: 'Registered Name')}" />
					
						<th><g:message code="legalEntity.legalType.label" default="Legal Type" /></th>
					
						<th><g:message code="legalEntity.hQAddress.label" default="HQA ddress" /></th>
					
						<g:sortableColumn property="language" title="${message(code: 'legalEntity.language.label', default: 'Language')}" />
					
						<th><g:message code="legalEntity.marketSegment.label" default="Market Segment" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${legalEntityInstanceList}" status="i" var="legalEntityInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${legalEntityInstance.id}">${fieldValue(bean: legalEntityInstance, field: "marketName")}</g:link></td>
					
						<td>${fieldValue(bean: legalEntityInstance, field: "registeredName")}</td>
					
						<td>${fieldValue(bean: legalEntityInstance, field: "legalType")}</td>
					
						<td>${fieldValue(bean: legalEntityInstance, field: "hQAddress")}</td>
					
						<td>${fieldValue(bean: legalEntityInstance, field: "language")}</td>
					
						<td>${fieldValue(bean: legalEntityInstance, field: "marketSegment")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${legalEntityInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
