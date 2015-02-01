import entities.LegalEntity
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalEntityindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalEntity/index.gsp" }
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
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("marketName"),'title':(message(code: 'legalEntity.marketName.label', default: 'Market Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("registeredName"),'title':(message(code: 'legalEntity.registeredName.label', default: 'Registered Name'))],-1)
printHtmlPart(14)
invokeTag('message','g',31,['code':("legalEntity.legalType.label"),'default':("Legal Type")],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("legalEntity.hQAddress.label"),'default':("HQA ddress")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("language"),'title':(message(code: 'legalEntity.language.label', default: 'Language'))],-1)
printHtmlPart(14)
invokeTag('message','g',37,['code':("legalEntity.marketSegment.label"),'default':("Market Segment")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( legalEntityInstance in (legalEntityInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: legalEntityInstance, field: "marketName"))
})
invokeTag('link','g',45,['action':("show"),'id':(legalEntityInstance.id)],3)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: legalEntityInstance, field: "registeredName"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: legalEntityInstance, field: "legalType"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: legalEntityInstance, field: "hQAddress"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: legalEntityInstance, field: "language"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: legalEntityInstance, field: "marketSegment"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',62,['total':(legalEntityInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748137L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
