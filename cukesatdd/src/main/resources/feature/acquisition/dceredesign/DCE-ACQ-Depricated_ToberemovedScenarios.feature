
#@DCE_Redesign_VPP_Details
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

# 	Removing this scenario, added new validation step for 
#		combined validation for all 3 stages text validation fro LIS buydown plans 
# 	Added to LISbuydown validation - @DCE_DrugDetailsLISBuyDown

  @dceRedesignExtraHelpAlertDetailPage @F478554 @F492102 @F519757
  Scenario Outline: Test to Verify that Extra help Warning messgae on drug detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user verify the extra help alert message on Drug Detail Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    And the user verifies the coverage gap message
      | coverageGap | <coverageGapMessage> |
    And the user verifies the catastrophic coverage message
      | catastrophicCoverage | <catastrophicCoverageMessage> |

#    @dceRedesignExtraHelpAlertDetailPage_AARP @extraHelpSNPAARP
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planyear | planname                                   | coverageGapMessage                                                           | catastrophicCoverageMessage                                                           |
      | AARP |   78006 | SNP      | Bexar County | yes             | Emsam | future   | UnitedHealthcare Dual Complete (HMO D-SNP) | During the Coverage Gap Stage, the plan pays all of the cost for your drugs. | During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs. |

 #   @dceRedesignExtraHelpAlertDetailPage_UHC @extraHelpDSNUHC
    Examples: 
      | site | zipcode | plantype | county       | isMultutiCounty | drug1 | planyear | planname                                   | coverageGapMessage                                                           | catastrophicCoverageMessage                                                           |
      | UHC  |   78006 | SNP      | Bexar County | yes             | Emsam | future   | UnitedHealthcare Dual Complete (HMO D-SNP) | During the Coverage Gap Stage, the plan pays all of the cost for your drugs. | During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs. |
