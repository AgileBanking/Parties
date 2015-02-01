package entities

class P2PRelation {
    P2PRelationType p2pRelation
    Person  fromPerson
    Person  toPerson
    String  notes
    String  recStatus = "Active"

    static belongsTo = [Person]
    static mappedBy = [fromPerson:'p2PRelationsFrom', toPerson:'p2PRelationsRight']


    String toString()  {"$p2pRelation from=$fromPerson, to=$toPerson"}

    static constraints = {
      p2pRelation(nullable:false)
      fromPerson(nullable:false)
      toPerson(nullable:false)
      notes(maxLength:250, nullable:true, widget: 'textarea')
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }
}