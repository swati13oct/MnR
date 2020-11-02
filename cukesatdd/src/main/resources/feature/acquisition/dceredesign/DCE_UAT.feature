@dce_redesign_Drug_summary_AARP @F426576
Feature: 1.10.1 UAT - DCE-REDESIGN - To test DCE Flow

	@DCE_DrugSummary_Page
  Scenario Outline: Test to verify the Drug summary page
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user verify the drug summary page

		@dce_DrugSummary_Page
    Examples: 
      |	site	| path                     													| pageName                   |	drugName	|	zipCode |
      |	AARP	| health-plans/estimate-drug-costs.html/getstarted 	| DCE Redesign - Get Started |	Lipitor		| 90210 	|
      
    @dce_DrugSummary_Page_UHC
    Examples: 
      |	site	| path                     													| pageName                   |	drugName	|	zipCode |
      |	UHC		| health-plans/estimate-drug-costs.html/getstarted 	| DCE Redesign - Get Started |	Lipitor		| 90210 	|
      
         