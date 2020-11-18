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
    And I click on view plan costs and navigate to Drug costs page
    Then the user clicks on return to compare link to return to plan compare

#    @DCE_Redesign_VPP_PlanCompare_AARP
    Examples: 
      |	site	| zipcode | plantype |	planyear	| county | isMultutiCounty | drug1        | planname                                           |
      |	AARP	|   90210 | MAPD     |	current		| none   | no              | meloxicam  | AARP Medicare Advantage SecureHorizons Focus (HMO) |
  