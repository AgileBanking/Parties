import entities.Signature
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_signatureshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/signature/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'signature.label', default: 'Signature'))],-1)
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
if(true && (signatureInstance?.image)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("signature.image.label"),'default':("Image")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (signatureInstance?.notes)) {
printHtmlPart(17)
invokeTag('message','g',35,['code':("signature.notes.label"),'default':("Notes")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',37,['bean':(signatureInstance),'field':("notes")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (signatureInstance?.recStatus)) {
printHtmlPart(19)
invokeTag('message','g',44,['code':("signature.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',46,['bean':(signatureInstance),'field':("recStatus")],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (signatureInstance?.dateCreated)) {
printHtmlPart(21)
invokeTag('message','g',53,['code':("signature.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(22)
invokeTag('formatDate','g',55,['date':(signatureInstance?.dateCreated)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (signatureInstance?.lastUpdated)) {
printHtmlPart(23)
invokeTag('message','g',62,['code':("signature.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(24)
invokeTag('formatDate','g',64,['date':(signatureInstance?.lastUpdated)],-1)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (signatureInstance?.person)) {
printHtmlPart(25)
invokeTag('message','g',71,['code':("signature.person.label"),'default':("Person")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(signatureInstance?.person?.encodeAsHTML())
})
invokeTag('link','g',73,['controller':("person"),'action':("show"),'id':(signatureInstance?.person?.id)],3)
printHtmlPart(15)
}
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',81,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',81,['class':("edit"),'action':("edit"),'resource':(signatureInstance)],3)
printHtmlPart(29)
invokeTag('actionSubmit','g',82,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',84,['url':([resource:signatureInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748847L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
