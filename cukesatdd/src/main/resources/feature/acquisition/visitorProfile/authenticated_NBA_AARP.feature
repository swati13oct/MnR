@AuthenticatedNBAValidations
Feature: 1.08. ACQ- Visitor Profile Authenticated NBA AARP

  @getStartedNBA @decRelease @authenticated 
  Scenario Outline: Verify get started NBA for authenticated user on VPP page for <plantype> plantype in <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user removes existing saved plans in visitor profile
    Then user clicks on home menu from Visitor profile page
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And user removes drugs from plan card
    And user removes provider from plan card
    Then user should see the Get started NBA on VPP
    When user clicks on Saved items on NBA
    Then user should be navigated to visitor profile page

    @getStartedNBA_MAPD_AARP @authenticatedNBAMAPDAARP01 @sanity
    Examples: 
      | site | userName      | password    | isMultiCounty | zipcode | county          | plantype |
      | AARP | mnracq@givmail.com | Password@1| NO            |   10001 | New York County | MAPD     |

    @getStartedNBA_PDP_AARP @authenticatedNBAPDPAARP01 
    Examples: 
      | site | userName      | password    | isMultiCounty | zipcode | county          | plantype |
      | AARP | mnracq@givmail.com | Password@1 | NO            |   10001 | New York County | PDP      |

    @getStartedNBA_MAPD_UHC01 @authenticatedNBAMAPDUHC01 
    Examples:  
      | site | userName      | password    | isMultiCounty | zipcode | county          | plantype |
      | UHC  | mnracq@givmail.com | Password@1 | NO            |   10001 | New York County | MAPD     |

    @getStartedNBA_PDP_UHC02 @authenticatedNBAPDPUHC02 @sanity
    Examples: 
      | site | userName      | password    | isMultiCounty | zipcode | county          | plantype |
      | UHC  | mnracq@givmail.com | Password@1 | NO            |   10001 | New York County | PDP      |

  @NBAAuthenticatedMAPD @authenticated @decRelease
  Scenario Outline: Verify NBA for authenticated Visitor Profile VPP summary page for <plantype> plantype
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user removes existing saved plans in visitor profile
    Then user clicks on home menu from Visitor profile page
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And user removes drugs from plan card
    And user removes provider from plan card
    Then user should see the Get started NBA on VPP
    Then user clicks on get started button on NBA
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drugName> |
    And clicks on Review drug cost button
    And the user click on return to plan summary on DCE summary page
    Then user validate Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with all plans
    When user saves plan as favorite on VPP
      | Plan Type | <testPlans> |
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with saved plans
      | Test Plans | <testPlans> |
    When user clicks on Saved items on NBA
    Then user should be navigated to visitor profile page

    @authenticatedNBA_MAPD_AARP @authenticatedNBAMAPDAARP01
    Examples: 
      | site | userName      | password    | isMultiCounty | zipcode | county          | plantype | drugName | testPlans                           |
      | AARP | mnracq@givmail.com | Password@1 | NO            |   10001 | New York County | MAPD     | Lipitor  | AARP Medicare Advantage Prime (HMO) |

    @authenticatedNBA_MAPD_UHC01 @authenticatedNBAMAPDUHC01
    Examples: 
      | site | userName      | password    | isMultutiCounty | zipcode | county          | plantype | drugName | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded | testPlans                           |
      | UHC  | mnracq@givmail.com | Password@1 | NO              |   10001 | New York County | MAPD     | Lipitor  | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     | AARP Medicare Advantage Prime (HMO) |

  @continueEnrollmentNBA @decRelease @authenticated
  Scenario Outline: Verify NBA for Continue Enrollment for authenticated Visitor Profile VPP summary page for single plan for <plantype> plantype
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs in Visitor profile
    And user clears the provider in visitor profile page
    And user removes existing saved plans in visitor profile
    Then user clicks on home menu from Visitor profile page
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the continue enrollment modal
    When user clicks on continue enrollment button
    Then user should navigated to enrollment page

    @continueEnrollmentNBA_MAPD_AARP @authenticatedNBAMAPDAARP01
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | AARP | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | MAPD     |

    @authenticatedNBAPDPAARP01
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | AARP | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | PDP      |

    @continueEnrollmentNBA__MAPD_UHC @authenticatedNBAMAPDUHC01
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | UHC  | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | MAPD     |

    @authenticatedNBAPDPUHC02
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | UHC  |mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | PDP      |

  @continueEnrollmentNBAMultiplePlan @decRelease @authenticated
  Scenario Outline: Verify NBA for Continue Enrollment for authenticated Visitor Profile VPP summary page for multiple plan for <plantype> plantype
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs in Visitor profile
    And user clears the provider in visitor profile page
    And user removes existing saved plans in visitor profile
    Then user clicks on home menu from Visitor profile page
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the continue enrollment modal for multiple plan
    When user clicks on Select a plan button on NBA
    Then continue enrollment button should be displayed for each plan
    When user clicks on continue enrollment button on the modal
    Then user should navigated to enrollment page

    @authenticatedNBAMAPDAARP01
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | AARP | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | MAPD     |

    @continueEnrollmentNBA_PDP_AARP @authenticatedNBAPDPAARP01
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | AARP | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | PDP      |

    @continueEnrollmentNBA__MAPD_UHC01 @authenticatedNBAMAPDUHC01
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | UHC  | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | MAPD     |

    @continueEnrollmentNBA__PDP_UHC01 @authenticatedNBAPDPUHC02
    Examples: 
      | site | userName     | password   | isMultiCounty | zipcode | county          | plantype |
      | UHC  | mnracq@givmail.com | Password@1 | NO            |   55344 | Hennepin County | PDP      |
