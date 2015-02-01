package entities

class MaritalStatus {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated
    
    String toString() {"$title/$titleInt"}

    static constraints = {
      title(blank:false, nullable:false, unique:true, length:2..15)
      titleInt(blank:false, nullable:false, unique:true, length:2..15)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}