import entities.Signature
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_signature_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/signature/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: signatureInstance, field: 'image', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("signature.image.label"),'default':("Image")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: signatureInstance, field: 'notes', 'error'))
printHtmlPart(3)
invokeTag('message','g',15,['code':("signature.notes.label"),'default':("Notes")],-1)
printHtmlPart(4)
invokeTag('textField','g',18,['name':("notes"),'value':(signatureInstance?.notes)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: signatureInstance, field: 'person', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("signature.person.label"),'default':("Person")],-1)
printHtmlPart(7)
invokeTag('select','g',26,['id':("person"),'name':("person.id"),'from':(entities.Person.list()),'optionKey':("id"),'required':(""),'value':(signatureInstance?.person?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748823L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
