@fixedTestCaseTest
@VBF-enrollInPlanUHC
Feature: To test enroll in plan on UHC site
Scenario Outline: Verify enroll in plan in UHC site for federal plan type member  
Given the user is on the UHC medicare solutions landing page
When user performs plan search using following information in UHC site
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site
        | <planName> |
And the user select the answer of this question Do you have End-Stage Renal Disease in UHC site
        |<answer>|
And the user navigates to Benefit information step in UHC site
And the user fill following information in beneficiary information step in UHC site
     | First Name                        | <firstName>                    |
     | Middle Initial                    | <middleInitial>            |
     | Last Name                         | <lastName>                    |
     | Birth Date                        | <birthDate>                    |
     | Gender                            | <selectedGender>            |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
     | Address                           | <address>                    |  
     | Apartment                         | <apartment>                    |
     | City                              | <city>                    |
     | Same Mailing Address                 | Yes                            |
     | Main Phone Number                 | <mainPhoneNumber>            |  
     | Other Phone Number                 | <otherPhoneNumber>            |
     | Email Address                         | <emailAddress>            |
     | Confirm Email Address                 | <confirmEmailAddress>    |
     | Language Preference                 | <languagePreference>     |
And the user navigates to Additional Information step in UHC site
And the user reviews the personal and plan data by navigating to Review application step in UHC site
And the user navigates to submit application step in UHC site
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site
And the user submits application by selecting agree to the Statement of Understanding in UHC site
Then the user validates the enrollment application confirmation in UHC site
    
  Examples:
  |zipcode |countyName   | planType   | planName                                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
 |80002   |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)|No    | First   |  m          |  last  |01/01/1940 |  Male                | 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234            | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |
 |80002  |Adams County | PDP        |AARP MedicareRx Preferred (PDP)                     |No    | miller  |  j          |desh    |11/12/1950 |  Male                | 222-22-2222-C      |07/01/1989                   |07/01/1989                  |7890   | Colorado  | a-12    |  9999922222                |8888811111             | testpdp@uhc.com       | testpdp@uhc.com             |English               | 

Scenario Outline: Verify enroll in plan in UHC site for federal plan type member  
Given the user is on the UHC medicare solutions landing page
When user performs plan search using following information in UHC site
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site
        | <planName> |
And the user select the answer of this question Do you have End-Stage Renal Disease in UHC site
        |<answer>|
And the user navigates to Benefit information step in UHC site
And the user fill following information in beneficiary information step in UHC site
     | First Name                        | <firstName>                    |
     | Middle Initial                    | <middleInitial>            |
     | Last Name                         | <lastName>                    |
     | Birth Date                        | <birthDate>                    |
     | Gender                            | <selectedGender>            |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
     | Address                           | <address>                    |  
     | Apartment                         | <apartment>                    |
     | City                              | <city>                    |
     | Same Mailing Address                 | Yes                            |
     | Main Phone Number                 | <mainPhoneNumber>            |  
     | Other Phone Number                 | <otherPhoneNumber>            |
     | Email Address                         | <emailAddress>            |
     | Confirm Email Address                 | <confirmEmailAddress>    |
     | Language Preference                 | <languagePreference>     |
And the user navigates to Additional Information step in UHC site
And the user reviews the personal and plan data by navigating to Review application step in UHC site
And the user navigates to submit application step in UHC site
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site
And the user submits application by selecting agree to the Statement of Understanding in UHC site
Then the user validates the enrollment application confirmation in UHC site

    
  Examples:
  |zipcode |countyName   | planType   | planName                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  |78006   |Comal County | PDP         |AARP MedicareRx Preferred (PDP)    |No |First   |  m          |  last  |01/01/1940 |  Male                | 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234            | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |
  |90210   |Los Angeles County | PDP         |AARP MedicareRx Preferred (PDP)    |No |First   |  m          |  last  |01/01/1940 |  Male                | 222-22-2222-A      |07/01/1988                   |07/01/1988                  |1234            | Beverly Hills    | UHG       |1111199999      |9999911111      | test@uhc.com   | test@uhc.com        |  English           |

Scenario Outline: Verify enroll in plan  in UHC site for federal plan type member  
Given the user is on the UHC medicare solutions landing page
When user performs plan search using following information in UHC site
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site
        | <planName> |
And the user select the answer of this question Do you have End-Stage Renal Disease in UHC site
        |<answer>|
And the user navigates to Benefit information step in UHC site
And the user fill following information in beneficiary information step in UHC site
     | First Name                        | <firstName>                    |
     | Middle Initial                    | <middleInitial>            |
     | Last Name                         | <lastName>                    |
     | Birth Date                        | <birthDate>                    |
     | Gender                            | <selectedGender>            |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
     | Address                           | <address>                    |  
     | Apartment                         | <apartment>                    |
     | City                              | <city>                    |
     | Same Mailing Address                 | Yes                            |
     | Main Phone Number                 | <mainPhoneNumber>            |  
     | Other Phone Number                 | <otherPhoneNumber>            |
     | Email Address                         | <emailAddress>            |
     | Confirm Email Address                 | <confirmEmailAddress>    |
     | Language Preference                 | <languagePreference>     |
  And the user navigates to Additional Information step in UHC site
  And the user select the answer for special election period in Additional Information
     |<answerForElectionPeriod>|
  And the user select the answer for prescription drug coverage in Additional Information
     |answerPrescriptionSelected|   
  And the user select the answer for long-term care facility question in Additional Information
     |<answerLongTermCareFacilitySelected>| 
  And the user select the answer for medicaid program question in Additional Information
     |<answerStateMedicaidSelected>|
# And the user checks for Primary Care Provider by clicking on look up your provider link
  And the user select the answer for other health insurance question in Additional Information
     |<answerOtherHealthInsurance>|   
# And the user select the answer for this question "Do you want to add a dental supplemental benefit?" in supplemental benefits 
     |<answerRiderSelected>|
    And the user select option for plan payment options
     |<planPaymentOptionSelected>|     
  And the user fill broker id 
     |<brokerId>|  
  And the user reviews the personal and plan data by navigating to Review application step in UHC site
 And the user navigates to submit application step in UHC site
 And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site
 And the user submits application by selecting agree to the Statement of Understanding in UHC site
 Then the user validates the enrollment application confirmation in UHC site
 
  Examples:
            |zipcode |countyName   | planType   | planName                                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |answerForElectionPeriod|answerPrescriptionSelected|answerLongTermCareFacilitySelected|answerStateMedicaidSelected|answerOtherHealthInsurance|answerRiderSelected|planPaymentOptionSelected|brokerId|           
            |80002   |Adams County | MAPD       |AARP MedicareComplete SecureHorizons Plan 2 (HMO)   |No    |  First  |  m          |  last  |01/01/1940 |  Male                | 111-11-1111-A      |07/01/1988                   |07/01/1988          	    |1234     	| Colorado       | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |Yes					   |	Yes				   	  |			No						 |		Yes					 |    No                    |    No             |    Yes                  |brok1234|
    
    
