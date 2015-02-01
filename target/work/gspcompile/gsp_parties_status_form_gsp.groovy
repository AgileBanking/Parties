import entities.Status
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_status_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/status/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: statusInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("status.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'maxlength':("20"),'required':(""),'value':(statusInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: statusInstance, field: 'titleInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("status.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("titleInt"),'maxlength':("20"),'required':(""),'value':(statusInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: statusInstance, field: 'notes', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("status.notes.label"),'default':("Notes")],-1)
printHtmlPart(6)
invokeTag('textField','g',26,['name':("notes"),'value':(statusInstance?.notes)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748855L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
