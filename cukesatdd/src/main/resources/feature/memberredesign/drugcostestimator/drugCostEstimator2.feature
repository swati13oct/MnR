Feature: Member DCE Page

@codeWarriors
  Scenario Outline: plan: <planType> -memberType: <memberType> - Verify find medication and DCE flow for individual members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user clicks on Find and Price a Medication Call To Action
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug1>      |
      | Dosage    | <dosage1>    |
      | Quantity  | <quantity1>  |
      | Frequency | <frequency1> |
    When I navigate to Pharmacy tab
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    When I select the pharmacy from the list
    When I navigate to costs tab
    Then I should see cost of the drug
    #Then I should see learn more about the drug tiers and learn more about the drug payment stages link
    #And any cost savings will be applied to my total cost savings in Step3

    Examples: 
      | planType | memberType | drug1   | dosage1          | quantity1 | frequency1    |
      | MAPD	 | MAPD_DCE	  | Lipitor | Lipitor TAB 10MG |        31 | Every 1 month |
     
