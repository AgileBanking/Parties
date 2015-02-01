import entities.PersonalId
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_personalId_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/personalId/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'person', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("personalId.person.label"),'default':("Person")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("person"),'name':("person.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(personalIdInstance?.person?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'idType', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("personalId.idType.label"),'default':("Id Type")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("idType"),'name':("idType.id"),'from':(entities.PersonalIdType.list()),'optionKey':("id"),'required':(""),'value':(personalIdInstance?.idType?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'idCode', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("personalId.idCode.label"),'default':("Id Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("idCode"),'maxlength':("20"),'required':(""),'value':(personalIdInstance?.idCode)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'issueDate', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("personalId.issueDate.label"),'default':("Issue Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',34,['name':("issueDate"),'precision':("day"),'value':(personalIdInstance?.issueDate)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'validUntil', 'error'))
printHtmlPart(7)
invokeTag('message','g',39,['code':("personalId.validUntil.label"),'default':("Valid Until")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',42,['name':("validUntil"),'precision':("day"),'value':(personalIdInstance?.validUntil)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'issuedBy', 'error'))
printHtmlPart(8)
invokeTag('message','g',47,['code':("personalId.issuedBy.label"),'default':("Issued By")],-1)
printHtmlPart(2)
invokeTag('textField','g',50,['name':("issuedBy"),'required':(""),'value':(personalIdInstance?.issuedBy)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'countryCode2', 'error'))
printHtmlPart(9)
invokeTag('message','g',55,['code':("personalId.countryCode2.label"),'default':("Country Code2")],-1)
printHtmlPart(2)
invokeTag('textField','g',58,['name':("countryCode2"),'maxlength':("2"),'required':(""),'value':(personalIdInstance?.countryCode2)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'idStatus', 'error'))
printHtmlPart(10)
invokeTag('message','g',63,['code':("personalId.idStatus.label"),'default':("Id Status")],-1)
printHtmlPart(11)
invokeTag('select','g',66,['id':("idStatus"),'name':("idStatus.id"),'from':(entities.IdStatus.list()),'optionKey':("id"),'value':(personalIdInstance?.idStatus?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: personalIdInstance, field: 'notes', 'error'))
printHtmlPart(12)
invokeTag('message','g',71,['code':("personalId.notes.label"),'default':("Notes")],-1)
printHtmlPart(11)
invokeTag('textField','g',74,['name':("notes"),'value':(personalIdInstance?.notes)],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748597L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
