package entities

class Register {
    String  authority
    String  authorityInt
    String  countryCode
    String  webAddress
    String  email
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    String  toString()  {"$authority/$authorityInt"}
    static hasMany = [registrations:Registration]

    static constraints = {
      authority(blank:false, nullable:false, unique:true, size:2..30)
      authorityInt(blank:true, nullable:true, unique:true, size:0..30)
      countryCode(blank:false, nullable:false,  size:2..2)
      webAddress(blank:true, nullable:true)
      email(blank:true, nullable:true, email:true)
      registrations(nullable:true)
      notes(maxLength:250, nullable:true)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}