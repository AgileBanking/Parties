import entities.LegalGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalGroupshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalGroup/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'legalGroup.label', default: 'LegalGroup'))],-1)
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
if(true && (legalGroupInstance?.title)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("legalGroup.title.label"),'default':("Title")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(legalGroupInstance),'field':("title")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupInstance?.titleInt)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("legalGroup.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(legalGroupInstance),'field':("titleInt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupInstance?.notes)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("legalGroup.notes.label"),'default':("Notes")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(legalGroupInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupInstance?.legalGroupType)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("legalGroup.legalGroupType.label"),'default':("Legal Group Type")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(legalGroupInstance?.legalGroupType?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("legalGroupType"),'action':("show"),'id':(legalGroupInstance?.legalGroupType?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (legalGroupInstance?.relatedEntities)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("legalGroup.relatedEntities.label"),'default':("Related Entities")],-1)
printHtmlPart(25)
for( r in (legalGroupInstance.relatedEntities) ) {
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("legalGroupRelation"),'action':("show"),'id':(r.id)],4)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(17)
if(true && (legalGroupInstance?.recStatus)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("legalGroup.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',77,['bean':(legalGroupInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(legalGroupInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',88,['url':([resource:legalGroupInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748245L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
