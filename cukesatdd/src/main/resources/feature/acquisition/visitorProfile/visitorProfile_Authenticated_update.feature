@UATRegression @visitorProfile 
Feature: 1.08. UAT- Visitor profile 

@sanity
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to Enroll in plans available in Guest Profile. Additional functionality tested: global flyout menu, saved plans, alert tip, external links
    Given user is on campaign external Links page
      | External Link | <externallink> |
    When user clicks on Estimate Your Prescription Drug Costs from external page
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
    And user verify the drug summary page
    And user should be able to see "Medicare Advantage Plans" by default
    Then user saves MAPD plan as favorite on drug summary page AARP site
     | Test Plans | <testPlans> |
     @regressionAARP
    Examples: 
      | Scenario                                             | externallink                                             | drug1 | drug2   | drug3   | drug4   | zipCode |	testPlans	|
      | Scenario 4 | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |	Nexium	|	Advair Diskus	|	aripiprazole	|	insulin lispro	|	80243	|	 AARP Medicare Advantage SecureHorizons Plan 1 (HMO)	|

