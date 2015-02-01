package entities

class Occupation {
    String  code
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated    

    String  toString()  {"$code: $title/$titleInt"}

    static constraints = {
      code(blank:false, nullable:false, unique:true, maxLength:20)
      title(blank:false, nullable:false, unique:true,maxLength:30)
      titleInt(blank:false, nullable:false, unique:true,maxLength:30)
      notes(nullable:true, maxLength:255)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}