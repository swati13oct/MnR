@KeyWordSearch_UHC, @Community_meeting_UHC, @acquisitionRegression
Feature: Acquistion Features community search, keyword search 
  
  
   @Keyword_Search_UHC
  Scenario Outline: Validating the search field on the UHC site 
   Given the user is on the uhcmedicaresolutions site landing page
   When the member validates the search box 
   Then the member lands on the result page 
   
    Examples:
	| placeholder | 
	| none   |

	 @Community_Meeting_UHC
  Scenario Outline: Attend community meeting flow in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to request more help and information page in UHC site and validates
    Then the user navigates to community meeting page on UHC site and validates
    
      Examples:
	| placeholder | 
	| none   |
	
	
	
    
	
