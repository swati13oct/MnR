@claimspage @theTransformers @regressionMember
Feature: T1.1To validate the new changes related to claims page on the member redesigned site

@claimsSummaryFED
Scenario Outline: To validate the claims present for the Federal member on claims summary page for federal members
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
Then I can validate the claims summary header
And I can search claims for the following claim period on redesigned site
  | Plan Type    | <planType>    |
  | Claim Period | <claimPeriod> |
Then I can see the claims displayed based on the selection in redesigned site
And I validate the pagination on the claims summary page 
And the user validates the EOB section based on domain in redesigned site
  | Domain     | <domain>      |
  | Plan Type  | <planType>    |
And the user validates the DownloadMyData section in redesigned site
#    Then I navigate to the Claim Details page in redesigned site
#    And I validate the Claims Total in claims details page in AARP site
Examples: 
     | planType | claimPeriod    | domain | claimssystem |
     | MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |
     | MA       | Last 24 months | NICE   | NICECLAIMS   |
     | MAPD       | Last 24 months | NICE   | NICECLAIMS   |
     | PDP      | Last 24 months | RX     | RXCLAIMS     |

@claimsSummarySHIP
Scenario Outline: To validate the claims present for the SHIP member on claims summary page for SHIP members
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
Then I can validate the claims summary header
And I can search claims for the following claim period on redesigned site
  | Plan Type    | <planType>    |
  | Claim Period | <claimPeriod> |
Then I can see the claims displayed based on the selection in redesigned site
And I validate the pagination on the claims summary page 
And the user validates the EOB section based on domain in redesigned site
     | Domain       | <domain>      |
      | Plan Type      | <planType>     |
Then I navigate to the Claim Details page in redesigned site
Then I validate the Claims Table in claims details page in redesigned site    
Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | SHIP     | Last 24 Months | NA     | SHIPCLAIMS   |
 
@claimsDetailsTableFED 
Scenario Outline: To Verify Claim Table on Claims Details Page for federal members
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
And I can search claims for the following claim period on redesigned site
  | Plan Type    | <planType>    |
  | Claim Period | <claimPeriod> |
#And the user search claims for the following time interval in redesigned site
#| Claims To Date   | <claimToDate>   |
#| Claims From Date | <claimFromDate>  |
Then I can see the claims displayed based on the selection in redesigned site
When I navigate to the Claim Details page for federal members
And I validate the Claims Table in claims details page for federal members
And I validate the Claims Total in claims details page in AARP site
Examples: 
  | planType | claimPeriod    | claimssystem |
  | MA       | Last 24 months | NICECLAIMS   |
  | MAPD     | Last 24 months | COSMOSCLAIMS |
    
@ClaimsDetailsSHIP
Scenario Outline: To Verify Learn more section on Claims Details Page
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
And I can search claims for the following claim period on redesigned site
  | Plan Type    | <planType>    |
  | Claim Period | <claimPeriod> |
Then I can see the claims displayed based on the selection in redesigned site
When I navigate to the Claim Details page for federal members
And I validate the Claims Table in claims details page for federal members
Examples: 
   | planType | claimPeriod    | claimssystem |
   | SHIP     | Last 24 Months | SHIPCLAIMS   |
   
  
@TC10_COMBO
Scenario Outline: To validate the claims present for the Combo member on claims sumamry page & the Details on the Claims Details page 
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
And I can search claims for the following claim period on redesigned site
  | Plan Type    | <planType>    |
  | Claim Period | <claimPeriod> |
Then I can see the claims displayed based on the selection in redesigned site
And I validate the pagination on the claims summary page combo member PDP plan
And the user validates the EOB section based on domain in redesigned site
  | Domain     | <domain>      |
  | Plan Type  | <planType>    |
And I navigate to the Claim Details page in AARP site for COMBO member
And I validate the Claim Search link on top    
And I validate the LEARN MORE ABOUT COST BreakDown Link 
Then I validate the Claims Table in claims details page for Combo
Then I validate EOB
And I can view a claim search back button in Claims Details page in AARP site
And I validate the two COMBO tabs on the page 
And I validate the two COMBO tabs on the claim Summary page 
#And the user validates the DownloadMyData section in redesigned site   
Examples: 
   | planType | claimPeriod    | domain | claimssystem |
   | SHIP    | Last 24 months  | NA      |    COSMOSCLAIMS |

