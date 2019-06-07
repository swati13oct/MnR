@vppPlanDetailsUlayer
Feature: 1.09-Acq-To test plan details in vpp flow AARP site

  @vppPlanDetailsRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific Additional Benefits in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates the following Additional Benefits of Plan for the plan in AARP
      | Eye Wear Benefit Type                                     | <eyeWearBenefitType>                              |
      | Eye Wear Expected Text                                    | <eyeWearExpectedText>                             |
      | Dental Benefit Type                                       | <dentalBenefitType>                               |
      | Dental Expected Text                                      | <dentalExpectedText>                              |
      | Transportation Benefit Type                               | <transportationBenefitType>                       |
      | Transportation Expected Text                              | <transportationExpectedText>                      |
      | ChiropracticCare Benefit Type                             | <chiropracticCareBenefitType>                     |
      | ChiropracticCare Expected Text                            | <chiropracticCareExpectedText>                    |
      | Acupuncture Benefit Type                                  | <acupunctureBenefitType>                          |
      | Acupuncture Expected Text                                 | <acupunctureExpectedText>                         |
      | Eye Exam Benefit Type                                     | <eyeExamBenefitType>                              |
      | Eye Exam Expected Text                                    | <eyeExamExpectedText>                             |
      | Foot Care Routine Benefit Type                            | <footCareRoutineBenefitType>                      |
      | Foot Care Routine Expected Text                           | <footCareRoutineExpectedText>                     |
      | Hearing Exam Benefit Type                                 | <hearingExamBenefitType>                          |
      | Hearing Exam Expected Text                                | <hearingExamExpectedText>                         |
      | Membership in Health Club / Fitness Classes Benefit Type  | <membershipinHealthClubFitnessClassesBenefitType> |
      | Membership in Health Club / Fitness Classes Expected Text | <membershipinHealthClubFitnessExpectedText>       |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                     | eyeWearBenefitType | eyeWearExpectedText                                                                          | dentalBenefitType | dentalExpectedText                                                        | transportationBenefitType | transportationExpectedText                                                        | chiropracticCareBenefitType | chiropracticCareExpectedText | acupunctureBenefitType | acupunctureExpectedText | eyeExamBenefitType | eyeExamExpectedText | footCareRoutineBenefitType | footCareRoutineExpectedText | hearingExamBenefitType | hearingExamExpectedText | membershipinHealthClubFitnessClassesBenefitType | membershipinHealthClubFitnessExpectedText                                                                   |
      | 15652 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare MedicareComplete Open (PPO) | Eyewear            | Eyewear has a plan benefit limit up to $100 per year                                         | Dental            | No Coverage                                                               | Transportation            | No Coverage                                                                       | Chiropractic Care           | No Coverage                  | Acupuncture            | No Coverage             | Eye Exam           | $20 copay 1         | Foot Care - Routine        | $50 copay 1                 | Hearing Exam           | $15 copay 1             | Membership in Health Club / Fitness Classes     | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost. |
      | 15645 |   99210 | No              | Spokane County | MA       | AARP MedicareComplete Essential (HMO)        | Eyewear            | Eyewear has a plan benefit limit up to $70 for frames or $105 for contacts per every 2 years | Dental            | $1,000.00 per year towards covered preventive and comprehensive services. | Transportation            | No Coverage                                                                       | Chiropractic Care           | No Coverage                  | Acupuncture            | No Coverage             | Eye Exam           | $20 copay 1         | Foot Care - Routine        | $45 copay 1                 | Hearing Exam           | $0 copay 1              | Membership in Health Club / Fitness Classes     | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost. |
      | 15653 |   99210 | No              | Spokane County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)     | Eyewear            | Eyewear has a plan benefit limit up to $200 per every 2 years                                | Dental            | $2,000.00 per year towards covered preventive and comprehensive services. | Transportation            | 48 one-way trips per year to or from approved locations with no additional cost.2 | Chiropractic Care           | Covered                      | Acupuncture            | Covered                 | Eye Exam           | $0 copay 1          | Foot Care - Routine        | $0 copay 1                  | Hearing Exam           | $0 copay 1              | Membership in Health Club / Fitness Classes     | Fitness Membership Only: Basic membership in a fitness program at a network location at no additional cost. |

  @vppPlanDetailsRegressionMedical
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific Medical Benefits in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits of Plan for the plan in AARP
      | Primary Care Provider Copay Benefit Type   | <primaryCareProviderCopayBenefitType>    |
      | Primary Care Provider Copay Expected Text  | <primaryCareProviderCopayExpectedText>   |
      | Specialist Copay Benefit Type              | <specialistCopayBenefitType>             |
      | Specialist Copay Expected Text             | <specialistCopayExpectedText>            |
      | Ambulatory Surgical Center Benefit Type    | <ambulatorySurgicalCenterBenefitType>    |
      | Ambulatory Surgical Center Expected Text   | <ambulatorySurgicalCenterExpectedText>   |
      | Outpatient Hospital Services Benefit Type  | <outpatientHospitalServicesBenefitType>  |
      | Outpatient Hospital Services Expected Text | <outpatientHospitalServicesExpectedText> |
      | Diabetes Monitoring Supplies Benefit Type  | <diabetesMonitoringSuppliesBenefitType>  |
      | Diabetes Monitoring Supplies Expected Text | <diabetesMonitoringSuppliesExpectedText> |
      | Ground Ambulance Services Benefit Type     | <groundAmbulanceServicesBenefitType>     |
      | Ground Ambulance Services Expected Text    | <groundAmbulanceServicesExpectedText>    |
      | Air Ambulance Services Benefit Type        | <airAmbulanceServicesBenefitType>        |
      | Air Ambulance Services Expected Text       | <airAmbulanceServicesExpectedText>       |
      | Urgent Care Benefit Type                   | <urgentCareBenefitType>                  |
      | Urgent Care Expected Text                  | <urgentCareExpectedText>                 |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                     | primaryCareProviderCopayBenefitType | primaryCareProviderCopayExpectedText | specialistCopayBenefitType | specialistCopayExpectedText | ambulatorySurgicalCenterBenefitType | ambulatorySurgicalCenterExpectedText | outpatientHospitalServicesBenefitType | outpatientHospitalServicesExpectedText | diabetesMonitoringSuppliesBenefitType | diabetesMonitoringSuppliesExpectedText | groundAmbulanceServicesBenefitType | groundAmbulanceServicesExpectedText | airAmbulanceServicesBenefitType | airAmbulanceServicesExpectedText | urgentCareBenefitType | urgentCareExpectedText |
      | 15672 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare MedicareComplete Open (PPO) | Primary Care Provider Copay         | $15 copay                            | Specialist Copay           | $50 copay                   | Ambulatory Surgical Center          | $335 copay                           | Outpatient Hospital Services          | $335 copay                             | Diabetes Monitoring Supplies          | $0 copay                               | Ground Ambulance Services          | $250 copay                          | Air Ambulance Services          | $250 copay                       | Urgent Care           | $30 - $40 copay        |
      | 15671 |   99210 | No              | Spokane County | MA       | AARP MedicareComplete Essential (HMO)        | Primary Care Provider Copay         | $0 copay                             | Specialist Copay           | $45 copay                   | Ambulatory Surgical Center          | 20% of the cost                      | Outpatient Hospital Services          | 20% of the cost                        | Diabetes Monitoring Supplies          | $0 copay                               | Ground Ambulance Services          | $250 copay                          | Air Ambulance Services          | $250 copay                       | Urgent Care           | $30 - $40 copay        |
      | 15675 |   99210 | No              | Spokane County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)     | Primary Care Provider Copay         | $0 copay                             | Specialist Copay           | $0 copay                    | Ambulatory Surgical Center          | $0 copay - 20% of the cost           | Outpatient Hospital Services          | $0 copay - 20% of the cost             | Diabetes Monitoring Supplies          | $0 copay                               | Ground Ambulance Services          | $0 copay - 20% of the cost          | Air Ambulance Services          | $0 copay - 20% of the cost       | Urgent Care           | $0 copay - $65 copay   |

  @vppPlanDetailsRegressionPlanCosts
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Plan costs tab and validates
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                     | monthlyPremium | yearlyPremium |
      | 15638 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare MedicareComplete Open (PPO) | $11.80         | $141.60       |
      | 15640 |   99210 | No              | Spokane County | MA       | AARP MedicareComplete Essential (HMO)        | $0             | $0            |
      | 15641 |   99210 | No              | Spokane County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)     | $0             | $0            |

  @vppPlanDetailsRegressionOptionalRiders
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Optional Services tab and add the rider
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
    Then the user click on Plan costs tab and validate riders monthly and yearly premium
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county        | plantype | planName                                                          | optionalRider   | monthlyPremium | yearlyPremium |
      | 15658 |   11516 | No              | Nassau County | MA       | UnitedHealthcare MedicareComplete Choice Essential (Regional PPO) | Dental Platinum | $32            | $384          |
      | 15662 |   11516 | No              | Nassau County | MAPD     | UnitedHealthcare MedicareComplete Choice Essential (Regional PPO) | Dental Platinum | $32            | $384          |
      | 15661 |   53910 | No              | Adams County  | MAPD     | UnitedHealthcare MedicareComplete Assist (PPO SNP)                | Dental Platinum | $32            | $384          |
