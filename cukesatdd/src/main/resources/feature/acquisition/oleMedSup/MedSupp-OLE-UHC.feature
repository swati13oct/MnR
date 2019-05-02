@CT @OLE_UHC @OLE_VPP_UHC_ResumeApplication
Feature: VPP OLE 3.0 Flow � Resume/Retrieve  Application in progress

@OLE_VPP_UHC @UHC_Resume_App_UHC @OLE_Regression   
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
     Then the user clicks on resume application button
     Then the user enters data to resume the application
       | applicationType           | <applicationType>|
       | ApplicationID |<ApplicationID>|
       | DOB           | <DOB>         |
       | zipcode       | <zipcode>     |
       
      
      Then The user validates the resume application processed
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
      
      
       Examples: 
      | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType |
      |   90210 | NO              | Los Angeles County | MS       | 11031950 | John      | Carry   |    ABCD        | Resume          |
     
  
@UHC_Retrive_App_UHC @OLE_Regression
 Scenario Outline: MedSup Retrieve Application with Application ID
 Given the user is on the uhcmedicaresolutions site landing page
   When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      
   Then the user clicks on resume application button
     Then the user enters data to resume the application
       | ApplicationID     | <ApplicationID>   |
       | DOB               | <DOB>         |
       | zipcode           | <zipcode>     |
       | applicationType           | <applicationType>     |
      
      Then The user validates the Retrive application
    | ApplicationID     | <ApplicationID>   |
     
       Examples: 
     | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname  |  ApplicationID   | applicationType |
     |   90210 | NO              | Los Angeles County | MS       | 11031950 | Donald     | Abrahm   |   E-PMO6-T5HH-78  | Retrive          |
   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      