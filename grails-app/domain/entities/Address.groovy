package entities

class Address {
  String        street
  String        streetNumber
  String        crossingStreet 
  String        crossingStreetNumber 
  String        floor 
  String        appartment
  String        city
  String        postCode
  String        stateOrProvince
  //@todo include POBox too
  String        countryCode2
  BigDecimal    geoLat
  BigDecimal    geoLng
  String        language  // iso2 : Corresponding language
  AddressType   addressType
  String        notes
  String        recStatus = "Active" 
  Date          dateCreated
  Date          lastUpdated  

  String toString() {"$addressType-$street $streetNumber, $postCode $city"}
 
  static belongsTo = [person:Person]
  
    static constraints = {
      person()
      addressType()
      street(blank:false, nullable:false, length:2..40)
      streetNumber(blank:false, nullable:false, length:1..5)
      crossingStreet(blank:true, nullable:true, maxSize:40)
      crossingStreetNumber(blank:true, nullable:true, maxSize:5)
      floor(blank:true, nullable:true, maxSize:20)
      appartment(blank:true, nullable:true, maxSize:5)
      city(blank:false, nullable:false, length:2..30)
      postCode(blank:false, nullable:false, length:4..6)
      stateOrProvince(blank:false, nullable:false, length:2..30)
      countryCode2(blank:false, nullable:false, length:2..2)
      geoLat(nullable:true,scale:8)
      geoLng(nullable:true,scale:8)
      language()
      notes(nullable:true, maxLength:200)
      recStatus (editable:false, display:false, inList:["Active", "Deleted"])
      dateCreated(editable:false)
      lastUpdated(editable:false)
  }
}
