#Author: Naveen BK
#created Date:04/06/2020
@ShopperProfile
Feature: 1.08. ACQ- Shopper Profile

  @searchProfileEmail
  Scenario Outline: Telesales agent searching for the profile using Email
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |

    Examples: 
      | username  | password  | email                  | enrolledplanName                                     | planName                                             | drugNames | providers             |
      | qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | AARP Medicare Advantage SecureHorizons Premier (HMO) | AARP Medicare Advantage SecureHorizons Premier (HMO) | No        | SCRIPPS CLINIC/SANTEE |

  @searchProfileName
  Scenario Outline: Telesales agent searching for the profile using first name and last name
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Name and Search
      | First Name | <fname> |
      | Last Name  | <lname> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |

    Examples: 
      | username  | password  | fname  | lname   | enrolledplanName                                     | planName                                             | drugNames | providers             |
      | qavgogine | qavgogine | AURORA | SHEPLEY | AARP Medicare Advantage SecureHorizons Premier (HMO) | AARP Medicare Advantage SecureHorizons Premier (HMO) | No        | SCRIPPS CLINIC/SANTEE |

  @searchProfileAndAddPlans
  Scenario Outline: Telesales agent searching for the profile using Email and Adding the plans for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
    Then agent saves two plans as favorite on AARP site for user
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    And user delets the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |

    Examples: 
      | username  | password  | email                     | plantype | enrolledplanName                  | planName                                | drugNames | providers                 | testPlans                                                                    |
      | qavgogine | qavgogine | LXAGFOFOAPWXK6@MASKED.COM | MAPD     | AARP Medicare Advantage (HMO-POS) | AARP Medicare Advantage Focus (HMO-POS) | No        | ALLA, M.D., SREENIVASA R. | AARP Medicare Advantage Focus (HMO-POS),AARP Medicare Advantage Choice (PPO) |

  @searchProfileAndAddDrugs
  Scenario Outline: Telesales agent searching for the profile using Email and Adding drugs for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    And user access DCE tool on aarp site
      | Plan Type | <plantype> |
      | PlanName  | <plan>     |
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And I select the first pharmacy
    And I navigate to step3 page and validate
      | Drug | <drug> |
    And the user clicks on the shopping cart icon on DCE page in AARP
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drug | <drug> |
    And user delets all the added drugs on visitor profile page of AARP site

    Examples: 
      | username  | password  | email                 | plan                                    | plantype | drug    | dosage   | quantity | frequency     | branded |
      | qavgogine | qavgogine | FAN.HGHBMR@MASKED.COM | AARP Medicare Advantage Walgreens (PPO) | MA       | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |

  @searchProfileAndProviderFlow
  Scenario Outline: Telesales agent searching for the profile using Email and Add a provider for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then agent saves two plans as favorite on AARP site for user
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page on AARP site
    Then Verify X out of Y provider covered information is displayed on visitor profile page of AARP site
      | PlanName | <planname> |
    And user delets the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    And user delets all the added providers on visitor profile page of AARP site

    Examples: 
      | username  | password  | email               | plantype | planname                                            | testPlans                                                                                               |
      | qavgogine | qavgogine | MACHELLE@MEMBER.COM | MAPD     | Sharp SecureHorizons Plan by UnitedHealthcare (HMO) | Sharp SecureHorizons Plan by UnitedHealthcare (HMO),AARP Medicare Advantage SecureHorizons Plan 4 (HMO) |

  @searchProfileAndEnroll
  Scenario Outline: Telesales agent searching for the profile using Email and validate OLE flow is not allowed
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |
    Then agent saves two plans as favorite on AARP site for user
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page on AARP site
    And enroll In Plan should not be clickable on Visitor Profile page in Agent mode

    Examples: 
      | username  | password  | email                  | plantype | enrolledplanName                                     | planName                                            | drugNames | providers      | testPlans                                                                                               |
      | qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | MAPD     | AARP Medicare Advantage SecureHorizons Premier (HMO) | Sharp SecureHorizons Plan by UnitedHealthcare (HMO) | No        | SHAHBAZ, MAJID | Sharp SecureHorizons Plan by UnitedHealthcare (HMO),AARP Medicare Advantage SecureHorizons Plan 4 (HMO) |

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
  Scenario Outline: Telesales agent searching for the Creating a profile
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address
      | Email | <email> |
      | DOB   | <dob>   |
      | MBI   | <mbi>   |
    And click on Create Profile button
    Then create a profile with the following details
      | Email      | <email> |
      | DOB        | <dob>   |
      | MBI        | <mbi>   |
      | First Name | <fname> |
      | Last Name  | <lname> |
    Then I land on the plan summary page of VPP
      | Enrolled Plan Name | <enrolledplanName> |
      | Plan Name          | <planName>         |
      | Drugs              | <drugNames>        |
      | Providers          | <providers>        |

    Examples: 
      | username  | password  | email                      | dob        | mbi           | fname   | lname      | enrolledplanName                                 | planName                                         | drugNames | providers             |
      | qavgogine | qavgogine | q4_rx_claims_056@gmail.com | 08/10/1933 | 2QY5-RF1-FJ55 | LIDIJA  | MASONE     | UnitedHealthcare Medicare Advantage Assure (HMO) | UnitedHealthcare Medicare Advantage Assure (HMO) | No        | JENSON, PETER M       |
      | qavgogine | qavgogine | TESTMAINTAINDEMO@GPS.COM   | 06/04/1938 | 7GE4-FF9-HG07 | MANISHA | BOOKWALTER | Medica HealthCare Plans MedicareMax (HMO)        | Medica HealthCare Plans MedicareMax (HMO)        | No        | PLASENCIA, M.D., LUIS |

  @createProfileNonMember
  Scenario Outline: Telesales agent Creating a Non Member Profile
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
    Then I land on the plan summary page of VPP for NonMember
      | Plan Name | <planName>  |
      | Drugs     | <drugNames> |
      | Providers | <providers> |

    Examples: 
      | username  | password  | email                  | dob        | gender | fname    | lname    | zipCode | planName                             | drugNames                                                                                                                                    | providers                                 |
      | qavgogine | qavgogine | DFPIXSWF@NONMEMBER.COM | 01/10/1950 | M      | DFPIXSWF | DFPIXSWL |   10010 | AARP Medicare Advantage Plan 1 (HMO) | 1ST Medx-Patch/Lidocaine PAD LIDOCAIN,quinapril hcl TAB 40MG,atorvastatin calcium TAB 10MG,sildenafil citrate TAB 20MG,amoxicillin TAB 875MG | Richard Vacca,Alfred Rogers,Robert Sperry |
