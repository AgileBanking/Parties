<%@ page import="entities.Registration" %>



<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'legalEntity', 'error')} required">
	<label for="legalEntity">
		<g:message code="registration.legalEntity.label" default="Legal Entity" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="legalEntity" name="legalEntity.id" from="${entities.LegalEntity.list()}" optionKey="id" required="" value="${registrationInstance?.legalEntity?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'register', 'error')} required">
	<label for="register">
		<g:message code="registration.register.label" default="Register" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="register" name="register.id" from="${entities.Register.list()}" optionKey="id" required="" value="${registrationInstance?.register?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'regId', 'error')} required">
	<label for="regId">
		<g:message code="registration.regId.label" default="Reg Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="regId" maxlength="40" required="" value="${registrationInstance?.regId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'regDate', 'error')} required">
	<label for="regDate">
		<g:message code="registration.regDate.label" default="Reg Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="regDate" precision="day"  value="${registrationInstance?.regDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'expDate', 'error')} required">
	<label for="expDate">
		<g:message code="registration.expDate.label" default="Exp Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="expDate" precision="day"  value="${registrationInstance?.expDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="registration.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${registrationInstance?.notes}"/>
</div>

