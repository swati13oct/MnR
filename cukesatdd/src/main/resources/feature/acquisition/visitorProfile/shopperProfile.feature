#Author: Naveen BK
#created Date:04/06/2020
@ShopperProfile @regressionAARP
Feature: 1.09. ACQ- Shopper Profile

  @searchProfileEmail @SanitySP @sanity @test123
  Scenario Outline: Telesales agent searching for the profile using Email
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |

    Examples: 
      | username  | password  | email          | mbi           | dob        | fname | lname | enrolledplanName                                  | planName                             | drugNames        | providers                                                                                                                  |
      | qavgogine | qavgogine | DAX@MEMBER.COM | 4F78-QY7-CU31 | 08/05/1951 | DAX   | MUNET | UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP) | AARP Medicare Advantage Plan 1 (HMO) | Lipitor TAB 10MG | Margaret S Miklic:3686 Grandview Pkwy Ste 300, Jefferson, AL, 35243;David J Knapp:1245 E South Blvd, Montgomery, AL, 36116 |

  @searchProfileName
  Scenario Outline: Telesales agent searching for the profile using first name and last name
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Name and Search
      | First Name | <fname> |
      | Last Name  | <lname> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planName> |
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal
    Then the user closes the Drug Info Modal on Plan Compare page
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |

    Examples: 
      | username  | password  | fname | lname | mbi           | dob        | enrolledplanName                                  | planName                             | drugNames        | providers                                                                                                                  |
      | qavgogine | qavgogine | DAX   | MUNET | 4F78-QY7-CU31 | 08/05/1951 | UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP) | AARP Medicare Advantage Plan 1 (HMO) | Lipitor TAB 10MG | Margaret S Miklic:3686 Grandview Pkwy Ste 300, Jefferson, AL, 35243;David J Knapp:1245 E South Blvd, Montgomery, AL, 36116 |

  @searchProfileAndAddPlans @SanitySP @sanity
  Scenario Outline: Telesales agent searching for the profile using Email and Adding the plans for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
    Then agent saves two plans as favorite for user
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user delets the added plans on visitor profile page
      | Test Plans | <testPlans> |

    Examples: 
      | username  | password  | email                     | fname  | lname    | mbi           | dob        | plantype | enrolledplanName                  | planName                             | drugNames | providers | testPlans                                                                 |
      | qavgogine | qavgogine | LXAGFOFOAPWXK6@MASKED.COM | CHERRY | KUKOWSKI | 9EX6-WA2-PQ79 | 12/05/1966 | MAPD     | AARP Medicare Advantage (HMO-POS) | AARP Medicare Advantage Plan 1 (HMO) | No        | No        | AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO) |

  @searchProfileAndAddDrugs
  Scenario Outline: Telesales agent searching for the profile using Email and Adding drugs for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then Navigate to Visitor Profile page from compare page
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    And user clicks on Edit Drug and Pharmacy on visitor profile page
    Then the user clicks on Remove button on Drug List page on DCE to delete drug
      | DrugName | <drug1> |

    Examples: 
      | username  | password  | email              | plan                                               | plantype | drug1   | dosage   | quantity | frequency     | branded | zipCode |
      | qavgogine | qavgogine | nynette@MEMBER.COM | AARP Medicare Advantage SecureHorizons Focus (HMO) | MA       | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   94019 |

  @searchProfileAndProviderFlow
  Scenario Outline: Telesales agent searching for the profile using Email and Add a provider for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then the user clicks on back on all plan linnk in Plan Compare page
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page
    Then Verify X out of Y provider covered information is displayed on visitor profile page
      | PlanName | <planname> |
    And user delets all the added providers on visitor profile page
      | PlanName | <planname> |

    Examples: 
      | username  | password  | email             | fname  | lname   | mbi           | dob        | plantype | enrolledplanName                                    | planname                                            | drugNames | providers |
      | qavgogine | qavgogine | nanine@member.com | NANINE | SLOVICK | 3XQ9-C41-RQ43 | 03/10/1949 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | No        | No        |

  @searchProfileAndEnroll
  Scenario Outline: Telesales agent searching for the profile using first name and last name and validate OLE flow is not allowed
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then Navigate to Visitor Profile page from compare page
    And enroll In Plan should not be clickable on Visitor Profile page in Agent mode

    Examples: 
      | username  | password  | email             | fname  | lname  | mbi           | dob        | plantype | enrolledplanName                     | planName                                | drugNames | providers |
      | qavgogine | qavgogine | tyrone@member.com | TYRONE | QUARRY | 3C36-J24-EH68 | 01/06/1950 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | No        | No        |

  @searchProfileAndVPPPlanDetail
  Scenario Outline: Telesales agent searching for the profile using first name and last name and validate additional benefits on Plan Details
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then Navigate to Visitor Profile page from compare page
    And user clicks on plan name
      | Test Plans | <planName> |
    Then the user validates the following Additional Benefits of Plan for the plan
      | Eye Wear Benefit Type           | <eyeWearBenefitType>          |
      | Eye Wear Expected Text          | <eyeWearExpectedText>         |
      | Eye Exam Benefit Type           | <eyeExamBenefitType>          |
      | Eye Exam Expected Text          | <eyeExamExpectedText>         |
      | Foot Care Routine Benefit Type  | <footCareRoutineBenefitType>  |
      | Foot Care Routine Expected Text | <footCareRoutineExpectedText> |
      | Hearing Exam Benefit Type       | <hearingExamBenefitType>      |
      | Hearing Exam Expected Text      | <hearingExamExpectedText>     |

    Examples: 
      | username  | password  | email             | fname  | lname  | mbi           | dob        | plantype | enrolledplanName                     | planName                                | drugNames | providers | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | qavgogine | qavgogine | tyrone@member.com | TYRONE | QUARRY | 3C36-J24-EH68 | 01/06/1950 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | No        | No        | Eyewear            | $0 copay every 2 years; up to $150 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

  @searchProfileEmptyFields
  Scenario Outline: Telesales agent searching for the profile using empty Email,firstname and lastname
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then validate empty email firstname and lastname

    Examples: 
      | username  | password  |
      | qavgogine | qavgogine |

  @searchProfileInvalidEmail
  Scenario Outline: Telesales agent searching for the profile using invalid Email
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then validate invalid email
      | Email | <email> |

    Examples: 
      | username  | password  | email     |
      | qavgogine | qavgogine | yy!ue.com |

  @searchProfileInvalidFnameLname
  Scenario Outline: Telesales agent searching for the profile using invalid first name and lastname
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then validate invalid first name and last name
      | First Name | <fname> |
      | Last Name  | <lname> |

    Examples: 
      | username  | password  | fname    | lname     |
      | qavgogine | qavgogine | !!AURORA | SHEPLEY__ |

  @createProfileMember
  Scenario Outline: Telesales agent searching for the Creating a profile - email - <email>
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address
      | Email | <email> |
      | DOB   | <dob>   |
      | MBI   | <mbi>   |
    And click on Create Profile button
    Then create a profile with the following details
      | Email      | <email>   |
      | DOB        | <dob>     |
      | MBI        | <mbi>     |
      | First Name | <fname>   |
      | Last Name  | <lname>   |
      | Zipcode    | <zipCode> |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |

    Examples: 
      | username  | password  | email                    | dob        | mbi           | fname   | lname      | zipCode | enrolledplanName                          | planName                                                         | drugNames | providers                                                       |
      | qavgogine | qavgogine | TESTMAINTAINDEMO@GPS.COM | 06/04/1938 | 7GE4-FF9-HG07 | MANISHA | BOOKWALTER |   33134 | Medica HealthCare Plans MedicareMax (HMO) | Medica HealthCare Plans MedicareMax (HMO)                        | No        | Luis Plasencia:8420 W Flagler St Ste 120, Miami-Dade, FL, 33144 |
      | qavgogine | qavgogine | LEONEL@MEMBER.COM        | 08/23/1940 | [blank]       | LEONEL  | DREHMER    |   10010 | [blank]                                   | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | No        | No                                                              |

  @createProfileNonMember
  Scenario Outline: Telesales agent Creating a Non Member Profile - email - <email>
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address for NonMember
      | Email      | <email> |
      | DOB        | <dob>   |
      | First Name | <fname> |
      | Last Name  | <lname> |
    And click on Create Profile button for NonMember
    Then create a profile with the following details for NonMember
      | Email      | <email>   |
      | DOB        | <dob>     |
      | Gender     | <gender>  |
      | First Name | <fname>   |
      | Last Name  | <lname>   |
      | Zipcode    | <zipCode> |
      | Consent    | <consent> |
    Then I land on the plan compare page for NonMember
      | Plan Name  | <planName>  |
      | Drugs      | <drugNames> |
      | Providers  | <providers> |
      | First Name | <fname>     |
      | Last Name  | <lname>     |
      | DOB        | <dob>       |
      | MBI        | <mbi>       |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP for NonMember
      | Plan Name  | <planName>  |
      | Drugs      | <drugNames> |
      | Providers  | <providers> |
      | First Name | <fname>     |
      | Last Name  | <lname>     |

    Examples: 
      | username  | password  | email                  | dob        | gender | fname    | lname    | zipCode | consent | planName                             | drugNames                                                                                                                                                                                 | providers                                                                                                                                                                                     |
      | qavgogine | qavgogine | DFONNMUF@NONMEMBER.COM | 08/20/1946 | F      | DFONNMUF | DFONNMUL |   10010 | YES     | AARP Medicare Advantage Plan 1 (HMO) | nifedipine TAB 60MG ER Osmotic,simvastatin TAB 20MG,trazodone hcl TAB 50MG,levothyroxine sodium TAB 100MCG,nitrofurantoin monohydrate/macrocrystals CAP 100MG,ciprofloxacin hcl TAB 500MG | Maria S Neri-Nixon:33100 Cleveland Clinic Blvd, Lorain, OH, 44011;Ronald L Garcia:33100 Cleveland Clinic Blvd, Lorain, OH, 44011;Ronald L Garcia:850 Columbia Rd Ste 130, Cuyahoga, OH, 44145 |
      | qavgogine | qavgogine | DFPIXROF@NONMEMBER.COM | 11/03/1943 | F      | DFPIXROF | DFPIXROL |   10010 | NO      | AARP Medicare Advantage Plan 1 (HMO) | No                                                                                                                                                                                        | No                                                                                                                                                                                            |
