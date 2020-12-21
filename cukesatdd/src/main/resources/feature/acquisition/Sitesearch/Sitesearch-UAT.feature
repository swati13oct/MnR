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
   | E2E Scenario 1_AMP | AARP | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearch_UHC_03	@prodSanity_UHC
    Examples: 
   |Scenario           |site| searchValue        |url|
   |E2E Scenario 1_UMS |UHC | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
   
   
   @SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : To verify search results on Visitor profile from Home page
   Given the user is on medicare acquisition site landing page
   	|Site| <site>|
   Then the user clicks on the shopping cart icon
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination
   Then the user validates count of results aganist the total shown at top of the page
   Then the user validates pagination and results displayed
   Then the user validates the secondary search by providing newsearchvalue in the text box
        |NewSearchValue|<newsearchvalue>|
   Then the user validates pagination and results displayed
 
   
  @SiteSearch_AARP   
     Examples: 
     |Scenario           |site | searchValue |newsearchvalue|
     |E2E Scenario 1_AMP |AARP  | Medicare    |Pharmacy|
     |E2E Scenario 1_AMP |AARP  |Medicare|MEDICARE PART D CLAIM FORM(PDF)|
     |E2E Scenario 1_AMP |AARP |Dental coverage| Drug cost estimator|
     
         
  @SiteSearch_UHC 
     Examples: 
     |Scenario             |site | searchValue |newsearchvalue|
     |E2E Scenario 1_UMS   |UHC  | Medicare    |Pharmacy|
     |E2E Scenario 1_UMS   |UHC  |Medicare|MEDICARE PART D CLAIM FORM(PDF)|
     |E2E Scenario 1_UMS   |UHC  |Dental coverage| Drug cost estimator|
     
     
  @SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario>: Verify Error handling on Visitor profile from Homepage
    Given the user is on medicare acquisition site landing page
    |Site| <site>|
   Then the user clicks on the shopping cart icon
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
   
   @SiteSearch_AARP  
    Examples: 
   |Scenario          | site|searchValue |Error | NewSearchValue| 
   |E2E Scenario 1_AMP| AARP|  Medicare  |Empty	  | |
   |E2E Scenario 1_AMP|AARP| Medicare|InvalidCharacter|medicareeee|  
   |E2E Scenario 1_AMP |AARP| Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj|
   |E2E Scenario 1_AMP |AARP| Medicare|InvalidCharacter|Unicorn|
    
   @SiteSearch_UHC  
    Examples: 
   |Scenario          | site|searchValue |Error | NewSearchValue| 
   |E2E Scenario 1_UMS | UHC|  Medicare  |Empty	  | |
   |E2E Scenario 1_UMS |UHC| Medicare|InvalidCharacter|medicareeee|  
   |E2E Scenario 1_UMS  |UHC| Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj|
   |E2E Scenario 1_UMS  |UHC| Medicare|InvalidCharacter|Unicorn| 
    
    
   @SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : Verify provider search third party URL on Visitor profile from homepage
   Given the user is on medicare acquisition site landing page
   	|Site| <site>|
   Then the user clicks on the shopping cart icon
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
      
 @SiteSearch_AARP
    Examples: 
   |Scenario  					|	site| searchValue         |url|
   | E2E Scenario 1_AMP | AARP | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearch_UHC
    Examples: 
   |Scenario           |site| searchValue        |url|
   |E2E Scenario 1_UMS |UHC | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     
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
    

@SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : Verify search results on Visitor profile from VPP page - <searchValue> - <NewSearchValue>
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
    Then the user clicks on the shopping cart icon
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
    Then the user should see fifteen results before pagination
    Then the user validates pagination and results displayed
    Then the user validates the secondary search by providing newsearchvalue in the text box
        |NewSearchValue|<newsearchvalue>|
    Then the user validates pagination and results displayed
    
             
@SiteSearch_AARP_07
Examples:
|Scenario             |site| TID  | zipcode | isMultutiCounty | county                        | plantype       | planName                                           |searchValue |newsearchvalue|
|E2E Scenario 3_AMP 	|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD           | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|
|E2E Scenario 3_AMP 	|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD           | AARP Medicare Advantage Choice Plan 2 (PPO)        |Dental coverage    |Drug cost estimator|
|E2E Scenario 3_AMP 	|AARP|15652 |   19019 | No              | Philadelphia County           | MAPD           | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|

