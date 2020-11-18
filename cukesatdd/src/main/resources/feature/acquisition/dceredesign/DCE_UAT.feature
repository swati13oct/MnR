@UATRegression
Feature:1.10.4 UAT-DCE-To test UAT DCE E2E Regression Scenarios

  @DCE_ShopForPlanPage_PDPpage 
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from Shop PDP page on
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
      |Scenario| drug1   | drug2  | drug3   | drug4    | zipCode |site|
     	|E2E Scenario 2_AMP| Orkambi | Fanapt | Humalog | Adderall |   80002 |AARP|
     
     @dce_redesign_ShopPDP_UHC
     Examples: 
      |Scenario | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      |E2E Scenario 2_UMS| Orkambi | Fanapt | Humalog | Adderall |   80002 |UHC|
      
      
  @DCE_MedEdPage
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from Med Ed page
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
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
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page

		@DCE_MedEdPage_AARP
    Examples: 
    	|Scenario  					|	site	| drug1   | drug2  | drug3   | drug4    | zipCode |
     	|E2E Scenario 4_AMP	| AARP	| Orkambi | Fanapt | Humalog | Adderall |   80002 |

    @DCE_MedEdPage_UHC
    Examples: 
    	|Scenario   				|	site	| drug1   | drug2  | drug3   | drug4    | zipCode |
    	|E2E Scenario 4_UMS | UHC		| Orkambi | Fanapt | Humalog | Adderall |   80002 |
         