class BootStrap {

     def init = { servletContext ->
        //Load the DB Manager
//        org.hsqldb.util.DatabaseManager.main("--url","jdbc:hsqldb:file:prodDb;shutdown=true")

        def mar1 = new entities.MaritalStatus(title:"Ελεύθερος(η)", titleInt:"Free").save()
        def mar2 = new entities.MaritalStatus(title:"Παντρεμένος(η)", titleInt:"Married").save(flush:true)

        def gender1 = new entities.Gender(title: "Άντρας", titleInt: "Male").save()
        def gender2 = new entities.Gender(title: "Γυναίκα", titleInt: "Female").save()
        def gender3 = new entities.Gender(title: "Άγνωστο", titleInt: "Unknown").save()
        def gender4 = new entities.Gender(title: "Άσχετο", titleInt: "Not Applicable").save(flush:true)

        def sal1 = new entities.Salutation(title:"Κύρ.", titleInt:"Mr.").save()
        def sal2 = new entities.Salutation(title:"Κα.", titleInt:"Mrs.").save()
        def sal3 = new entities.Salutation(title:"Δοκτορα.", titleInt:"Doctor").save(flush:true)

        def at1 = new entities.AddressType(title: "Μόνιμη Κατοικία", titleInt: "Home").save()
        def at2 = new entities.AddressType(title: "Εργασία", titleInt: "Work").save()
        def at3 = new entities.AddressType(title: "Εξοχική Κατοικία", titleInt: "Holyday House").save()
        def at4 = new entities.AddressType(title: "Προσωρινή Διεύθυνση", titleInt: "Temporal Address").save(flush:true)

        def ids1 = new entities.IdStatus(title: "Ενεργό", titleInt: "Active", comments:"").save()
        def ids2 = new entities.IdStatus(title: "Δήλωθηκε Απώλεια", titleInt: "Lost", comments:"").save()
        def ids3 = new entities.IdStatus(title: "Έληξε", titleInt: "Expired", comments:"").save(flush:true)

        def p2pR1 = new entities.P2PRelationType(title:"Γονέας-Παιδί", titleInt:"Parent-Child", left:"Parent of", right:"Child of", bloodRelation:1, comments:"").save()
        def p2pR2 = new entities.P2PRelationType(title:"Σύζυγοι", titleInt:"married couple", left:"Husband of", right:"Wife of", bloodRelation:0, comments:"").save(flush:true)

        def pcomp1 = new entities.ContractualAbility(title:"Ικανός", titleInt:"Able", comments:"").save()
        def pcomp2 = new entities.ContractualAbility(title:"Ανίκανος", titleInt:"Desabled", comments:"").save(flush:true)

        def pidt1 = new entities.PersonalIdType (title:"Δελτίο Αστ. ταυτότητας", titleInt:"Police ID").save()
        def pidt2 = new entities.PersonalIdType (title:"Διαβατήριο", titleInt:"Passport").save()
        def pidt3 = new entities.PersonalIdType (title:"'Αδεια Παραμονής", titleInt:"Residence Permit").save()
        def pidt4 = new entities.PersonalIdType (title:"Άδεια Οδήγησης", titleInt:"Driving License").save(flush:true)

        def occ1 = new entities.Occupation(code:"1", title:"Ψαράς", titleInt:"Fisherman", notes:"").save()
        def occ2 = new entities.Occupation(code:"2", title:"Μαραγγος", titleInt:"Carpenter", notes:"").save(flush:true)
        
        def lgt1 = new entities.LegalGroupType(title:"Μετοχικός Όμιλος", titleInt:"Equity Group", notes:"").save()
        def lgt2 = new entities.LegalGroupType(title:"Προνομιακός Όμιλος", titleInt:"Franchise Group", notes:"").save(flush:true)
        
        def lgp1 = new entities.LegalGroup(legalGroupType:lgt1, title:"Intracom", titleInt:"Intracom", notes:"").save()
        def lgp2 = new entities.LegalGroup(legalGroupType:lgt1, title:"Ergo", titleInt:"Ergo", notes:"").save(flush:true)
        
        def let1 = new entities.LegalEntityType(title:"Ατομική Εταιρεία", titleInt:"Personal", notes:"").save()
        def let2 = new entities.LegalEntityType(title:"ΕΠΕ", titleInt:"LTD", notes:"").save()
        def let3 = new entities.LegalEntityType(title:"ΑΝΩΝΥΜΗ Εταιρεία", titleInt:"SA", notes:"").save()
        def let4 = new entities.LegalEntityType(title:"ΤΡΑΠΕΖΙΚΗ ΕΤΑΙΡΕΙΑ", titleInt:"BANK", notes:"").save()
        def let5 = new entities.LegalEntityType(title:"ΕΚΠΑΙΔΕΥΤΙΚΟΣ ΟΡΓΑΝΙΣΜΟΣ", titleInt:"EDUCATIONAL INSTITUTE", notes:"").save(flush:true)
        
        def rwu1 = new entities.RelationWithUs(title:"Μέτοχος", titleInt:"Shareholder", notes:null).save()
        def rwu2 = new entities.RelationWithUs(title:"Στέλεχος", titleInt:"Employee", notes:null).save()
        def rwu3 = new entities.RelationWithUs(title:"Πελάτης", titleInt:"Customer", notes:null).save()
        def rwu4 = new entities.RelationWithUs(title:"Συνεργάτης", titleInt:"Partner", notes:null).save(flush:true) 
        
        def pt1 = new entities.PhoneType(phoneType:"Σταθερό στο σπίτι", phoneTypeInt:"Home").save()
        def pt2 = new entities.PhoneType(phoneType:"κινητό", phoneTypeInt:"Mobile").save()
        def pt3 = new entities.PhoneType(phoneType:"Εργασίας", phoneTypeInt:"Work").save()
        def pt4 = new entities.PhoneType(phoneType:"Συζύγου", phoneTypeInt:"Spouse").save(flush:true) 
        
//        def phn1 = new entities.Phone(phone:"210 6655111", phoneType:pt3).save()
//        def phn2 = new entities.Phone(phone:"210 6040506", phoneType:pt1).save()
//        def phn3 = new entities.Phone(phone:"6947 995737", phoneType:pt2).save(flush:true)
        
        def wpt1 = new entities.WebProfileType(title:"Ηλεκτρονικο ταχυδρομειο", titleInt:"email address").save()
        def wpt2 = new entities.WebProfileType(title:"Ιστοσελίδα", titleInt:"Web Page").save()
        def wpt3 = new entities.WebProfileType(title:"Κωδικός Facebook", titleInt:"Facebook id").save()
        def wpt4 = new entities.WebProfileType(title:"Κωδικός Twitter", titleInt:"Twitter id").save(flush:true)
        
//        def pid1 = new entities.PersonalId(idType:pidt1, idCode:"AI345678", issueDate:"1992-10-2", validUntil:"2022-10-1", issuedBy:"Α.Τ. Παλλήνης", countryCode2:"GR",status:ids1).save()        
//        def lgr1 = new entities.LegalGroupelation()

        
//        def person1 = new entities.Person(
//            salutation:sal1,
//            firstName:"Νίκος",
//            middleName:null,
//            lastName:"Καραμολέγκος",
//            alliasName:null,
//            fathername:"Χρήστος",
//            motherName:"Δήμητρα",
//            internationalFullname:"NIKOS KARAMOLEGOS",
//            gender:gender1,
//            maritalStatus:mar2,
//            spouseFirstName:"Δέσποινα",
//            spouseLastName:"Τούντα",
//            spouseFatherName:"Δημήτριος",
//            birthdate:"1944-3-8",
//            placeOfBirth: "Nikaia",
//            compitency:pcomp1,
//            nationality:"GR",
//            citizenship:"GR",
//            contractualAbility:pcomp1,
//            SSN:"",
//            oldId:""
//        ).save()
//
//        def personId1 = new entities.PersonalId(
//            person:person1, idType:pid1, idCode:"Σ123456", issueDate:"2000-10-11", validUntil:"2000-10-11",
//            issuedBy:"Αστ. Τμ. Γλ. Νερών",
//            countryCode2:"GR", idStatusCodes:ids1, notes:""
//        ).save()


//
//       def add1 = new entities.Address(
//            personOwner:person1,
//            street:"Afroditis",
//            streetNumber:"13",
//            crossingStreet:"",
//            crossingStreetNumber:"",
//            floor:"",
//            appartment:"",
//            city:"KANTZA",
//            postCode:"15351",
//            stateOrProvince:"Attika",
//            countryCode:"GR",
//            title:at1,
//            language:lang1
//        ).save()
     

     }
     def destroy = {
     }
} 