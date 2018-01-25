@thePredators
@pharmacylocator
Feature:To test Locate a Pharmacy tool in Redesign site

@PharmacyDistanceDefaultZip
Scenario Outline:To verify for default zipcode, filters, Show on map, View PDF, More Info in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
	| Plan Type | <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters distance details in Redesign site
	| Distance | <distance>  |
And the user selects Pharmacy Types to Filter in Redesign Site
| Pharmacy Type	| <pharmacyType> |
Then the user validates the pharmacies available in Redesign site
And the user Validates show on map link in Redesign Site
And the user validate more information content based on plan type in Redesign Site
And the user Validates view search PDF link in Redesign Site

Examples:
	| planType | memberType 			| distance |pharmacyType			|
	| MAPD      | AARPIndividual  |  10       |Open 24 hours |
	| PDP	   | AARPIndividual  |   25      |Standard Network Pharmacy (90-day) |
#	| MAPD	   | AARPIndividual  | 25        | Long-term care |

@ValidateLanguageandZIPcode
Scenario Outline: To verify pharmacy Locator ZIP code entry and for Chinese and Spanish Language in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters following details for pharmacy search in Redesign Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
Then the user validates the pharmacies available in Redesign site
When  the user Selects Chinese Language in Redesign Site
Then  the user searches multi lang for pharmacy search results available in Redesign site
When the user Selects Spanish Language in Redesign site
Then the user searches multi lang for pharmacy search results available in Redesign site

     Examples: 
    | planType | memberType  | zipcode | distance | 
    | MAPD	   | AARPIndividual  |  10980 |       15 | 
    
    
@ZipCodeErrorMessages
Scenario Outline: To verify error messages for invalid Zipcode in pharmacy locator page in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
When the user enters following details for pharmacy search in Redesign Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
Then the user verify error messages in pharmacy locator page in Redesign site
 
     Examples: 
   | planType | memberType    | zipcode | distance | 
      | MAPD	   | AARPIndividual  |         |       15 | 
      | MAPD	   | AARPIndividual  |    9999 |       15 | 

#@zipcodeEntry
#  Scenario Outline: To verify pharmacy locator zipcode entry in Redesign site
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
#  | Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#And the user enters following details for pharmacy search in Redesign Site
#      | Zip Code    | <zipcode>  |
#      | Distance    | <distance> |
#Then the user validates the pharmacies available in Redesign site

#    Examples: 
#    | planType | memberType  | zipcode | distance | 
#    | PDP 		 | AARPIndividual  |  10980  |  15			|
#    | MAPD	   | AARPIndividual  |   10980 |       15 | 


 #@ValidateMoreInfoPlanSpecific
 #   Scenario Outline: To verify pharmacy locator More Info Limited Access Disclaimers for Specific Plans
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
#  | Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user validates more information content for Limited Access Disclaimer
#  | Disclaimer Text  | <DisclaimerText> |

# Examples: 
#    | planType 	| memberType 		| DisclaimerText | 
#    | PDP	   		| SymphonixRx  | pharmacy network offers limited access to pharmacies with preferred cost sharing in rural Montana, Nebraska, North Dakota, South Dakota and Wyoming. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use. For up-to-date information about our network pharmacies, including pharmacies with preferred cost sharing, please call   |
#    | PDP	   		| WalgreensRx  |  pharmacy network offers limited access to pharmacies with preferred cost sharing in urban North Dakota and West Virginia, suburban California, Hawaii, Maine, Maryland, New York, North Dakota, Pennsylvania, West Virginia, and rural Alaska, Arkansas, Hawaii, Idaho, Iowa, Kansas, Kentucky, Maine, Minnesota, Mississippi, Missouri, Montana, Nebraska, New York, Oklahoma, Pennsylvania, South Dakota, Texas, Vermont, Virginia, West Virginia and Wyoming. There are an extremely limited number of preferred cost share pharmacies in urban Vermont and rural North Dakota. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use |
#    | PDP	   		| MedicareRxSaverPlus |  pharmacy network offers limited access to pharmacies with preferred cost sharing in rural Montana, Nebraska, North Dakota, South Dakota and Wyoming. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use. For up-to-date information about our network pharmacies, including pharmacies with preferred cost sharing |  
#    | PDP	   		| MedicareRxPreferred  | pharmacy network offers limited access to pharmacies with preferred cost sharing in rural Montana, Nebraska, North Dakota, South Dakota and Wyoming. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use. For up-to-date information about our network pharmacies, including pharmacies with preferred cost sharing  |
    


    