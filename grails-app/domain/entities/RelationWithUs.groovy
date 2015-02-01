package entities

class RelationWithUs {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    String toString() {"$title/$titleInt"}

    static constraints = {
      title(blank:false, nullable:false, unique:true, length:2..20)
      titleInt(blank:false, nullable:false, unique:true, length:2..20)
      notes(blank:true, nullable:true, length:10..250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
