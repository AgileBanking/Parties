
<%@ page import="entities.Address" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-address" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list address">
			
				<g:if test="${addressInstance?.person}">
				<li class="fieldcontain">
					<span id="person-label" class="property-label"><g:message code="address.person.label" default="Person" /></span>
					
						<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="show" id="${addressInstance?.person?.id}">${addressInstance?.person?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.addressType}">
				<li class="fieldcontain">
					<span id="addressType-label" class="property-label"><g:message code="address.addressType.label" default="Address Type" /></span>
					
						<span class="property-value" aria-labelledby="addressType-label"><g:link controller="addressType" action="show" id="${addressInstance?.addressType?.id}">${addressInstance?.addressType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.street}">
				<li class="fieldcontain">
					<span id="street-label" class="property-label"><g:message code="address.street.label" default="Street" /></span>
					
						<span class="property-value" aria-labelledby="street-label"><g:fieldValue bean="${addressInstance}" field="street"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.streetNumber}">
				<li class="fieldcontain">
					<span id="streetNumber-label" class="property-label"><g:message code="address.streetNumber.label" default="Street Number" /></span>
					
						<span class="property-value" aria-labelledby="streetNumber-label"><g:fieldValue bean="${addressInstance}" field="streetNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.crossingStreet}">
				<li class="fieldcontain">
					<span id="crossingStreet-label" class="property-label"><g:message code="address.crossingStreet.label" default="Crossing Street" /></span>
					
						<span class="property-value" aria-labelledby="crossingStreet-label"><g:fieldValue bean="${addressInstance}" field="crossingStreet"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.crossingStreetNumber}">
				<li class="fieldcontain">
					<span id="crossingStreetNumber-label" class="property-label"><g:message code="address.crossingStreetNumber.label" default="Crossing Street Number" /></span>
					
						<span class="property-value" aria-labelledby="crossingStreetNumber-label"><g:fieldValue bean="${addressInstance}" field="crossingStreetNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.floor}">
				<li class="fieldcontain">
					<span id="floor-label" class="property-label"><g:message code="address.floor.label" default="Floor" /></span>
					
						<span class="property-value" aria-labelledby="floor-label"><g:fieldValue bean="${addressInstance}" field="floor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.appartment}">
				<li class="fieldcontain">
					<span id="appartment-label" class="property-label"><g:message code="address.appartment.label" default="Appartment" /></span>
					
						<span class="property-value" aria-labelledby="appartment-label"><g:fieldValue bean="${addressInstance}" field="appartment"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="address.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${addressInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.postCode}">
				<li class="fieldcontain">
					<span id="postCode-label" class="property-label"><g:message code="address.postCode.label" default="Post Code" /></span>
					
						<span class="property-value" aria-labelledby="postCode-label"><g:fieldValue bean="${addressInstance}" field="postCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.stateOrProvince}">
				<li class="fieldcontain">
					<span id="stateOrProvince-label" class="property-label"><g:message code="address.stateOrProvince.label" default="State Or Province" /></span>
					
						<span class="property-value" aria-labelledby="stateOrProvince-label"><g:fieldValue bean="${addressInstance}" field="stateOrProvince"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.countryCode2}">
				<li class="fieldcontain">
					<span id="countryCode2-label" class="property-label"><g:message code="address.countryCode2.label" default="Country Code2" /></span>
					
						<span class="property-value" aria-labelledby="countryCode2-label"><g:fieldValue bean="${addressInstance}" field="countryCode2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.geoLat}">
				<li class="fieldcontain">
					<span id="geoLat-label" class="property-label"><g:message code="address.geoLat.label" default="Geo Lat" /></span>
					
						<span class="property-value" aria-labelledby="geoLat-label"><g:fieldValue bean="${addressInstance}" field="geoLat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.geoLng}">
				<li class="fieldcontain">
					<span id="geoLng-label" class="property-label"><g:message code="address.geoLng.label" default="Geo Lng" /></span>
					
						<span class="property-value" aria-labelledby="geoLng-label"><g:fieldValue bean="${addressInstance}" field="geoLng"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.language}">
				<li class="fieldcontain">
					<span id="language-label" class="property-label"><g:message code="address.language.label" default="Language" /></span>
					
						<span class="property-value" aria-labelledby="language-label"><g:fieldValue bean="${addressInstance}" field="language"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="address.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${addressInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="address.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${addressInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="address.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${addressInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="address.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${addressInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:addressInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${addressInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
