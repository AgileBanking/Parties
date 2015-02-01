package entities

class PersonalIdType {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    String  toString() {title + "/" + titleInt}

    static constraints = {
      title(blank:false, length:2..15, unique:true)
      titleInt(blank:false, length:2..15, unique:true)
      notes(nullable:true,maxLenth:200)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}