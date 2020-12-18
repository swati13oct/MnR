@UATRegression @F513647
Feature:1.08 UAT-Site Search Flows

@SiteSearchULayer @UATRegression
 Scenario Outline: Verify search results on Homepage - <searchValue> - <newsearchvalue>
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
   
  @SiteSearch_AARP_01   
     Examples: 
     |Scenario           |site | searchValue |newsearchvalue|
     |E2E Scenario 1_AMP |AARP  | Medicare    |Pharmacy|
     |E2E Scenario 1_AMP  |AARP  |Medicare|MEDICARE PART D CLAIM FORM(PDF)|
     |E2E Scenario 1_AMP  |AARP |Dental coverage| Drug cost estimator|
      
  @SiteSearch_UHC_01 
     Examples: 
     |Scenario            |site | searchValue |newsearchvalue|
     |E2E Scenario 1_UMS  |UHC  | Medicare    |Pharmacy|
     |E2E Scenario 1_UMS  |UHC  |Medicare|MEDICARE PART D CLAIM FORM(PDF)|
     |E2E Scenario 1_UMS  |UHC  |Dental coverage| Drug cost estimator|
     
  @prodSanity_AARP
  	Examples: 
     |Scenario           |site 	| searchValue |newsearchvalue	|
     |E2E Scenario 1_AMP |AARP  | Medicare    |Pharmacy				|
     
  @prodSanity_UHC
  	Examples: 
     |Scenario           	|site	| searchValue |newsearchvalue	|
     |E2E Scenario 1_UMS  |UHC	| Medicare    |Pharmacy				|
   	   
      
  @SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario>: Verify Error handling on Homepage - <searchValue> - <NewSearchValue>
    Given the user is on medicare acquisition site landing page
    |Site| <site>|
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
   
   @SiteSearch_AARP_02
    Examples: 
   |Scenario          | site|searchValue |Error | NewSearchValue| 
   |E2E Scenario 1_AMP| AARP|  Medicare  |Empty	  | |
   |E2E Scenario 1_AMP|AARP| Medicare|InvalidCharacter|medicareeee|  
   |E2E Scenario 1_AMP |AARP| Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj|
   |E2E Scenario 1_AMP |AARP| Medicare|InvalidCharacter|Unicorn|
    
   @SiteSearch_UHC_02
    Examples: 
   |Scenario          | site|searchValue |Error | NewSearchValue| 
   |E2E Scenario 1_UMS| UHC|  Medicare  |Empty	  | |
   |E2E Scenario 1_UMS|UHC| Medicare|InvalidCharacter|medicareeee|  
   |E2E Scenario 1_UMS |UHC| Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj|
   |E2E Scenario 1_UMS |UHC| Medicare|InvalidCharacter|Unicorn|
   
   @prodSanity_AARP
  	Examples:
  		|Scenario          |	site	|	searchValue |	Error 						| NewSearchValue	|
  		|E2E Scenario 1_AMP|	AARP	| Medicare		|	InvalidCharacter	|	medicareeee			|
  		
  @prodSanity_UHC
  	Examples:
  		|Scenario          |	site	|	searchValue |	Error 						| NewSearchValue	|
  		|E2E Scenario 1_UMS|	UHC		| Medicare		|	InvalidCharacter	|	medicareeee			|
  	 
 
 @SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : Verify provider search third party URL from homepage - <searchValue>
   Given the user is on medicare acquisition site landing page
   	|Site| <site>|
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
      
 @SiteSearch_AARP_03	@prodSanity_AARP
    Examples: 
   |Scenario  					|	site| searchValue         |url|
   | E2E Scenario 3_AMP | AARP | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearch_UHC_03	@prodSanity_UHC
    Examples: 
   |Scenario           |site| searchValue        |url|
   |E2E Scenario 3_UMS |UHC | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
    
     
@SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : Verify search results on VPP page - <searchValue> - <newsearchvalue>
    Given the user is on medicare acquisition site landing page
     	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the user navigates to the plan details page
      | Plan Name | <planName> |
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
    Then the user should see fifteen results before pagination
    Then the user validates pagination and results displayed
    Then the user validates the secondary search by providing newsearchvalue in the text box
        |NewSearchValue|<newsearchvalue>|
    Then the user validates pagination and results displayed
    
             
