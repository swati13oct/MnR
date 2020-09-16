@dce_redesign_ShopPDP
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Shop Plans -> PDP page to NEW DCE Flows

  @DCE_ShopForPlanPage_PDPpage
  Scenario Outline: To verify DCE REDESIGN flow from Shop PDP page on
    Given the user is on acquisition site landing page
    		|Site| <site>|
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then end user validates GetStarted Page
    Then end user clicks on Build Drug List to navigate to Build Drug List Page
    Then end user searching and adding the following Drug to Drug List
      | DrugName | <drug1> |
    Then end user searching and adding the following Drug to Drug List
      | DrugName | <drug2> |
    Then end user searching and adding the following Drug to Drug List
      | DrugName | <drug3> |
    Then end user searching and adding the following Drug to Drug List
      | DrugName | <drug4> |
    Then user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zip and county value
      | ZipCode | <zipCode> |
    And user click on continue button in Zip Entry Page

		@dce_redesign_ShopPDP_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |AARP|
     
     @dce_redesign_ShopPDP_UHC
     Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |UHC| 
