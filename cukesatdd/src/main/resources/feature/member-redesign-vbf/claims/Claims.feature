@smokeTest
Feature: 1.02-VBF-MemRedesign-To test claim functionality
@smokeTest_Claims @rallyDashboard @testharness
Scenario Outline: To validate that claims are present on claims summary page and claims details page
    Given I am an AARP member on the redesigned site
      | Plan Type      | <planType>     |
      | Test Data Type | <claimssystem> |
       | Member Type | <membertype> |
    When I navigate to the claims Summary page in redesigned site
    And the user search claims for the following claim period in AARP site
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    Then user validates the claims displayed based on the selection in redesigned site
    And the user validates the EOB section based on domain in redesigned site
      | Domain | <domain> |
    And the user validates the DownloadMyData section in redesigned site
    And I navigate to the Claim Details page in AARP site
    Then I validate the Claims Table in claims details page in AARP site
    And I validate the Claims Total in claims details page in AARP site

    Examples: 
 	 | membertype 	 | planType | claimPeriod    | domain | claimssystem |
     |  BlueLayerInd | MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |
     |  BlueLayerInd | MAPD     | Last 24 months | NICE   | NICECLAIMS   |
    # |  ULayerInd 	 | MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |
   #  |  ULayerInd	 | MAPD     | Last 24 months | NICE   | NICECLAIMS   |
   #  |  GroupRetiree | MAPD     | Last 24 months | COSMOS | COSMOSCLAIMS |
   #  |  GroupRetiree | MAPD     | Last 24 months | NICE   | NICECLAIMS   |
     