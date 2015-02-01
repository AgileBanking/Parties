import entities.PersonalIdType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_personalIdType_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/personalIdType/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: personalIdTypeInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("personalIdType.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'required':(""),'value':(personalIdTypeInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdTypeInstance, field: 'titleInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("personalIdType.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("titleInt"),'required':(""),'value':(personalIdTypeInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdTypeInstance, field: 'notes', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("personalIdType.notes.label"),'default':("Notes")],-1)
printHtmlPart(6)
invokeTag('textField','g',26,['name':("notes"),'value':(personalIdTypeInstance?.notes)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdTypeInstance, field: 'recStatus', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("personalIdType.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(6)
invokeTag('select','g',34,['name':("recStatus"),'from':(personalIdTypeInstance.constraints.recStatus.inList),'value':(personalIdTypeInstance?.recStatus),'valueMessagePrefix':("personalIdType.recStatus"),'noSelection':(['': ''])],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748629L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
