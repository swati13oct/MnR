@CT @OLE_UHC @OLE_VPP_UHC_ResumeApplication
Feature: 2.06. ACQ-OLE Resume and Retrieve Application UMS

@OLE_VPP_UHC @UHC_Resume_App_UHC @OLE_Regression @oleMedSupBlayer @prodRegression
    Scenario Outline: MedSup Resume Application with Application ID
 Given the user is on the uhcmedicaresolutions site landing page
   When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
     When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     Then the UHC user clicks on Start Application Button proceed to next pages for getting resume application key
       | DOB           | <DOB>         |
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
       | Zipcode       | <zipcode>     | 
     Then the user navigates to next page to locate resume application button
   	 	| DOB               | <DOB>         |
   	 	#| Firstname     | <Firstname>   |
       #| Lastname      | <Lastname>    |
       Then the user signs in with optum Id credentials to resume application in UHC site
      | User Name | <userName> |
      | Password  | <password> |	
     Then the user enters data to resume the application
       | applicationType           | <applicationType>|
      | ApplicationID |<ApplicationID>|
       | DOB           | <DOB>         |
       | Zipcode       | <zipcode>     |   
      Then The user validates the resume application processed
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
      
      
       Examples: 
      | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType |userName | password  |
      |   90002 | NO              | Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |mnrqavd  | Password@1 | 
     
  
@UHC_Retrive_App_UHC @OLE_Regression @oleMedSupBlayer
 Scenario Outline: MedSup Retrieve Application with Application ID
 Given the user is on the uhcmedicaresolutions site landing page
   When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the UHC user clicks on Start Application Button proceed to next pages for getting resume application key
       | DOB           | <DOB>         |
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
       | Zipcode       | <zipcode>     |
   Then the user will navigate to locate resume application button
   	 	| DOB               | <DOB>         |
   	 	| Zipcode           | <zipcode>     |
     Then the user enters data to resume the application
       | ApplicationID     | <ApplicationID>   |
       | DOB               | <DOB>         |
       | zipcode           | <zipcode>     |
       | applicationType           | <applicationType>     |
      
      Then The user validates the Retrive application
    | ApplicationID     | <ApplicationID>   |
     
       Examples: 
     | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname  |  ApplicationID   | applicationType |
     |   90002 | NO              | Los Angeles County | MS       | 11/13/1940 | Donald     | Abrahm   |   E-PMO6-T5HH-78  | Retrieve         |
   
      
  
      
      
      
      
      