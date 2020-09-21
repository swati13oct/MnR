@DCE_Redesign_VPP_Details
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

  @DCE_Redesign_VPP_PlanDetails
  Scenario Outline: 1.10.2.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Details
    Given the consumer is on medicare acquisition site landing page
    	|Site| <site>|
    When the consumer performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the consumer navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Details for the plan
    Then the consumer validates Get Started Page
    Then the consumer clicks on Build Drug List to navigate to Build Drug List Page
    Then the consumer searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the consumer searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the consumer searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the consumer searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the consumer searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the consumer searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the consumer clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the consumer validates planName matches plan Name in VPP
    Then the consumer Captures Drug costs on Drug Details Page
    Then the consumer validates Drug Costs section
    Then the consumer validates Your Drugs sections
    Then the consumer validates Monthly Drug Costs by Stage Section
    Then the consumer validates Important information section
    Then the consumer Clicks button to VPP Plan Details Page from Drug Details Page
    Then the consumer validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page

    @DCE_Redesign_VPP_PlanDetails_MAPD_AARP
    Examples: 
      |	site	| zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |	AARP	|   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
    