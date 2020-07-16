@DCE_Redesign_VPP_MAPD
Feature: 1.10.2 ACQ-DCE-VPP_1 AARP - To test DCE to VPP Plan Summary in AARP site

  @DCE_VPP_MAPD
  Scenario Outline: 1.10.2.1 To test the DCE flow for PlanType :  <plantype> from vpp and the switch now option in step 3
    Given the user is on the AARP medicare site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And I access the DCE tool on aarp site
      | Plan Type | <plantype> |
    
      