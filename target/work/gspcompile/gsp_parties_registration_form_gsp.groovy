import entities.Registration
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_registration_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/registration/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: registrationInstance, field: 'legalEntity', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("registration.legalEntity.label"),'default':("Legal Entity")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("legalEntity"),'name':("legalEntity.id"),'from':(entities.LegalEntity.list()),'optionKey':("id"),'required':(""),'value':(registrationInstance?.legalEntity?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registrationInstance, field: 'register', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("registration.register.label"),'default':("Register")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("register"),'name':("register.id"),'from':(entities.Register.list()),'optionKey':("id"),'required':(""),'value':(registrationInstance?.register?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registrationInstance, field: 'regId', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("registration.regId.label"),'default':("Reg Id")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("regId"),'maxlength':("40"),'required':(""),'value':(registrationInstance?.regId)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registrationInstance, field: 'regDate', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("registration.regDate.label"),'default':("Reg Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',34,['name':("regDate"),'precision':("day"),'value':(registrationInstance?.regDate)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registrationInstance, field: 'expDate', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("registration.expDate.label"),'default':("Exp Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',42,['name':("expDate"),'precision':("day"),'value':(registrationInstance?.expDate)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registrationInstance, field: 'notes', 'error'))
printHtmlPart(8)
invokeTag('message','g',47,['code':("registration.notes.label"),'default':("Notes")],-1)
printHtmlPart(9)
invokeTag('textField','g',50,['name':("notes"),'value':(registrationInstance?.notes)],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748760L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
