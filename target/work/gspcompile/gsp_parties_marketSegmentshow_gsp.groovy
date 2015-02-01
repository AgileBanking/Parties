import entities.MarketSegment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_marketSegmentshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/marketSegment/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'marketSegment.label', default: 'MarketSegment'))],-1)
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
if(true && (marketSegmentInstance?.code)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("marketSegment.code.label"),'default':("Code")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(marketSegmentInstance),'field':("code")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.title)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("marketSegment.title.label"),'default':("Title")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(marketSegmentInstance),'field':("title")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.titleInt)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("marketSegment.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(marketSegmentInstance),'field':("titleInt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.parent)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("marketSegment.parent.label"),'default':("Parent")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(marketSegmentInstance?.parent?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("marketSegment"),'action':("show"),'id':(marketSegmentInstance?.parent?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.notes)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("marketSegment.notes.label"),'default':("Notes")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(marketSegmentInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.recStatus)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("marketSegment.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(marketSegmentInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.children)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("marketSegment.children.label"),'default':("Children")],-1)
printHtmlPart(29)
for( c in (marketSegmentInstance.children) ) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(c?.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("marketSegment"),'action':("show"),'id':(c.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.dateCreated)) {
printHtmlPart(33)
invokeTag('message','g',93,['code':("marketSegment.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(34)
invokeTag('formatDate','g',95,['date':(marketSegmentInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (marketSegmentInstance?.lastUpdated)) {
printHtmlPart(35)
invokeTag('message','g',102,['code':("marketSegment.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(36)
invokeTag('formatDate','g',104,['date':(marketSegmentInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',112,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',112,['class':("edit"),'action':("edit"),'resource':(marketSegmentInstance)],3)
printHtmlPart(39)
invokeTag('actionSubmit','g',113,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(40)
})
invokeTag('form','g',115,['url':([resource:marketSegmentInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',117,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748437L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
