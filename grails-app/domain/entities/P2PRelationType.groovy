package entities

class P2PRelationType {
    String  title
    String  titleInt
    String  fromPart
    String  toPart
    boolean isReflective = false
    String  notes
    String  recStatus = "Active"

    String  toString() {"$title/$titleInt"}

    static constraints = {
      title(blank:false, nullable:false, unique:true)
      titleInt(blank:false, nullable:false, unique:true)
      fromPart(blank:false, nullable:false)
      toPart(blank:false, nullable:false)
      isReflective(nullable:false)
      notes(maxLength:250, widget: 'textarea', nullable:true)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}