package entities

class PhoneType {
    String phoneType
    String phoneTypeInt
    String notes
    String recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    String toString() {return "${phoneType}/${phoneTypeInt}" }

    static constraints = {
        phoneType(blank:false, nullable:false, maxSize:30)
        phoneTypeInt(maxSize:30)
        notes(nullable:true, maxLenth:200)
        recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}