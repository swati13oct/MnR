@DCE_Redesign_VPP_PlanSummary
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanSummary AARP - To test VPP Plan Details - DCE Flows in AARP site

  @DCE_Redesign_VPP_PlanSummary_Plan
  Scenario Outline: 1.10.2.1 To test the DCE Redesign flow for PlanType :  <plantype> from vpp Plan Details
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user validates link to Drug Summary Page

    @DCE_Redesign_VPP_PlanSummary_MAPD_AARP
    Examples: 
      |	site	| zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |	AARP	|   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |

		@DCE_Redesign_VPP_PlanSummary_MAPD_UHC
    Examples: 
      |	site	| zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |	UHC	|   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |
	
    @DCE_Redesign_VPP_PlanSummary_PDP_AARP
    Examples: 
      |	site	| zipcode | plantype | county       | isMultutiCounty | drug1   | planname                        |
      |	AARP	|   80002 | PDP      | Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |
      
    @DCE_Redesign_VPP_PlanSummary_PDP_UHC
    Examples: 
      |	site	| zipcode | plantype | county       | isMultutiCounty | drug1   | planname                        |
      |	UHC	|   80002 | PDP      | Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_VPP_PlanSummary_SNP_AARP
    Examples: 
      |	site	| zipcode | plantype | county       | isMultutiCounty | drug1   | planname                                              |
      |	AARP	|   78006 | SNP      | Bexar County | yes             | Orkambi | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) |
      
    @DCE_Redesign_VPP_PlanSummary_SNP_UHC
    Examples: 
      |	site	| zipcode | plantype | county       | isMultutiCounty | drug1   | planname                                              |
      |	UHC		|   78006 | SNP      | Bexar County | yes             | Orkambi | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) |
