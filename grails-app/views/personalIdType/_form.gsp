<%@ page import="entities.PersonalIdType" %>



<div class="fieldcontain ${hasErrors(bean: personalIdTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="personalIdType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${personalIdTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdTypeInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="personalIdType.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${personalIdTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="personalIdType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${personalIdTypeInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personalIdTypeInstance, field: 'recStatus', 'error')} ">
	<label for="recStatus">
		<g:message code="personalIdType.recStatus.label" default="Rec Status" />
		
	</label>
	<g:select name="recStatus" from="${personalIdTypeInstance.constraints.recStatus.inList}" value="${personalIdTypeInstance?.recStatus}" valueMessagePrefix="personalIdType.recStatus" noSelection="['': '']"/>
</div>

