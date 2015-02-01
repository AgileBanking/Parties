import entities.WebProfile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_webProfile_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/webProfile/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: webProfileInstance, field: 'person', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("webProfile.person.label"),'default':("Person")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("person"),'name':("person.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(webProfileInstance?.person?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: webProfileInstance, field: 'webProfileType', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("webProfile.webProfileType.label"),'default':("Web Profile Type")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("webProfileType"),'name':("webProfileType.id"),'from':(entities.WebProfileType.list()),'optionKey':("id"),'required':(""),'value':(webProfileInstance?.webProfileType?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: webProfileInstance, field: 'notes', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("webProfile.notes.label"),'default':("Notes")],-1)
printHtmlPart(6)
invokeTag('textArea','g',26,['name':("notes"),'cols':("40"),'rows':("5"),'value':(webProfileInstance?.notes)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748884L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
