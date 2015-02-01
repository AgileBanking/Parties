package entities

class MarketSegment {
    String  code
    String  title
    String  titleInt
    String  notes
    MarketSegment parent
    String  recStatus = "Active"
    Date        dateCreated
    Date        lastUpdated
    
    String toString() {return "$code: $title/$titleInt"}
//    String toString() {return "$code: $title" + {if(!ititleInt) {"/$titleInt"}}}

  
    static hasMany = [children: MarketSegment]

    static constraints = {
      code(blank:false, nullable:false, unique:true)
      title(blank:false,nullable:false, maxLength:50)
      titleInt(blank:true,nullable:true, maxLength:50)
      parent(nullable:true)
      notes(maxLength:250, nullable:true)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}