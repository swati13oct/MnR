@dce_redesign_Drug_summary_AARP
Feature: 1.10.1 DCE-REDESIGN AARP - To test Drug summary page in New DCE flow

 
  @dCERedesign_ChangePharmacyModal @F426569 @F535368 @decRelease
  Scenario Outline: Test to verify sort, pagination, invalid zipcode error functionality for change pharmacy on drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    #And user should be able to see Medicare Advantage plan by default
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user selects Preferred mail order pharmacy
    Then the message "OptumRx Home Delivery only provides 90-day refill for your drugs." should be displayed on change pharmacy modal
    And user verify the default distance on change pharmacy modal
    When user sort the pharmacy list by "A to Z"
    Then pharmacy list should be displayed in ascending order
    When user sort the pharmacy list by "Z to A"
    Then pharmacy list should be displayed in descending order
    When user clicks on next button on change pharmacy modal
    Then user should be navigated to second page of pharmacy list
    When user clicks on back button on change pharmacy modal
    Then user should be navigated to first page of pharmacy list
    When user search with zipcode with no pharamacies
      | ZipCode | <zipCode1> |
    Then no results message should be displayed
      | NoResultsMessage | <message> |
    When user search with incorrect zipcode
      | ZipCode | <zipCode2> |
    Then error message "Please enter a valid ZIP code." should be displayed on change pharmacy modal

    @dCERedesign_ChangePharmacyModal_AARP
    Examples: 
      | site | drug1   | zipCode | message                                                                                                                                            | zipCode1 | zipCode2 |
      | AARP | Lipitor |   90001 | Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result. |    96799 |    78456 |

    @dCERedesign_ChangePharmacyModal_UHC
    Examples: 
      | site | drug1   | zipCode | message                                                                                                                                            | zipCode1 | zipCode2 |
      | UHC  | Lipitor |   90001 | Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result. |    96799 |    78456 |
