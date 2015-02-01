<%@ page import="entities.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'givenName', 'error')} required">
	<label for="givenName">
		<g:message code="person.givenName.label" default="Given Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="givenName" required="" value="${personInstance?.givenName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="person.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${personInstance?.middleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'familyName', 'error')} required">
	<label for="familyName">
		<g:message code="person.familyName.label" default="Family Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="familyName" required="" value="${personInstance?.familyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'alliasName', 'error')} ">
	<label for="alliasName">
		<g:message code="person.alliasName.label" default="Allias Name" />
		
	</label>
	<g:textField name="alliasName" value="${personInstance?.alliasName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'fatherName', 'error')} required">
	<label for="fatherName">
		<g:message code="person.fatherName.label" default="Father Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fatherName" required="" value="${personInstance?.fatherName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'motherName', 'error')} required">
	<label for="motherName">
		<g:message code="person.motherName.label" default="Mother Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="motherName" required="" value="${personInstance?.motherName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'internationalFullname', 'error')} required">
	<label for="internationalFullname">
		<g:message code="person.internationalFullname.label" default="International Fullname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="internationalFullname" required="" value="${personInstance?.internationalFullname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'salutation', 'error')} required">
	<label for="salutation">
		<g:message code="person.salutation.label" default="Salutation" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="salutation" name="salutation.id" from="${entities.Salutation.list()}" optionKey="id" required="" value="${personInstance?.salutation?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'gender', 'error')} required">
	<label for="gender">
		<g:message code="person.gender.label" default="Gender" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="gender" name="gender.id" from="${entities.Gender.list()}" optionKey="id" required="" value="${personInstance?.gender?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'p2PRelationsFrom', 'error')} ">
	<label for="p2PRelationsFrom">
		<g:message code="person.p2PRelationsFrom.label" default="P2 PR elations From" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.p2PRelationsFrom?}" var="p">
    <li><g:link controller="p2PRelation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="p2PRelation" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'p2PRelation.label', default: 'P2PRelation')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'p2PRelationsTo', 'error')} ">
	<label for="p2PRelationsTo">
		<g:message code="person.p2PRelationsTo.label" default="P2 PR elations To" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.p2PRelationsTo?}" var="p">
    <li><g:link controller="p2PRelation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="p2PRelation" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'p2PRelation.label', default: 'P2PRelation')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'spouseGivenName', 'error')} ">
	<label for="spouseGivenName">
		<g:message code="person.spouseGivenName.label" default="Spouse Given Name" />
		
	</label>
	<g:textField name="spouseGivenName" value="${personInstance?.spouseGivenName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'spouseFamilyName', 'error')} ">
	<label for="spouseFamilyName">
		<g:message code="person.spouseFamilyName.label" default="Spouse Family Name" />
		
	</label>
	<g:textField name="spouseFamilyName" value="${personInstance?.spouseFamilyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'spouseFatherName', 'error')} ">
	<label for="spouseFatherName">
		<g:message code="person.spouseFatherName.label" default="Spouse Father Name" />
		
	</label>
	<g:textField name="spouseFatherName" value="${personInstance?.spouseFatherName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'birthdate', 'error')} required">
	<label for="birthdate">
		<g:message code="person.birthdate.label" default="Birthdate" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthdate" precision="day"  value="${personInstance?.birthdate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'placeOfBirth', 'error')} ">
	<label for="placeOfBirth">
		<g:message code="person.placeOfBirth.label" default="Place Of Birth" />
		
	</label>
	<g:textField name="placeOfBirth" value="${personInstance?.placeOfBirth}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'deathdate', 'error')} ">
	<label for="deathdate">
		<g:message code="person.deathdate.label" default="Deathdate" />
		
	</label>
	<g:textField name="deathdate" value="${personInstance?.deathdate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="person.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${personInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'webProfile', 'error')} required">
	<label for="webProfile">
		<g:message code="person.webProfile.label" default="Web Profile" />
		<span class="required-indicator">*</span>
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.webProfile?}" var="w">
    <li><g:link controller="webProfile" action="show" id="${w.id}">${w?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="webProfile" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'webProfile.label', default: 'WebProfile')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'contractualAbility', 'error')} required">
	<label for="contractualAbility">
		<g:message code="person.contractualAbility.label" default="Contractual Ability" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contractualAbility" name="contractualAbility.id" from="${entities.ContractualAbility.list()}" optionKey="id" required="" value="${personInstance?.contractualAbility?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'occupation', 'error')} ">
	<label for="occupation">
		<g:message code="person.occupation.label" default="Occupation" />
		
	</label>
	<g:select id="occupation" name="occupation.id" from="${entities.Occupation.list()}" optionKey="id" value="${personInstance?.occupation?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'maritalStatus', 'error')} required">
	<label for="maritalStatus">
		<g:message code="person.maritalStatus.label" default="Marital Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="maritalStatus" name="maritalStatus.id" from="${entities.MaritalStatus.list()}" optionKey="id" required="" value="${personInstance?.maritalStatus?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'nationality', 'error')} required">
	<label for="nationality">
		<g:message code="person.nationality.label" default="Nationality" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nationality" maxlength="2" required="" value="${personInstance?.nationality}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'citizenship', 'error')} required">
	<label for="citizenship">
		<g:message code="person.citizenship.label" default="Citizenship" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="citizenship" maxlength="2" required="" value="${personInstance?.citizenship}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'residency', 'error')} required">
	<label for="residency">
		<g:message code="person.residency.label" default="Residency" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="residency" maxlength="2" required="" value="${personInstance?.residency}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'ssn', 'error')} ">
	<label for="ssn">
		<g:message code="person.ssn.label" default="Ssn" />
		
	</label>
	<g:textField name="ssn" maxlength="12" value="${personInstance?.ssn}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'taxID', 'error')} ">
	<label for="taxID">
		<g:message code="person.taxID.label" default="Tax ID" />
		
	</label>
	<g:textField name="taxID" value="${personInstance?.taxID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'signature', 'error')} ">
	<label for="signature">
		<g:message code="person.signature.label" default="Signature" />
		
	</label>
	<g:select id="signature" name="signature.id" from="${entities.Signature.list()}" optionKey="id" value="${personInstance?.signature?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="person.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" value="${personInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="person.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="status" name="status.id" from="${entities.Status.list()}" optionKey="id" required="" value="${personInstance?.status?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'oldId', 'error')} ">
	<label for="oldId">
		<g:message code="person.oldId.label" default="Old Id" />
		
	</label>
	<g:textField name="oldId" value="${personInstance?.oldId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'givenNamePhonetic', 'error')} ">
	<label for="givenNamePhonetic">
		<g:message code="person.givenNamePhonetic.label" default="Given Name Phonetic" />
		
	</label>
	<g:textField name="givenNamePhonetic" value="${personInstance?.givenNamePhonetic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'givenNameSoundex', 'error')} ">
	<label for="givenNameSoundex">
		<g:message code="person.givenNameSoundex.label" default="Given Name Soundex" />
		
	</label>
	<g:textField name="givenNameSoundex" value="${personInstance?.givenNameSoundex}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'familyNamePhonetic', 'error')} ">
	<label for="familyNamePhonetic">
		<g:message code="person.familyNamePhonetic.label" default="Family Name Phonetic" />
		
	</label>
	<g:textField name="familyNamePhonetic" value="${personInstance?.familyNamePhonetic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'familyNameSoundex', 'error')} ">
	<label for="familyNameSoundex">
		<g:message code="person.familyNameSoundex.label" default="Family Name Soundex" />
		
	</label>
	<g:textField name="familyNameSoundex" value="${personInstance?.familyNameSoundex}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'recStatus', 'error')} ">
	<label for="recStatus">
		<g:message code="person.recStatus.label" default="Rec Status" />
		
	</label>
	<g:select name="recStatus" from="${personInstance.constraints.recStatus.inList}" value="${personInstance?.recStatus}" valueMessagePrefix="person.recStatus" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'addresses', 'error')} ">
	<label for="addresses">
		<g:message code="person.addresses.label" default="Addresses" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.addresses?}" var="a">
    <li><g:link controller="address" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="address" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'address.label', default: 'Address')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'ids', 'error')} ">
	<label for="ids">
		<g:message code="person.ids.label" default="Ids" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.ids?}" var="i">
    <li><g:link controller="personalId" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="personalId" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'personalId.label', default: 'PersonalId')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'phones', 'error')} ">
	<label for="phones">
		<g:message code="person.phones.label" default="Phones" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.phones?}" var="p">
    <li><g:link controller="phone" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="phone" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'phone.label', default: 'Phone')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'relationsWithUs', 'error')} ">
	<label for="relationsWithUs">
		<g:message code="person.relationsWithUs.label" default="Relations With Us" />
		
	</label>
	<g:select name="relationsWithUs" from="${entities.PRelationWithUs.list()}" multiple="multiple" optionKey="id" size="5" value="${personInstance?.relationsWithUs*.id}" class="many-to-many"/>
</div>

