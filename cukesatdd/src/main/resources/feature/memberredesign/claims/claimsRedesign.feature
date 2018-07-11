@claimspage @theTransformers @regression_06_06_18 
Feature: T1.1To validate the new changes related to claims page on the member redesigned site

  @claimsSummaryFED @theTransformers @regression_06_06_18 
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
    #Then I navigate to the Claim Details page in redesigned site
    #And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      #| MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |
      #| MA       | Last 24 months | NICE   | NICECLAIMS   |
      | PDP      | Last 24 months | RX     | RXCLAIMS     |
      #| MA       | Last 24 months | COSMOS | COSMOSCLAIMS   |
      
      
      
  @claimsSummarySHIP @theTransformers
  Scenario Outline: To validate the claims present for the SHIP member on claims sumamry page for AARP site
    Given login with following details logins in the member portal and validate elements
      #  Given I am an Individual or Group member on the redesigned site
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

  @claimsDetailsTableFED @theTransformers @regression_06_06_18 
  Scenario Outline: To Verify Claim Table on Claims Details Page
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
    And I navigate to the Claim Details page in AARP site
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    | claimssystem |
      #| MA       | Last 24 months | NICECLAIMS   |
      | MAPD     | Last 24 months | COSMOSCLAIMS |

  @ClaimsDetailsSHIP @theTransformers
  Scenario Outline: To Verify Learn more section on Claims Details Page
    Given login with following details logins in the member portal and validate elements
      # Given I am an Individual or Group member on the redesigned site
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    And I can search claims for the following claim period on redesigned site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then I can see the claims displayed based on the selection in redesigned site
    And I navigate to the Claim Details page in AARP site
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    | claimssystem |
      | SHIP     | Last 24 Months | SHIPCALIMS   |
      
      @regression_06_06_18 @TC01_FED_AARP_Individual_NICE @TC10_COMBO
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
  And the user validates the DownloadMyData section in redesigned site
   
   
   
    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | SHIP    | Last 24 months  | NA      |    COSMOSCLAIMS |

  @claimsPHIP @theTransformers @regression_06_06_18 
  Scenario Outline: To validate the Error Message for a PHIP  member on claims sumamry page
    #Given I am an Individual or Group member on the redesigned site
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
    When I navigate to the claims Summary page in redesigned site
    And I validate the error message for a PHIP Member on the screen
       | Domain     | <domain>      |
      | Plan Type  | <planType>    |
    Examples: 
      | planType | claimssystem |
      | SHIP     | SHIPCALIMS   |
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
    And I navigate to the Claim Details page in AARP site
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | planType | claimPeriod    | domain | claimssystem |
      | MAPD     | Last 24 months | NICE   | NICECLAIMS   | 

     
