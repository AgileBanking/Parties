import entities.Occupation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_occupation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/occupation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: occupationInstance, field: 'code', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("occupation.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("code"),'required':(""),'value':(occupationInstance?.code)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: occupationInstance, field: 'title', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("occupation.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("title"),'required':(""),'value':(occupationInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: occupationInstance, field: 'titleInt', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("occupation.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("titleInt"),'required':(""),'value':(occupationInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: occupationInstance, field: 'notes', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("occupation.notes.label"),'default':("Notes")],-1)
printHtmlPart(7)
invokeTag('textField','g',34,['name':("notes"),'value':(occupationInstance?.notes)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748446L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
