#####Added the @insuranceSolution Tag below for specific scenarios################
@MedSupp_OLE_Common
Feature: 1.05.9 -OLE MedSupp Flow

  @MedSupp_OLE_Common
  Scenario Outline: MedSup Resume Application with Application ID on acq site -<site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on Start Application Button proceed to next pages
      | DOB       | <DOB>       |
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
    Then user clicks on resume application button
      | DOB       | <DOB>       |
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
    #Then the user signs in with optum Id credentials to resume application in UHC site
    #  | User Name | <userName> |
    #  | Password  | <password> |
    Then the user signs in with optum Id
      | User Name | <username> |
      | Password  | <password> |
    Then the user validate retrieve application URL
      | AARP URL     | <AARPUrl>     |
      | AARP URL STG | <AARPUrl-stg> |

    #Then the user enters data to resume the application
    #  | applicationType| <applicationType>|
    #	 | ApplicationID |<ApplicationID>|
    #  | DOB           | <DOB>         |
    #  | Zipcode       | <zipcode>     |
    #Then The user validates the resume application processed
    #  | Firstname     | <Firstname>   |
    #  | Lastname      | <Lastname>    |
    #@MedSupp_OLE_Regression_AARP
    Examples: 
      | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site |
      |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | TiggerOptumID40 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    #@MedSupp_OLE_Regression_UHC
    Examples: 
      | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site |
      |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | John      | TEST_PORTALS_Carry    | TEST_PORTALS_ABCD          | Resume          | TiggerOptumID40 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |

  @MedSupp_OLE_Common
  Scenario Outline: <scenario> MedSup E2E Flow through Shop Pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for Medsupp plans
    When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the site user clicks on Start Application Button and proceed Next
      | DOB       | <DOB>       |
      | Firstname | <Firstname> |
      | Lastname  | <Lastname>  |
    Then the site user clicks on continue application until confirmaion page
      | MedicareNumber | <medicarenumber> |

    #   @MedSupp_OLE_Common_AARP
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 3_AMP |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP | 1EG1TE1MK12    |

    #	@MedSupp_OLE_Common_UHC
    Examples: 
      | scenario           | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username        | password      | AARPUrl-stg                                                                                     | site | medicarenumber |
      | E2E Scenario 3_UMS |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | TiggerOptumID29 | TiggerTigger1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  | 1EG1TE1MK13    |

  @MedSupp_OLE_Common
  Scenario Outline: Med Sup Heart icon should save  on VPP summary page when the cart count <NoOfSavedPlansOnComparePage> is reflecting correctly
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on View Plans Button proceed to View Plans Page
      | DOB | <DOB> |
    #And user clicks on compare button and navigate to plan compare page
    #| No Of Plans To Compare      | <NoOfPlans>         |
    And user clicks on compare button and navigate to plan compare page for "first" time
      | No Of Plans To Compare | <NoOfPlans>         |
      | Navigate To Compare    | <NavigateToCompare> |
    And user clicks on save button and saves to plan cart for "first" time
      | No Of Plans To Compare | <NoOfPlans> |
    And user clicks on Edit Your Information link and navigate back to micro form
    And user clicks on View plan button link and navigate back to vpp summary page of medsupp
    Then user clicks on Save icon for all the plans and validate count in cart should match to plans
      | No Of Saved Plans On Compare Page | <NoOfSavedPlansOnComparePage> |

    @MedSupp_OLE_Regression_AARP @MedSupp_OLE_Regression_AARP_1 @regressionAARP @insuranceSolution 
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | yes               |                           1 |         1 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    @MedSupp_OLE_Regression_UHC @regressionUHC @insuranceSolution 
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | yes               |                           1 |         1 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |

  @MedSupp_OLE_Common
  Scenario Outline: Med Sup Heart icon should save  on VPP summary page when the cart count <NoOfSavedPlansOnComparePage> is reflecting correctly
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on View Plans Button proceed to View Plans Page
      | DOB | <DOB> |
    And user clicks on compare button and navigate to plan compare page for "first" time
      | No Of Plans To Compare | <NoOfPlans>         |
      | Navigate To Compare    | <NavigateToCompare> |
    And user clicks on save button and saves to plan cart for "first" time
      | No Of Plans To Compare | <NoOfPlans> |
    And user clicks on add more plans for comparing
    And user clicks on save button and saves to plan cart for "second" time
      | No Of Plans To Compare | <NoOfPlans> |
    Then user clicks on Save icon for all the plans and validate count in cart should match to plans
      | No Of Saved Plans On Compare Page | <NoOfSavedPlansOnComparePage> |

    @MedSupp_OLE_Regression_AARP @regressionAARP @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    @MedSupp_OLE_Regression_UHC @regressionUHC @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |

  @MedSupp_OLE_Common
  Scenario Outline: Med sup Plans saved in summary page not reflecting in Plans compare page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on View Plans Button proceed to View Plans Page
      | DOB | <DOB> |
    And user clicks on compare button and navigate to plan compare page for "first" time
      | No Of Plans To Compare | <NoOfPlans>         |
      | Navigate To Compare    | <NavigateToCompare> |
    Then user saves more than two plans on summary page navigate to compare page and validate that saved plans are displayed

    @MedSupp_OLE_Regression_AARP @insuranceSolution @regressionAARP
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | No                |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    @MedSupp_OLE_Regression_UHC @regressionUHC @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | No                |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |

  @MedSupp_OLE_Common
  Scenario Outline: Shopper Profile selection of Edit Your Information Navigated to Med Supp Entry Page with data elements prepopulated
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on View Plans Button proceed to View Plans Page
      | DOB | <DOB> |
    And user clicks on heart icon and save two heart icon plans
      | No Of Plans To Save | <NoOfPlans> |
    And user clicks on view saved plans land on shopper profile page
    And user clicks on Edit Your Information link and navigate back to micro form
    Then user validate all fields are editable and view plan and cancel buttons are visible

    @MedSupp_OLE_Regression_AARP @insuranceSolution @regressionAARP
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | Yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    @MedSupp_OLE_Regression_UHC @regressionUHC @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | Yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |

  @MedSupp_OLE_Common
  Scenario Outline: Shopper Profile selection of View Plan Details Navigated to Med Supp Plan Compare Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on View Plans Button proceed to View Plans Page
      | DOB | <DOB> |
    And user clicks on heart icon and save two heart icon plans
      | No Of Plans To Save | <NoOfPlans> |
    And user clicks on view saved plans land on shopper profile page
    Then user clicks on compare plans link and validates plan name start application button and benefit link

    @MedSupp_OLE_Regression_AARP @regressionAARP @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | Yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    @MedSupp_OLE_Regression_UHC @regressionUHC @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | Yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | TEST_PORTALS_John      | TEST_PORTALS_Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |

  @MedSupp_OLE_Common
  Scenario Outline: Shopper Profile selection of View Plan Details Navigated to Med Supp Plan Details Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user clicks on View Plans Button proceed to View Plans Page
      | DOB | <DOB> |
    And user clicks on heart icon and save two heart icon plans
      | No Of Plans To Save | <NoOfPlans> |
    And user clicks on view saved plans land on shopper profile page
    Then user clicks on view plan details button and validates plan name start application button and benefit link

    @MedSupp_OLE_Regression_AARP @regressionAARP @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | Yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

    @MedSupp_OLE_Regression_UHC @regressionUHC @insuranceSolution
    Examples: 
      | NavigateToCompare | NoOfSavedPlansOnComparePage | NoOfPlans | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      | Yes               |                           4 |         2 |   10001 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | New York County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | UHC  |