@SiteSearch_AARP_04
Examples:
|Scenario             |site| TID  | zipcode | isMultutiCounty | county                        | plantype       | planName                                           |searchValue |newsearchvalue|
|E2E Scenario 3_AMP 	|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD           | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|
|E2E Scenario 3_AMP 	|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD           | AARP Medicare Advantage Choice Plan 2 (PPO)        |Dental coverage    |Drug cost estimator|
|E2E Scenario 3_AMP 	|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD           | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|

@SiteSearch_UHC_04
Examples:
|Scenario             |site| TID | zipcode | isMultutiCounty | county                      | plantype        | planName                                           |searchValue |newsearchvalue|
|E2E Scenario 3_UMS 	|UHC|15652 |   19019 | No              | Philadelphia County         | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|

     
    
@SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : To verify Errorhandling on VPP page - <searchValue> - <NewSearchValue> 
   Given the user is on medicare acquisition site landing page
   	|Site| <site>|
   When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
  And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the user navigates to the plan details page
      | Plan Name | <planName> |
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
   
   @SiteSearch_AARP_03
     Examples: 
    |Scenario             | site| TID   | zipcode | isMultutiCounty | county                        | plantype       	| planName																					|	searchValue |	Error      			| NewSearchValue| 
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)       |	Medicare    | Empty  					|	    |           
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)       |	Medicare		|	InvalidCharacter|	medicareeee| 
    
    @SiteSearch_AARP_06
     Examples:
    |Scenario             | site| TID   | zipcode | isMultutiCounty | county                        | plantype       	| planName																					|	searchValue |	Error      			| NewSearchValue|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)       |	Medicare		|	InvalidCharacter|	ggahjksabdegfhijkalalamnpqrajjjjkkkrrasabdabatuvyazefghijakmnpqttttvwyzabde|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)       |	Medicare		|	InvalidCharacter|	Unicorn|
    
    @SiteSearch_AARP_05
    	Examples:
    |Scenario             | site| TID   | zipcode | isMultutiCounty | county                        | plantype       | planName|searchValue |Error      | NewSearchValue|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|plan25|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|123456|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|@@@@|
    
   @SiteSearch_UHC_03
    Examples:
   |Scenario              |site	| TID   | zipcode | isMultutiCounty | county                        | plantype        | planName                                    |searchValue |Error           | NewSearchValue| 
   |E2E Scenario 3_UMS 	  |UHC 	| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) |Medicare    |	Empty         |               |
   |E2E Scenario 3_UMS    |UHC 	|	15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) |Medicare     |InvalidCharacter|medicareeee|  
   
   @SiteSearch_UHC_06
    Examples:
   |Scenario             	|site	| TID  | zipcode | isMultutiCounty | county                        | plantype       | planName|searchValue |Error      | NewSearchValue|
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|ggahjksabdegfhijkalalamnpqrajjjjkkkrrasabdabatuvyazefghijakmnpqttttvwyzabde|
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|Unicorn|
   
   @SiteSearch_UHC_05
    Examples:
   |Scenario            	| site| TID  | zipcode | isMultutiCounty | county                        | plantype       | planName|searchValue |Error      | NewSearchValue|
   |E2E Scenario 3_UMS    |	UHC |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|plan25|
   |E2E Scenario 3_UMS    |	UHC |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|123456|
   |E2E Scenario 3_UMS    |	UHC |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|@@@@|
  
@SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : To verify provider search third party URL on VPP Page - <searchValue>
    Given the user is on medicare acquisition site landing page
     	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user views the plans of the below plan type
         | Plan Type | <plantype> |
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
      
 @SiteSearch_AARP_06	@prodSanity_AARP
    Examples: 
   |Scenario  					|	site| TID   | zipcode | isMultutiCounty | county                        | plantype       | planName|searchValue         |url|
   | E2E Scenario 3_AMP | AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)     | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearch_UHC_06	@prodSanity_UHC
    Examples: 
   |Scenario           |site|TID   | zipcode | isMultutiCounty | county                        | plantype       | planName| searchValue        |url|
   |E2E Scenario 3_UMS |UHC |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)    | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
    



