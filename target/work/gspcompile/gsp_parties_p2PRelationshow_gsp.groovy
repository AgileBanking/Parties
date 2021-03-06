import entities.P2PRelation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_p2PRelationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/p2PRelation/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'p2PRelation.label', default: 'P2PRelation'))],-1)
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
if(true && (p2PRelationInstance?.p2pRelation)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("p2PRelation.p2pRelation.label"),'default':("P2p Relation")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(p2PRelationInstance?.p2pRelation?.encodeAsHTML())
})
invokeTag('link','g',30,['controller':("p2PRelationType"),'action':("show"),'id':(p2PRelationInstance?.p2pRelation?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (p2PRelationInstance?.fromPerson)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("p2PRelation.fromPerson.label"),'default':("From Person")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(p2PRelationInstance?.fromPerson?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("person"),'action':("show"),'id':(p2PRelationInstance?.fromPerson?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (p2PRelationInstance?.toPerson)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("p2PRelation.toPerson.label"),'default':("To Person")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(p2PRelationInstance?.toPerson?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("person"),'action':("show"),'id':(p2PRelationInstance?.toPerson?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (p2PRelationInstance?.notes)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("p2PRelation.notes.label"),'default':("Notes")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(p2PRelationInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (p2PRelationInstance?.recStatus)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("p2PRelation.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(p2PRelationInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',74,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',74,['class':("edit"),'action':("edit"),'resource':(p2PRelationInstance)],3)
printHtmlPart(28)
invokeTag('actionSubmit','g',75,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(29)
})
invokeTag('form','g',77,['url':([resource:p2PRelationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748512L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
