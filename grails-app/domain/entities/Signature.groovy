package entities

class Signature {
    byte[]  image
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated      

    static belongsTo = [person:Person]

    static constraints = {
      image(nullable:true, maxSize: 131072 /* 128K */)
      notes(nullable:true, maxLength: 255 )
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}