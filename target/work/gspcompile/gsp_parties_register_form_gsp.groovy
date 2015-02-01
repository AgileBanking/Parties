import entities.Register
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_register_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: registerInstance, field: 'authority', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("register.authority.label"),'default':("Authority")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("authority"),'maxlength':("30"),'required':(""),'value':(registerInstance?.authority)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registerInstance, field: 'authorityInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("register.authorityInt.label"),'default':("Authority Int")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("authorityInt"),'maxlength':("30"),'value':(registerInstance?.authorityInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registerInstance, field: 'countryCode', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("register.countryCode.label"),'default':("Country Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("countryCode"),'maxlength':("2"),'required':(""),'value':(registerInstance?.countryCode)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registerInstance, field: 'webAddress', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("register.webAddress.label"),'default':("Web Address")],-1)
printHtmlPart(5)
invokeTag('textField','g',34,['name':("webAddress"),'value':(registerInstance?.webAddress)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registerInstance, field: 'email', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("register.email.label"),'default':("Email")],-1)
printHtmlPart(5)
invokeTag('field','g',42,['type':("email"),'name':("email"),'value':(registerInstance?.email)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: registerInstance, field: 'registrations', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("register.registrations.label"),'default':("Registrations")],-1)
printHtmlPart(10)
for( r in (registerInstance?.registrations) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',53,['controller':("registration"),'action':("show"),'id':(r.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'registration.label', default: 'Registration')]))
})
invokeTag('link','g',56,['controller':("registration"),'action':("create"),'params':(['register.id': registerInstance?.id])],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: registerInstance, field: 'notes', 'error'))
printHtmlPart(15)
invokeTag('message','g',64,['code':("register.notes.label"),'default':("Notes")],-1)
printHtmlPart(5)
invokeTag('textField','g',67,['name':("notes"),'value':(registerInstance?.notes)],-1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748728L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
