@SiteSearchResultsUHC @F294024
Feature:2.03-Acq-To verify Sitesearch results in UMS site

@SiteSearchUHC  @SiteSearchRegressionUHC
 Scenario Outline: Verify search results in UHC site
   Given the user is on the uhcmedicaresolutions site landing page
   Then the user enter the searchValue in the search text box and hits enter on UHC Site
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination on UHC Site
   Then the user validates count of results aganist the total shown at top of the page on UHC Site
   Then the user validates pagination and results displayed on UHC Site
   Then the user validates the secondary search by providing newsearchvalue in the text box on UHC Site
        |NewSearchValue|<newsearchvalue>|
    Then the user validates pagination and results displayed on UHC Site
    Examples: 
      | searchValue |newsearchvalue|
      | Medicare    |pharmacy|
      
  @SiteSearchResultsVPPBlayer    @SiteSearchRegressionUHC
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific Additional Benefits in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
#    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on UHC
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
      
      Then the user enter the searchValue in the search text box and hits enter on UHC Site
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination on UHC Site
   Then the user validates count of results aganist the total shown at top of the page on UHC Site
   Then the user validates pagination and results displayed on UHC Site
   Then the user validates the secondary search by providing newsearchvalue in the text box on UHC Site
        |NewSearchValue|<newsearchvalue>|
    Then the user validates pagination and results displayed on UHC Site

 Examples:
   | TID   | zipcode | isMultutiCounty | county         | plantype | planName          |searchValue |newsearchvalue|
   | 15652 |   19019 | No  | Iowa County    | MAPD     | AARP Medicare Advantage Choice Plan 1 (PPO)       |Medicare    |pharmacy|

    
 @SiteSearchErrorHandlingUHC  @SiteSearchRegressionUHC
 Scenario Outline: Verify search results in UHC site
   Given the user is on the uhcmedicaresolutions site landing page
   Then the user enter the searchValue in the search text box and hits enter on UHC Site
       |search Value|<searchValue>|
   Then the user clear secondary search box and insert new search value on UHC Site
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message on UHC site
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
    Examples: 
    | searchValue |Error | NewSearchValue| 
  	|   Medicare  |Empty	  | |
    |Medicare|InvalidCharacter|medicareeee|  
    
	@SearchResultsPharmacyLocatorBlayer    @SiteSearchRegressionUHC
  Scenario Outline: To verify search results in pharmacy locator Blayer page
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |      
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination
   #Then the user validates count of results aganist the total shown at top of the page
   Then the user validates pagination and results displayed
   Then the user validates the secondary search by providing newsearchvalue in the text box
        |NewSearchValue|<newsearchvalue>|
   Then the user validates pagination and results displayed
       
  Examples: 
      | siteName | searchValue |newsearchvalue|
      | Blayer   |  Medicare    |pharmacy|

  #@SiteSearchResultsDCEBlayer    @SiteSearchRegressionUHC
   #Scenario Outline: 2.10.11 To verify search results in DCE Blayer page
  # Given the user is on the uhcmedicaresolutions site landing page
  # When I access the acquisition DCE tool from home page on ums site
  # Then the user enter the searchValue in the search text box and hits enter
    #   |search Value|<searchValue>| 
  # Then the user should see fifteen results before pagination
   #Then the user validates count of results aganist the total shown at top of the page
  # Then the user validates pagination and results displayed
   #Then the user validates the secondary search by providing newsearchvalue in the text box
      #  |NewSearchValue|<newsearchvalue>|
   #Then the user validates pagination and results displayed
   
 # Examples: 
    #  | searchValue |newsearchvalue|
     # | Medicare    |pharmacy|
      
	
