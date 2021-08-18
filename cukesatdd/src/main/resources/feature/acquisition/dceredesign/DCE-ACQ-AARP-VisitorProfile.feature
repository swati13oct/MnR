@dce @dce_redesign_VP
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Visitor Profile to NEW DCE Flows

  @dce_VisitorProfile
  Scenario Outline: To verify DCE REDESIGN flow from <site> home page through visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
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
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page

  @dce_VisitorProfile_AARP @regressionAARP @prodRegression @vbfGate
    Examples:
      | drug1   | drug2  | drug3   | drug4    | zipCode | site |
      | Orkambi | Fanapt | Humalog | Adderall | 80002   | AARP |

  @dce_VisitorProfile_UHC @regressionUHC @sanity
    Examples:
      | drug1   | drug2  | drug3   | drug4    | zipCode | site |
      | Orkambi | Fanapt | Humalog | Adderall | 80002   | UHC  |

  @dceShopperProfileAddDrugsGlobally @decRelease @FebRelease @F547321
  Scenario Outline: To verify DCE REDESIGN shopper profile flow when adding and editing drugs globally
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user clicks on the add drugs button globally on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    When user clicks on Back to profile button
    Then user should be navigated to shopper profile page
    When user clicks on Edit Drug and Pharmacy on visitor profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    And user should be able to see Back to profile button on details page

  @dceShopperProfileAddDrugsGlobally_AARP @F539025AARP @regressionAARP
    Examples:
      | drug1   | zipCode | site | drug2  | planType | planName                                            |
      | Orkambi | 80002   | AARP | Fanapt | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @dceShopperProfileAddDrugsGlobally_UHC @F539025UHC @regressionUHC @prodRegression
    Examples:
      | drug1   | zipCode | site | drug2  | planType | planName                                            |
      | Orkambi | 80002   | UHC  | Fanapt | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @dceShopperProfileAddDrugsPlancard @decRelease @F547321
  Scenario Outline: To verify DCE REDESIGN shopper profile flow when adding and editing drugs from plan card
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on view saved plans button
    And user validates the added plans on new visitor profile page
      | Test Plans | <testPlans> |
    And the user clicks on the enter drug information button from plan card on Visitor Profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then user should be able to see Return to profile link on details page
    When user clicks on Return to profile link on details page
    Then user should be navigated to shopper profile page
    And user should see back to drug cost estimator link on visitor profile page
    When user clicks on edit drugs button from plan card
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then user should be able to see Return to profile link on details page
    And user should be able to see Back to profile button on details page

  @dceShopperProfileAddDrugsPlancard_AARP @regressionAARP @prodRegression
    Examples:
      | site | drug1   | drug2  | plantype | testPlans                                                                 | zipcode | isMultiCounty | county          |
      | AARP | Orkambi | Fanapt | MAPD     | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) | 10001   | NO            | New York County |

  @dceShopperProfileAddDrugsPlancard_UHC @regressionUHC
    Examples:
      | site | drug1   | drug2  | plantype | testPlans                                                                 | zipcode | isMultiCounty | county          |
      | UHC  | Orkambi | Fanapt | MAPD     | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) | 10001   | NO            | New York County |

  @dceShopperProfileAddDrugsGloballyAuthenticatedUser @decRelease
  Scenario Outline: To verify DCE REDESIGN shopper profile flow when adding and editing drugs globally for authenticated user
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs in Visitor profile
    And user clears the provider in visitor profile page
    #And user removed existing saved plans
    And the user clicks on the add drugs button globally on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    When user clicks on Back to profile button
    Then user should be navigated to shopper profile page
    Then user clicks on Add drugs button globally on shopper profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    And user should be able to see Back to profile button on details page

  @dceShopperProfileAddDrugsGloballyAuthenticatedUser_AARP123 @F539025AARP_01 @regressionAARP
    Examples:
      | site | drug1   | zipCode | drug2  | planType | planName                                            | userName      | password   |
      | AARP | Orkambi | 80002   | Fanapt | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | mnracq@givmail.com| Password@1 |

  @dceImportDrugs_AuthMember
  Scenario Outline: To verify DCE  - Drug Import flow for Authenticated Member Profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs in Visitor profile
    And user clears the provider in visitor profile page
    And the user clicks on the add drugs button globally on the profile page
    Then the user validates Get Started Page
    Then the user validates Import Option is displayed
    Then the user clicks on Import Drugs and validates Import Flow - Imports Get Started, Member NonMember Selection modals
      | AuthenticatedFlag | <authenticatedflag> |
    Then the user selects Member and provides Member Details and proceeds to import
      | AuthenticatedFlag | <authenticatedflag> |
      | DOB     | <dob>           |
      | ZipCode | <importZipCode> |
      | MBI     | <mbi>           |
    Then the user validates Import Success/Failure modal as follows
      | DrugsFlag     | <drugFlag>      |
      | ProvidersFlag | <providersFlag> |
    Then the user clicks on Review Imported Drugs and lands on Build your Drug List Page
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    When user clicks on Back to profile button
    Then user should be navigated to shopper profile page
    Then the user validates Drugs and provides are added or not added on shopper profile page as follows
      | DrugsFlag     | <drugFlag>      |
      | ProvidersFlag | <providersFlag> |
    When user clicks on Add drugs button globally on shopper profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    And user should be able to see Back to profile button on details page

  @dceImportDrugs_AuthMember_AARP
    Examples:
      | site | zipCode | drug2  | planType | planName                                            | userName | password   | dob        | importZipCode | mbi         | drugFlag | providersFlag |authenticatedflag |
      | AARP | 80002   | Fanapt | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | mnracq@givmail.com | Password@1 | 10/20/1942 | 06096         | 2ED7ET4TC62 | true     | true          | true  |


  @dceImportDrugs_AuthMember_UHC
    Examples:
      | site | zipCode | drug2  | planType | planName                        | userName  | password   | dob        | importZipCode | mbi         | drugFlag | providersFlag | authenticatedflag |
      | UHC  | 80002   | Fanapt | PDP      | AARP MedicareRx Preferred (PDP) | DCE_ATDD1 | Password@1 | 06/11/1943 | 06383         | 3AA6TD4UY48 | true     | false         | true              |
 #     | UHC  | 80002   | Fanapt | PDP      | AARP MedicareRx Preferred (PDP) | DCE_ATDD2 | Password@1 | 05/11/1953 | 06052         | 3WD2PU1GE94 | false    | true          | true |


  @dceImportDrugs_AuthNonMember
  Scenario Outline: To verify DCE  - Drug Import flow for Authenticated Non-Member
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs in Visitor profile
    And user clears the provider in visitor profile page
    And the user clicks on the add drugs button globally on the profile page
    Then the user validates Get Started Page
    Then the user validates Import Option is displayed
    Then the user clicks on Import Drugs and validates Import Flow - Imports Get Started, Member NonMember Selection modals
      | AuthenticatedFlag | <authenticatedflag> |
    Then the user selects NonMember, validates disclsimer page and provides following NonMember Details and proceeds to import
      | DOB     | <dob>           |
      | ZipCode | <importZipCode> |
      | Gender  | <gender>        |
    Then the user validates Import Success/Failure modal as follows
      | DrugsFlag     | <drugFlag>      |
      | ProvidersFlag | <providersFlag> |
    Then the user clicks on Review Imported Drugs and lands on Build your Drug List Page
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    When user clicks on Back to profile button
    Then user should be navigated to shopper profile page
    Then the user validates Drugs and provides are added or not added on shopper profile page as follows
      | DrugsFlag     | <drugFlag>      |
      | ProvidersFlag | <providersFlag> |
    When user clicks on Add drugs button globally on shopper profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    And user should be able to see Back to profile button on details page

  @dceImportDrugs_AuthNonMember_AARP
    Examples:
      | site | zipCode | drug2  | planType | planName                                            | userName | password    | dob        | importZipCode | gender | drugFlag | providersFlag |
      | AARP | 80002   | Fanapt | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | mnracq@givmail.com | Password@1 | 06/30/1948 | 06096         | F      | true     | true          |


  @dceImportDrugs_AuthNonMember_UHC
    Examples:
      | site | zipCode | drug2  | planType | planName                        | userName | password    | dob        | importZipCode | gender | drugFlag | providersFlag |
      | UHC  | 80002   | Fanapt | PDP      | AARP MedicareRx Preferred (PDP) | DFONNNEF | 1DCEProfile | 10/06/1942 | 06383         | F      | true     | false         |


  @drugSummary_DefaultPlanType
  Scenario Outline: To verify default plan type on drug summary page when there are no MAPD plans available from visitor profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default

  @drugSummary_DefaultPlanType_AARP @regressionAARP
    Examples:
      | drug1   | zipCode | site |
      | Orkambi | 40701   | AARP |

  @drugSummary_DefaultPlanType_UHC @regressionUHC
    Examples:
      | drug1   | zipCode | site |
      | Orkambi | 40701   | UHC  |

  @drugSummary_DefaultPlanType
  Scenario Outline: To verify default plan type on drug summary page when there are MAPD plans available from visitor profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Advantage Plans" by default

  @drugSummary_DefaultPlanType_AARP @regressionAARP
    Examples:
      | drug1   | zipCode | site |
      | Orkambi | 90210   | AARP |

  @drugSummary_DefaultPlanType_UHC @regressionUHC
    Examples:
      | drug1   | zipCode | site |
      | Orkambi | 90210   | UHC  |

  @dceShopperProfileAddDrugsgloablly @febRelease @febF539025
  Scenario Outline: To verify DCE will not prompt the user to input a ZIP code from VP when plans are saved and drugs are editing globally
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on view saved plans button
    And user validates the added plans on new visitor profile page
      | Test Plans | <testPlans> |
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    And user should be able to see Back to profile button on details page

  @dceShopperProfileAddDrugsGlobally_AARP @F539025AARP @regressionAARP
    Examples:
      | site | drug1   | drug2  | plantype | planyear | testPlans                                                                | zipcode | isMultiCounty | county          | planName                            |
      | AARP | Orkambi | Fanapt | MAPD     | next     | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Plan 1 (HMO) | 10001   | NO            | New York County | AARP Medicare Advantage Prime (HMO) |

  @dceShopperProfileAddDrugsGlobally_UHC @F539025UHC @regressionUHC
    Examples:
      | site | drug1   | drug2  | plantype | planyear | testPlans                                                                | zipcode | isMultiCounty | county          | planName                            |
      | UHC  | Orkambi | Fanapt | MAPD     | next     | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Plan 1 (HMO) | 10001   | NO            | New York County | AARP Medicare Advantage Prime (HMO) |

  Scenario Outline: To verify zipcode information retained while navigating to shop pages from visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user clicks on the shopping cart icon
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default

  @F549665
    Examples:
      | site | zipcode | county | isMultutiCounty | drug1   |
      | AARP | 90210   | none   | no              | Orkambi |

  @F549665
    Examples:
      | site | zipcode | county | isMultutiCounty | drug1   |
      | UHC  | 90210   | none   | no              | Orkambi |
