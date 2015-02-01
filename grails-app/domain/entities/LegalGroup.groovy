package entities

class LegalGroup {
    LegalGroupType  legalGroupType
    String          title
    String          titleInt
    String          notes
    String          recStatus = "Active"

    String toString() {"${title}/${titleInt}" }
    
    static belongsTo = LegalGroupType

    static hasMany = [relatedEntities: LegalGroupRelation]

    static constraints = {
      title(blank:false, nullable:false, unique:true, maxSize:40)
      titleInt(blank:true, nullable:true, unique:true, maxSize:40)
      notes(nullable:true, maxLength:250)
      legalGroupType(nullable:false)
      relatedEntities()
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
