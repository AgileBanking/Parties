package entities

class LRepType {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated
    
    String toString() {"$title/$titleInt"}
    
    static constraints = {
      title(blank:false, nullable:false, unique:true, maxLength:40)
      titleInt(blank:true, nullable:true, unique:true, maxLength:40)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}