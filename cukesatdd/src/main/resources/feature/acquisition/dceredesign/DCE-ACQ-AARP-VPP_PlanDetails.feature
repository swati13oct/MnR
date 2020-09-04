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
      
      @DCE_Redesign_DCE_Detail_to_Vpp_Details
  Scenario Outline: Test to verify the Drug cost estimator and view plan summary from DCE to VPP detail page
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
     #And clicks on Review drug cost button  
     Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
   Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user click on drug cost estimator on vpp plan detail page in AARP
    Then User validates planName matches plan Name in DCE detail page in AARP
    
    @DCE_Redesign_DCE_Detail_to_Vpp_Details_MAPD
      
      Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
     @DCE_Redesign_DCE_Detail_to_Vpp_Details_PDP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |   80002 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @DCE_Redesign_DCE_Detail_to_Vpp_Details_SNP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  |
      |   78006 | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |  |
      
     
      @DCE_Redesign_VPPSummary_to_Vpp_Details
      
      
      Scenario Outline: Test to verify the Drug cost estimator and view plan summary are not visible when user navigate away from DCE and navigate to VPP detail page
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
    And clicks on Review drug cost button
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    Then the user click on view plan summary on vpp detail page in AARP
    Then user click on veiw plan details on summary page in AARP
    #Then user verifiy drug cost estomator and view plan summary is not exist in vpp detail page in ARRP
     
      @DCE_Redesign_VPPSummary_to_Vpp_Details_MAPD
     
      Examples: 
      | zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
       @DCE_Redesign_VPPSummary_to_Vpp_Details_PDP
       
        Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |   80002 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
       
       @DCE_Redesign_VPPSummary_to_Vpp_Details_SNP
     
       Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  |
      |   78006 | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |  |
      
      
      @noPrescriptionCoverage @F492445
      Scenario Outline: Test to verify No Prescription Coverage for Pharmacies on DCE Details Page
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
     And clicks on Review drug cost button  
    #Then the user Clicks button to VPP Plan Details Page from Drug Details Page
     And user clicks on change pharmacy link from details page in AARP
     Then user change the pharmacy to view no prescription coverage
     #Then user validate the monthly premium value on detail page 
     
     @noPrescriptionCoverge_MAPD
     
      Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  |
      |   78006 | MAPD      | Bexar County | yes             | Lipitor | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor |  AARP Medicare Advantage Choice (PPO)  |  |
      
   # @noPrescriptionCoverge_SNP
    #  Examples: 
     # | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  |
      #|   78006 | SNP      | Bexar County | yes             | Lipitor | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Dual Complete (HMO D-SNP) |  |
      
     # @noPrescriptionCoverge_PDP
    #  Examples: 
     # | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  |
      #|   78006 | PDP      | Bexar County | yes             | Lipitor | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor |  AARP MedicareRx Walgreens (PDP) |  |
      
     
     
      @dceRedesignExtraHelpAlertDetailPage @F478554 @F492102
   Scenario Outline: Test to Verify that Extra help Warning messgae on drug detail page
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
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the user verify the extra help alert message on Drug Detail Page  
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    #Then the user validates Important information section
    And the user verifies the catastrophic coverage message
    |catastrophicCoverage|<catastrophicCoverageMessage>|
    And the user verifies the coverage gap message
    |coverageGap|<coverageGapMessage>|
    
      Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |catastrophicCoverageMessage|coverageGapMessage|
      |   78006 | SNP      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |During the Coverage Gap Stage, the plan pays all of the cost for your drugs.|During the Catastrophic Coverage Stage, the plan pays all of the cost for your drugs.|
            
        @dceRedesignDefaultPharmacy @F497405
        
        Scenario Outline: Test to Verify default Retail chain pharmacy on detail page  
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
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
    Then the user verify the Retail chain pharmacy on detail page
    And user clicks on change pharmacy link from details page in AARP
    Then user clicks on Keep Using This Pharmacy on change pharmacy page
    Then User validate Walgreens pharmacy on detail page 
    
        @dceRetailChain_MAPD
      Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                              |  
      |   10001 | MAPD      | Bexar County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | 
    
       @dceRetailChain_PDP
      Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |   10001 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

      @dceRetailChain_SNP
      Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |   10001 | SNP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
      
     