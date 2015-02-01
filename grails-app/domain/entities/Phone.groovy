package entities

class Phone {
//    Person      person
    String      phone
    PhoneType   phoneType
    String      notes
    String      recStatus = "Active"
    Date        dateCreated
    Date        lastUpdated      

    String toString() {"$person - $phoneType: $phone"}

    static belongsTo = [person:Person]

    static constraints = {
        person()
        phone(blank:false, nullable:false, maxSize:20)
        phoneType()
        notes(nullable:true, maxSize:250)
        recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}