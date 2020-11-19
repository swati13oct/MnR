@DCE_Redesign_VPP_Compare
Feature: 1.10.3 DCE-Redesign-VPP_PlanCompare - To test DCE - VPP Plan Compare Integration

  @DCE_Redesign_VPP_PlanCompare1
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>| 
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates drug is displayed on the plan compare page
    	|DrugName	|<drug1>|
		#Then the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page

    @DCE_Redesign_VPP_PlanCompare_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1        | planname                                           |
      |	AARP	|   90210 | MAPD     |	current		| none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
      @DCE_Redesign_VPP_PlanCompare_UHC
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |	UHC		|   90210 | MAPD     |	current		| none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanCompare_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	AARP	|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
      
    @DCE_Redesign_VPP_PlanCompare_UHC
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	UHC		|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |  

 
   @DCE_Redesign_VPP_PlanCompare2
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare from vpp Plan Compare View Drug Info Modal
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates drug is displayed on the plan compare page
    	|DrugName	|<drug1>|
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user clicks on View Plan Compare button and validates Plan Compare page

    @DCE_Redesign_VPP_PlanCompare2_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1        | planname                                           |
      |	AARP	|   90210 | MAPD     |	current		| none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
      @DCE_Redesign_VPP_PlanCompare2_UHC
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |	UHC		|   90210 | MAPD     |	current		| none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanCompare2_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	AARP	|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
      
    @DCE_Redesign_VPP_PlanCompare2_UHC
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	UHC		|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |  


   @DCE_Redesign_VPP_PlanCompare3
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare View Drug Info Modal
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates drug is displayed on the plan compare page
    	|DrugName	|<drug1>|
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user clicks on Back to Compare link and validates Plan Compare page
    

    @DCE_Redesign_VPP_PlanCompare3_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1        | planname                                           |
      |	AARP	|   90210 | MAPD     |	current		| none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
      @DCE_Redesign_VPP_PlanCompare3_UHC
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      |	UHC		|   90210 | MAPD     |	current		| none   | no              | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @DCE_Redesign_VPP_PlanCompare3_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	AARP	|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
      
    @DCE_Redesign_VPP_PlanCompare3_UHC
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |	UHC		|   80002 | PDP      |	current		| Adams County | yes             | meloxicam | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |  
    