@TC_09claimsPHIP 
Scenario Outline: To validate the Error Message for a PHIP  member on claims sumamry page
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
And I validate the error message for a PHIP Member on the screen
Examples: 
   | planType | claimssystem |
   | SHIP     | SHIPCLAIMS   |
  
   # This Scenario can only execute when max claims indicator as true
  #@MaxClaimsResultsError
  #Scenario Outline: To Verify the Drug Claims History: Reached Maximum Claim Results Error
    #Given I am an AARP member on the redesigned site
      #| Plan Type | <planType> |
    #When I navigate to the claims Summary page in redesigned site
    #And the user search claims for the following claim period in AARP site
      #| Claim Period | <claimPeriod> |
    #Then The User can able to see Drug Claims History: Reached Maximum Claim Results Error
#
    #Examples: 
      #| planType | claimPeriod    | domain |
      #| PDP      | Last 24 Months | NA     |
#
  #@shipDateRangeGreaterThan24MonthsErrmsg
  #Scenario Outline: To Verify the SHIP Date Range Greater Than 24-Months Error
    #Given I am an AARP member on the redesigned site
      #| Plan Type | <planType> |
    #When I navigate to the claims Summary page in redesigned site
    #And the user search claims for the following claim period in AARP site
      #| Claim Period | <claimPeriod> |
    #And the user search claims for the following time interval in redesigned site
      #| Claims To Date   | <claimToDate>   |
      #| Claims From Date | <claimFromDate> |
    #Then the user should be able to see the SHIP Date Range Greater Than 24-Months Error
#
    #Examples: 
      #| planType | claimPeriod   | domain | claimToDate | claimFromDate |
      #| SHIP     | Custom Search | NA     | 10/10/2017  | 06/14/2012    |
#
  #@govtDateRangeGreaterThan24MonthsErrmsg
  #Scenario Outline: To Verify the FED Date Range Greater Than 24-Months Error
    #Given I am an AARP member on the redesigned site
      #| Plan Type | <planType> |
    #When I navigate to the claims Summary page in redesigned site
    #And the user search claims for the following claim period in AARP site
      #| Claim Period | <claimPeriod> |
    #And the user search claims for the following time interval in redesigned site
      #| Claims To Date   | <claimToDate>   |
      #| Claims From Date | <claimFromDate> |
    #Then the user should be able to see the FED Date Range Greater Than 24-Months Error
#
    #Examples: 
      #| planType | claimPeriod   | claimToDate | claimFromDate |
      #| MAPD     | Custom Search | 10/10/2017  | 06/14/2012    |
  
  @claimsSummaryAndDetails 
  Scenario Outline: To validate the claims present for the Federal member on claims sumamry page for AARP site
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    Then I can validate the claims summary header
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection in redesigned site
    And I validate the pagination on the claims summary page 
   	And the user validates the EOB section based on domain in redesigned site
      | Domain     | <domain>      |
      | Plan Type  | <planType>    |
    And the user validates the DownloadMyData section in redesigned site
    When I navigate to the Claim Details page for federal members
    And I validate the Claims Table in claims details page for federal members
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | MAPD     | Last 24 months | NICE   | NICECLAIMS   | 


