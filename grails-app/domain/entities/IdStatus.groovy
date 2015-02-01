package entities

class IdStatus {
    String      title
    String      titleInt
    String      notes
    String      recStatus = "Active"
    Date        dateCreated
    Date        lastUpdated
    
    String toString() {"${title}/${titleInt}"}
    
    static constraints = {
        title(unique:true, size:2..20)
        titleInt(unique:true, size:2..20)
        notes(nullable:true, maxLength:500)
        recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
