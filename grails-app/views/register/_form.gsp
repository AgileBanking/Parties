<%@ page import="entities.Register" %>



<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="register.authority.label" default="Authority" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="authority" maxlength="30" required="" value="${registerInstance?.authority}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'authorityInt', 'error')} ">
	<label for="authorityInt">
		<g:message code="register.authorityInt.label" default="Authority Int" />
		
	</label>
	<g:textField name="authorityInt" maxlength="30" value="${registerInstance?.authorityInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'countryCode', 'error')} required">
	<label for="countryCode">
		<g:message code="register.countryCode.label" default="Country Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="countryCode" maxlength="2" required="" value="${registerInstance?.countryCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'webAddress', 'error')} ">
	<label for="webAddress">
		<g:message code="register.webAddress.label" default="Web Address" />
		
	</label>
	<g:textField name="webAddress" value="${registerInstance?.webAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="register.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${registerInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'registrations', 'error')} ">
	<label for="registrations">
		<g:message code="register.registrations.label" default="Registrations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${registerInstance?.registrations?}" var="r">
    <li><g:link controller="registration" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registration" action="create" params="['register.id': registerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registration.label', default: 'Registration')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: registerInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="register.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${registerInstance?.notes}"/>
</div>

