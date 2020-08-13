@DCE_Redesign_VPP_Details
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

  @DCE_Redesign_VPP_PlanDetails
  Scenario Outline: 1.10.2.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Details
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign on aarp site from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page

    @DCE_Redesign_VPP_PlanDetails_MAPD
    Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanDetails_PDP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |   80002 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPP_PlanDetails_SNP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  |
      |   78006 | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |  |
