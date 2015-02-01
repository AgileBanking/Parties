package entities

class AddressType {
    String  title
    String  titleInt       // OPTIONAL International
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated
    
    String toString() {"${title}/${titleInt}" }

    static constraints = {
        title(blank:false, nullable:false, maxSize:30, unique:true)
        titleInt(blank:true, nullable:true, maxSize:30, unique:true)
        notes(nullable:true, maxLength:200)
        recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }    

    static mapping = {
        table 'addresses'
        version true
        autoTimestamp true
        titleInt index:'title_Idx'
        sort "titleInt"
    }      
}
