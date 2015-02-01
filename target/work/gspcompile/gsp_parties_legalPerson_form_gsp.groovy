import entities.LegalPerson
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalPerson_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalPerson/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: legalPersonInstance, field: 'person', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("legalPerson.person.label"),'default':("Person")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("person"),'name':("person.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(legalPersonInstance?.person?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalPersonInstance, field: 'repType', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("legalPerson.repType.label"),'default':("Rep Type")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("repType"),'name':("repType.id"),'from':(entities.LRepType.list()),'optionKey':("id"),'required':(""),'value':(legalPersonInstance?.repType?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalPersonInstance, field: 'expdate', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("legalPerson.expdate.label"),'default':("Expdate")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',26,['name':("expdate"),'precision':("day"),'value':(legalPersonInstance?.expdate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalPersonInstance, field: 'terms', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("legalPerson.terms.label"),'default':("Terms")],-1)
printHtmlPart(6)
invokeTag('textField','g',34,['name':("terms"),'value':(legalPersonInstance?.terms)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748323L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
