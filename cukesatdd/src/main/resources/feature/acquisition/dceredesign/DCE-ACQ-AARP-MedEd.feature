@dce_redesign_MedEd
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Medicare Education Prescriotion Page to NEW DCE Flows

  @DCE_MedEdPage
  Scenario Outline: To verify DCE REDESIGN flow from Med Ed page
    Given the user is on AARP medicare acquisition site landing page
    Then the user navigates to Med Ed - Prescription Drugs Page
    Then the uset clicks on Estimate Drug Costs Link to land on DCE Redesign
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
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page in AARP

    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |
