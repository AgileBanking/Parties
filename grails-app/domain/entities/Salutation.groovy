package entities

class Salutation {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    String toString()  {title + "/" + titleInt}

    static constraints = {
      title(blank: false, length:0..15, unique:true)
      titleInt(blank: false, length:0..15, unique:true)
      notes(nullable:true, maxLength:200)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}