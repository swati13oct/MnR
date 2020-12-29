Feature: 1.06-UAT Scripts to test Federal Agent Link and request an appointment with an agent flow on vpp Pages

Scenario Outline: <scenario> Verify request an <plantype> appointment through <site>
		Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
		And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
    Then the user enters following information in Request Plan Information Guide
    	    | Firstname     | <Firstname>   |
          | Lastname      | <Lastname>    |
          | Email         | <email>       |
   	
   	@requestPlanInformationBlayer
    Examples: 
      |scenario                                       |	site	|PlanType |planyear|planYear|zipcode    | isMultutiCounty | county          | plantype |planyear|Firstname|Lastname|email|
      |Request plan information scenario 1 _AARP			|	AARP	|MA-MBI   |future  |future  |			10001 | NO              | New York County | MA       | future |Test_Portals_J|Test_Portals_K|venkata.kanagala@optum.com|
   
   @requestPlanInformationUlayer
    Examples: 
      |scenario                                       |	site	|PlanType |planyear|planYear|zipcode    | isMultutiCounty | county          | plantype |planyear|Firstname|Lastname|email|
      |Request plan information scenario 1 _UHCMS			|	UHC 	|MA-MBI   |future  |future  |			10001 | NO              | New York County | MA       | future |Test_Portals_J|Test_Portals_K|venkata.kanagala@optum.com|
    

Scenario Outline: <scenario> Verify request an <plantype>appointment through <site>
		Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
		And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
    Then the user enters following information in Request Plan Information Guide
    	    | Firstname     | <Firstname>   |
          | Lastname      | <Lastname>    |
          | Email         | <email>       |
   	
   	@requestPlanInformationBlayer
    Examples: 
      |scenario                                       |	site	|PlanType |planyear|planYear|zipcode    | isMultutiCounty | county          | plantype |planyear|Firstname|Lastname|email|
      |Request plan information scenario 1 _AARP			|	AARP	|PDP-MBI   |future  |future  |			10001 | NO              | New York County | PDP        | future |Test_Portals_J|Test_Portals_K|venkata.kanagala@optum.com|
   
   @requestPlanInformationUlayer
    Examples: 
      |scenario                                       |	site	|PlanType |planyear|planYear|zipcode    | isMultutiCounty | county          | plantype |planyear|Firstname|Lastname|email|
      |Request plan information scenario 1 _UHCMS			|	UHC	|PDP-MBI   |future  |future  |			10001 | NO              | New York County | PDP        | future |Test_Portals_J|Test_Portals_K|venkata.kanagala@optum.com|
    

    
    Scenario Outline: <scenario> Verify request <plantype> an appointment through <site>
		Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
		And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
    Then the user enters following information in Request Plan Information Guide
    	    | Firstname     | <Firstname>   |
          | Lastname      | <Lastname>    |
          | Email         | <email>       |
   	
   	@requestPlanInformationBlayer
    Examples: 
      |scenario                                       |	site	|PlanType |planyear|planYear|zipcode    | isMultutiCounty | county          | plantype |planyear|Firstname|Lastname|email|
      |Request plan information scenario 1 _AARP			|	AARP	|PCP-DSNP-MBI   |future  |future  |			10001 | NO              | New York County | SNP       | future |Test_Portals_J|Test_Portals_K|venkata.kanagala@optum.com|
   
   @requestPlanInformationUlayer
    Examples: 
      |scenario                                       |	site	|PlanType |planyear|planYear|zipcode    | isMultutiCounty | county          | plantype |planyear|Firstname|Lastname|email|
      |Request plan information scenario 1 _UHCMS			|	UHC	|PCP-DSNP-MBI    |future  |future  |			10001 | NO              | New York County | SNP       | future |Test_Portals_J|Test_Portals_K|venkata.kanagala@optum.com|
    
    