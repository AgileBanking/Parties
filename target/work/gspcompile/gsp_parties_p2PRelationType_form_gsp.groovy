import entities.P2PRelationType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_p2PRelationType_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/p2PRelationType/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: p2PRelationTypeInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("p2PRelationType.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'required':(""),'value':(p2PRelationTypeInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationTypeInstance, field: 'titleInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("p2PRelationType.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("titleInt"),'required':(""),'value':(p2PRelationTypeInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationTypeInstance, field: 'fromPart', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("p2PRelationType.fromPart.label"),'default':("From Part")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("fromPart"),'required':(""),'value':(p2PRelationTypeInstance?.fromPart)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationTypeInstance, field: 'toPart', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("p2PRelationType.toPart.label"),'default':("To Part")],-1)
printHtmlPart(2)
invokeTag('textField','g',34,['name':("toPart"),'required':(""),'value':(p2PRelationTypeInstance?.toPart)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationTypeInstance, field: 'isReflective', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("p2PRelationType.isReflective.label"),'default':("Is Reflective")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',42,['name':("isReflective"),'value':(p2PRelationTypeInstance?.isReflective)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: p2PRelationTypeInstance, field: 'notes', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("p2PRelationType.notes.label"),'default':("Notes")],-1)
printHtmlPart(8)
invokeTag('textField','g',50,['name':("notes"),'value':(p2PRelationTypeInstance?.notes)],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748521L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
