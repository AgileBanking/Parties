package entities

class LegalEntity {
    String          id 
    String          marketName          // IBM
    String          registeredName      // International Business Machines
    LegalEntityType legalType
    Address         hQAddress           // Headquarters
    Address         businessAddress
    String          language            // iso2 correspondance language
    MarketSegment   marketSegment
    Registration    registration
    String          corporateRate       // internal of Moody's or S&P ...
    String          listingStatus
    String          taxID
    String          webSite
    Status          status
    String          oldSysId
    String          notes
    String          recStatus = "Active"
    Date            dateCreated
    Date            lastUpdated

  //@tip  LiquidationDate :  make liquidation an event
  //@tip  Swift
  //@todo Address Type for Legal Entities

    String toString() {marketName}

    static hasMany = [ relWithUs:RelationWithUs, legalPersons:LegalPerson]

    static constraints = {
      marketName(blank:false, nullable:false, unique:true, size:2..40)
      registeredName(blank:false, nullable:false,unique:true, size:2..100)
      legalType(nullable:false)
      hQAddress(nullable:false)
      language(nullable:false)
      marketSegment(nullable:false)
      corporateRate(blank:true, nullable:true)
      listingStatus(blank:false, nullable:false)
      registration(nullable:true)
      relWithUs(nullable:true)
      legalPersons(nullable:true)
      taxID(blank:false, nullable:false, size:5..15)
      webSite(blank:true, nullable:true,url:true)
      status(nullable:false)
      oldSysId(blank:true, nullable:true)
      notes(nullable:true, maxLength:250)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
    }

    static mapping = {
      id generator: 'assigned' //manually assigned before saving the instance
    }
    
    def beforeValidate() { 
        if (id==null) {id = "L" + UUID.randomUUID().toString()}
    }      
}
