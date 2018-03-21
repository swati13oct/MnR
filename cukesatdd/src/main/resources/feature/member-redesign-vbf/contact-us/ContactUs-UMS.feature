@smokeTest 
Feature: 1.03-VBF-MemRedesign-To test contact us page
@smokeTest_contactusInd @rallyDashboard @testharness
  Scenario Outline: Verify Click to Call and email Widget section on contact us page for Federal member
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates secure email widget UI in redesign contact us page
    Then user validates clickToCallButton display on contactUS redesign page
 	And user clicks on Request Confirmation Click
    
     Examples: 
      | userName        |  | password   | memberType |
       | q1_apr_uhc002 |  | Password@1 | UHC      |
   #     | q1_aarp_feb015 |  | Password@1 | AARP      |
        
        @smokeTest_contactusGrp @rallyDashboard @testharness
  Scenario Outline: Verify Click to Call and email Widget section on contact us page for Group member
    Given registered UMS member with following attributes
      | UserName    | <userName>   |
      | Password    | <password>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
   # Then user validates Group secure email widget  in redesign contact us page
   Then user validates secure email widget UI in redesign contact us page
    Then user validates clickToCallButton display on contactUS redesign page
 	And user clicks on Request Confirmation Click
    
     Examples: 
      | userName        |  | password   | memberType |
      | q1_grp_feb018 |  | Password@1 | Group      |
       