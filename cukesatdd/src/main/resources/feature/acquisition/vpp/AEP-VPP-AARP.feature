@AEP_VPP @AEP_VPP_Ulayer
Feature: test plan summary and Plan Details in vpp flow AARP site for AEP scenarios

#  @teamF_DCEdateChange
#  Scenario Outline: To change DCE server date for Team-F for AEP testing
#    Given the user is on team-f dce date change url and changes DCE server date to following date
#      | DCE Date | <dcedate> |

#   Examples: 
#      | dcedate    |
#      | 10/01/2018 |

  @Ulayer10_01
  Scenario Outline: Verify plan summary and Plan Details in AARP site for server date 10/01 pre-AEP period
    Given the user is on team-f dce date change url and changes DCE server date to following date
          | DCE Date | <dcedate> |
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user validates Current year and next year links in VPP
    Then the user validates Next year Plan summary Page for pre-AEP for below plan
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan
    Then the user validates Next year Plan details Page for pre-AEP
    Then the user returns to Plan Summary page
    Then the user validates Current year Plan Summary Page for pre-AEP
    Then the user view plan details of the above selected plan
    Then the user validates Current year Plan Details Page for pre-AEP

    Examples: 
      | dcedate    | zipcode | county             | plantype | planName                                          |
      | 10/01/2018 |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @Ulayer10_15
  Scenario Outline: Verify plan summary and Plan Details in AARP site for server date 10/01 pre-AEP period
    Given the user is on team-f dce date change url and changes DCE server date to following date
      | DCE Date | <dcedate> |
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user validates Current year and next year links in VPP
    Then the user validates Next year Plan summary Page for AEP enrollment period for below plan
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan
    Then the user validates Next year Plan details Page for AEP enrollment period
    Then the user returns to Plan Summary page
    Then the user validates Current year Plan Summary Page for AEP enrollment period
    Then the user view plan details of the above selected plan
    Then the user validates Current year Plan Details Page for AEP enrollment period

    Examples: 
      | dcedate    | zipcode | county             | plantype | planName                                          |
      | 10/15/2018 |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
      
   @Ulayer12_01
  Scenario Outline: Verify plan summary and Plan Details in AARP site for server date 10/01 pre-AEP period
    Given the user is on team-f dce date change url and changes DCE server date to following date
      | DCE Date | <dcedate> |
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user validates Current year and next year links in VPP
    Then the user validates Next year Plan summary Page for AEP enrollment period for below plan
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan
    Then the user validates Next year Plan details Page for AEP enrollment period
    Then the user returns to Plan Summary page
    Then the user validates Current year Plan Summary Page for Non enrollment period
    Then the user view plan details of the above selected plan
    Then the user validates Current year Plan Details Page for Non enrollment period

    Examples: 
      | dcedate    | zipcode | county             | plantype | planName                                          |
      | 12/01/2018 |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
