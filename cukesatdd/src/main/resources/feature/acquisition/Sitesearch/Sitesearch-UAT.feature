@UATRegression @F513647
Feature:1.08 UAT-Site Search Flows

@SiteSearchULayer @UATRegression
 Scenario Outline: Verify search results on Homepage
    Given the user is on medicare acquisition site landing page
     	|Site| <site>|
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination
   Then the user validates count of results aganist the total shown at top of the page
   Then the user validates pagination and results displayed
   Then the user validates the secondary search by providing newsearchvalue in the text box
        |NewSearchValue|<newsearchvalue>|
   Then the user validates pagination and results displayed
   
  @SiteSearchAARP   
     Examples: 
      |site | searchValue |newsearchvalue|
      |AARP  | Medicare    |Pharmacy|
      |AARP  |Medicare|MEDICARE PART D CLAIM FORM(PDF)|
      |AARP |Dental coverage| Drug cost estimator|
      
  @SiteSearchUHC 
     Examples: 
      |site | searchValue |newsearchvalue|
      |UHC  | Medicare    |Pharmacy|
      |UHC  |Medicare|MEDICARE PART D CLAIM FORM(PDF)|
      |UHC  |Dental coverage| Drug cost estimator|
      
      
  @SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario>: Verify Error handling on Homepage
    Given the user is on medicare acquisition site landing page
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
    Examples: 
    | searchValue |Error | NewSearchValue| 
  	|   Medicare  |Empty	  | |
    |Medicare|InvalidCharacter|medicareeee|  
    |Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj|
    |Medicare|InvalidCharacter|Unicorn|
    
     
 @SiteSearchULayer @UATRegressionthird
 Scenario Outline: <Scenario> : Verify provider search third party URL from homepage
   Given the user is on medicare acquisition site landing page
   	|Site| <site>|
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
      
 @SiteSearchAARP
    Examples: 
   |Scenario  					|	site| searchValue         |url|
   | E2E Scenario 3_AMP | AARP | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearchUHC
    Examples: 
   |Scenario           |site| searchValue        |url|
   |E2E Scenario 3_UMS |UHC | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
    
     
@SiteSearchULayer
 Scenario Outline: <Scenario> : Verify search results on VPP page
    Given the user is on medicare acquisition site landing page
     	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user is on View Plan and Pricing page
    And the user views the plans of the below MA plantype
      | Plan Type | <plantype> |
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
    #Then user validates the URL for search header  
    Then the user is able to see pagination based on number of search results
    And user is able to see pagination based on number of search results
    When user is on Pagination page 1 
    Then the user is on the first page of pagination and page count is greater than 1
    And the next arrow is clickable for next page pagination
    #And search result fetches .pdf extension when on pagination page 1  
    When user is on Pagination page 2, Count of result fetched is  < 30 
    When user is on Pagination page 2, Count of result fetched is  >=30  
    Then  user is on the second page of pagination and page count is greater than 2 
    And the previous arrow and next arrow are clickable for previous page and next page pagination
    And the user is on the second page of pagination and page count is equal to 2
    #And search result fetches .pdf extension when on pagination page 2
    When user is on Pagination page 3, Count of result fetched is  < 45 
    When user is on Pagination page 3, Count of result fetched is  >=45
    And the user is on the third page of pagination and page count is greater than 3
    Then the previous arrow and next arrow are clickable for previous page and next page pagination
    And the user is on the third page of pagination and page count is equal to 3
    #And search result fetches .pdf extension when on pagination page 3
    When user is on Pagination page 4, Count of result fetched is < 50
    When user is on Pagination page 4, Count of result fetched is =50
    And the user is on the fourth page of pagination and page count is equal to 4
    And the previous arrow is clickable for previous page  pagination
    #And search result fetches .pdf extension when on pagination page 4
    #Then the user can click on search results link and is being redirected to appropriate page within the same portal
    Then the user is able to go back to search results page on clicking browser back page button
    And the user is able to click on Search icon without entering any search term as blank
    And the user should be able to click on OK button to continue browsing
    
    
   
    And the user can click on Heart icon
    Then the user Clicks on Sign in link
    
@SiteSearchAARP
Examples:
|site| TID   | zipcode | isMultutiCounty | county                        | plantype       | planName                                           |searchValue |newsearchvalue|
|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|


@SiteSearchUHC
Examples:
|site| TID   | zipcode | isMultutiCounty | county                        | plantype        | planName                                           |searchValue |newsearchvalue|
|UHC|15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|

     
    
   @SiteSearchULayer @UATRegressionError
 Scenario Outline: <Scenario> : To verify Errorhandling on VPP page
   Given the user is on medicare acquisition site landing page
   	|Site| <site>|
   When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user is on View Plan and Pricing page
    And the user views the plans of the below MA plantype
      | Plan Type | <plantype> |
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
   
   @SiteSearchAARP
    Examples: 
    |Scenario             | site|searchValue |Error      | NewSearchValue| 
    |E2E Scenario 3_AMP 	| AARP|  Medicare  |Empty	    |            |
   |E2E Scenario 3_AMP   |AARP|Medicare|InvalidCharacter|medicareeee|  
   |E2E Scenario 3_AMP   |AARP|Medicare|InvalidCharacter|ggahjksabdegfhijkalalamnpqrajjjjkkkrrasabdabatuvyazefghijakmnpqttttvwyzabde|
   |E2E Scenario 3_AMP  |AARP|Medicare|InvalidCharacter|Unicorn|
   |E2E Scenario 3_AMP  |AARP|Medicare|InvalidCharacter|plan25|
    
    @SiteSearchUHC
    Examples:
   |Scenario              | site|searchValue |Error      | NewSearchValue| 
   |E2E Scenario 3_UMS 	  |UHC  |Medicare    |Empty	      |            |
   |E2E Scenario 3_UMS    |UHC  |Medicare    |InvalidCharacter|medicareeee|  
   |E2E Scenario 3_UMS    |UHC  |Medicare    |InvalidCharacter|ggahjksabdegfhijkalalamnpqrajjjjkkkrrasabdabatuvyazefghijakmnpqttttvwyzabde|
   |E2E Scenario 3_UMS    |UHC  |Medicare    |InvalidCharacter|Unicorn|
   |E2E Scenario 3_UMS    |UHC  |Medicare    |InvalidCharacter|plan25|
    
  
 @SiteSearchULayer @UATRegressionthird
 Scenario Outline: <Scenario> : To verify provider search third party URL on VPP Page
    Given the user is on medicare acquisition site landing page
     	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user is on View Plan and Pricing page
    And the user views the plans of the below MA plantype
      | Plan Type | <plantype> |
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
      
 @SiteSearchAARP
    Examples: 
   |Scenario  					|	site| searchValue         |url|
   | E2E Scenario 3_AMP | AARP | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearchUHC
    Examples: 
   |Scenario           |site| searchValue        |url|
   |E2E Scenario 3_UMS |UHC | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
    



