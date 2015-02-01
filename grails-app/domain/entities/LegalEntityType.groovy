package entities

class LegalEntityType {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"

    String toString() {"$title/$titleInt"}
    static constraints = {
      title(blank:false, nullable:false, unique:true, length:2..30)
      titleInt(blank:false, nullable:false, unique:true, length:2..30)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
