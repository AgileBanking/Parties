import entities.LegalGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalGroup_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalGroup/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: legalGroupInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("legalGroup.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'maxlength':("40"),'required':(""),'value':(legalGroupInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupInstance, field: 'titleInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("legalGroup.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("titleInt"),'maxlength':("40"),'value':(legalGroupInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupInstance, field: 'notes', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("legalGroup.notes.label"),'default':("Notes")],-1)
printHtmlPart(5)
invokeTag('textField','g',26,['name':("notes"),'value':(legalGroupInstance?.notes)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupInstance, field: 'legalGroupType', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("legalGroup.legalGroupType.label"),'default':("Legal Group Type")],-1)
printHtmlPart(2)
invokeTag('select','g',34,['id':("legalGroupType"),'name':("legalGroupType.id"),'from':(entities.LegalGroupType.list()),'optionKey':("id"),'required':(""),'value':(legalGroupInstance?.legalGroupType?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupInstance, field: 'relatedEntities', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("legalGroup.relatedEntities.label"),'default':("Related Entities")],-1)
printHtmlPart(9)
for( r in (legalGroupInstance?.relatedEntities) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("legalGroupRelation"),'action':("show"),'id':(r.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'legalGroupRelation.label', default: 'LegalGroupRelation')]))
})
invokeTag('link','g',48,['controller':("legalGroupRelation"),'action':("create"),'params':(['legalGroup.id': legalGroupInstance?.id])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748220L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
