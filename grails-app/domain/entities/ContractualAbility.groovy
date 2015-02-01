package entities

class ContractualAbility {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"

    String  toString() {title + "/" + titleInt}
    
    static constraints = {
      title(blank:false, length:3..20, unique:true)
      titleInt(blank:false, length:3..20, unique:true)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
