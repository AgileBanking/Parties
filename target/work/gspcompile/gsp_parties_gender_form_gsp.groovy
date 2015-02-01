import entities.Gender
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_gender_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/gender/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: genderInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("gender.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'maxlength':("20"),'required':(""),'value':(genderInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: genderInstance, field: 'titleInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("gender.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(5)
invokeTag('select','g',18,['name':("titleInt"),'from':(genderInstance.constraints.titleInt.inList),'value':(genderInstance?.titleInt),'valueMessagePrefix':("gender.titleInt"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: genderInstance, field: 'notes', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("gender.notes.label"),'default':("Notes")],-1)
printHtmlPart(5)
invokeTag('textField','g',26,['name':("notes"),'value':(genderInstance?.notes)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748046L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