@SiteSearch_UHC_07
Examples:
|Scenario             |site| TID | zipcode | isMultutiCounty | county                      | plantype        | planName                                           |searchValue |newsearchvalue|
|E2E Scenario 3_UMS 	|UHC|15652 |   19019 | No              | Philadelphia County         | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    |pharmacy|

     
    
@SiteSearchULayer @UATRegression 
 Scenario Outline: <Scenario> : To verify Errorhandling on Visitor profile from VPP page - <searchValue> - <NewSearchValue>
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
    Then the user clicks on the shopping cart icon
    Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
   
   @SiteSearch_AARP_07
     Examples: 
    |Scenario             | site| TID   | zipcode | isMultutiCounty | county                        | plantype       | planName|searchValue |Error      | NewSearchValue| 
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare    | Empty  |	    |           
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|medicareeee| 
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|ggahjksabdegfhijkalalamnpqrajjjjkkkrrasabdabatuvyazefghijakmnpqttttvwyzabde|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|Unicorn|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|plan25|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|123456|
    |E2E Scenario 3_AMP 	| AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)        |Medicare|InvalidCharacter|@@@@|
    
   @SiteSearch_UHC_07
    Examples:
   |Scenario              | site| TID   | zipcode | isMultutiCounty | county                        | plantype        | planName                                    |searchValue |Error           | NewSearchValue| 
   |E2E Scenario 3_UMS 	  |UHC  | 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) |Medicare    |	Empty         |               |
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) |Medicare     |InvalidCharacter|medicareeee|  
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|ggahjksabdegfhijkalalamnpqrajjjjkkkrrasabdabatuvyazefghijakmnpqttttvwyzabde|
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|Unicorn|
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|plan25|
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|123456|
   |E2E Scenario 3_UMS    |UHC  |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO) | Medicare    |InvalidCharacter|@@@@|
  
@SiteSearchULayer @UATRegression
 Scenario Outline: <Scenario> : To verify provider search third party URL on Visitor profile from VPP Page - <searchValue> 
    Given the user is on medicare acquisition site landing page
     	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
   Then the user views the plans of the below plan type
         | Plan Type | <plantype> |
   Then the user clicks on the shopping cart icon
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
      
 @SiteSearch_AARP_07
    Examples: 
   |Scenario  					|	site| TID   | zipcode | isMultutiCounty | county                        | plantype       | planName|searchValue         |url|
   | E2E Scenario 3_AMP | AARP| 15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)     | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      
      
  @SiteSearch_UHC_07
    Examples: 
   |Scenario           |site|TID   | zipcode | isMultutiCounty | county                        | plantype       | planName| searchValue        |url|
   |E2E Scenario 3_UMS |UHC |15652 |   19019 | No              | Philadelphia County           | MAPD            | AARP Medicare Advantage Choice Plan 2 (PPO)    | Provider search    |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
    
  
