import entities.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_parties_personshow__Master_PC_s_conflicted_copy_2014_02_13__gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/show (Master-PC's conflicted copy 2014-02-13).gsp" }
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
if(true && (personInstance?.p2PRelationsLeft)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("person.p2PRelationsLeft.label"),'default':("P2 PR elations Left")],-1)
printHtmlPart(35)
for( p in (personInstance.p2PRelationsLeft) ) {
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
if(true && (personInstance?.p2PRelationsRight)) {
printHtmlPart(39)
invokeTag('message','g',120,['code':("person.p2PRelationsRight.label"),'default':("P2 PR elations Right")],-1)
printHtmlPart(35)
for( p in (personInstance.p2PRelationsRight) ) {
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
if(true && (personInstance?.spouseFirstName)) {
printHtmlPart(41)
invokeTag('message','g',131,['code':("person.spouseFirstName.label"),'default':("Spouse First Name")],-1)
printHtmlPart(42)
invokeTag('fieldValue','g',133,['bean':(personInstance),'field':("spouseFirstName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.spouseLastName)) {
printHtmlPart(43)
invokeTag('message','g',140,['code':("person.spouseLastName.label"),'default':("Spouse Last Name")],-1)
printHtmlPart(44)
invokeTag('fieldValue','g',142,['bean':(personInstance),'field':("spouseLastName")],-1)
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
if(true && (personInstance?.contractualAbility)) {
printHtmlPart(55)
invokeTag('message','g',194,['code':("person.contractualAbility.label"),'default':("Contractual Ability")],-1)
printHtmlPart(56)
createTagBody(3, {->
expressionOut.print(personInstance?.contractualAbility?.encodeAsHTML())
})
invokeTag('link','g',196,['controller':("contractualAbility"),'action':("show"),'id':(personInstance?.contractualAbility?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.occupation)) {
printHtmlPart(57)
invokeTag('message','g',203,['code':("person.occupation.label"),'default':("Occupation")],-1)
printHtmlPart(58)
createTagBody(3, {->
expressionOut.print(personInstance?.occupation?.encodeAsHTML())
})
invokeTag('link','g',205,['controller':("occupation"),'action':("show"),'id':(personInstance?.occupation?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.maritalStatus)) {
printHtmlPart(59)
invokeTag('message','g',212,['code':("person.maritalStatus.label"),'default':("Marital Status")],-1)
printHtmlPart(60)
createTagBody(3, {->
expressionOut.print(personInstance?.maritalStatus?.encodeAsHTML())
})
invokeTag('link','g',214,['controller':("maritalStatus"),'action':("show"),'id':(personInstance?.maritalStatus?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.nationality)) {
printHtmlPart(61)
invokeTag('message','g',221,['code':("person.nationality.label"),'default':("Nationality")],-1)
printHtmlPart(62)
invokeTag('fieldValue','g',223,['bean':(personInstance),'field':("nationality")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.citizenship)) {
printHtmlPart(63)
invokeTag('message','g',230,['code':("person.citizenship.label"),'default':("Citizenship")],-1)
printHtmlPart(64)
invokeTag('fieldValue','g',232,['bean':(personInstance),'field':("citizenship")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.residency)) {
printHtmlPart(65)
invokeTag('message','g',239,['code':("person.residency.label"),'default':("Residency")],-1)
printHtmlPart(66)
invokeTag('fieldValue','g',241,['bean':(personInstance),'field':("residency")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.SSN)) {
printHtmlPart(67)
invokeTag('message','g',248,['code':("person.SSN.label"),'default':("SSN")],-1)
printHtmlPart(68)
invokeTag('fieldValue','g',250,['bean':(personInstance),'field':("SSN")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.taxID)) {
printHtmlPart(69)
invokeTag('message','g',257,['code':("person.taxID.label"),'default':("Tax ID")],-1)
printHtmlPart(70)
invokeTag('fieldValue','g',259,['bean':(personInstance),'field':("taxID")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.signature)) {
printHtmlPart(71)
invokeTag('message','g',266,['code':("person.signature.label"),'default':("Signature")],-1)
printHtmlPart(72)
createTagBody(3, {->
expressionOut.print(personInstance?.signature?.encodeAsHTML())
})
invokeTag('link','g',268,['controller':("signature"),'action':("show"),'id':(personInstance?.signature?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.notes)) {
printHtmlPart(73)
invokeTag('message','g',275,['code':("person.notes.label"),'default':("Notes")],-1)
printHtmlPart(74)
invokeTag('fieldValue','g',277,['bean':(personInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.status)) {
printHtmlPart(75)
invokeTag('message','g',284,['code':("person.status.label"),'default':("Status")],-1)
printHtmlPart(76)
createTagBody(3, {->
expressionOut.print(personInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',286,['controller':("status"),'action':("show"),'id':(personInstance?.status?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.oldId)) {
printHtmlPart(77)
invokeTag('message','g',293,['code':("person.oldId.label"),'default':("Old Id")],-1)
printHtmlPart(78)
invokeTag('fieldValue','g',295,['bean':(personInstance),'field':("oldId")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.givenNamePhonetic)) {
printHtmlPart(79)
invokeTag('message','g',302,['code':("person.givenNamePhonetic.label"),'default':("Given Name Phonetic")],-1)
printHtmlPart(80)
invokeTag('fieldValue','g',304,['bean':(personInstance),'field':("givenNamePhonetic")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.givenNameSoundex)) {
printHtmlPart(81)
invokeTag('message','g',311,['code':("person.givenNameSoundex.label"),'default':("Given Name Soundex")],-1)
printHtmlPart(82)
invokeTag('fieldValue','g',313,['bean':(personInstance),'field':("givenNameSoundex")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.familyNamePhonetic)) {
printHtmlPart(83)
invokeTag('message','g',320,['code':("person.familyNamePhonetic.label"),'default':("Family Name Phonetic")],-1)
printHtmlPart(84)
invokeTag('fieldValue','g',322,['bean':(personInstance),'field':("familyNamePhonetic")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.familyNameSoundex)) {
printHtmlPart(85)
invokeTag('message','g',329,['code':("person.familyNameSoundex.label"),'default':("Family Name Soundex")],-1)
printHtmlPart(86)
invokeTag('fieldValue','g',331,['bean':(personInstance),'field':("familyNameSoundex")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.recStatus)) {
printHtmlPart(87)
invokeTag('message','g',338,['code':("person.recStatus.label"),'default':("Rec Status")],-1)
printHtmlPart(88)
invokeTag('fieldValue','g',340,['bean':(personInstance),'field':("recStatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.dateCreated)) {
printHtmlPart(89)
invokeTag('message','g',347,['code':("person.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(90)
invokeTag('formatDate','g',349,['date':(personInstance?.dateCreated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.lastUpdated)) {
printHtmlPart(91)
invokeTag('message','g',356,['code':("person.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(92)
invokeTag('formatDate','g',358,['date':(personInstance?.lastUpdated)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (personInstance?.addresses)) {
printHtmlPart(93)
invokeTag('message','g',365,['code':("person.addresses.label"),'default':("Addresses")],-1)
printHtmlPart(35)
for( a in (personInstance.addresses) ) {
printHtmlPart(94)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',368,['controller':("address"),'action':("show"),'id':(a.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.ids)) {
printHtmlPart(95)
invokeTag('message','g',376,['code':("person.ids.label"),'default':("Ids")],-1)
printHtmlPart(35)
for( i in (personInstance.ids) ) {
printHtmlPart(96)
createTagBody(4, {->
expressionOut.print(i?.encodeAsHTML())
})
invokeTag('link','g',379,['controller':("personalId"),'action':("show"),'id':(i.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.phones)) {
printHtmlPart(97)
invokeTag('message','g',387,['code':("person.phones.label"),'default':("Phones")],-1)
printHtmlPart(35)
for( p in (personInstance.phones) ) {
printHtmlPart(98)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',390,['controller':("phone"),'action':("show"),'id':(p.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(17)
if(true && (personInstance?.relationsWithUs)) {
printHtmlPart(99)
invokeTag('message','g',398,['code':("person.relationsWithUs.label"),'default':("Relations With Us")],-1)
printHtmlPart(35)
for( r in (personInstance.relationsWithUs) ) {
printHtmlPart(100)
createTagBody(4, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',401,['controller':("PRelationWithUs"),'action':("show"),'id':(r.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(101)
createTagBody(2, {->
printHtmlPart(102)
createTagBody(3, {->
invokeTag('message','g',410,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',410,['class':("edit"),'action':("edit"),'resource':(personInstance)],3)
printHtmlPart(103)
invokeTag('actionSubmit','g',411,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(104)
})
invokeTag('form','g',413,['url':([resource:personInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(105)
})
invokeTag('captureBody','sitemesh',415,[:],1)
printHtmlPart(106)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422691748582L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
