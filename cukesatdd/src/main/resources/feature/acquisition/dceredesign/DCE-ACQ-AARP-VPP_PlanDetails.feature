@DCE_Redesign_VPP_MAPD
Feature: 1.10.2 ACQ-DCE-VPP_1 AARP - To test DCE to VPP Plan Summary in AARP site

  @DCE_Redesign_VPP_PlanDetails
  Scenario Outline: 1.10.2.1 To test the DCE flow for PlanType :  <plantype> from vpp and the switch now option in step 3
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign on aarp site from Plan Details for the plan
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the user validates planName matches plan Name in VPP
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
		Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |
