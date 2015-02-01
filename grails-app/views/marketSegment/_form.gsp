<%@ page import="entities.MarketSegment" %>



<div class="fieldcontain ${hasErrors(bean: marketSegmentInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="marketSegment.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${marketSegmentInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: marketSegmentInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="marketSegment.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${marketSegmentInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: marketSegmentInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="marketSegment.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${marketSegmentInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: marketSegmentInstance, field: 'parent', 'error')} ">
	<label for="parent">
		<g:message code="marketSegment.parent.label" default="Parent" />
		
	</label>
	<g:select id="parent" name="parent.id" from="${entities.MarketSegment.list()}" optionKey="id" value="${marketSegmentInstance?.parent?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: marketSegmentInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="marketSegment.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${marketSegmentInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: marketSegmentInstance, field: 'children', 'error')} ">
	<label for="children">
		<g:message code="marketSegment.children.label" default="Children" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${marketSegmentInstance?.children?}" var="c">
    <li><g:link controller="marketSegment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="marketSegment" action="create" params="['marketSegment.id': marketSegmentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'marketSegment.label', default: 'MarketSegment')])}</g:link>
</li>
</ul>

</div>

