import entities.P2PRelation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_p2PRelation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/p2PRelation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: p2PRelationInstance, field: 'p2pRelation', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("p2PRelation.p2pRelation.label"),'default':("P2p Relation")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("p2pRelation"),'name':("p2pRelation.id"),'from':(entities.P2PRelationType.list()),'optionKey':("id"),'required':(""),'value':(p2PRelationInstance?.p2pRelation?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationInstance, field: 'fromPerson', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("p2PRelation.fromPerson.label"),'default':("From Person")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("fromPerson"),'name':("fromPerson.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(p2PRelationInstance?.fromPerson?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationInstance, field: 'toPerson', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("p2PRelation.toPerson.label"),'default':("To Person")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("toPerson"),'name':("toPerson.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(p2PRelationInstance?.toPerson?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationInstance, field: 'notes', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("p2PRelation.notes.label"),'default':("Notes")],-1)
printHtmlPart(7)
invokeTag('textField','g',34,['name':("notes"),'value':(p2PRelationInstance?.notes)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748477L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
