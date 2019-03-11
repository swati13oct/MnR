@fixedTestCaseTest
Feature: 1.15-VBF-Acq-To test Provider Search Flow  in UMS site

  @ProviderSearchBlayerSmoke
  Scenario Outline: Verify Provider Search  in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    When user Click on Is my Provider covered link ums
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |

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
