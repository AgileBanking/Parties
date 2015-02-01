
<%@ page import="entities.P2PRelation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'p2PRelation.label', default: 'P2PRelation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-p2PRelation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-p2PRelation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="p2PRelation.p2pRelation.label" default="P2p Relation" /></th>
					
						<th><g:message code="p2PRelation.fromPerson.label" default="From Person" /></th>
					
						<th><g:message code="p2PRelation.toPerson.label" default="To Person" /></th>
					
						<g:sortableColumn property="notes" title="${message(code: 'p2PRelation.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'p2PRelation.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${p2PRelationInstanceList}" status="i" var="p2PRelationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${p2PRelationInstance.id}">${fieldValue(bean: p2PRelationInstance, field: "p2pRelation")}</g:link></td>
					
						<td>${fieldValue(bean: p2PRelationInstance, field: "fromPerson")}</td>
					
						<td>${fieldValue(bean: p2PRelationInstance, field: "toPerson")}</td>
					
						<td>${fieldValue(bean: p2PRelationInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: p2PRelationInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${p2PRelationInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
