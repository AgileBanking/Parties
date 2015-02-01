package entities

class LegalGroupRelation {
    LegalGroup      legalEntityGroup
    LegalEntity     member1
    LegalEntity     member2
//    String      relationType  = "->"
    Date            lastRevision
    Date            nextRevision
    String          notes
    String          recStatus = "Active"
    Date            dateCreated
    Date            lastUpdated
    
    String  toString() {"$legalEntityGroup: $member1/$member2"}

    static belongsTo = LegalGroup

    static constraints = {
      legalEntityGroup(nullable:false)
      member1(nullable:false)
      member2(nullable:false)
//      RelationType(blank:false, nullable:false, size:2)//, inList:['->', '<-', '--', '<>'])
          // -> : member1 ---> member2
          // -> : member1 <--- member2
          // -- : member1 ---- member2
          // <> : member1 <--> member2
      lastRevision(blank:false, nullable:false, maxValue:new Date())
      nextRevision(blank:true, nullable:true)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}
