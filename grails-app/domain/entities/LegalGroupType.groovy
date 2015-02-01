package entities

class LegalGroupType {
    String  title
    String  titleInt =""
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated    

    String  toString() {"$title/$titleInt"}
    static hasMany = [legalGroups: LegalGroup]

    static constraints = {
      title(blank:false, nullable:false, unique:true, maxSize:40)
      titleInt(blank:true, nullable:true, unique:true, maxSize:40)
      legalGroups(nullable:true)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }  
}
