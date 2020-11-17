@UATRegression
Feature: 1.12 UAT - Header and Footer flows

  @globalfooterULayer
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on VPP page.
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
     When user accesses global header of the Medicare Plans home page
    And user verifies the logo on home page
    And user clicks on Sign in link in the header
    And the user clicks on browser back button
    And user clicks on register link in the header
    And the user clicks on browser back button
    Then the user clicks on the shopping cart icon
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

	@globalfooter_AARP
  Examples: 
     |Scenario  					|	site	|zipcode | isMultutiCounty | county        |
      |E2E Scenario_3 AMP |	AARP	|80001	| No								|Jefferson|
 
 @globalfooter_UHC
  Examples: 
       |Scenario					|	site|zipcode | isMultutiCounty | county        |
      |E2E Scenario_3 UMS |	UHC	|90210	| No							 | New York|				     
       
	@globalfooterULayer
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on DCE page.
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When I click on DCE Redesign link from Shop for a plan hover over
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    When user accesses global header of the Medicare Plans home page
    And user clicks on Sign in link in the header
    And the user clicks on browser back button
    And user clicks on register link in the header
    And the user clicks on browser back button
    Then the user clicks on the shopping cart icon
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

	@globalfooter_AARP
  Examples: 
     |Scenario  |	site	|
      |E2E Scenario_4 AMP |	AARP	|
 
 @globalfooter_UHC
  Examples: 
       |Scenario|	site	|
      |E2E Scenario_4 UMS |	UHC	| 
      
      	@globalfooterULayer
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on home page.
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When user accesses global footer of the Medicare Plans All page
     And user vaidates the state drop down link on the home page
    And user clicks on View all disclaimer information link on the home page
    And the user clicks on browser back button
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    When user accesses global header of the Medicare Plans home page
    And user clicks on Sign in link in the header
    And the user clicks on browser back button
    And user clicks on register link in the header
    And the user clicks on browser back button
    Then the user clicks on the shopping cart icon
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

	@globalfooter_AARP
  Examples: 
     |Scenario  |	site	|
      |E2E Scenario_1 AMP |	AARP	|
 
 @globalfooter_UHC
  Examples: 
       |Scenario|	site	|
      |E2E Scenario_1 UMS |	UHC	| 
    
   @globalfooterULayer
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on Pharmacy page.
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user navigate to pharmacy search page from the navigation bar
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    And user verifies home link of agents&brokers page
    And the user clicks on browser back button
    When user accesses global header of the Medicare Plans home page
    And user clicks on Sign in link in the header
    And the user clicks on browser back button
    And user clicks on register link in the header
    And the user clicks on browser back button
    Then the user clicks on the shopping cart icon
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

	@globalfooter_AARP
  Examples: 
     |Scenario  |	site	|
      |E2E Scenario_5 AMP |	AARP	|
 
 @globalfooter_UHC
  Examples: 
       |Scenario|	site	|
      |E2E Scenario_5 UMS |	UHC	 |
      
  @globalheaderULayer
  Scenario Outline: <Scenario> : To verify links displayed in the global header from VPP page
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |	
    When user accesses global header of the Medicare Plans home page
    And user clicks on Sign in link in the header
    And the user clicks on browser back button
    And user clicks on register link in the header
    And the user clicks on browser back button
    Then user clicks on the heart icon in the header
  
  @globalheader
  Examples: 
      |Scenario|	site	|zipcode | isMultutiCounty | county        |
       |E2E Scenario_3 AMP|	AARP	|80001	| No								|Jefferson|
       
  @globalheader
  Examples: 
       |Scenario 					|	site|zipcode | isMultutiCounty | county        |
       |E2E Scenario_3 UMS|	UHC	|90210  |No								| Los Angeles County|
       
 @globalheaderULayer
  Scenario Outline: <Scenario> : To verify links displayed in the global header from DCE 
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When I click on DCE Redesign link from Shop for a plan hover over
    When user accesses global header of the Medicare Plans home page
    And user clicks on Sign in link in the header
    And user clicks on register link in the header
    Then user clicks on the heart icon in the header
  
  @globalheader
  Examples: 
      |Scenario|	site	|
       |E2E Scenario_4 AMP|	AARP	| 
       
  @globalheader
  Examples: 
       |Scenario |	site	|
       |E2E Scenario_4 UMS|	UHC	|
