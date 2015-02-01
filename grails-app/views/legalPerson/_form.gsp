<%@ page import="entities.LegalPerson" %>



<div class="fieldcontain ${hasErrors(bean: legalPersonInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="legalPerson.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${entities.Person.list()}" optionKey="id" required="" value="${legalPersonInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalPersonInstance, field: 'repType', 'error')} required">
	<label for="repType">
		<g:message code="legalPerson.repType.label" default="Rep Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="repType" name="repType.id" from="${entities.LRepType.list()}" optionKey="id" required="" value="${legalPersonInstance?.repType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: legalPersonInstance, field: 'expdate', 'error')} ">
	<label for="expdate">
		<g:message code="legalPerson.expdate.label" default="Expdate" />
		
	</label>
	<g:datePicker name="expdate" precision="day"  value="${legalPersonInstance?.expdate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: legalPersonInstance, field: 'terms', 'error')} ">
	<label for="terms">
		<g:message code="legalPerson.terms.label" default="Terms" />
		
	</label>
	<g:textField name="terms" value="${legalPersonInstance?.terms}"/>
</div>

