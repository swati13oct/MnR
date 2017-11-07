@TeamPredators
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
    | PDP 		 | Individual  |  90210  |  15			|
    | MAPD	   | Individual  |   90210 |       15 | 

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

# VIEW as PDF LInk not working / Not Available
#       @ValidateViewAsPDF
#   Scenario Outline: To verify pharmacy locator View As PDF in Redesign site
#Given registered member to verify locate a pharmacy in Redesign Site
#| Plan Type	| <planType> |
#  | Member Type  | <memberType> |
#When the user navigates to pharmacy search page in Redesign site
#Then the user Validates view search PDF link in Redesign Site

#     Examples: 
#    | planType | memberType  |
#    | MAPD	   | Individual  | 
  
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
    