@VPP-DCE
Feature: VPP-DCE - BLayer

	@sanity
  Scenario Outline: VPP DCE flow integration with different zipcodes
    Given the user is on the vpp portfolio page
    Then the user performs plan search using zipcode
      | Zip Code | <zipCode> |
      | County   | <county>  |
    Then the user navigates to the following plan type
      | PlanType | <planType> |
    Then the user navigates to DCE and adds a drug
      | Plan Name | <planName> |
      | Drug Name | <drugName> |
    And the user validates benefits table
      | Drug Cost | <drugCost> |

    Examples: 
      | zipCode | county             | planType | planName                                          | drugName | drugCost  |
      |   90210 | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | lipitor  | $4,040.64 |
      |   33012 | Miami-Dade County  | SNP      | Preferred Special Care Miami-Dade (HMO SNP)       | lipitor  | $4,052.64 |
      |   33012 | Miami-Dade County  | PDP      | AARP MedicareRx Preferred (PDP)                   | lipitor  | $4,040.64 |

  Scenario Outline: VPP Integration with Med Supp
    Given the user is on the vpp portfolio page
    Then the user performs plan search using zipcode
      | Zip Code | <zipCode> |
      | County   | <county>  |
    Then the user navigates to the following plan type
      | PlanType | <planType> |

    Examples: 
      | zipCode | county             | planType |
      |   90210 | Los Angeles County | MS       |

  Scenario Outline: To validate plan count from portfolio page
    Given the user is on the vpp portfolio page
    Then the user performs plan search using zipcode
      | Zip Code | <zipCode> |
      | County   | <county>  |
    Then the user navigates to the following plan type
      | PlanType | <planType> |
    And the user should see plan count for the plan type seelcted

    Examples: 
      | zipCode | county             | planType |
      |   90210 | Los Angeles County | ma       |
      |   90210 | Los Angeles County | pdp      |
      |   33012 | Miami-Dade County  | snp      |

  Scenario Outline: VPP plan benefits table flow
    Given the user is on the vpp portfolio page
    Then the user performs plan search using zipcode
      | Zip Code | <zipCode> |
      | County   | <county>  |
    Then user validates plan count for all plan types on plan summary page in AARP site
    Then the user navigates to the following plan type
      | PlanType | <planType> |
    And the user validates benefit table
      | Plan Name          | <planName>         |
      | MonthlyPremium     | <monthlypremium>   |
      | PCP                | <primarycare>      |
      | Specialist         | <specialist>       |
      | ReferralRequired   | <referralRequired> |
      | Prescription Drugs | <prescriptionDrug> |

    Examples: 
      | zipCode | county            | planType | planName                                             | monthlypremium | primarycare | specialist | referralRequired | prescriptionDrug |
      |   33012 | Miami-Dade County | snp      | UnitedHealthcare Dual Complete RP (Regional PPO SNP) | $29.10         | $0          |         20 | No               |               25 |

  Scenario Outline: VPP plan costs on plan details page
    Given the user is on the vpp portfolio page
    Then the user performs plan search using zipcode
      | Zip Code | <zipCode> |
      | County   | <county>  |
    Then the user navigates to the following plan type
      | PlanType | <planType> |
    Then the user navigates to pan details page
      | Plan Name | <planName> |
    And the user validates plan costs
      | High Optional Dental | <highOptionalDental> |
      | Optional Dental      | <optionalDental>     |

    Examples: 
      | zipCode | county             | planType | planName                                          | highOptionalDental | optionalDental |
      |   90210 | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | true               | true           |
