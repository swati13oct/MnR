@goGreenTestUms
Feature: To test go green on UHC site 
Scenario Outline: Verify go green in UHC site for INDIVIDUAL plan and GROUP plan type member  
Given registered UHC member with following attributes
    | <planType>              |
    | <memberType>            |
When the user views go green in UHC site 
And the user select online delivery preference for Medical Explanation of Benefits (EOB) document    
    | Document Name	      | <documentname>        |
    | Delivery Preferences | <deliverypreferences> |
And the user select updates preferences
    | <updatePreferences>      |        
Then the user validates confirmation message for selected delivery preference with document name in go green
    | Medical Explanation of Benefits (EOB) |
Examples:
    | planType   | memberType  |
    | MA         | Individual  |
    | MAPD       | Individual  |
    | MA         | Group       |
    | MAPD       | Group       |
    
    
Scenario: Verify go green in UHC site for PDP Group plan type member  
Given registered UHC member with following attributes
    | PDP |
When the user views go green in UHC site 
And the user select online delivery preference for Prescription Drug Explanation of Benefits (EOB) document    
    |<onlineSelected>          |
And the user select updates preferences
    | <updatePreferences>      |        
Then the user validates confirmation message for selected delivery preference with document name in go green
    | Prescription Drug Explanation of Benefits (EOB) |
    
    
    
    

    
 
 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 

     

    