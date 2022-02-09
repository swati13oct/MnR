#Author: Naveen BK
#created Date:04/06/2020
#nonProd tags used to negate running these flows in offline and prod. - Aayush 10/11
@shopperProfile @nonProd
Feature: 1.09. ACQ- Shopper Profile

  @searchProfileEmail @SanitySP @regressionSP
  Scenario Outline: Telesales agent searching for the profile using Email
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
      | Email              | <email>            |
      | ZipCode            | <zipcode>          |
      | County             | <county>           |
#    Then the user validates the view drug information on Plan Compare page
#      | Drugs | <drugNames> |
    Then the user Select PCP popup modal on Plan Compare page
      | PCPs | <pcps> |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |

    @team-e @regressionSPTeamE @featureGate
    Examples:
      | username | password       | email          | mbi           | dob        | fname | lname | uuid                                 | enrolledplanName | planName                             | zipcode | county          | drugNames | providers | pcps |
      | ocpuser2 | Password@12345 | dax@member.com | 4F78-QY7-CU31 | 08/05/1951 | DAX   | MUNET | 3b2db19f-6e92-49ef-bcf0-b6d1406d1a2c | [blank]          | AARP Medicare Advantage Plan 1 (HMO) | 36132   | New York County | no        | no        | no   |

    @stageSearchProfileEmail @regressionSPStage @sanity @regressionAARP
    Examples:
      | username | password       | email          | mbi           | dob        | fname | lname | uuid                                 | enrolledplanName                                  | planName                             | zipcode | county          | drugNames        | providers                                                        | pcps                                                               |
      | ocpuser2 | Password@12345 | dax@member.com | 4F78-QY7-CU31 | 08/05/1951 | DAX   | MUNET | 11a702c8-7313-4b76-9f3d-0c1932a25740 | UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP) | AARP Medicare Advantage Plan 1 (HMO) | 10010   | New York County | Lipitor TAB 10MG | Niva Shakya MD 825 Euclid Ave # Q112764, Kansas City, MO, 64124; | Niva Shakya MD [825 Euclid Ave # Q112764, Kansas City, MO, 64124]; |

  @searchProfileName
  Scenario Outline: Telesales agent searching for the profile using first name and last name
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Name and Search
      | First Name | <fname> |
      | Last Name  | <lname> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
      | Email              | <email>            |
      | ZipCode            | <zipcode>          |
      | County             | <county>           |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |

    @team-e @regressionSPTeamE @featureGate
    Examples:
      | username | password       | email          | mbi           | dob        | fname | lname | uuid                                 | enrolledplanName | planName                             | zipcode | county          | drugNames | providers |
      | ocpuser2 | Password@12345 | dax@member.com | 4F78-QY7-CU31 | 08/05/1951 | DAX   | MUNET | 03bebc20-b607-4ce8-9ed4-4f090c84fef9 | [blank]          | AARP Medicare Advantage Plan 1 (HMO) | 36132   | New York County | no        | no        |

    @stage123 @regressionSPStage @sanity @regressionAARP
    Examples:
      | username | password       | email          | mbi           | dob        | fname | lname | uuid                                 | enrolledplanName                                  | planName                             | zipcode | county          | drugNames        | providers                                                        | pcps                                                               |
      | ocpuser2 | Password@12345 | dax@member.com | 4F78-QY7-CU31 | 08/05/1951 | DAX   | MUNET | 11a702c8-7313-4b76-9f3d-0c1932a25740 | UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP) | AARP Medicare Advantage Plan 1 (HMO) | 10010   | New York County | Lipitor TAB 10MG | Niva Shakya MD 825 Euclid Ave # Q112764, Kansas City, MO, 64124; | Niva Shakya MD [825 Euclid Ave # Q112764, Kansas City, MO, 64124]; |

  @searchProfileAndAddPlans @SanitySP
  Scenario Outline: Telesales agent searching for the profile using Email and Adding the plans for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
      | Email              | <email>            |
      | ZipCode            | <zipcode>          |
      | County             | <county>           |
    Then agent saves two plans as favorite for user on plan compare page
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page from compare page
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user delets the added plans on visitor profile page
      | Test Plans | <testPlans> |

    @team-e_AddPlans @regressionSPTeamE @featureGate
    Examples:
      | username | password       | email                     | mbi           | dob        | fname  | lname    | uuid                                 | enrolledplanName                               | plantype | planName                             | testPlans                                                                                         | zipcode | county          | drugNames | providers |
      | ocpuser2 | Password@12345 | LXAGFOFOAPWXK6@MASKED.COM | 9EX6-WA2-PQ79 | 12/05/1966 | CHERRY | KUKOWSKI | 5015274f-416c-4ec9-9dcf-e5c3557c3465 | AARP Medicare Advantage Freedom Plus (HMO-POS) | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO) | 90210   | New York County | no        | no        |

    @stage_AddPlans @regressionSPStage @sanity @regressionAARP
    Examples:
      | username | password       | email                     | mbi           | dob        | fname  | lname    | uuid                                 | enrolledplanName                  | plantype | planName                             | testPlans                                                                                         | zipcode | county          | drugNames                                                                                                                                                                                                                                                                                                                                                                                                                                              | providers |
      | ocpuser2 | Password@12345 | LXAGFOFOAPWXK6@MASKED.COM | 9EX6-WA2-PQ79 | 12/05/1966 | CHERRY | KUKOWSKI | 854ac2fc-75dd-4be9-a390-8b2986e33ed5 | AARP Medicare Advantage (HMO-POS) | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO) | 90210   | New York County | calcitriol CAP 0.25MCG,torsemide TAB 100MG,vitamin d CAP 1.25MG,amlodipine besylate TAB 5MG,losartan potassium TAB 50MG,ezetimibe TAB 10MG,Onetouch Ultra TES ULTRA,MODERNA COVID-19 VACCINE SUSPENSION COVID-19,BD Hypodermic Needle Regular Bevel Thin Wall 18G X 1-1/2" MIS 18GX1.5",levothyroxine sodium (tablets) TAB 25MCG,Onetouch Ultra TES ULTRA,Onetouch Ultra TES ULTRA,FLUZONE HIGH-DOSE PF 2021-2022 SUSPENSION PREFILLED SYRINGE 2021-22 | no        |

  @searchProfileAndAddDrugs
  Scenario Outline: Telesales agent searching for the profile using Email and Adding drugs for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then All set and Navigate to Visitor Profile page from compare page
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    And user navigates to Review drug costs page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    And user clicks on Edit Drug and Pharmacy on visitor profile page
    Then the user clicks on Remove button on Drug List page on DCE to delete drug
      | DrugName | <drug1> |

    @team-e_AddDrugs @regressionSPTeamE @featureGate
    Examples:
      | username | password       | email              | mbi           | dob        | fname   | lname    | uuid                                 | plan                                               | plantype | drug1   | dosage   | quantity | frequency     | branded | zipcode |
      | ocpuser2 | Password@12345 | nynette@MEMBER.COM | 2WG7-Q78-WE76 | 08/26/1954 | nynette | washnock | cf845834-6ec0-4feb-877c-966186e1299c | AARP Medicare Advantage SecureHorizons Focus (HMO) | MA       | Lipitor | TAB 10MG | 30       | Every 1 month | yes     | 94019   |

    @stage_AddDrugs @regressionSPStage @sanity @regressionAARP
    Examples:
      | username | password       | email              | mbi           | dob        | fname   | lname    | uuid                                 | plan                                               | plantype | drug1   | dosage   | quantity | frequency     | branded | zipcode |
      | ocpuser2 | Password@12345 | nynette@MEMBER.COM | 2WG7-Q78-WE76 | 08/26/1954 | nynette | washnock | 5240993c-4ca5-41f2-8e16-f05272590b43 | AARP Medicare Advantage SecureHorizons Focus (HMO) | MA       | Lipitor | TAB 10MG | 30       | Every 1 month | yes     | 94019   |

  @searchProfileAndProviderFlow @UATSpartans
  Scenario Outline: Telesales agent searching for the profile using Email and Add a provider for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then All set and Navigate to Visitor Profile page from compare page
    When user selects a provider and retuns to Profile page
    Then Verify X out of Y provider covered information is displayed on visitor profile page
      | PlanName | <planname> |
    And user delets all the added providers on visitor profile page
      | PlanName | <planname> |

    @team-e_AddProvider @regressionSPTeamE @featureGate
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname   | uuid                                 | enrolledplanName                                    | planname                                            | plantype | drugNames | providers |
      | ocpuser2 | Password@12345 | nanine@member.com | 3XQ9-C41-RQ43 | 03/10/1949 | 80229   | NANINE | SLOVICK | 473768c6-466d-4a32-9c3b-2c66b712aaf4 | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | MAPD     | No        | No        |

    @stage_AddProvider @regressionSPStage @sanity @regressionAARP
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname   | uuid                                 | enrolledplanName                                    | planname                                            | plantype | drugNames | providers |
      | ocpuser2 | Password@12345 | nanine@member.com | 3XQ9-C41-RQ43 | 03/10/1949 | 80229   | NANINE | SLOVICK | 4463d5a0-0b79-477e-a3cc-b2e3d19aa5a9 | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | MAPD     | No        | No        |

  @searchProfileAndEnroll
  Scenario Outline: Telesales agent searching for the profile using first name and last name and validate OLE flow is not allowed
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then All set and Navigate to Visitor Profile page from compare page
    And enroll In Plan should not be clickable on Visitor Profile page in Agent mode

    @team-e_searchProfileAndEnroll @regressionSPTeamE @featureGate
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planname                                | plantype | drugNames | providers |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | 473768c6-466d-4a32-9c3b-2c66b712aaf4 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        |

    @stage_searchProfileAndEnroll @regressionSPStage @regressionAARP
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planname                                | plantype | drugNames | providers |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        |

  @searchProfileAndVPPPlanDetail
  Scenario Outline: Telesales agent searching for the profile using first name and last name and validate additional benefits on Plan Details
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then All set and Navigate to Visitor Profile page from compare page
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

    @team-e_searchProfileAndVPPPlanDetail @regressionSPTeamE @featureGatePRB
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planName                                | plantype | drugNames | providers | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        | Eyewear            | $0 copay every 2 years; up to $150 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

    @stage_searchProfileAndVPPPlanDetail @regressionSPStage @regressionAARP
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planName                                | plantype | drugNames | providers | eyeWearBenefitType | eyeWearExpectedText                                                                                                                             | eyeExamBenefitType | eyeExamExpectedText    | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        | Eyewear            | $0 copay every 2 years; up to $150 for frames or contact lenses. Standard single, bifocal, trifocal, or progressive lenses are covered in full. | Eye Exam           | $0 copay; 1 every year | Foot Care - Routine        | $45 copay                   | Hearing Exam           | $0 copay                |

  @createProfileMemberSP @regressionSPStage @regressionAARP @featureGate
  Scenario Outline: Telesales agent searching for the Creating a profile - email - <email>
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address
      | Email | <email> |
    And click on Create Profile button
    Then create a profile with the following details
      | Email      | <email>   |
      | DOB        | <dob>     |
      | MBI        | <mbi>     |
      | First Name | <fname>   |
      | Last Name  | <lname>   |
      | Zipcode    | <zipCode> |
      | Gender     | <gender>  |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
      | Email              | <email>            |
      | ZipCode            | <zipcode>          |
      | County             | <county>           |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |

    Examples:
      | username | password       | email                    | dob        | mbi           | gender | fname   | lname      | zipCode | enrolledplanName  | planName                                                         | drugNames | providers |
      | ocpuser2 | Password@12345 | TESTMAINTAINDEMO@GPS.COM | 06/04/1938 | 7GE4-FF9-HG07 | male   | MANISHA | BOOKWALTER | 33134   | MedicareMax (HMO) | MedicareMax (HMO)                                                | No        | No        |
      | ocpuser2 | Password@12345 | LEONEL@MEMBER.COM        | 08/23/1940 | [blank]       | male   | LEONEL  | DREHMER    | 10010   | [blank]           | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | No        | No        |

  @createProfileNonMemberSP @regressionSPStage @regressionAARP @featureGate
  Scenario Outline: Telesales agent Creating a Non Member Profile - email - <email>
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address
      | Email | <email> |
    And click on Create Profile button
    Then create a profile with the following details
      | Email      | <email>   |
      | DOB        | <dob>     |
      | MBI        | <mbi>     |
      | First Name | <fname>   |
      | Last Name  | <lname>   |
      | Zipcode    | <zipCode> |
      | Gender     | <gender>  |
    Then I land on the plan compare page for NonMember
      | Plan Name  | <planName>  |
      | Drugs      | <drugNames> |
      | Providers  | <providers> |
      | First Name | <fname>     |
      | Last Name  | <lname>     |
      | DOB        | <dob>       |
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then I land on the plan summary page of VPP for NonMember
      | Plan Name  | <planName>  |
      | Drugs      | <drugNames> |
      | Providers  | <providers> |
      | First Name | <fname>     |
      | Last Name  | <lname>     |

    Examples:
      | username | password       | email                  | dob        | mbi | gender | fname    | lname    | zipCode | planName                             | drugNames                                                                                                                                                                                          | providers                                                                                                                                                                                                                                                  |
      | ocpuser2 | Password@12345 | DFONNMUF@NONMEMBER.COM | 08/20/1946 |     | female | DFONNMUF | DFONNMUL | 10010   | AARP Medicare Advantage Plan 1 (HMO) | nitrofurantoin monohydrate/macrocrystals CAP 100MG,ciprofloxacin hcl TAB 500MG,trazodone hcl TAB 50MG,simvastatin TAB 20MG,nifedipine TAB 60MG ER Osmotic,levothyroxine sodium (tablets) TAB 75MCG | Maria S Neri-Nixon:33100 Cleveland Clinic Blvd, Lorain, OH, 44011;Ronald L Garcia:33100 Cleveland Clinic Blvd, Lorain, OH, 44011;Ronald L Garcia:850 Columbia Rd Ste 120, Cuyahoga, OH, 44145;Ronald L Garcia:850 Columbia Rd Ste 130, Cuyahoga, OH, 44145 |

  @PlanDetailPlanCompare @PRB0993334 @UATSpartans
  Scenario Outline: Telesales agent validate navigation from plan details to plan compare
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
      | Email              | <email>            |
      | ZipCode            | <zipcode>          |
      | County             | <county>           |
    Then the user clicks on Plan details link in new Plan Compare page
    Then validate all available plans are shown on click of browser back

    @team-e_searchProfileAndVPPPlanDetail @regressionSPTeamE
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planName                                | plantype | drugNames | providers |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        |

    @stage_searchProfileAndVPPPlanDetail @PRB0993334
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planName                                | plantype | drugNames | providers |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        |

  @SPBaseLinePopup @F700755 @UATSpartans
  Scenario Outline: Telesales agent validate navigation from plan details to plan compare
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
      | First Name   | <fname>   |
      | Last Name    | <lname>   |
      | DOB          | <dob>     |
      | MBI          | <mbi>     |
      | Email        | <email>   |
      | ZipCode      | <zipcode> |
      | County       | <county>  |
      | Profile UUID | <uuid>    |
    Then I land on the plan compare page
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
      | First Name         | <fname>            |
      | Last Name          | <lname>            |
      | DOB                | <dob>              |
      | MBI                | <mbi>              |
      | Email              | <email>            |
      | ZipCode            | <zipcode>          |
      | County             | <county>           |
    Then validate base line benefit popup
      | Plan Name              | <planName>             |
      | Medical Deductible     | <medicalDeductible>    |
      | Primary Care Physician | <primaryCarePhysician> |
      | Specialist             | <specialist>           |

    @team-e_searchProfileAndVPPPlanDetail @regressionSPTeamE
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planName                                | plantype | drugNames | providers | medicalDeductible | primaryCarePhysician          | specialist                     |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        | In: $0 / Out: $0  | In: $0 copay / Out: $25 copay | In: $45 copay / Out: $65 copay |

    @stage_searchProfileAndVPPPlanDetail @SPBaseLinePopupStage
    Examples:
      | username | password       | email             | mbi           | dob        | zipcode | fname  | lname  | uuid                                 | enrolledplanName                     | planName                                | plantype | drugNames | providers | medicalDeductible | primaryCarePhysician          | specialist                     |
      | ocpuser2 | Password@12345 | tyrone@member.com | 3C36-J24-EH68 | 01/06/1950 | 97426   | TYRONE | QUARRY | b726de44-ee3e-4696-90f4-5c1b00f0d972 | AARP Medicare Advantage Plan 2 (HMO) | AARP Medicare Advantage Walgreens (PPO) | MAPD     | No        | No        | In: $0 / Out: $0  | In: $0 copay / Out: $25 copay | In: $45 copay / Out: $65 copay |
