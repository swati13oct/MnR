@Test @AARPvisitorprofile
Feature: 1.08. ACQ- Visitor profile


  @VisitorProfile_AARP_mobile @prodRegression_AARP
  Scenario Outline: Verify user is able to add drug information to the unauthenticated visitor profile - zip - <zipCode>

    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    And the user clicks on the shopping cart icon mobile
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page mobile
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    

    Examples: 

      | state        | drug1   | zipCode | site |
      | Alabama      | Lipitor |   90210 | AARP |
     # | Virginia | Lipitor |   15001 | AARP |

   
     
	@VisitorProfile_AARP_mobile
  Scenario Outline: Verify user is able to add drug from DCE to the unauthenticated visitor profile - zip -<zipCode>

    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page mobile
      | State | <state> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    When user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |

    
    Examples: 
      | state    | drug1   | zipCode | site |
      | Alabama  | Lipitor |   90210 | AARP |
      | Virginia | Lipitor |   22320 | AARP |

   