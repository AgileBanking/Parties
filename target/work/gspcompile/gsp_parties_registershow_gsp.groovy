import entities.Register
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_registershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'register.label', default: 'Register'))],-1)
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
if(true && (registerInstance?.authority)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("register.authority.label"),'default':("Authority")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(registerInstance),'field':("authority")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.authorityInt)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("register.authorityInt.label"),'default':("Authority Int")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(registerInstance),'field':("authorityInt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.countryCode)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("register.countryCode.label"),'default':("Country Code")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(registerInstance),'field':("countryCode")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.webAddress)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("register.webAddress.label"),'default':("Web Address")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(registerInstance),'field':("webAddress")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.email)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("register.email.label"),'default':("Email")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(registerInstance),'field':("email")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.registrations)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("register.registrations.label"),'default':("Registrations")],-1)
printHtmlPart(27)
for( r in (registerInstance.registrations) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("registration"),'action':("show"),'id':(r.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(17)
if(true && (registerInstance?.notes)) {
printHtmlPart(31)
invokeTag('message','g',84,['code':("register.notes.label"),'default':("Notes")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',86,['bean':(registerInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.recStatus)) {
printHtmlPart(33)
invokeTag('message','g',93,['code':("register.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',95,['bean':(registerInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.dateCreated)) {
printHtmlPart(35)
invokeTag('message','g',102,['code':("register.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(36)
invokeTag('formatDate','g',104,['date':(registerInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (registerInstance?.lastUpdated)) {
printHtmlPart(37)
invokeTag('message','g',111,['code':("register.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(38)
invokeTag('formatDate','g',113,['date':(registerInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
createTagBody(3, {->
invokeTag('message','g',121,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',121,['class':("edit"),'action':("edit"),'resource':(registerInstance)],3)
printHtmlPart(41)
invokeTag('actionSubmit','g',122,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',124,['url':([resource:registerInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',126,[:],1)
printHtmlPart(44)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748751L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
