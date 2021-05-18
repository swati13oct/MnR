@dce_redesign_Drug_summary_AARP @F426576 @dce
Feature: 1.10.3 DCE-REDESIGN- To test integration flows between DCE and VPP from various pages

  @dce_Redesign_VPP_PlanSummary_Integration
  Scenario Outline: 1.10.3.2 To test the DCE Redesign flow for PlanType :  <plantype> from vpp Plan Summary
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
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    And the user click on return to plan summary from Drug Details Page to return to VPP Plan Summary
    And the user validates the added drug name on plan summary page for the selected plan
      | Plan Name | <planname> |
      | DrugName  | <drug1>    |
    And the user validates the drug cost on plan summary page for the selected plan
      | Plan Name | <planname> |
    And the user clicks on drug dropdown on plan summary page and navigates to DCE
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And the user clicks on Edit your drug list link on drug details page
    And the user clicks on Edit button on Drug List page on DCE
      | DrugName | <drug1> |
    And the user changes the supply length
      | Supply Length | <supplyLength> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Captures Drug costs on Drug Details Page
    And the user click on return to plan summary from Drug Details Page to return to VPP Plan Summary
    And the user validates the drug cost on plan summary page for the selected plan
      | Plan Name | <planname> |
    And the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And the user click on Prescription Drug Benefits tab on plan details
    And the user verifies the drug information on prescription drug tab
      | DrugName | <drug1> |
    And the user clicks on Edit drug on plan details page and navigates to DCE
    And the user clicks on Remove button on Drug List page on DCE to delete drug
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Captures Drug costs on Drug Details Page
    And the user clicks on Return to details link on Drug Details page
    And the user verifies the drug information on prescription drug tab
      | DrugName | <drug2> |
    Then the user click on Plan costs tab
    And the user click on Edit Drugs Link on plan costs tab
    And the user clicks on Edit button on Drug List page on DCE
      | DrugName | <drug2> |
    And the user changes the supply length
      | Supply Length | <supplyLength> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Captures Drug costs on Drug Details Page
    And the user clicks on Return to details link on Drug Details page
    And the user verifies the drug information on plan costs tab

    @dce_Redesign_VPP_PlanSummary_Integration_MAPD_AARP @regressionAARP
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1   | drug2   | planname                                           | supplyLength   |
      | AARP |   90210 | future   | MAPD     | none   | no              | Orkambi | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) | Every 3 Months |

    @dce_Redesign_VPP_PlanSummary_MAPD_UHC @regressionUHC @prodRegression @sanity
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | drug1   | drug2   | planname                                           | supplyLength   |
      | UHC  |   90210 | future   | MAPD     | none   | no              | Orkambi | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) | Every 3 Months |

  Scenario Outline: To test the NBA - to -DCE Redesign flow for PlanType :  <plantype> from vpp Plan Summary
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
    And the user clicks on NBA to navigate to DCE Redesign page
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    And user navigates to Review drug costs page
    And user verify the drug summary page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then user validates planName matches plan Name in Drug Details pages
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    And the user clicks on DCE button to return to Review Drug cost page

    @vpp_NBA_DCE_Redesign_Integration_AARP @regressionAARP @vbfGate
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | planname                                                         | drug1   |
      | AARP |   10001 | future   | MAPD     | none   | no              | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | Orkambi |

    @vpp_NBA_DCE_Redesign_Integration_UHC @regressionUHC
    Examples: 
      | site | zipcode | planyear | plantype | county | isMultutiCounty | planname                                                         | drug1   |
      | UHC  |   10001 | future   | MAPD     | none   | no              | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | Orkambi |
