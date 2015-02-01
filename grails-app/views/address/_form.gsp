<%@ page import="entities.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="address.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${entities.Person.list()}" optionKey="id" required="" value="${addressInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressType', 'error')} required">
	<label for="addressType">
		<g:message code="address.addressType.label" default="Address Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="addressType" name="addressType.id" from="${entities.AddressType.list()}" optionKey="id" required="" value="${addressInstance?.addressType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'street', 'error')} required">
	<label for="street">
		<g:message code="address.street.label" default="Street" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="street" required="" value="${addressInstance?.street}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'streetNumber', 'error')} required">
	<label for="streetNumber">
		<g:message code="address.streetNumber.label" default="Street Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="streetNumber" required="" value="${addressInstance?.streetNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'crossingStreet', 'error')} ">
	<label for="crossingStreet">
		<g:message code="address.crossingStreet.label" default="Crossing Street" />
		
	</label>
	<g:textField name="crossingStreet" maxlength="40" value="${addressInstance?.crossingStreet}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'crossingStreetNumber', 'error')} ">
	<label for="crossingStreetNumber">
		<g:message code="address.crossingStreetNumber.label" default="Crossing Street Number" />
		
	</label>
	<g:textField name="crossingStreetNumber" maxlength="5" value="${addressInstance?.crossingStreetNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'floor', 'error')} ">
	<label for="floor">
		<g:message code="address.floor.label" default="Floor" />
		
	</label>
	<g:textField name="floor" maxlength="20" value="${addressInstance?.floor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'appartment', 'error')} ">
	<label for="appartment">
		<g:message code="address.appartment.label" default="Appartment" />
		
	</label>
	<g:textField name="appartment" maxlength="5" value="${addressInstance?.appartment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="address.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${addressInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'postCode', 'error')} required">
	<label for="postCode">
		<g:message code="address.postCode.label" default="Post Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="postCode" required="" value="${addressInstance?.postCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'stateOrProvince', 'error')} required">
	<label for="stateOrProvince">
		<g:message code="address.stateOrProvince.label" default="State Or Province" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="stateOrProvince" required="" value="${addressInstance?.stateOrProvince}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'countryCode2', 'error')} required">
	<label for="countryCode2">
		<g:message code="address.countryCode2.label" default="Country Code2" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="countryCode2" required="" value="${addressInstance?.countryCode2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'geoLat', 'error')} ">
	<label for="geoLat">
		<g:message code="address.geoLat.label" default="Geo Lat" />
		
	</label>
	<g:field name="geoLat" value="${fieldValue(bean: addressInstance, field: 'geoLat')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'geoLng', 'error')} ">
	<label for="geoLng">
		<g:message code="address.geoLng.label" default="Geo Lng" />
		
	</label>
	<g:field name="geoLng" value="${fieldValue(bean: addressInstance, field: 'geoLng')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'language', 'error')} ">
	<label for="language">
		<g:message code="address.language.label" default="Language" />
		
	</label>
	<g:textField name="language" value="${addressInstance?.language}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="address.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${addressInstance?.notes}"/>
</div>

