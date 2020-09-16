@dce_redesign_ShopPDP
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Shop Plans -> PDP page to NEW DCE Flows

  @DCE_ShopForPlanPage_PDPpage
  Scenario Outline: To verify DCE REDESIGN flow from Shop PDP page on
    Given the user is on medicare acquisition site landing page
    		|Site| <site>|
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
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
    And user clicks on continue button in Zip Entry Page

		@dce_redesign_ShopPDP_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |AARP|
     
     @dce_redesign_ShopPDP_UHC
     Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |UHC| 
