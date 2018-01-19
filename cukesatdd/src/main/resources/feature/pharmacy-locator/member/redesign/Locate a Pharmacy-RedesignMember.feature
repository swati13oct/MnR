@thePredators
@pharmacylocator
Feature:To test Locate a Pharmacy tool in Redesign site

@PharmacyDistanceDefaultZip
Scenario Outline:To verify all available pharmacies for default zipcode in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
	| Plan Type | <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters distance details in Redesign site
	| Distance | <distance>  |
Then the user validates the pharmacies available in Redesign site

Examples:
	| planType | memberType | distance |
	| PDP      | Individual  |  25       |
	| MAPD	   | Individual  |   10      |

@PharmacyFilters
Scenario Outline:To verify pharmacies displayed for particular pharamcy type for default zipcode in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters distance details in Redesign site
| Distance	| <distance>  |
And the user selects Pharmacy Types to Filter in Redesign Site
| Pharmacy Type	| <pharmacyType> |
Then the user validates the pharmacies available in Redesign site

Examples:
	| planType | memberType | distance | pharmacyType							|
	| PDP      | Individual  | 25       |	Open 24 hours |
	| MAPD	   | Individual  | 25        | Long-term care |
	| MAPD	   | Individual  | 25        | Standard Network Pharmacy (90-day) |


  @zipcodeEntry
  Scenario Outline: To verify pharmacy locator zipcode entry in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters following details for pharmacy search in Redesign Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
Then the user validates the pharmacies available in Redesign site

    Examples: 
    | planType | memberType  | zipcode | distance | 
    | PDP 		 | Individual  |  10980  |  15			|
    | MAPD	   | Individual  |   10980 |       15 | 

   @Validateshowonmap
   Scenario Outline: To verify pharmacy locator showmap in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
Then the user Validates show on map link in Redesign Site

     Examples: 
    | planType | memberType  | 
    | PDP  		 | Individual	 |
#    | MAPD	   | Individual  | 


#       @ValidateViewAsPDF
#   Scenario Outline: To verify pharmacy locator View As PDF in Redesign site
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
#  | Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user Validates view search PDF link in Redesign Site

 #    Examples: 
 #   | planType | memberType  |
 #   | MAPD	   | Individual  | 
  
        @ValidateMoreInfoMAPD
   Scenario Outline: To verify pharmacy locator More Info Disclaimers for MAPD in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
Then the user validate more information content based on plan type in Redesign Site

     Examples: 
    | planType | memberType  | 
    | MAPD	   | Individual  | 
    
      @ValidateMoreInfoPDP
   Scenario Outline: To verify pharmacy locator More Info Disclaimers for PDP in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
Then the user validate more information content based on plan type in Redesign Site

     Examples: 
    | planType | memberType | 
    | PDP	   | Individual  |  

 @ValidateMoreInfoPlanSpecific
    Scenario Outline: To verify pharmacy locator More Info Limited Access Disclaimers for Specific Plans
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
Then the user validates more information content for Limited Access Disclaimer
  | Disclaimer Text  | <DisclaimerText> |

 Examples: 
    | planType 	| memberType 		| DisclaimerText | 
    | PDP	   		| SymphonixRx  | pharmacy network offers limited access to pharmacies with preferred cost sharing in rural Montana, Nebraska, North Dakota, South Dakota and Wyoming. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use. For up-to-date information about our network pharmacies, including pharmacies with preferred cost sharing, please call   |
    | PDP	   		| WalgreensRx  |  pharmacy network offers limited access to pharmacies with preferred cost sharing in urban North Dakota and West Virginia, suburban California, Hawaii, Maine, Maryland, New York, North Dakota, Pennsylvania, West Virginia, and rural Alaska, Arkansas, Hawaii, Idaho, Iowa, Kansas, Kentucky, Maine, Minnesota, Mississippi, Missouri, Montana, Nebraska, New York, Oklahoma, Pennsylvania, South Dakota, Texas, Vermont, Virginia, West Virginia and Wyoming. There are an extremely limited number of preferred cost share pharmacies in urban Vermont and rural North Dakota. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use |
    | PDP	   		| MedicareRxSaverPlus |  pharmacy network offers limited access to pharmacies with preferred cost sharing in rural Montana, Nebraska, North Dakota, South Dakota and Wyoming. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use. For up-to-date information about our network pharmacies, including pharmacies with preferred cost sharing |  
    | PDP	   		| MedicareRxPreferred  | pharmacy network offers limited access to pharmacies with preferred cost sharing in rural Montana, Nebraska, North Dakota, South Dakota and Wyoming. The lower costs advertised in our plan materials for these pharmacies may not be available at the pharmacy you use. For up-to-date information about our network pharmacies, including pharmacies with preferred cost sharing  |
    

 
 
#         @ValidateChatWindowMAPD
#   Scenario Outline: To verify pharmacy Chat Window for MAPD in Redesign site
##Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
  #| Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user validate chat widget in Redesign Site
#
     #Examples: 
    #| planType | memberType  | 
    #| MAPD	   | Individual  | 
    
#      @ValidateChatWindowPDP
   #Scenario Outline: To verify pharmacy locator Chat Window PDP in Redesign site
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
  #| Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user validate chat widget in Redesign Site
#
     #Examples: 
    #| planType | memberType | 
    #| PDP	   | Individual  |  

#         @ValidateTfnWidgetMAPD
   #Scenario Outline: To verify pharmacy TFN Widget for MAPD in Redesign site
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
  #| Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user validate TFN widget in Redesign Site
#
     #Examples: 
    #| planType | memberType  | 
    #| MAPD	   | Individual  | 
    
     # @ValidateTfnWidgetPDP
   #Scenario Outline: To verify pharmacy locator TFN Widget PDP in Redesign site
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
  #| Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user validate TFN widget in Redesign Site
#
     #Examples: 
    #| planType | memberType | 
    #| PDP	   | Individual  |  

        @ValidateChineseLanguage
   Scenario Outline: To verify pharmacy Locator for Chinese Language in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
When  the user Selects Chinese Language in Redesign Site
Then  the user searches multi lang for pharmacy search results available in Redesign site


     Examples: 
    | planType | memberType  | 
    | MAPD	   | Individual  | 
    
      @ValidateSpanishLanguage
   Scenario Outline: To verify pharmacy locator for Spanish Language in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
When the user Selects Spanish Language in Redesign site
Then the user searches multi lang for pharmacy search results available in Redesign site

     Examples: 
    | planType | memberType  | 
    | MAPD	   | Individual  | 

    
      @ZipCodeErrorMessages
   Scenario Outline: To verify error messages for invalid Zipcode in pharmacy locator page in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
| Plan Type	| <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters following details for pharmacy search in Redesign Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
     And the user verify error messages in pharmacy locator page in Redesign site
 
     Examples: 
   | planType | memberType    | zipcode | distance | 
      | MAPD	   | Individual  |         |       15 | 
      | MAPD	   | Individual  |    9999 |       15 | 
    