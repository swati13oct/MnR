@dce @dce_redesign_MedEd
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Medicare Education Prescriotion Page to NEW DCE Flows

  @dce_MedEdPage
  Scenario Outline: To verify DCE REDESIGN flow from Med Ed page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to Med Ed - Prescription Drugs Page
    Then the uset clicks on Estimate Drug Costs Link to land on DCE Redesign
    Then the user validates Get Started Page
    Then the user validates the Step Header as follows
      | Flags | <GetStartedHeader> |
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user validates the Step Header as follows
      | Flags | <DrugListPage_NoDrugs> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user validates the Step Header as follows
      | Flags | <DrugListPage_DrugsAdded> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    Then the user validates the Step Header as follows
      | Flags | <ZipPage_ZipAdded> |
    And user clicks on continue button in Zip Entry Page

    @dce_MedEdPage_AARP    @regressionAARP @sanity
    Examples: 
      | site | drug1   | drug2  | drug3   | drug4    | zipCode | GetStartedHeader | DrugListPage_NoDrugs | DrugListPage_DrugsAdded | ZipPage_ZipAdded |
      | AARP | Orkambi | Fanapt | Humalog | Adderall |   80002 | C:E:D            | E:C:D                | E:C:E                   | E:E:E            |

    #@dce_MedEdPage_UHC
    @regressionUHC
    Examples: 
      | site | drug1   | drug2  | drug3   | drug4    | zipCode |
      | UHC  | Orkambi | Fanapt | Humalog | Adderall |   80002 |
