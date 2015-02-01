package entities

class WebProfile {
    WebProfileType      webProfileType
    String              notes
    String              recStatus = "Active"
    
    String toString() {"$person / $webProfileType"}
    
    static belongsTo = [person:Person]
    static constraints = {
        person          ()
        webProfileType  ()
        notes           (nullable:true, maxLength:250, widget: 'textarea')
        recStatus       (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
