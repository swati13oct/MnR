@DCE_Redesign_VPP_PlanSummary
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanSummary AARP - To test VPP Plan Details - DCE Flows in AARP site

  @DCE_Redesign_VPP_PlanSummary_Plan
  Scenario Outline: 1.10.2.1 To test the DCE Redesign flow for PlanType :  <plantype> from vpp Plan Details
    Given the enduser is on medicare acquisition site landing page
    	|Site| <site>|
    When the enduser performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the enduser views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    And enduser access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the enduser validates Get Started Page
    Then the enduser clicks on Build Drug List to navigate to Build Drug List Page
    Then the enduser searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the enduser clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the enduser validates planName matches plan Name in VPP
    Then the enduser Captures Drug costs on Drug Details Page
    Then the enduser validates Drug Costs section
    Then the enduser validates Your Drugs sections
    Then the enduser validates Monthly Drug Costs by Stage Section
    Then the enduser validates Important information section
    Then the enduser validates link to Drug Summary Page

    @DCE_Redesign_VPP_PlanSummary_MAPD_AARP
    Examples: 
      |	site	| zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |	AARP	|   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |
