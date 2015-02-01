package entities

class PRelationWithUs {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"

    String toString() {"$title/$titleInt"}

    static constraints = {
      title(blank:false, nullable:false, unique:true, maxLength:20)
      titleInt(blank:false, nullable:false, unique:true, maxLength:20)
      notes(nullable:true, lmaxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}