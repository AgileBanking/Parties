
<%@ page import="entities.LegalGroupRelation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'legalGroupRelation.label', default: 'LegalGroupRelation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-legalGroupRelation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-legalGroupRelation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="legalGroupRelation.legalEntityGroup.label" default="Legal Entity Group" /></th>
					
						<th><g:message code="legalGroupRelation.member1.label" default="Member1" /></th>
					
						<th><g:message code="legalGroupRelation.member2.label" default="Member2" /></th>
					
						<g:sortableColumn property="lastRevision" title="${message(code: 'legalGroupRelation.lastRevision.label', default: 'Last Revision')}" />
					
						<g:sortableColumn property="nextRevision" title="${message(code: 'legalGroupRelation.nextRevision.label', default: 'Next Revision')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'legalGroupRelation.notes.label', default: 'Notes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${legalGroupRelationInstanceList}" status="i" var="legalGroupRelationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${legalGroupRelationInstance.id}">${fieldValue(bean: legalGroupRelationInstance, field: "legalEntityGroup")}</g:link></td>
					
						<td>${fieldValue(bean: legalGroupRelationInstance, field: "member1")}</td>
					
						<td>${fieldValue(bean: legalGroupRelationInstance, field: "member2")}</td>
					
						<td><g:formatDate date="${legalGroupRelationInstance.lastRevision}" /></td>
					
						<td><g:formatDate date="${legalGroupRelationInstance.nextRevision}" /></td>
					
						<td>${fieldValue(bean: legalGroupRelationInstance, field: "notes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${legalGroupRelationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
