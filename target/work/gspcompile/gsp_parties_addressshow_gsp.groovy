import entities.Address
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_addressshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/address/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'address.label', default: 'Address'))],-1)
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
if(true && (addressInstance?.person)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("address.person.label"),'default':("Person")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(addressInstance?.person?.encodeAsHTML())
})
invokeTag('link','g',30,['controller':("person"),'action':("show"),'id':(addressInstance?.person?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.addressType)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("address.addressType.label"),'default':("Address Type")],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(addressInstance?.addressType?.encodeAsHTML())
})
invokeTag('link','g',39,['controller':("addressType"),'action':("show"),'id':(addressInstance?.addressType?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.street)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("address.street.label"),'default':("Street")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(addressInstance),'field':("street")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.streetNumber)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("address.streetNumber.label"),'default':("Street Number")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(addressInstance),'field':("streetNumber")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.crossingStreet)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("address.crossingStreet.label"),'default':("Crossing Street")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(addressInstance),'field':("crossingStreet")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.crossingStreetNumber)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("address.crossingStreetNumber.label"),'default':("Crossing Street Number")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(addressInstance),'field':("crossingStreetNumber")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.floor)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("address.floor.label"),'default':("Floor")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(addressInstance),'field':("floor")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.appartment)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("address.appartment.label"),'default':("Appartment")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',93,['bean':(addressInstance),'field':("appartment")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.city)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("address.city.label"),'default':("City")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',102,['bean':(addressInstance),'field':("city")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.postCode)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("address.postCode.label"),'default':("Post Code")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',111,['bean':(addressInstance),'field':("postCode")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.stateOrProvince)) {
printHtmlPart(36)
invokeTag('message','g',118,['code':("address.stateOrProvince.label"),'default':("State Or Province")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',120,['bean':(addressInstance),'field':("stateOrProvince")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.countryCode2)) {
printHtmlPart(38)
invokeTag('message','g',127,['code':("address.countryCode2.label"),'default':("Country Code2")],-1)
printHtmlPart(39)
invokeTag('fieldValue','g',129,['bean':(addressInstance),'field':("countryCode2")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.geoLat)) {
printHtmlPart(40)
invokeTag('message','g',136,['code':("address.geoLat.label"),'default':("Geo Lat")],-1)
printHtmlPart(41)
invokeTag('fieldValue','g',138,['bean':(addressInstance),'field':("geoLat")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.geoLng)) {
printHtmlPart(42)
invokeTag('message','g',145,['code':("address.geoLng.label"),'default':("Geo Lng")],-1)
printHtmlPart(43)
invokeTag('fieldValue','g',147,['bean':(addressInstance),'field':("geoLng")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.language)) {
printHtmlPart(44)
invokeTag('message','g',154,['code':("address.language.label"),'default':("Language")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',156,['bean':(addressInstance),'field':("language")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.notes)) {
printHtmlPart(46)
invokeTag('message','g',163,['code':("address.notes.label"),'default':("Notes")],-1)
printHtmlPart(47)
invokeTag('fieldValue','g',165,['bean':(addressInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.recStatus)) {
printHtmlPart(48)
invokeTag('message','g',172,['code':("address.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(49)
invokeTag('fieldValue','g',174,['bean':(addressInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.dateCreated)) {
printHtmlPart(50)
invokeTag('message','g',181,['code':("address.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(51)
invokeTag('formatDate','g',183,['date':(addressInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (addressInstance?.lastUpdated)) {
printHtmlPart(52)
invokeTag('message','g',190,['code':("address.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(53)
invokeTag('formatDate','g',192,['date':(addressInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(54)
createTagBody(2, {->
printHtmlPart(55)
createTagBody(3, {->
invokeTag('message','g',200,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',200,['class':("edit"),'action':("edit"),'resource':(addressInstance)],3)
printHtmlPart(56)
invokeTag('actionSubmit','g',201,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(57)
})
invokeTag('form','g',203,['url':([resource:addressInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',205,[:],1)
printHtmlPart(59)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691747924L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
