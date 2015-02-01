package entities

class Registration {
    LegalEntity legalEntity
    Register  register
    String    regId
    Date      regDate
    Date      expDate
    String    notes
    String    recStatus = "Active"
    Date      dateCreated
    Date      lastUpdated      

    String  toString() {"$register: $regId"}
    static  belongsTo = [register:Register, legalEntity: LegalEntity]

    static constraints = {
      legalEntity(nullable:false)
      register(nullable:false)
      regId(blank:false, nullable:false, maxSize:40)
      regDate(max:new Date(), nullable:false)
      expDate(nullable:false)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}