package entities

class Status {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    String toString() {"$title/$titleInt"}

    static constraints = {
      title(blank:false, nullable:false, unique:true, maxSize:20)
      titleInt(blank:false, nullable:false, unique:true, maxSize:20)
      notes(maxLength:250, nullable:true)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}