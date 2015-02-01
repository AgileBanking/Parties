package entities

class PersonalId {
    Person      person
    PersonalIdType idType
    String      idCode
    Date        issueDate
    Date        validUntil
    String      issuedBy
    String      countryCode2
    IdStatus    idStatus
    String      notes
    String      recStatus   = "Active"
    Date        dateCreated
    Date        lastUpdated    

    String  toString() {"$idType: $idCode,$status" }

    static belongsTo = [person:Person]
    
    static constraints = {
      person()
      idType(nullable:false)
      idCode(blank:false, nullable:false, size:2..20)
      issueDate(blank:false, nullable:false)
      validUntil(blank:false, nullable:false)
      issuedBy(blank:false, nullable:false)
      countryCode2(blank:false, nullable:false, size:2..2)
      idStatus(nullable:true)
      notes(nullable:true)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}