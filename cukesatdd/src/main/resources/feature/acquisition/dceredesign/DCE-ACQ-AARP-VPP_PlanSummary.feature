@DCE_Redesign_VPP_PlanSummary
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanSummary AARP - To test VPP Plan Details - DCE Flows in AARP site

  @DCE_Redesign_VPP_PlanSummary_Plan
  Scenario Outline: 1.10.2.1 To test the DCE Redesign flow for PlanType :  <plantype> from vpp Plan Summary
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
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
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


@dceRedesingDrugSummarytoVPPdetail @470713
      
       Scenario Outline: Test to Verify that user navigates to vpp detail page from drug summary page to validate drug cost estimator and view plan summary  
    Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
   And adds drugs in drug list page
    | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    And user click on view plan details on drug summary page
    Then the user verify the drug cost estimator and view plan summary on VPP summary page in AARP
    Then the user click on drug cost estimator on vpp plan summary page in AARP
    #Then User validates planName matches plan Name in DCE summary page in AARP
    
     @dceRedesingDrugSummarytoVPPdetail_MAPD
   
    Examples: 
    
      | zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |   10001 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
        @dceRedesingDrugSummarytoVPPdetail_PDP
        
    Examples: 
     
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                        |
      |   80002 | PDP      | Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

     @dceRedesingDrugSummarytoVPPdetail_SNP
   
    Examples: 
     
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                                              |
      |   78006 | SNP      | Bexar County | yes             | Orkambi | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |
      
      
      @vvpSummarytoVppDetail
      
      Scenario Outline: Test to verify the Drug cost estimator and view plan summary are not visible when user navigate away from DCE and navigate to VPP detail page
      
      Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
   And adds drugs in drug list page
    | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    And user click on view plan details on drug summary page
    Then the user verify the drug cost estimator and view plan summary on VPP summary page in AARPs
    Then the user click on view plan summary on vpp detail page in AARP
    Then user click on veiw plan details on summary page in AARP
    
    @vvpSummarytoVppDetail_MAPD
    
    Examples:
     
      | zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |   10001 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
      @vvpSummarytoVppDetail_PDP
       Examples: 
     
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                        |
      |   80002 | PDP      | Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

      @vvpSummarytoVppDetail_SNP
   
    Examples: 
     
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                                              |
      |   78006 | SNP      | Bexar County | yes             | Orkambi | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |
<<<<<<< HEAD
=======
      

      
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
      