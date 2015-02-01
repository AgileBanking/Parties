<%@ page import="entities.P2PRelationType" %>



<div class="fieldcontain ${hasErrors(bean: p2PRelationTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="p2PRelationType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${p2PRelationTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationTypeInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="p2PRelationType.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" required="" value="${p2PRelationTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationTypeInstance, field: 'fromPart', 'error')} required">
	<label for="fromPart">
		<g:message code="p2PRelationType.fromPart.label" default="From Part" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fromPart" required="" value="${p2PRelationTypeInstance?.fromPart}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationTypeInstance, field: 'toPart', 'error')} required">
	<label for="toPart">
		<g:message code="p2PRelationType.toPart.label" default="To Part" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="toPart" required="" value="${p2PRelationTypeInstance?.toPart}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationTypeInstance, field: 'isReflective', 'error')} ">
	<label for="isReflective">
		<g:message code="p2PRelationType.isReflective.label" default="Is Reflective" />
		
	</label>
	<g:checkBox name="isReflective" value="${p2PRelationTypeInstance?.isReflective}" />
</div>

<div class="fieldcontain ${hasErrors(bean: p2PRelationTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="p2PRelationType.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${p2PRelationTypeInstance?.notes}"/>
</div>

