import entities.MarketSegment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_marketSegment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/marketSegment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: marketSegmentInstance, field: 'code', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("marketSegment.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("code"),'required':(""),'value':(marketSegmentInstance?.code)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: marketSegmentInstance, field: 'title', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("marketSegment.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("title"),'required':(""),'value':(marketSegmentInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: marketSegmentInstance, field: 'titleInt', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("marketSegment.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(6)
invokeTag('textField','g',26,['name':("titleInt"),'value':(marketSegmentInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: marketSegmentInstance, field: 'parent', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("marketSegment.parent.label"),'default':("Parent")],-1)
printHtmlPart(6)
invokeTag('select','g',34,['id':("parent"),'name':("parent.id"),'from':(entities.MarketSegment.list()),'optionKey':("id"),'value':(marketSegmentInstance?.parent?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: marketSegmentInstance, field: 'notes', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("marketSegment.notes.label"),'default':("Notes")],-1)
printHtmlPart(6)
invokeTag('textField','g',42,['name':("notes"),'value':(marketSegmentInstance?.notes)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: marketSegmentInstance, field: 'children', 'error'))
printHtmlPart(9)
invokeTag('message','g',47,['code':("marketSegment.children.label"),'default':("Children")],-1)
printHtmlPart(10)
for( c in (marketSegmentInstance?.children) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(c?.encodeAsHTML())
})
invokeTag('link','g',53,['controller':("marketSegment"),'action':("show"),'id':(c.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'marketSegment.label', default: 'MarketSegment')]))
})
invokeTag('link','g',56,['controller':("marketSegment"),'action':("create"),'params':(['marketSegment.id': marketSegmentInstance?.id])],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748415L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
