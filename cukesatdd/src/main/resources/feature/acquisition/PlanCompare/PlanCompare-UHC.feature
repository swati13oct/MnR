@PlanCompare
Feature: Acq-To test PlanCompare Flows in AARP site

  @PlancompareProviderSearch
  Scenario Outline: TID: <TID> - TC01_RallyTool_Through_Plan Compare_Page
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I select all 3 plans to compare and click on compare plan link in UHC
    And I Click on Look up your doctor link on Plan compare
    And I click on Get Started on and Add Provider from find care page
    Then Verify provider is count is updated on plan compare page

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             |
      | 15488 |   90210 | NO              | Los Angeles County |
