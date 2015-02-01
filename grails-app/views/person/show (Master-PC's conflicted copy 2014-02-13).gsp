
<%@ page import="entities.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.givenName}">
				<li class="fieldcontain">
					<span id="givenName-label" class="property-label"><g:message code="person.givenName.label" default="Given Name" /></span>
					
						<span class="property-value" aria-labelledby="givenName-label"><g:fieldValue bean="${personInstance}" field="givenName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="person.middleName.label" default="Middle Name" /></span>
					
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${personInstance}" field="middleName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.familyName}">
				<li class="fieldcontain">
					<span id="familyName-label" class="property-label"><g:message code="person.familyName.label" default="Family Name" /></span>
					
						<span class="property-value" aria-labelledby="familyName-label"><g:fieldValue bean="${personInstance}" field="familyName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.alliasName}">
				<li class="fieldcontain">
					<span id="alliasName-label" class="property-label"><g:message code="person.alliasName.label" default="Allias Name" /></span>
					
						<span class="property-value" aria-labelledby="alliasName-label"><g:fieldValue bean="${personInstance}" field="alliasName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.fatherName}">
				<li class="fieldcontain">
					<span id="fatherName-label" class="property-label"><g:message code="person.fatherName.label" default="Father Name" /></span>
					
						<span class="property-value" aria-labelledby="fatherName-label"><g:fieldValue bean="${personInstance}" field="fatherName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.motherName}">
				<li class="fieldcontain">
					<span id="motherName-label" class="property-label"><g:message code="person.motherName.label" default="Mother Name" /></span>
					
						<span class="property-value" aria-labelledby="motherName-label"><g:fieldValue bean="${personInstance}" field="motherName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.internationalFullname}">
				<li class="fieldcontain">
					<span id="internationalFullname-label" class="property-label"><g:message code="person.internationalFullname.label" default="International Fullname" /></span>
					
						<span class="property-value" aria-labelledby="internationalFullname-label"><g:fieldValue bean="${personInstance}" field="internationalFullname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.salutation}">
				<li class="fieldcontain">
					<span id="salutation-label" class="property-label"><g:message code="person.salutation.label" default="Salutation" /></span>
					
						<span class="property-value" aria-labelledby="salutation-label"><g:link controller="salutation" action="show" id="${personInstance?.salutation?.id}">${personInstance?.salutation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.gender}">
				<li class="fieldcontain">
					<span id="gender-label" class="property-label"><g:message code="person.gender.label" default="Gender" /></span>
					
						<span class="property-value" aria-labelledby="gender-label"><g:link controller="gender" action="show" id="${personInstance?.gender?.id}">${personInstance?.gender?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.p2PRelationsLeft}">
				<li class="fieldcontain">
					<span id="p2PRelationsLeft-label" class="property-label"><g:message code="person.p2PRelationsLeft.label" default="P2 PR elations Left" /></span>
					
						<g:each in="${personInstance.p2PRelationsLeft}" var="p">
						<span class="property-value" aria-labelledby="p2PRelationsLeft-label"><g:link controller="p2PRelation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.p2PRelationsRight}">
				<li class="fieldcontain">
					<span id="p2PRelationsRight-label" class="property-label"><g:message code="person.p2PRelationsRight.label" default="P2 PR elations Right" /></span>
					
						<g:each in="${personInstance.p2PRelationsRight}" var="p">
						<span class="property-value" aria-labelledby="p2PRelationsRight-label"><g:link controller="p2PRelation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.spouseFirstName}">
				<li class="fieldcontain">
					<span id="spouseFirstName-label" class="property-label"><g:message code="person.spouseFirstName.label" default="Spouse First Name" /></span>
					
						<span class="property-value" aria-labelledby="spouseFirstName-label"><g:fieldValue bean="${personInstance}" field="spouseFirstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.spouseLastName}">
				<li class="fieldcontain">
					<span id="spouseLastName-label" class="property-label"><g:message code="person.spouseLastName.label" default="Spouse Last Name" /></span>
					
						<span class="property-value" aria-labelledby="spouseLastName-label"><g:fieldValue bean="${personInstance}" field="spouseLastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.spouseFatherName}">
				<li class="fieldcontain">
					<span id="spouseFatherName-label" class="property-label"><g:message code="person.spouseFatherName.label" default="Spouse Father Name" /></span>
					
						<span class="property-value" aria-labelledby="spouseFatherName-label"><g:fieldValue bean="${personInstance}" field="spouseFatherName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.birthdate}">
				<li class="fieldcontain">
					<span id="birthdate-label" class="property-label"><g:message code="person.birthdate.label" default="Birthdate" /></span>
					
						<span class="property-value" aria-labelledby="birthdate-label"><g:formatDate date="${personInstance?.birthdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.placeOfBirth}">
				<li class="fieldcontain">
					<span id="placeOfBirth-label" class="property-label"><g:message code="person.placeOfBirth.label" default="Place Of Birth" /></span>
					
						<span class="property-value" aria-labelledby="placeOfBirth-label"><g:fieldValue bean="${personInstance}" field="placeOfBirth"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.deathdate}">
				<li class="fieldcontain">
					<span id="deathdate-label" class="property-label"><g:message code="person.deathdate.label" default="Deathdate" /></span>
					
						<span class="property-value" aria-labelledby="deathdate-label"><g:fieldValue bean="${personInstance}" field="deathdate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="person.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${personInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.contractualAbility}">
				<li class="fieldcontain">
					<span id="contractualAbility-label" class="property-label"><g:message code="person.contractualAbility.label" default="Contractual Ability" /></span>
					
						<span class="property-value" aria-labelledby="contractualAbility-label"><g:link controller="contractualAbility" action="show" id="${personInstance?.contractualAbility?.id}">${personInstance?.contractualAbility?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.occupation}">
				<li class="fieldcontain">
					<span id="occupation-label" class="property-label"><g:message code="person.occupation.label" default="Occupation" /></span>
					
						<span class="property-value" aria-labelledby="occupation-label"><g:link controller="occupation" action="show" id="${personInstance?.occupation?.id}">${personInstance?.occupation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.maritalStatus}">
				<li class="fieldcontain">
					<span id="maritalStatus-label" class="property-label"><g:message code="person.maritalStatus.label" default="Marital Status" /></span>
					
						<span class="property-value" aria-labelledby="maritalStatus-label"><g:link controller="maritalStatus" action="show" id="${personInstance?.maritalStatus?.id}">${personInstance?.maritalStatus?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.nationality}">
				<li class="fieldcontain">
					<span id="nationality-label" class="property-label"><g:message code="person.nationality.label" default="Nationality" /></span>
					
						<span class="property-value" aria-labelledby="nationality-label"><g:fieldValue bean="${personInstance}" field="nationality"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.citizenship}">
				<li class="fieldcontain">
					<span id="citizenship-label" class="property-label"><g:message code="person.citizenship.label" default="Citizenship" /></span>
					
						<span class="property-value" aria-labelledby="citizenship-label"><g:fieldValue bean="${personInstance}" field="citizenship"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.residency}">
				<li class="fieldcontain">
					<span id="residency-label" class="property-label"><g:message code="person.residency.label" default="Residency" /></span>
					
						<span class="property-value" aria-labelledby="residency-label"><g:fieldValue bean="${personInstance}" field="residency"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.SSN}">
				<li class="fieldcontain">
					<span id="SSN-label" class="property-label"><g:message code="person.SSN.label" default="SSN" /></span>
					
						<span class="property-value" aria-labelledby="SSN-label"><g:fieldValue bean="${personInstance}" field="SSN"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.taxID}">
				<li class="fieldcontain">
					<span id="taxID-label" class="property-label"><g:message code="person.taxID.label" default="Tax ID" /></span>
					
						<span class="property-value" aria-labelledby="taxID-label"><g:fieldValue bean="${personInstance}" field="taxID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.signature}">
				<li class="fieldcontain">
					<span id="signature-label" class="property-label"><g:message code="person.signature.label" default="Signature" /></span>
					
						<span class="property-value" aria-labelledby="signature-label"><g:link controller="signature" action="show" id="${personInstance?.signature?.id}">${personInstance?.signature?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="person.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${personInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="person.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:link controller="status" action="show" id="${personInstance?.status?.id}">${personInstance?.status?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.oldId}">
				<li class="fieldcontain">
					<span id="oldId-label" class="property-label"><g:message code="person.oldId.label" default="Old Id" /></span>
					
						<span class="property-value" aria-labelledby="oldId-label"><g:fieldValue bean="${personInstance}" field="oldId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.givenNamePhonetic}">
				<li class="fieldcontain">
					<span id="givenNamePhonetic-label" class="property-label"><g:message code="person.givenNamePhonetic.label" default="Given Name Phonetic" /></span>
					
						<span class="property-value" aria-labelledby="givenNamePhonetic-label"><g:fieldValue bean="${personInstance}" field="givenNamePhonetic"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.givenNameSoundex}">
				<li class="fieldcontain">
					<span id="givenNameSoundex-label" class="property-label"><g:message code="person.givenNameSoundex.label" default="Given Name Soundex" /></span>
					
						<span class="property-value" aria-labelledby="givenNameSoundex-label"><g:fieldValue bean="${personInstance}" field="givenNameSoundex"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.familyNamePhonetic}">
				<li class="fieldcontain">
					<span id="familyNamePhonetic-label" class="property-label"><g:message code="person.familyNamePhonetic.label" default="Family Name Phonetic" /></span>
					
						<span class="property-value" aria-labelledby="familyNamePhonetic-label"><g:fieldValue bean="${personInstance}" field="familyNamePhonetic"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.familyNameSoundex}">
				<li class="fieldcontain">
					<span id="familyNameSoundex-label" class="property-label"><g:message code="person.familyNameSoundex.label" default="Family Name Soundex" /></span>
					
						<span class="property-value" aria-labelledby="familyNameSoundex-label"><g:fieldValue bean="${personInstance}" field="familyNameSoundex"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="person.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${personInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="person.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${personInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="person.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${personInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.addresses}">
				<li class="fieldcontain">
					<span id="addresses-label" class="property-label"><g:message code="person.addresses.label" default="Addresses" /></span>
					
						<g:each in="${personInstance.addresses}" var="a">
						<span class="property-value" aria-labelledby="addresses-label"><g:link controller="address" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.ids}">
				<li class="fieldcontain">
					<span id="ids-label" class="property-label"><g:message code="person.ids.label" default="Ids" /></span>
					
						<g:each in="${personInstance.ids}" var="i">
						<span class="property-value" aria-labelledby="ids-label"><g:link controller="personalId" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.phones}">
				<li class="fieldcontain">
					<span id="phones-label" class="property-label"><g:message code="person.phones.label" default="Phones" /></span>
					
						<g:each in="${personInstance.phones}" var="p">
						<span class="property-value" aria-labelledby="phones-label"><g:link controller="phone" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.relationsWithUs}">
				<li class="fieldcontain">
					<span id="relationsWithUs-label" class="property-label"><g:message code="person.relationsWithUs.label" default="Relations With Us" /></span>
					
						<g:each in="${personInstance.relationsWithUs}" var="r">
						<span class="property-value" aria-labelledby="relationsWithUs-label"><g:link controller="PRelationWithUs" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:personInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${personInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
