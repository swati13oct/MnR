@DCE_Redesign_VPP_MAPD
Feature: 1.10.2 ACQ-DCE-VPP_1 AARP - To test DCE to VPP Plan Summary in AARP site

  @DCE_Redesign_VPP_PlanSummary
  Scenario Outline: 1.10.2.1 To test the DCE flow for PlanType :  <plantype> from vpp and the switch now option in step 3
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And I access the DCE Redesign on aarp site from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
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
		Then the user validates link to Drug Summary Page
    Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |
