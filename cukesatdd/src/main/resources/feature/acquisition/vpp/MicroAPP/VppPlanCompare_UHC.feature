@vppPlanCompareUHC
Feature: Vpp to plan Compare UHC Scenarios

  @vppPlanCompareUHC01
  Scenario Outline: TID: <TID> - Verify a plan can be removed using Remove link from the widget on the top of page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then remove one plan from plan compare page for UHC
    And click on back to plans on plan compare page for UHC
    Then Verify the Plan compare checkbox should be unchecked for the removed plan for UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |
      | 15488 |   90210 | NO              | Los Angeles County | MAPD     |

  @vppPlanCompareUHC02
  Scenario Outline: TID: <TID> - Verify a plan can be added while on plan compare page by using '+Add a plan' widget.
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link in UHC
    Then verify plan compare page is loaded on UHC
    Then Click on Add Icon and verify it navigates to plan summary page for UHC
    And check one plan and add it to plancompare for UHC
    Then Verify newly added plan displayed on plan compare page for UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | count |
      | 15488 |   90210 | NO              | Los Angeles County | MAPD     |     1 |

  @vppPlanCompareUHC03
  Scenario Outline: TID: <TID> - Verify the checkbox for add to compare link is not visible for single plan.
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then verify plan compare checkbox is not visible on plan summary on UHC

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |
      | 15488 |   96799 | NO              | Western District   | PDP      |
      | 15488 |   90210 | NO              | Los Angeles County | SNP      |

  @vppPlanCompareUHC04
  Scenario Outline: TID: <TID> - Verify for zipcode with 2 plans when 1 is selected then the other plan is auto-selected and De-selection
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype |
      | 15488 |   35616 | NO              | Colbert County | MAPD     |
