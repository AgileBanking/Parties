import entities.LegalGroupRelation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalGroupRelationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalGroupRelation/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'legalGroupRelation.label', default: 'LegalGroupRelation'))],-1)
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
if(true && (legalGroupRelationInstance?.legalEntityGroup)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("legalGroupRelation.legalEntityGroup.label"),'default':("Legal Entity Group")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(legalGroupRelationInstance?.legalEntityGroup?.encodeAsHTML())
})
invokeTag('link','g',30,['controller':("legalGroup"),'action':("show"),'id':(legalGroupRelationInstance?.legalEntityGroup?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.member1)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("legalGroupRelation.member1.label"),'default':("Member1")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(legalGroupRelationInstance?.member1?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("legalEntity"),'action':("show"),'id':(legalGroupRelationInstance?.member1?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.member2)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("legalGroupRelation.member2.label"),'default':("Member2")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(legalGroupRelationInstance?.member2?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("legalEntity"),'action':("show"),'id':(legalGroupRelationInstance?.member2?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.lastRevision)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("legalGroupRelation.lastRevision.label"),'default':("Last Revision")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',57,['date':(legalGroupRelationInstance?.lastRevision)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.nextRevision)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("legalGroupRelation.nextRevision.label"),'default':("Next Revision")],-1)
printHtmlPart(25)
invokeTag('formatDate','g',66,['date':(legalGroupRelationInstance?.nextRevision)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.notes)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("legalGroupRelation.notes.label"),'default':("Notes")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(legalGroupRelationInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.recStatus)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("legalGroupRelation.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(legalGroupRelationInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.dateCreated)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("legalGroupRelation.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(31)
invokeTag('formatDate','g',93,['date':(legalGroupRelationInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupRelationInstance?.lastUpdated)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("legalGroupRelation.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(33)
invokeTag('formatDate','g',102,['date':(legalGroupRelationInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',110,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',110,['class':("edit"),'action':("edit"),'resource':(legalGroupRelationInstance)],3)
printHtmlPart(36)
invokeTag('actionSubmit','g',111,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(37)
})
invokeTag('form','g',113,['url':([resource:legalGroupRelationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(38)
})
invokeTag('captureBody','sitemesh',115,[:],1)
printHtmlPart(39)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748283L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
