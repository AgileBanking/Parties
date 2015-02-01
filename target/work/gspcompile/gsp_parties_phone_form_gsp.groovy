import entities.Phone
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_phone_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/phone/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: phoneInstance, field: 'person', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("phone.person.label"),'default':("Person")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("person"),'name':("person.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(phoneInstance?.person?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: phoneInstance, field: 'phone', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("phone.phone.label"),'default':("Phone")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("phone"),'maxlength':("20"),'required':(""),'value':(phoneInstance?.phone)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: phoneInstance, field: 'phoneType', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("phone.phoneType.label"),'default':("Phone Type")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("phoneType"),'name':("phoneType.id"),'from':(entities.PhoneType.list()),'optionKey':("id"),'required':(""),'value':(phoneInstance?.phoneType?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: phoneInstance, field: 'notes', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("phone.notes.label"),'default':("Notes")],-1)
printHtmlPart(7)
invokeTag('textField','g',34,['name':("notes"),'maxlength':("250"),'value':(phoneInstance?.notes)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748663L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