@TC03_FEDAARPIndividualPDP   
    Scenario Outline: To validate the claims present for the Federal member on claims sumamry page for AARP site
    Given login with following details logins in the member portal and validate elements
      
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then  I can see the claims displayed based on the selection in redesigned site for PDP plans 
    And I validate the pagination on the claims summary page for members  
    And the user validates the EOB section in redesigned site    
   # And the user validates the DownloadMyData section in redesigned site
    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | PDP      | Last 24 months | RX     | RXCLAIMS     |
     
        @Tc02 @Tc05
  Scenario Outline: To validate the claims present for the Federal member on claims sumamry page for AARP site
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    Then I can validate the claims summary header
     And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection in redesigned site
    And I validate the pagination on the claims summary page for members
   	And the user validates the EOB section based on domain in redesigned site
      | Domain     | <domain>      |
      | Plan Type  | <planType>    |
    And the user validates the DownloadMyData section in redesigned site
    When I navigate to the Claim Details page for federal members
    And I validate the Claims Table in claims details page for federal members
    And I validate the Claims Total in claims details page in AARP site
    And I validate the claims history Button
   
    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | MAPD     | Last 24 months | NICE   | NICECLAIMS   |
      | MAPD     | Last 24 months | COSMOS| COSMOSCLAIMS   |
     
  
       @TC01_FED_AARP_Individual_NICE @TC04_FED_UHC_Individual_COSMOS
  Scenario Outline: To validate the claims present for the Federal member on claims sumamry page & the Details on the Claims Details page 
   Given login with following details logins in the member portal and validate elements
     
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    Then I validate the claim summary header
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection in redesigned site
    And I validate the pagination on the claims summary page for members
   	And the user validates the EOB section based on domain in redesigned site
      | Domain     | <domain>      |
      | Plan Type  | <planType>    |
 	  When I navigate to the Claim Details page for federal members
    And I validate the Claims Table in claims details page for federal members
    And I validate the Claims Total in claims details page in AARP site
    And I can view a claim search back button in Claims Details page in AARP site
    #And the user validates the DownloadMyData section in redesigned site
   
    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | MA       | Last 24 months | NICE   | NICECLAIMS   |
      #| MA       | Last 24 months | COSMOS | COSMOSCLAIMS |
      
     
      @TC11_PCP
  Scenario Outline: To validate the claims present for the Federal member on claims sumamry page for AARP site
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    Then I can validate the claims summary header
    Then I validate the text for PCP & medica members 
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection in redesigned site
    And I validate the pagination on the claims summary page for members
   	And the user validates the EOB section based on domain in redesigned site
      | Domain     | <domain>      |
      | Plan Type  | <planType>    |
    And the user validates the DownloadMyData section in redesigned site
    When I navigate to the Claim Details page for federal members
    And I validate the Claims Table in claims details page for federal members
    And I validate the Claims Total in claims details page in AARP site
    And I validate the claims history Button
   
    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | PCP      | Last 24 months | PCP   | COSMOSCLAIMS   |
      
    
      @claimsprintanddownload @thePredator
  	Scenario Outline: To validate the <claimssystem> on claims summary page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    #Then I can validate the claims summary header
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |      
    Then I can see the claims displayed based on the selection in redesigned site
    Then I can see the print and download option in claims details table
    And I validate the print and download option in claims details table
    And I validate the pagination on the claims summary page 
    And the user validates the EOB section based on domain in redesigned site    
     | Domain       | <domain>      |
     | Plan Type    | <planType>    |
    Then I navigate to the Claim Details page in redesigned site
    Then I validate the Claims Table in claims details page in redesigned site
    And I validate the EOB option in claims details page in redesigned site    

    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | MAPD     | Last 24 Months | COSMOS     | COSMOSCLAIMS   |
      
      @claimsSummaryFEDError
Scenario Outline: To validate the claims present for the Federal member on claims summary page for federal members
Given login with following details logins in the member portal and validate elements
  | Plan Type      | <planType>     |
  | Test Data Type | <claimssystem> |
When I navigate to the claims Summary page in redesigned site
Then I can validate the claims summary header
And I can search claims for the following claim period on redesigned site
  | Plan Type    | <planType>    |
  | Claim Period | <claimPeriod> |
And the user search claims for the following time interval in redesigned site
| Claims To Date   | <claimToDate>   |
| Claims From Date | <claimFromDate>  |
Then the user should be able to see the from date is greater than to date error message
Examples: 
     | planType | claimPeriod    | domain | claimssystem |claimToDate | claimFromDate |
     | MAPD     |customsearch | COSMOS | COSMOSCLAIMS |11/06/2018  | 01/02/2019 |