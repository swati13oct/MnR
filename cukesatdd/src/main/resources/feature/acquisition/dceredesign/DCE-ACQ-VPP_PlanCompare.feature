@DCE_Redesign_VPP_Details
Feature: 1.10.3 ACQ-DCERedesign-VPP_PlanCompare - To test DCE - VPP Plan Compare Integration

  @DCE_Redesign_VPP_PlanDetails1
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare
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
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates drug is displayed on the plan compare page
      | DrugName | <drug1> |

    @DCE_Redesign_VPP_PlanCompare_AARP
    Examples: 
<<<<<<< HEAD
<<<<<<< HEAD
      | site | zipcode | plantype | county | isMultutiCounty | drug1 | planname |
=======
      |	site	| zipcode | plantype | county | isMultutiCounty | drug1        | planname                                           |
      |	AARP	|   90210 | MAPD     | none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
=======
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1        | planname                                           |
      |	AARP	|   90210 | MAPD     |	current		| none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
      
      @DCE_Redesign_VPP_PlanCompare_UHC
    Examples: 
<<<<<<< HEAD
      |	site	| zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |	UHC		|   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

    #      |	AARP	|   90210 | MAPD     | none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
    @DCE_Redesign_VPP_PlanCompare_UHC
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | UHC  |   90210 | MAPD     | none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
=======
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |	UHC		|   90210 | MAPD     |	current		| none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

    @DCE_Redesign_VPP_PlanCompare_AARP
    Examples: 
<<<<<<< HEAD
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | AARP |   80002 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

=======
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	AARP	|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
      
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
    @DCE_Redesign_VPP_PlanCompare_UHC
    Examples: 
<<<<<<< HEAD
      | site | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | UHC  |   80002 | PDP      | Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
=======
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	UHC		|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |  

    
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
