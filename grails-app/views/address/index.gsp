
<%@ page import="entities.Address" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-address" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="address.person.label" default="Person" /></th>
					
						<th><g:message code="address.addressType.label" default="Address Type" /></th>
					
						<g:sortableColumn property="street" title="${message(code: 'address.street.label', default: 'Street')}" />
					
						<g:sortableColumn property="streetNumber" title="${message(code: 'address.streetNumber.label', default: 'Street Number')}" />
					
						<g:sortableColumn property="crossingStreet" title="${message(code: 'address.crossingStreet.label', default: 'Crossing Street')}" />
					
						<g:sortableColumn property="crossingStreetNumber" title="${message(code: 'address.crossingStreetNumber.label', default: 'Crossing Street Number')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${addressInstanceList}" status="i" var="addressInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${addressInstance.id}">${fieldValue(bean: addressInstance, field: "person")}</g:link></td>
					
						<td>${fieldValue(bean: addressInstance, field: "addressType")}</td>
					
						<td>${fieldValue(bean: addressInstance, field: "street")}</td>
					
						<td>${fieldValue(bean: addressInstance, field: "streetNumber")}</td>
					
						<td>${fieldValue(bean: addressInstance, field: "crossingStreet")}</td>
					
						<td>${fieldValue(bean: addressInstance, field: "crossingStreetNumber")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${addressInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