@SiteSearchULayerPages @UATRegression
 Scenario Outline: <Scenario> : To verify provider search third party URL on page mentioned - - <searchValue> 
   Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
       Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>|  
   Then the user clicks on the united health care medicare solutions link
   Then the user validates the "<url>"  
   
   @SiteSearchShop_AARP
    Examples: 
      |Scenario  					 |	site  | path| 	                   | pageName                                          | searchValue         |url| 
      | E2E Scenario 2_AMP |	AARP	| shop.html                  | ShopPlan: Shop Hub                                | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
  	  | E2E Scenario 2__AMP|	AARP	| shop/compare.html                                | ShopPlan: Compare           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      | E2E Scenario 2_AMP |	AARP	| shop/estimate.html                               | ShopPlan: Estimate          | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      | E2E Scenario 2_AMP |	AARP	| shop/switch.html                                 | ShopPlan: Switch            | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      | E2E Scenario 2_AMP  |	AARP	| shop/compare/compare-ms.html                     | ShopPlan: Compare MS        | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      | E2E Scenario 2_AMP   |	AARP	| shop/estimate/ms-costs.html                      | ShopPlan: Estimate MS       | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/compare/compare-ma-ms.html                  | ShopPlan: Compare MA MS     |  Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| safe-shopping.html                               | ShopPlan: Shop              | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/compare/compare-pdp.html                    | ShopPlan: Compare PDP Plan  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/compare/compare-ma.html                     | ShopPlan: Compare MA  Plan  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/estimate/ma-costs.html                      | ShopPlan: Estimate MA Plan  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP  |	AARP	| shop/estimate/pdp-costs.html                     | ShopPlan: Estimate PDP Plan | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			 | E2E Scenario 2_AMP  |	AARP	| shop/renew-active.html                           | ShopPlan: Renew-Active      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			 | E2E Scenario 2_AMP |  AARP  | shop/medicare-advantage-veteran-plan.html        | MA Veteran Plan             |Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_AMP |  AARP  | health-plans.html#/plan-summary                  |Shop for a plan|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			
   @SiteSearchShop_UHC
    Examples: 
      |	Scenario  					 |site	| path                                             | pageName                    | searchValue         |url| 
     	| E2E Scenario 2_UMS  |	UHC		| shop.html                                        | ShopPlan: Shop Hub          | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			|	E2E Scenario 2_UMS|UHC		| shop/compare.html                                | ShopPlan: Compare           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			|	E2E Scenario 2_UMS|	UHC		| shop/estimate.html                               | ShopPlan: Estimate          | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			|	E2E Scenario 2_UMS|	UHC		| shop/switch.html                                 | ShopPlan: Switch            | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
        |	E2E Scenario 2_UMS|	UHC		| shop/compare/compare-ms.html                     | ShopPlan: Compare           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
        |	E2E Scenario 2_UMS|	UHC		| shop/estimate/ms-costs.html                      | ShopPlan: Estimate          | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
        |	E2E Scenario 2_UMS|	UHC		| shop/compare/compare-ma-ms.html                  | ShopPlan: Compare           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS |	UHC		| safe-shopping.html                               | ShopPlan: Shop               | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
        |	E2E Scenario 2_UMS|	UHC  	| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS |	UHC	  | shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS |	UHC	  | shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
        |	E2E Scenario 2_UMS|	UHC	  | shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS |	UHC	| shop/compare/compare-pdp.html                    | ShopPlan: Compare PDP Plan  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
        |	E2E Scenario 2_UMS|	UHC	| shop/compare/compare-ma.html                     | ShopPlan: Compare MA  Plan  |Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip| 
       |	E2E Scenario 2_UMS |	UHC	| shop/estimate/ma-costs.html                      | ShopPlan: Estimate MA Plan  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS |	UHC	| shop/estimate/pdp-costs.html                     | ShopPlan: Estimate PDP Plan | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS |	UHC	| shop/renew-active.html                           | ShopPlan: Renew-Active      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       |	E2E Scenario 2_UMS   |UHC  | shop/medicare-advantage-veteran-plan.html       | MA Veteran Plan|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
       | E2E Scenario 2_UMS|  UHC  | health-plans.html#/plan-summary                  |Shop for a plan|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
			
