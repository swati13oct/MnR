Feature: Member DCE Page

@codeWarriors @F467985
  Scenario Outline: plan: <planType> -memberType: <memberType> - Verify DCE flow for individual members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
 	#  | Plan Type   |	<planType>   |
	#  | Member Type |	<memberType> |
    #And user clicks on Find and Price a Medication Call To Action
    When I navigate to Find Care & Cost menu
    And I navigate to Drug Lookup option
    And I delete all added drugs
    And I add branded drug
      | Drug      | <drug1>      |
      | Dosage    | <dosage1>    |
      | Quantity  | <quantity1>  |
      | Frequency | <frequency1> |
    And I navigate to Pharmacy tab
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the pharmacy from the list
    And I navigate to costs tab
    Then I should see cost of the drug
    And I should see learn more about the drug tiers and learn more about the drug payment stages link
    And I verify dosage and quantity fields data
      | Dosage    | <dosage1>    |
      | Quantity  | <quantity1>  |
      | Frequency | <frequency1> |
    And I verify Total cost Annual deductible and Drug coverage legend tooltips
      
    Examples: 
      | planType | memberType 	  | drug1   | dosage1          | quantity1 | frequency1    | zipcode | radius   |
      | PDP		 | IndividualPDP  | Lipitor | Lipitor TAB 10MG |        31 | Every 1 month | 07747	 | 25 miles |
      | MAPD	 | IndividualMAPD | Lipitor | Lipitor TAB 10MG |        31 | Every 1 month | 06450	 | 25 miles |
     
