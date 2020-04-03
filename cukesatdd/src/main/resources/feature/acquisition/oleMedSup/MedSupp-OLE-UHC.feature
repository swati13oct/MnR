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
     Then the user enters data to resume the application
       | applicationType           | <applicationType>|
       | ApplicationID |<ApplicationID>|
       | DOB           | <DOB>         |
       | Zipcode       | <zipcode>     |   
      Then The user validates the resume application processed
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
      
      
       Examples: 
      | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType |
      |   90002 | NO              | Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |
     
  
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
   
      
           @MedSuppOLEBLayerSmoke
 Scenario Outline: MedSup OLE End to end from UHC Acquisition site VPP Plan Summary
 Given the user is on UHC medicare acquisition site page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
     Then user clicks on Start Application Button proceed to next pages
      | Zip Code        | <zipcode>         |
       | DOB           | <DOB>         |
      When user fill medsupp form details and proceed to next pages  
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    | 
      Then User navigates to plan summary page of AARP site 
   Examples: 
     | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname  | 
     |   90002 | NO              | Los Angeles County | MS       | 11/11/1940 | test     | test   |
      
      
      
      
      
      
      
      
      
      
      
      
      