package entities

class Person {
    String      id // Busines Defined ID in order to move easily from environment to environment (Test-Production)
    Salutation  salutation
    String      givenName
    String      middleName
    String      familyName
    String      alliasName
    String      fatherName
    String      motherName
    String      internationalFullname
    Gender      gender
    MaritalStatus maritalStatus
    String      spouseGivenName
    String      spouseFamilyName
    String      spouseFatherName
    Date        birthdate
    String      placeOfBirth
    String      deathdate = null
    ContractualAbility  contractualAbility        
    Occupation  occupation
     //@todo Να φορτώνει το Global Local Country
     //@todo Να συνδέεται με combo box. Ιδανικά να φορτώνεται με rest GET
    String      nationality
    String      citizenship
    String      residency
    String      email
    String      ssn                         // Social Security Number
    String      taxID
    Signature   signature
    String      notes
    Status      status 
    String      oldId                       // In case it was migrated or copied from other system
    String      recStatus = "Active"
    Date        dateCreated
    Date        lastUpdated

//    Phonetic
    String  givenNamePhonetic
    String  givenNameSoundex
    String  familyNamePhonetic
    String  familyNameSoundex


    String toString()  {"$givenName $familyName 0f $fatherName"}

    static hasMany = [  ids: PersonalId, 
                        addresses: Address, 
                        phones:Phone, 
                        p2PRelationsFrom: P2PRelation, 
                        p2PRelationsTo: P2PRelation, 
                        relationsWithUs:PRelationWithUs,
                        webProfile:WebProfile
                    ]
    static mappedBy = [ p2PRelationsFrom:'fromPerson', 
                        p2PRelationsTo:'toPerson']

    
    static constraints = {
      givenName(blank:false)
      middleName(blank:true, nullable:true)
      familyName(blank:false)
      alliasName(blank:true, nullable:true)
      fatherName(blank:false)
      motherName(blank:false)
      internationalFullname(blank:false)
      salutation()
      gender()
      p2PRelationsFrom(nullable:true)
      p2PRelationsTo(nullable:true)
      spouseGivenName(blank:true, nullable:true)
      spouseFamilyName(blank:true, nullable:true)
      spouseFatherName(blank:true, nullable:true)
      birthdate(blank:false,  max: new Date() )
      placeOfBirth(maxsize:40)
      deathdate(blank:true, nullable:true)
      email(blank:true, nullable:true, email:true, unique:true)
      webProfile(nullable:true)
      contractualAbility()
      occupation(nullable:true)
      maritalStatus(blank:false)
      nationality(blank:false,  size:2..2)
      citizenship(blank:false,  size:2..2)
      residency(blank:false,  size:2..2)
      ssn(blank:true, nullable:true, size:6..12, unique:true)
      taxID(blank:true, nullable:true, unique:true)
      signature(nullable:true)
      notes(nullable:true, maxLength:250, widget: 'textarea')
      status(nullable:false)
      oldId(blank:true, nullable:true, unique:true)
      givenNamePhonetic(blank:true, nullable:true)
      givenNameSoundex(blank:true, nullable:true)
      familyNamePhonetic(blank:true, nullable:true)
      familyNameSoundex(blank:true, nullable:true)
      recStatus (editable:false, inList:["Active", "Deleted"])
      dateCreated(editable:false)
      lastUpdated(editable:false)
    }
    
    static mapping = {
        id generator: 'assigned' //manually assigned before saving the instance

        version true
        autoTimestamp true

        // byName
        familyName  index: 'byName'
        givenName   index: 'byName' 
        fatherName  index: 'byName'
        
        givenNameSoundex    index: 'byFirstNameSoundex'
        familyNameSoundexby index: 'byFamilyNameSoundex'
        
        fullnameorder sort: 'familyName', 'givenName', 'fatherName' 
        cache true       
    } 
    
    def beforeValidate() { 
        if (id==null) {id = "P" + UUID.randomUUID().toString()}
    }    
    /*
    Include in PersonController
        def SoundexService

        params.givenNameSoundex = SoundexService.convertToSoundex(params.givenName)
        params.familyNameSoundex = SoundexService.convertToSoundex(params.familyName)
    */
}