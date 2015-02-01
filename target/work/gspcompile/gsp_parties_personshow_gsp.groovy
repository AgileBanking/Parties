import entities.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_personshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
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
if(true && (personInstance?.givenName)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("person.givenName.label"),'default':("Given Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(personInstance),'field':("givenName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.middleName)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("person.middleName.label"),'default':("Middle Name")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(personInstance),'field':("middleName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.familyName)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("person.familyName.label"),'default':("Family Name")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(personInstance),'field':("familyName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.alliasName)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("person.alliasName.label"),'default':("Allias Name")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(personInstance),'field':("alliasName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.fatherName)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("person.fatherName.label"),'default':("Father Name")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(personInstance),'field':("fatherName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.motherName)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("person.motherName.label"),'default':("Mother Name")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(personInstance),'field':("motherName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.internationalFullname)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("person.internationalFullname.label"),'default':("International Fullname")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(personInstance),'field':("internationalFullname")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.salutation)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("person.salutation.label"),'default':("Salutation")],-1)
printHtmlPart(31)
createTagBody(3, {->
expressionOut.print(personInstance?.salutation?.encodeAsHTML())
})
invokeTag('link','g',93,['controller':("salutation"),'action':("show"),'id':(personInstance?.salutation?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.gender)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("person.gender.label"),'default':("Gender")],-1)
printHtmlPart(33)
createTagBody(3, {->
expressionOut.print(personInstance?.gender?.encodeAsHTML())
})
invokeTag('link','g',102,['controller':("gender"),'action':("show"),'id':(personInstance?.gender?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.p2PRelationsFrom)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("person.p2PRelationsFrom.label"),'default':("P2 PR elations From")],-1)
printHtmlPart(35)
for( p in (personInstance.p2PRelationsFrom) ) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',112,['controller':("p2PRelation"),'action':("show"),'id':(p.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.p2PRelationsTo)) {
printHtmlPart(39)
invokeTag('message','g',120,['code':("person.p2PRelationsTo.label"),'default':("P2 PR elations To")],-1)
printHtmlPart(35)
for( p in (personInstance.p2PRelationsTo) ) {
printHtmlPart(40)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',123,['controller':("p2PRelation"),'action':("show"),'id':(p.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.spouseGivenName)) {
printHtmlPart(41)
invokeTag('message','g',131,['code':("person.spouseGivenName.label"),'default':("Spouse Given Name")],-1)
printHtmlPart(42)
invokeTag('fieldValue','g',133,['bean':(personInstance),'field':("spouseGivenName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.spouseFamilyName)) {
printHtmlPart(43)
invokeTag('message','g',140,['code':("person.spouseFamilyName.label"),'default':("Spouse Family Name")],-1)
printHtmlPart(44)
invokeTag('fieldValue','g',142,['bean':(personInstance),'field':("spouseFamilyName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.spouseFatherName)) {
printHtmlPart(45)
invokeTag('message','g',149,['code':("person.spouseFatherName.label"),'default':("Spouse Father Name")],-1)
printHtmlPart(46)
invokeTag('fieldValue','g',151,['bean':(personInstance),'field':("spouseFatherName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.birthdate)) {
printHtmlPart(47)
invokeTag('message','g',158,['code':("person.birthdate.label"),'default':("Birthdate")],-1)
printHtmlPart(48)
invokeTag('formatDate','g',160,['date':(personInstance?.birthdate)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.placeOfBirth)) {
printHtmlPart(49)
invokeTag('message','g',167,['code':("person.placeOfBirth.label"),'default':("Place Of Birth")],-1)
printHtmlPart(50)
invokeTag('fieldValue','g',169,['bean':(personInstance),'field':("placeOfBirth")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.deathdate)) {
printHtmlPart(51)
invokeTag('message','g',176,['code':("person.deathdate.label"),'default':("Deathdate")],-1)
printHtmlPart(52)
invokeTag('fieldValue','g',178,['bean':(personInstance),'field':("deathdate")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.email)) {
printHtmlPart(53)
invokeTag('message','g',185,['code':("person.email.label"),'default':("Email")],-1)
printHtmlPart(54)
invokeTag('fieldValue','g',187,['bean':(personInstance),'field':("email")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.webProfile)) {
printHtmlPart(55)
invokeTag('message','g',194,['code':("person.webProfile.label"),'default':("Web Profile")],-1)
printHtmlPart(35)
for( w in (personInstance.webProfile) ) {
printHtmlPart(56)
createTagBody(4, {->
expressionOut.print(w?.encodeAsHTML())
})
invokeTag('link','g',197,['controller':("webProfile"),'action':("show"),'id':(w.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.contractualAbility)) {
printHtmlPart(57)
invokeTag('message','g',205,['code':("person.contractualAbility.label"),'default':("Contractual Ability")],-1)
printHtmlPart(58)
createTagBody(3, {->
expressionOut.print(personInstance?.contractualAbility?.encodeAsHTML())
})
invokeTag('link','g',207,['controller':("contractualAbility"),'action':("show"),'id':(personInstance?.contractualAbility?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.occupation)) {
printHtmlPart(59)
invokeTag('message','g',214,['code':("person.occupation.label"),'default':("Occupation")],-1)
printHtmlPart(60)
createTagBody(3, {->
expressionOut.print(personInstance?.occupation?.encodeAsHTML())
})
invokeTag('link','g',216,['controller':("occupation"),'action':("show"),'id':(personInstance?.occupation?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.maritalStatus)) {
printHtmlPart(61)
invokeTag('message','g',223,['code':("person.maritalStatus.label"),'default':("Marital Status")],-1)
printHtmlPart(62)
createTagBody(3, {->
expressionOut.print(personInstance?.maritalStatus?.encodeAsHTML())
})
invokeTag('link','g',225,['controller':("maritalStatus"),'action':("show"),'id':(personInstance?.maritalStatus?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.nationality)) {
printHtmlPart(63)
invokeTag('message','g',232,['code':("person.nationality.label"),'default':("Nationality")],-1)
printHtmlPart(64)
invokeTag('fieldValue','g',234,['bean':(personInstance),'field':("nationality")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.citizenship)) {
printHtmlPart(65)
invokeTag('message','g',241,['code':("person.citizenship.label"),'default':("Citizenship")],-1)
printHtmlPart(66)
invokeTag('fieldValue','g',243,['bean':(personInstance),'field':("citizenship")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.residency)) {
printHtmlPart(67)
invokeTag('message','g',250,['code':("person.residency.label"),'default':("Residency")],-1)
printHtmlPart(68)
invokeTag('fieldValue','g',252,['bean':(personInstance),'field':("residency")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.ssn)) {
printHtmlPart(69)
invokeTag('message','g',259,['code':("person.ssn.label"),'default':("Ssn")],-1)
printHtmlPart(70)
invokeTag('fieldValue','g',261,['bean':(personInstance),'field':("ssn")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.taxID)) {
printHtmlPart(71)
invokeTag('message','g',268,['code':("person.taxID.label"),'default':("Tax ID")],-1)
printHtmlPart(72)
invokeTag('fieldValue','g',270,['bean':(personInstance),'field':("taxID")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.signature)) {
printHtmlPart(73)
invokeTag('message','g',277,['code':("person.signature.label"),'default':("Signature")],-1)
printHtmlPart(74)
createTagBody(3, {->
expressionOut.print(personInstance?.signature?.encodeAsHTML())
})
invokeTag('link','g',279,['controller':("signature"),'action':("show"),'id':(personInstance?.signature?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.notes)) {
printHtmlPart(75)
invokeTag('message','g',286,['code':("person.notes.label"),'default':("Notes")],-1)
printHtmlPart(76)
invokeTag('fieldValue','g',288,['bean':(personInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.status)) {
printHtmlPart(77)
invokeTag('message','g',295,['code':("person.status.label"),'default':("Status")],-1)
printHtmlPart(78)
createTagBody(3, {->
expressionOut.print(personInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',297,['controller':("status"),'action':("show"),'id':(personInstance?.status?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.oldId)) {
printHtmlPart(79)
invokeTag('message','g',304,['code':("person.oldId.label"),'default':("Old Id")],-1)
printHtmlPart(80)
invokeTag('fieldValue','g',306,['bean':(personInstance),'field':("oldId")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.givenNamePhonetic)) {
printHtmlPart(81)
invokeTag('message','g',313,['code':("person.givenNamePhonetic.label"),'default':("Given Name Phonetic")],-1)
printHtmlPart(82)
invokeTag('fieldValue','g',315,['bean':(personInstance),'field':("givenNamePhonetic")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.givenNameSoundex)) {
printHtmlPart(83)
invokeTag('message','g',322,['code':("person.givenNameSoundex.label"),'default':("Given Name Soundex")],-1)
printHtmlPart(84)
invokeTag('fieldValue','g',324,['bean':(personInstance),'field':("givenNameSoundex")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.familyNamePhonetic)) {
printHtmlPart(85)
invokeTag('message','g',331,['code':("person.familyNamePhonetic.label"),'default':("Family Name Phonetic")],-1)
printHtmlPart(86)
invokeTag('fieldValue','g',333,['bean':(personInstance),'field':("familyNamePhonetic")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.familyNameSoundex)) {
printHtmlPart(87)
invokeTag('message','g',340,['code':("person.familyNameSoundex.label"),'default':("Family Name Soundex")],-1)
printHtmlPart(88)
invokeTag('fieldValue','g',342,['bean':(personInstance),'field':("familyNameSoundex")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.recStatus)) {
printHtmlPart(89)
invokeTag('message','g',349,['code':("person.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(90)
invokeTag('fieldValue','g',351,['bean':(personInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.dateCreated)) {
printHtmlPart(91)
invokeTag('message','g',358,['code':("person.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(92)
invokeTag('formatDate','g',360,['date':(personInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.lastUpdated)) {
printHtmlPart(93)
invokeTag('message','g',367,['code':("person.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(94)
invokeTag('formatDate','g',369,['date':(personInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.addresses)) {
printHtmlPart(95)
invokeTag('message','g',376,['code':("person.addresses.label"),'default':("Addresses")],-1)
printHtmlPart(35)
for( a in (personInstance.addresses) ) {
printHtmlPart(96)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',379,['controller':("address"),'action':("show"),'id':(a.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.ids)) {
printHtmlPart(97)
invokeTag('message','g',387,['code':("person.ids.label"),'default':("Ids")],-1)
printHtmlPart(35)
for( i in (personInstance.ids) ) {
printHtmlPart(98)
createTagBody(4, {->
expressionOut.print(i?.encodeAsHTML())
})
invokeTag('link','g',390,['controller':("personalId"),'action':("show"),'id':(i.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.phones)) {
printHtmlPart(99)
invokeTag('message','g',398,['code':("person.phones.label"),'default':("Phones")],-1)
printHtmlPart(35)
for( p in (personInstance.phones) ) {
printHtmlPart(100)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',401,['controller':("phone"),'action':("show"),'id':(p.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.relationsWithUs)) {
printHtmlPart(101)
invokeTag('message','g',409,['code':("person.relationsWithUs.label"),'default':("Relations With Us")],-1)
printHtmlPart(35)
for( r in (personInstance.relationsWithUs) ) {
printHtmlPart(102)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',412,['controller':("PRelationWithUs"),'action':("show"),'id':(r.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(103)
createTagBody(2, {->
printHtmlPart(104)
createTagBody(3, {->
invokeTag('message','g',421,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',421,['class':("edit"),'action':("edit"),'resource':(personInstance)],3)
printHtmlPart(105)
invokeTag('actionSubmit','g',422,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(106)
})
invokeTag('form','g',424,['url':([resource:personInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(107)
})
invokeTag('captureBody','sitemesh',426,[:],1)
printHtmlPart(108)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748589L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
