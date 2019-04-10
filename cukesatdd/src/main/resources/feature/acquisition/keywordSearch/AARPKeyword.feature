@Community_Meeting_AARP, @Keywordsearch_AARP, @acquisitionRegression
Feature: AARP_Acquistion Features community search, keyword search 
  

  @KeywordSearch_AARP
    Scenario Outline: Validating the search field on the AARP site 
    Given the user is on AARP medicare acquisition site landing page
    When the member validates the search box 
    Then the member lands on the result page 
   
    Examples:
	| placeholder | 
	| none   |
	
	@Community_Meeting_AARP
	Scenario Outline: Verify attend community meeting flow in AARP site
  Given the user is on AARP medicare acquisition site landing page
  When the user navigates to request more help and information page in AARP site and validates
  Then the user navigates to community meeting page on AARP site and validates
  Then the user validates elements on the page
Examples:
	| placeholder | 
	| none      |
	