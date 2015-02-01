import entities.PersonalId
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_personalIdshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/personalId/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'personalId.label', default: 'PersonalId'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (personalIdInstance?.person)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("personalId.person.label"),'default':("Person")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(personalIdInstance?.person?.encodeAsHTML())
})
invokeTag('link','g',30,['controller':("person"),'action':("show"),'id':(personalIdInstance?.person?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.idType)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("personalId.idType.label"),'default':("Id Type")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(personalIdInstance?.idType?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("personalIdType"),'action':("show"),'id':(personalIdInstance?.idType?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.idCode)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("personalId.idCode.label"),'default':("Id Code")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(personalIdInstance),'field':("idCode")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.issueDate)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("personalId.issueDate.label"),'default':("Issue Date")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',57,['date':(personalIdInstance?.issueDate)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.validUntil)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("personalId.validUntil.label"),'default':("Valid Until")],-1)
printHtmlPart(25)
invokeTag('formatDate','g',66,['date':(personalIdInstance?.validUntil)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.issuedBy)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("personalId.issuedBy.label"),'default':("Issued By")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(personalIdInstance),'field':("issuedBy")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.countryCode2)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("personalId.countryCode2.label"),'default':("Country Code2")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(personalIdInstance),'field':("countryCode2")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.idStatus)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("personalId.idStatus.label"),'default':("Id Status")],-1)
printHtmlPart(31)
createTagBody(3, {->
expressionOut.print(personalIdInstance?.idStatus?.encodeAsHTML())
})
invokeTag('link','g',93,['controller':("idStatus"),'action':("show"),'id':(personalIdInstance?.idStatus?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.notes)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("personalId.notes.label"),'default':("Notes")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',102,['bean':(personalIdInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.recStatus)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("personalId.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',111,['bean':(personalIdInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.dateCreated)) {
printHtmlPart(36)
invokeTag('message','g',118,['code':("personalId.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(37)
invokeTag('formatDate','g',120,['date':(personalIdInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personalIdInstance?.lastUpdated)) {
printHtmlPart(38)
invokeTag('message','g',127,['code':("personalId.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(39)
invokeTag('formatDate','g',129,['date':(personalIdInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
createTagBody(3, {->
invokeTag('message','g',137,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',137,['class':("edit"),'action':("edit"),'resource':(personalIdInstance)],3)
printHtmlPart(42)
invokeTag('actionSubmit','g',138,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(43)
})
invokeTag('form','g',140,['url':([resource:personalIdInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',142,[:],1)
printHtmlPart(45)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748621L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
