package entities

class LegalPerson {
    Person    person
    LRepType  repType
    Date      expdate
    String    terms     // and conditions
    String    recStatus = "Active"

    String toString() {"$person ($repType)"}

    static belongsTo = LegalEntity
    static constraints = {
      person(nullable:false)
      repType(nullable:false)
      expdate(nullable:true)
      terms(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
