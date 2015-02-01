import entities.LegalGroupRelation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalGroupRelation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalGroupRelation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: legalGroupRelationInstance, field: 'legalEntityGroup', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("legalGroupRelation.legalEntityGroup.label"),'default':("Legal Entity Group")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("legalEntityGroup"),'name':("legalEntityGroup.id"),'from':(entities.LegalGroup.list()),'optionKey':("id"),'required':(""),'value':(legalGroupRelationInstance?.legalEntityGroup?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupRelationInstance, field: 'member1', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("legalGroupRelation.member1.label"),'default':("Member1")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("member1"),'name':("member1.id"),'from':(entities.LegalEntity.list()),'optionKey':("id"),'required':(""),'value':(legalGroupRelationInstance?.member1?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupRelationInstance, field: 'member2', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("legalGroupRelation.member2.label"),'default':("Member2")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("member2"),'name':("member2.id"),'from':(entities.LegalEntity.list()),'optionKey':("id"),'required':(""),'value':(legalGroupRelationInstance?.member2?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupRelationInstance, field: 'lastRevision', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("legalGroupRelation.lastRevision.label"),'default':("Last Revision")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',34,['name':("lastRevision"),'precision':("day"),'value':(legalGroupRelationInstance?.lastRevision)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupRelationInstance, field: 'nextRevision', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("legalGroupRelation.nextRevision.label"),'default':("Next Revision")],-1)
printHtmlPart(8)
invokeTag('datePicker','g',42,['name':("nextRevision"),'precision':("day"),'value':(legalGroupRelationInstance?.nextRevision),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupRelationInstance, field: 'notes', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("legalGroupRelation.notes.label"),'default':("Notes")],-1)
printHtmlPart(8)
invokeTag('textField','g',50,['name':("notes"),'value':(legalGroupRelationInstance?.notes)],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748254L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
