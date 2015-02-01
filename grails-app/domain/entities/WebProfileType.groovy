package entities

class WebProfileType {
    String      title
    String      titleInt
    String      notes
    String      recStatus = "Active"
    
    String toString() {"$title/$titleInt"}
    
    
    static constraints = {
        title       ()
        titleInt    ()
        notes       (nullable:true, maxLength:250, widget: 'textarea')
        recStatus   (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
