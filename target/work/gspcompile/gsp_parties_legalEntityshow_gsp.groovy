import entities.LegalEntity
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalEntityshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalEntity/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'legalEntity.label', default: 'LegalEntity'))],-1)
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
if(true && (legalEntityInstance?.marketName)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("legalEntity.marketName.label"),'default':("Market Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(legalEntityInstance),'field':("marketName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.registeredName)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("legalEntity.registeredName.label"),'default':("Registered Name")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(legalEntityInstance),'field':("registeredName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.legalType)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("legalEntity.legalType.label"),'default':("Legal Type")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(legalEntityInstance?.legalType?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("legalEntityType"),'action':("show"),'id':(legalEntityInstance?.legalType?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.hQAddress)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("legalEntity.hQAddress.label"),'default':("HQA ddress")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(legalEntityInstance?.hQAddress?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("address"),'action':("show"),'id':(legalEntityInstance?.hQAddress?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.language)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("legalEntity.language.label"),'default':("Language")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(legalEntityInstance),'field':("language")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.marketSegment)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("legalEntity.marketSegment.label"),'default':("Market Segment")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(legalEntityInstance?.marketSegment?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("marketSegment"),'action':("show"),'id':(legalEntityInstance?.marketSegment?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.corporateRate)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("legalEntity.corporateRate.label"),'default':("Corporate Rate")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(legalEntityInstance),'field':("corporateRate")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.listingStatus)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("legalEntity.listingStatus.label"),'default':("Listing Status")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',93,['bean':(legalEntityInstance),'field':("listingStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.registration)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("legalEntity.registration.label"),'default':("Registration")],-1)
printHtmlPart(33)
createTagBody(3, {->
expressionOut.print(legalEntityInstance?.registration?.encodeAsHTML())
})
invokeTag('link','g',102,['controller':("registration"),'action':("show"),'id':(legalEntityInstance?.registration?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.relWithUs)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("legalEntity.relWithUs.label"),'default':("Rel With Us")],-1)
printHtmlPart(35)
for( r in (legalEntityInstance.relWithUs) ) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',112,['controller':("relationWithUs"),'action':("show"),'id':(r.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.legalPersons)) {
printHtmlPart(39)
invokeTag('message','g',120,['code':("legalEntity.legalPersons.label"),'default':("Legal Persons")],-1)
printHtmlPart(35)
for( l in (legalEntityInstance.legalPersons) ) {
printHtmlPart(40)
createTagBody(4, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',123,['controller':("legalPerson"),'action':("show"),'id':(l.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.taxID)) {
printHtmlPart(41)
invokeTag('message','g',131,['code':("legalEntity.taxID.label"),'default':("Tax ID")],-1)
printHtmlPart(42)
invokeTag('fieldValue','g',133,['bean':(legalEntityInstance),'field':("taxID")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.webSite)) {
printHtmlPart(43)
invokeTag('message','g',140,['code':("legalEntity.webSite.label"),'default':("Web Site")],-1)
printHtmlPart(44)
invokeTag('fieldValue','g',142,['bean':(legalEntityInstance),'field':("webSite")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.status)) {
printHtmlPart(45)
invokeTag('message','g',149,['code':("legalEntity.status.label"),'default':("Status")],-1)
printHtmlPart(46)
createTagBody(3, {->
expressionOut.print(legalEntityInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',151,['controller':("status"),'action':("show"),'id':(legalEntityInstance?.status?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.oldSysId)) {
printHtmlPart(47)
invokeTag('message','g',158,['code':("legalEntity.oldSysId.label"),'default':("Old Sys Id")],-1)
printHtmlPart(48)
invokeTag('fieldValue','g',160,['bean':(legalEntityInstance),'field':("oldSysId")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.notes)) {
printHtmlPart(49)
invokeTag('message','g',167,['code':("legalEntity.notes.label"),'default':("Notes")],-1)
printHtmlPart(50)
invokeTag('fieldValue','g',169,['bean':(legalEntityInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.recStatus)) {
printHtmlPart(51)
invokeTag('message','g',176,['code':("legalEntity.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(52)
invokeTag('fieldValue','g',178,['bean':(legalEntityInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.businessAddress)) {
printHtmlPart(53)
invokeTag('message','g',185,['code':("legalEntity.businessAddress.label"),'default':("Business Address")],-1)
printHtmlPart(54)
createTagBody(3, {->
expressionOut.print(legalEntityInstance?.businessAddress?.encodeAsHTML())
})
invokeTag('link','g',187,['controller':("address"),'action':("show"),'id':(legalEntityInstance?.businessAddress?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.dateCreated)) {
printHtmlPart(55)
invokeTag('message','g',194,['code':("legalEntity.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(56)
invokeTag('formatDate','g',196,['date':(legalEntityInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalEntityInstance?.lastUpdated)) {
printHtmlPart(57)
invokeTag('message','g',203,['code':("legalEntity.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(58)
invokeTag('formatDate','g',205,['date':(legalEntityInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(59)
createTagBody(2, {->
printHtmlPart(60)
createTagBody(3, {->
invokeTag('message','g',213,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',213,['class':("edit"),'action':("edit"),'resource':(legalEntityInstance)],3)
printHtmlPart(61)
invokeTag('actionSubmit','g',214,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(62)
})
invokeTag('form','g',216,['url':([resource:legalEntityInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(63)
})
invokeTag('captureBody','sitemesh',218,[:],1)
printHtmlPart(64)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748178L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