@SiteSearchEnroll_AARP
    Examples: 
    |Scenario  					 | 	site	| path                                    | pageName                   | searchValue         |url| 
     |E2E Scenario 2_AMP |	AARP	| enroll.html                             | ShopPlan: Enroll           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP |	AARP	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP |	AARP	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP |	AARP	| enroll/ms-apply.html                    | ShopPlan: Enroll           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP |	AARP	| resources/mail-order-pharmacy.html      | ShopPlan: Resources Mail Order Pharmacy| Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP  |AARP   | contact-us.html                         | Contact us                 | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP |  AARP   |health-plans/estimate-drug-costs.html#/drug-cost-estimator|Drug Cost Estimator|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_AMP|  AARP   |health-plans/aarp-pharmacy.html#/Pharmacy-Search-English|Pharmacy Locator|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
  
  @SiteSearchEnroll_UHC
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue         |url| 
     |	E2E Scenario 2_UMS |	UHC	| enroll.html                             | ShopPlan: Enroll           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS|	UHC	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS|	UHC	| enroll/ms-apply.html                    | ShopPlan: Enroll           | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC | resources/mail-order-pharmacy.html      | ShopPlan: Resources Mail Order Pharmacy| Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_UMS  |UHC   | contact-us.html                         | Contact us                 | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |E2E Scenario 2_UMS|  UHC   |health-plans/estimate-drug-costs.html#/drug-cost-estimator|Drug Cost Estimator|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      |E2E Scenario 2_UMS|  UHC   |health-plans/aarp-pharmacy.html#/Pharmacy-Search-English|Pharmacy Locator|Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
  
  
   @SiteSearchMedEd_AARP
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue         |url| 
     |	E2E Scenario 2_AMP|	AARP	| medicare-education.html                   | Understanding Medicare      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-eligibility.html       | Medicare Eligibility       | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-parts-and-.htmlmedigap-plans     | Medicare and Medigap Coverage Options     | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	 AARP	| medicare-education/medicare-benefits.html                 |  Medicare Prescriptions, Providers & Benefits      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-costs.html                   | Medicare Cost Basics    | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/enrollment-and-changing-plans.html|Medicare Enrollment Basics | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-faq.html|Medicare FAQ | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-advantage-plans.html|Medicare Advantage (Part C) Plans | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-supplement-plans.html|Medicare Supplement Insurance Plans| Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-part-d.html|Medicare Prescription Drug Plans| Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     
  @SiteSearchMedEd_UHC
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue         |url| 
     |	E2E Scenario 2_UMS |	UHC	| medicare-education.html                   | Understanding Medicare      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-eligibility.html       | Medicare Eligibility       | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-parts-and-.htmlmedigap-plans     | Medicare and Medigap Coverage Options     | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-benefits.html                 |  Medicare Prescriptions, Providers & Benefits      | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-costs.html                   | Medicare Cost Basics  | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/enrollment-and-changing-plans.html|Medicare Enrollment Basics | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-faq.html|Medicare FAQ | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-advantage-plans.html|Medicare Advantage (Part C) Plans | Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-supplement-plans.html|Medicare Supplement Insurance Plans| Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
      |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-part-d.html|Medicare Prescription Drug Plans| Provider search     |https://connect.werally.com/county-plan-selection/uhc.mnr/zip|
     
     
    @SiteSearchULayerPages @UATRegression
 Scenario Outline: Verify search results on page mentioned - <searchValue> - <newsearchvalue>
   Given the user is on medicare acquisition site landing page
         	|Site| <site>|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination
   Then the user validates count of results aganist the total shown at top of the page
   Then the user validates pagination and results displayed
   Then the user validates the secondary search by providing newsearchvalue in the text box
        |NewSearchValue|<newsearchvalue>|
   Then the user validates pagination and results displayed
   
  @SiteSearchShop1_AARP   
     Examples: 
     |Scenario           |site  | path                       |pageName            |searchValue |newsearchvalue|searchValue |newsearchvalue|searchValue |newsearchvalue|
     |E2E Scenario 2_AMP |AARP	| shop.html                  | ShopPlan: Shop Hub |Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  |  shop/compare.html         | ShopPlan: Compare|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
       |E2E Scenario 2_AMP |AARP  | shop/estimate.html         | ShopPlan: Estimate|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |AARP  | shop/switch.html              | ShopPlan: Switch|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-ms.html    | ShopPlan: Compare|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |AARP  | shop/estimate/ms-costs.html          | ShopPlan: Estimate|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-ma-ms.html      | ShopPlan: Compare |Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator| 
     |E2E Scenario 2_AMP |AARP  | safe-shopping.html                     | ShopPlan: Shop|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |AARP| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-pdp.html                    | ShopPlan: Compare PDP Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-ma.html                     | ShopPlan: Compare MA  Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/estimate/pdp-costs.html                     | ShopPlan: Estimate PDP Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/renew-active.html                           | ShopPlan: Renew-Active|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/medicare-advantage-veteran-plan.html       | MA Veteran Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | health-plans.html#/plan-summary                  |Shop for a plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
   
      
      
  @SiteSearchShop1_UHC 
     Examples: 
     |Scenario           |site  | path                       |pageName            |searchValue |newsearchvalue|searchValue |newsearchvalue|searchValue |newsearchvalue|
     |E2E Scenario 2_UMS |UHC	| shop.html                  | ShopPlan: Shop Hub |Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC  |  shop/compare.html         | ShopPlan: Compare|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
       |E2E Scenario 2_UMS |UHC  | shop/estimate.html         | ShopPlan: Estimate|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_UMS |UHC  | shop/switch.html              | ShopPlan: Switch|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC  | shop/compare/compare-ms.html    | ShopPlan: Compare|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_UMS |UHC | shop/estimate/ms-costs.html          | ShopPlan: Estimate|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC | shop/compare/compare-ma-ms.html      | ShopPlan: Compare |Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator| 
     |E2E Scenario 2_UMS |UHC  | safe-shopping.html                     | ShopPlan: Shop|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_UMS |UHC| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC | shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC  | shop/compare/compare-pdp.html                    | ShopPlan: Compare PDP Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC  | shop/compare/compare-ma.html                     | ShopPlan: Compare MA  Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC  | shop/estimate/pdp-costs.html                     | ShopPlan: Estimate PDP Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_AMP |AARP  | shop/renew-active.html                           | ShopPlan: Renew-Active|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC | shop/medicare-advantage-veteran-plan.html       | MA Veteran Plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS |UHC  | health-plans.html#/plan-summary                  |Shop for a plan|Medicare    |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
   
   @SiteSearchEnroll1_AARP
    Examples: 
    |Scenario  					 | 	site	| path                                    | pageName                   | searchValue |newsearchvalue|searchValue |newsearchvalue|searchValue |newsearchvalue|
     |E2E Scenario 2_AMP |	AARP	| enroll.html                             | ShopPlan: Enroll           | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |	AARP	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  |Medicare  | Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |	AARP	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |	AARP	| enroll/ms-apply.html                    | ShopPlan: Enroll           | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |	AARP	| resources/mail-order-pharmacy.html      | ShopPlan: Resources Mail Order Pharmacy| Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator||
     |E2E Scenario 2_AMP  |AARP   | contact-us.html                         | Contact us                 | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP |  AARP   |health-plans/estimate-drug-costs.html#/drug-cost-estimator|Drug Cost Estimator|Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_AMP|  AARP   |health-plans/aarp-pharmacy.html#/Pharmacy-Search-English|Pharmacy Locator|Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
  
  @SiteSearchEnroll1_UHC
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue         |newsearchvalue|searchValue |newsearchvalue|searchValue |newsearchvalue|
     |	E2E Scenario 2_UMS |	UHC	| enroll.html                             | ShopPlan: Enroll           | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS|	UHC	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS|	UHC	| enroll/ms-apply.html                    | ShopPlan: Enroll           | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC | resources/mail-order-pharmacy.html      | ShopPlan: Resources Mail Order Pharmacy| Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_UMS  |UHC   | contact-us.html                         | Contact us                 | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |E2E Scenario 2_UMS|  UHC   |health-plans/estimate-drug-costs.html#/drug-cost-estimator|Drug Cost Estimator|Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |E2E Scenario 2_UMS|  UHC   |health-plans/aarp-pharmacy.html#/Pharmacy-Search-English|Pharmacy Locator|Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
       
   @SiteSearchMedEd1_AARP
    Examples: 
     |Scenario             |	site	| path                                                     | pageName                   | searchValue         |newsearchvalue|searchValue |newsearchvalue|searchValue |newsearchvalue|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education.html                                  | Understanding Medicare     | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-eligibility.html             | Medicare Eligibility       |Medicare   |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-parts-and-.htmlmedigap-plans | Medicare and Medigap Coverage Options     |Medicare  | Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	 AARP	| medicare-education/medicare-benefits.html                |  Medicare Prescriptions, Providers & Benefits      | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-costs.html                   | Medicare Cost Basics    | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/enrollment-and-changing-plans.html|Medicare Enrollment Basics | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-faq.html                      |Medicare FAQ |Medicare|Pharmacy|Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-advantage-plans.html|Medicare Advantage (Part C) Plans |Medicare  | Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-supplement-plans.html|Medicare Supplement Insurance Plans| Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-part-d.html|Medicare Prescription Drug Plans| Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
 
   @SiteSearchMedEd1_UHC
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue         |newsearchvalue|searchValue |newsearchvalue|searchValue |newsearchvalue| 
     |	E2E Scenario 2_UMS |	UHC	| medicare-education.html                   | Understanding Medicare      | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-eligibility.html       | Medicare Eligibility       | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-parts-and-.htmlmedigap-plans     | Medicare and Medigap Coverage Options     | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-benefits.html                 |  Medicare Prescriptions, Providers & Benefits      | Medicare|Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-costs.html                   | Medicare Cost Basics  |Medicare  | Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/enrollment-and-changing-plans.html|Medicare Enrollment Basics |Medicare  | Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-faq.html|Medicare FAQ | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-advantage-plans.html|Medicare Advantage (Part C) Plans | Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-supplement-plans.html|Medicare Supplement Insurance Plans| Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
      |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-part-d.html|Medicare Prescription Drug Plans| Medicare  |Pharmacy      |Medicare|MEDICARE PART D CLAIM FORM(PDF)|Dental coverage| Drug cost estimator|
   
   
    @SiteSearchULayerPages @UATRegression
 Scenario Outline: <Scenario>: Verify Error handling on page mentioned - <searchValue> - <NewSearchValue> 
    Given the user is on medicare acquisition site landing page
    |Site| <site>|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user clear secondary search box and insert new search value
   | New Search Value|<NewSearchValue> |
   Then the user validates Error message
   |Error|<Error>|
   |NewSearchValue|<NewSearchValue>|
   
   @SiteSearchShop2_AARP   
     Examples: 
     |Scenario           |site  | path                       |pageName            |searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| 
     |E2E Scenario 2_AMP |AARP	| shop.html                  | ShopPlan: Shop Hub |Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  |  shop/compare.html         | ShopPlan: Compare|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
       |E2E Scenario 2_AMP |AARP  | shop/estimate.html         | ShopPlan: Estimate|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |AARP  | shop/switch.html              | ShopPlan: Switch|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-ms.html    | ShopPlan: Compare|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |AARP  | shop/estimate/ms-costs.html          | ShopPlan: Estimate|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-ma-ms.html      | ShopPlan: Compare |Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |AARP  | safe-shopping.html                     | ShopPlan: Shop|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |AARP| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-pdp.html                    | ShopPlan: Compare PDP Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/compare/compare-ma.html                     | ShopPlan: Compare MA  Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/estimate/pdp-costs.html                     | ShopPlan: Estimate PDP Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/renew-active.html                           | ShopPlan: Renew-Active|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/medicare-advantage-veteran-plan.html       | MA Veteran Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | health-plans.html#/plan-summary                  |Shop for a plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
   
      
      
  @SiteSearchShop2_UHC 
     Examples: 
     |Scenario           |site  | path                       |pageName            |searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| 
     |E2E Scenario 2_UMS |UHC	| shop.html                  | ShopPlan: Shop Hub |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC  |  shop/compare.html         | ShopPlan: Compare|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
       |E2E Scenario 2_UMS |UHC  | shop/estimate.html         | ShopPlan: Estimate|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_UMS |UHC  | shop/switch.html              | ShopPlan: Switch|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC  | shop/compare/compare-ms.html    | ShopPlan: Compare|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_UMS |UHC | shop/estimate/ms-costs.html          | ShopPlan: Estimate|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC | shop/compare/compare-ma-ms.html      | ShopPlan: Compare |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_UMS |UHC  | safe-shopping.html                     | ShopPlan: Shop|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_UMS |UHC| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC | shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC  | shop/compare/compare-pdp.html                    | ShopPlan: Compare PDP Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC  | shop/compare/compare-ma.html                     | ShopPlan: Compare MA  Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC  | shop/estimate/pdp-costs.html                     | ShopPlan: Estimate PDP Plan|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_AMP |AARP  | shop/renew-active.html                           | ShopPlan: Renew-Active|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC | shop/medicare-advantage-veteran-plan.html       | MA Veteran Plan|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS |UHC  | health-plans.html#/plan-summary                  |Shop for a plan|Medicare    |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
   
   @SiteSearchEnroll2_AARP
    Examples: 
    |Scenario  					 | 	site	| path                                    | pageName                   | searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| 
     |E2E Scenario 2_AMP |	AARP	| enroll.html                             | ShopPlan: Enroll           | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |	AARP	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |	AARP	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |	AARP	| enroll/ms-apply.html                    | ShopPlan: Enroll           | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |	AARP	| resources/mail-order-pharmacy.html      | ShopPlan: Resources Mail Order Pharmacy| Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP  |AARP   | contact-us.html                         | Contact us                 | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP |  AARP   |health-plans/estimate-drug-costs.html#/drug-cost-estimator|Drug Cost Estimator|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_AMP|  AARP   |health-plans/aarp-pharmacy.html#/Pharmacy-Search-English|Pharmacy Locator|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
  
  @SiteSearchEnroll2_UHC
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| 
     |	E2E Scenario 2_UMS |	UHC	| enroll.html                             | ShopPlan: Enroll           | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS|	UHC	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS|	UHC	| enroll/ms-apply.html                    | ShopPlan: Enroll           | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC | resources/mail-order-pharmacy.html      | ShopPlan: Resources Mail Order Pharmacy| Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_UMS  |UHC   | contact-us.html                         | Contact us                 | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |E2E Scenario 2_UMS|  UHC   |health-plans/estimate-drug-costs.html#/drug-cost-estimator|Drug Cost Estimator|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |E2E Scenario 2_UMS|  UHC   |health-plans/aarp-pharmacy.html#/Pharmacy-Search-English|Pharmacy Locator|Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
   
    @SiteSearchMedEd2_AARP
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| 
     |	E2E Scenario 2_AMP|	AARP	| medicare-education.html                   | Understanding Medicare      | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-eligibility.html       | Medicare Eligibility       | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-parts-and-.htmlmedigap-plans     | Medicare and Medigap Coverage Options     | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	 AARP	| medicare-education/medicare-benefits.html                 |  Medicare Prescriptions, Providers & Benefits      | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP	| medicare-education/medicare-costs.html                   | Medicare Cost Basics    | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/enrollment-and-changing-plans.html|Medicare Enrollment Basics | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-faq.html|Medicare FAQ | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-advantage-plans.html|Medicare Advantage (Part C) Plans | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-supplement-plans.html|Medicare Supplement Insurance Plans| Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |	E2E Scenario 2_AMP |	AARP  |medicare-education/medicare-part-d.html|Medicare Prescription Drug Plans| Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
 
   @SiteSearchMedEd2_UHC
    Examples: 
     |Scenario             |	site	| path                                    | pageName                   | searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| searchValue |Error | NewSearchValue| 
     |	E2E Scenario 2_UMS |	UHC	| medicare-education.html                   | Understanding Medicare      | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-eligibility.html       | Medicare Eligibility       | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-parts-and-.htmlmedigap-plans     | Medicare and Medigap Coverage Options     | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-benefits.html                 |  Medicare Prescriptions, Providers & Benefits      | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC	| medicare-education/medicare-costs.html                   | Medicare Cost Basics  | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/enrollment-and-changing-plans.html|Medicare Enrollment Basics | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-faq.html|Medicare FAQ |Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-advantage-plans.html|Medicare Advantage (Part C) Plans | Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
     |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-supplement-plans.html|Medicare Supplement Insurance Plans| Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
      |	E2E Scenario 2_UMS |	UHC  |medicare-education/medicare-part-d.html|Medicare Prescription Drug Plans| Medicare  |Empty	  | | Medicare|InvalidCharacter|medicareeee|  Medicare|InvalidCharacter|ggahjkllllllllllllllllllllllllllllllllllllllllllljjjjjjjjjjjjjjjjjjjjjjjjjj| Medicare|InvalidCharacter|Unicorn|
   
     