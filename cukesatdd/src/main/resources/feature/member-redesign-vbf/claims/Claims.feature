@smokeTest
Feature: 1.02-VBF-MemRedesign-To test claim functionality

  @smokeTest_Claims @rallyDashboard @testharness
  Scenario Outline: To validate that claims are present on claims summary page and claims details page
    Given I am a authenticated member on the member redesign site for Direct Login
      | Plan Type    | <planType>    |
      | Test Data Type | <claimssystem> |
      | Member Type    | <memberType>   |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
       |ClaimSystem| <claimssystem>|
    Then user validates the claims displayed based on the selection in redesigned site
    And the user validates the EOB section based on domain in redesigned site
      | Domain | <domain> |
    And the user validates the DownloadMyData section in redesigned site
    And I navigate to the Claim Details page in AARP site
    |ClaimSystem| <claimssystem>|
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
      | memberType   | planType | claimPeriod    | domain | claimssystem | friendname | favcolor | phonenumber |
    #  | BlueLayerInd |MAPD |  Last 24 months | COSMOS | COSMOSCLAIMS | name1      | color1   | number1     |
   	#	 | BlueLayerInd |MAPD |  Last 24 months | COSMOS   | RxCLAIMS   | name1      | color1   | number1     |
    #  | BlueLayerInd |MAPD |  Last 24 months | NICE   | NICECLAIMS   | name1      | color1   | number1     |
     |  ULayerInd 	 |MAPD |  Last 24 months | COSMOS | COSMOSCLAIMS |name1      | color1   | number1     |
  #  	| ULayerInd |MAPD |  Last 24 months | COSMOS   | RxCLAIMS   | name1      | color1   | number1     |
     |  ULayerInd		 |MAPD |  Last 24 months | NICE   | NICECLAIMS   |name1      | color1   | number1     |
   # |  GroupRetiree |MAPD |  Last 24 months | COSMOS | COSMOSCLAIMS |name1      | color1   | number1     |
   #  |  GroupRetiree |MAPD |  Last 24 months | NICE   | NICECLAIMS   |name1      | color1   | number1     |
   | GroupRetiree |MAPD |  Last 24 months | Rx   | RxCLAIMS   | name1      | color1   | number1     |
