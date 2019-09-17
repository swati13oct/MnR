@CT @Keywordsearch_AARP
Feature: 1.09. ACQ- Community search, keyword search AARP
  

  @KeywordSearch_AARP @acquisitionRegression
    Scenario Outline: Validating the search field on the AARP site 
    Given the potential user is on AARP medicare acquisition site landing page
    When the member validates the search engine
    Then the member lands on the result pag   
    Examples:
	| placeholder | 
	| none   |
	
	# @Community_Meeting_AARP_obsulete_functionality_not_avaliable_any_more
	# Scenario Outline: Verify attend community meeting flow in AARP site
  # Given the user is on AARP medicare acquisition site landing page
  # When the user navigates to request more help and information page in AARP site and validates
  # Then the user navigates to community meeting page on AARP site and validates
  # Then the user validates elements on the page  
 # Examples:
	#| placeholder | 
#	| none      |
	