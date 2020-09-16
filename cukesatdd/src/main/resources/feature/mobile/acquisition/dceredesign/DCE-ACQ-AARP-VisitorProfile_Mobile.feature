@dce_redesign_VP
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Visitor Profile to NEW DCE Flows

  @DCE_VisitorProfile
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given user is on AARP site
    		|Site| <site>|
    And the user clicks on the shopping cart icon
    And user goto DCE redesign profile page via add drug button
    Then end user goto GetStarted button and click on it
    Then enduser navigate to build drug list by clicking on build drug list
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then enduser land on ZipEntry page by clicking on Review Drung Costs
    Then enduser provide zipcode and select county
      | ZipCode | <zipCode> |
    Then user click on continue button

		@DCE_VisitorProfile_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |AARP|
      
      @DCE_VisitorProfile_UHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |UHC|

