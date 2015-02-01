import entities.LegalGroupType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_legalGroupType_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/legalGroupType/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: legalGroupTypeInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("legalGroupType.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'maxlength':("40"),'required':(""),'value':(legalGroupTypeInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupTypeInstance, field: 'titleInt', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("legalGroupType.titleInt.label"),'default':("Title Int")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("titleInt"),'maxlength':("40"),'value':(legalGroupTypeInstance?.titleInt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: legalGroupTypeInstance, field: 'legalGroups', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("legalGroupType.legalGroups.label"),'default':("Legal Groups")],-1)
printHtmlPart(7)
for( l in (legalGroupTypeInstance?.legalGroups) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',29,['controller':("legalGroup"),'action':("show"),'id':(l.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'legalGroup.label', default: 'LegalGroup')]))
})
invokeTag('link','g',32,['controller':("legalGroup"),'action':("create"),'params':(['legalGroupType.id': legalGroupTypeInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: legalGroupTypeInstance, field: 'notes', 'error'))
printHtmlPart(12)
invokeTag('message','g',40,['code':("legalGroupType.notes.label"),'default':("Notes")],-1)
printHtmlPart(5)
invokeTag('textField','g',43,['name':("notes"),'value':(legalGroupTypeInstance?.notes)],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748292L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
