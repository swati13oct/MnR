@xyz
Feature: Experiment

  @xyz
  Scenario Outline: index: <Index> - Validate getConsumerInformation API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user obtains getConsummerInformation from target test environment   
      | Test Env    | <targetTestEnv> |
   Then user compares getConsumerInformation api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   
    Examples: 
      | Index | testUser            | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 1     | Johntvolpe@Aol.Com | online-prod           | offline-prod | getConsumerInformation | MA  |
#      | 2     | Johntvolpe@Aol.Com | offline-prod          | online-prod | getConsumerInformation | MA  |
#      | 3     | q2_may_rally002    | online-stage          | online-stage | getConsumerInformation | MA  |
#      | 4     | q2_may_rally002     | team-atest            | online-stage | getConsumerInformation | MA  |

#----------------------------------------------------------------------------------
#-------------------------- Health and Wellness -----------------------------------
#----------------------------------------------------------------------------------
  Scenario Outline: index: <Index> - Validate Health and Wellness rewardsEligibility API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke rewardsEligibility API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke rewardsEligibility API from target test environment using getConsumerInfo from baseline env 
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares rewardsEligibility api responses between expected result and target test result 
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   
    Examples: 
      | Index | testUser            | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | rewardsEligibility | MA  |
#     | 02    | VirginiaRuth1936 | online-prod           | offline-prod | rewardsEligibility | MA  |
#     | 03    | VirginiaRuth1936    | offline-prod         | online-stage | rewardsEligibility | SHIP+FED  |
#     | 04    | nino2@theciliangroup.com    | offline-prod         | online-stage | rewardsEligibility | FED+SHIP  |
#     | 05    | DKELLY27    | offline-prod         | online-stage | rewardsEligibility | PDP+SHIP  |
#     | 06    | Gcdurant3    | offline-prod         | online-stage | rewardsEligibility | SHIP  |




  Scenario Outline: index: <Index> - Validate Health and Wellness getRallyRAConfirmationCode API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke getRallyRAConfirmationCode API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke getRallyRAConfirmationCode API from target test environment using getConsumerInfo from baseline env 
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares getRallyRAConfirmationCode api responses between expected result and target test result 
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   
    Examples: 
      | Index | testUser            | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | getRallyRAConfirmationCode | MA  |
#     | 02    | VirginiaRuth1936 | online-prod           | offline-prod | getRallyRAConfirmationCode | MA  |
#     | 03    | VirginiaRuth1936    | offline-prod         | online-stage | getRallyRAConfirmationCode | SHIP+FED  |
#     | 04    | nino2@theciliangroup.com    | offline-prod         | online-stage | getRallyRAConfirmationCode | FED+SHIP  |
#     | 05    | DKELLY27    | offline-prod         | online-stage | getRallyRAConfirmationCode | PDP+SHIP  |
#     | 06    | Gcdurant3    | offline-prod         | online-stage | getRallyRAConfirmationCode | SHIP  |

#----------------------------------------------------------------------------------
#-------------------------- EOB ---------------------------------------------------
#----------------------------------------------------------------------------------

  Scenario Outline: index: <Index> - Validate EOB medical and rx search API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   #----- rewardsEligibility
   Then user invoke dream EOB medical and rx search API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke pdfDownload API from dream EOB medical and rx search API response for target test environment   
      | Test Env    | <baselineTestEnv> |
#   Then user invoke dream EOB medical and rx search API from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user invoke pdfDownload API from dream EOB medical and rx search API response from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user compares dream EOB medical and rx search api responses between expected result and target test result
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01     | Dream_EOB_MAPD_007    | online-stage    | team-atest    | EOB medical and rx search | MAPD COSMOS                 |
#      | 01     | q4_Nice_UAT4_004      | online-stage    | team-atest    | EOB medical and rx search | MAPD NICE                   |
#      | 01     | Dream_multiEOB        | online-stage    | team-atest    | EOB medical and rx search | MAPD same EOB in same month |
#      | 01     | q3_sep_UAT4_Group131  | online-stage    | team-atest    | EOB medical and rx search | MA COSMOS                   |
#      | 01     | Dream_EOB_MA_009      | online-stage    | team-atest    | EOB medical and rx search | MA NICE                     |
#      | 01     | GENARO_Q4_COMBO       | online-stage    | team-atest    | EOB medical and rx search | SHIP+MAPD                   |
#      | 01     | q2_DreamEOB_0002      | online-stage    | team-atest    | EOB medical and rx search | MAPD Spanish EOB Med and Rx |
#      | 01     | q2_DreamEOB_0003      | online-stage    | team-atest    | EOB medical and rx search | MAPD Spanish EOB Rx         |
#      | 01     | q4_DSNP_052           | online-stage    | team-atest    | EOB medical and rx search | DSNP                        |
#      | 01     | q3_sep_UAT4_UHC063    | online-stage    | team-atest    | EOB medical and rx search | SSP combo pdp+ssp           |

 
  Scenario Outline: index: <Index> - Validate EOB rx search API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke dream EOB rx search API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke pdfDownload API from dream EOB rx search API response for target test environment   
      | Test Env    | <baselineTestEnv> |
#   Then user invoke dream EOB rx search API from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user invoke pdfDownload API from dream EOB rx search API response from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user compares dream EOB rx search api responses between expected result and target test result
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01     | Dream_EOB_PDP_010     | online-stage    | team-atest    | EOB rx search             | PDP RX                      |
#      | 01     | q4_ShipVAS_005        | online-stage    | team-atest    | EOB rx search             | PDP+SHIP                    |
#      | 01     | q2_RxRetail_015       | online-stage    | team-atest    | EOB rx search             | SHIP+PDP                    |
#      | 01     | q4_DSNP_052           | online-stage    | team-atest    | EOB rx search             | DSNP                        |
#      | 01     | q3_sep_UAT4_UHC063    | online-stage    | team-atest    | EOB rx search             | SSP combo pdp+ssp           |
 
  Scenario Outline: index: <Index> - Validate EOB medicaleobs search API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke dream EOB medicaleobs search API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke pdfDownload API from dream EOB medicaleobs search API response for target test environment   
      | Test Env    | <baselineTestEnv> |
#   Then user invoke dream EOB medicaleobs search API from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user invoke pdfDownload API from dream EOB medicaleobs search API response from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user compares dream EOB medicaleobs search api responses between expected result and target test result
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01     | q4_DSNP_052           | online-stage    | team-atest    | EOB medicaleobs search    | DSNP                        |
#      | 01     | q3_sep_UAT4_UHC063    | online-stage    | team-atest    | EOB medicaleobs search    | SSP combo pdp+ssp           |
 
 
  Scenario Outline: index: <Index> - Validate EOB ship search API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke dream EOB ship search API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke pdfDownload API from EOB ship search API response for target test environment   
      | Test Env    | <baselineTestEnv> |
#   Then user invoke EOB ship search API from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user invoke pdfDownload API from EOB ship search API response from target test environment using getConsumerInfo from baseline env
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |
#   Then user compares EOB ship search api responses between expected result and target test result
#      | Baseline Test Env    | <baselineTestEnv> |
#      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01     | q4_ShipVAS_005        | online-stage    | team-atest    | EOB ship search           | PDP+SHIP                    |
#      | 01     | q2_RxRetail_015       | online-stage    | team-atest    | EOB ship search           | SHIP+PDP                    |
#      | 01     | q4_Ship_014           | online-stage    | team-atest    | EOB ship search           | SHIP multi-plan             |

#----------------------------------------------------------------------------------
#-------------------------- Plan Doc ----------------------------------------------
#----------------------------------------------------------------------------------

  Scenario Outline: index: <Index> - Validate PlanDoc formsAndResourcesForIndividual API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke formsAndResourcesForIndividual API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke formsAndResourcesForIndividual API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares formsAndResourcesForIndividual api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | formsAndResourcesForIndividual | MA  |


  Scenario Outline: index: <Index> - Validate PlanDoc formsAndResourcesForGroup API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke formsAndResourcesForGroup API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke formsAndResourcesForGroup API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares formsAndResourcesForGroup api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | formsAndResourcesForGroup | MA Ind - will fail |
      | 02    | ExDesertrat | online-prod           | offline-prod | formsAndResourcesForGroup | MA Group |

  Scenario Outline: index: <Index> - Validate PlanDoc formsAndResourcesForShip API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke formsAndResourcesForShip API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke formsAndResourcesForShip API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares formsAndResourcesForShip api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | formsAndResourcesForShip | MA Ind - will fail |
     | 02    | Gcdurant3    | offline-prod         | online-prod | formsAndResourcesForShip | SHIP  |

  Scenario Outline: index: <Index> - Validate PlanDoc planDocuments API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke planDocuments API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke planDocuments API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares planDocuments api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | planDocuments | MA Ind - will fail |
     | 02    | Gcdurant3    | offline-prod         | online-prod | planDocuments | SHIP  |


  Scenario Outline: index: <Index> - Validate PlanDoc staticDocumentStatus API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke staticDocumentStatus API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke staticDocumentStatus API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares staticDocumentStatus api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | staticDocumentStatus | MA Ind - will fail |
     | 02    | Gcdurant3    | online-prod         | offline-prod | staticDocumentStatus | SHIP  |


#----------------------------------------------------------------------------------
#-------------------------- Benefits -----------------------------------
#----------------------------------------------------------------------------------
  Scenario Outline: index: <Index> - Validate Benefits premium API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke premium API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke premium API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares premium api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | staticDocumentStatus | MA Ind |
     | 02    | Gcdurant3    | online-prod         | offline-prod | staticDocumentStatus | SHIP - will fail |

  Scenario Outline: index: <Index> - Validate Benefits planBenefits GOVT API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke planBenefits GOVT API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke planBenefits GOVT API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares planBenefits GOVT api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | staticDocumentStatus | MA Ind |
     | 02    | Gcdurant3    | online-prod         | offline-prod | staticDocumentStatus | SHIP - will fail |

  Scenario Outline: index: <Index> - Validate Benefits planBenefits SHIP API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke planBenefits SHIP API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke planBenefits SHIP API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares planBenefits SHIP api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | Johntvolpe@Aol.Com | online-prod           | offline-prod | staticDocumentStatus | MA Ind - will fail|
     | 02    | Gcdurant3    | online-prod         | offline-prod | staticDocumentStatus | SHIP  |

  @thisone
  Scenario Outline: index: <Index> - Validate Benefits addRider SHIP API
    Given user obtains getConsummerInformation from test environment as expected result
      | Test User   | <testUser>|
      | Test Env    | <baselineTestEnv> |
   Then user invoke planBenefits GOVT API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke addRider API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke removeRider API from target test environment as expected result
      | Test Env    | <baselineTestEnv> |
   Then user invoke planBenefits GOVT API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user invoke addRider API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user invoke removeRider API from target test environment using getConsumerInfo from baseline env
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares addRider api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |
   Then user compares removeRider api responses between expected result and target test result
      | Baseline Test Env    | <baselineTestEnv> |
      | Target Test Env    | <targetTestEnv> |

    Examples: 
       | Index  | testUser              | baselineTestEnv | targetTestEnv | testApiNote | userNote    | 
      | 01    | q3_sep_UAT4_UHC092 | online-stage           | team-atest | addRider | MAPD w/ Rider|
  
#----------------------------------------------------------------------------------
#-------------------------- NOTE--------------- -----------------------------------
#----------------------------------------------------------------------------------
 
#  @thisone




# http://apsrp04762.uhc.com:8080  - either online-prod or offline-prod
# http://apsrp04763.uhc.com:8080  - either online-prod or offline-prod
# http://apsrs7260.uhc.com:8080  - online-stage
# https://www.team-atest-medicare.ocp-elr-core-nonprod.optum.com  - team-atest
# www.team-atest-medicare.ocp-elr-core-nonprod.optum.com 443
# https://offline-generic.uhc.com/ - offline-prod
# https://generic.uhc.com/ - online-prod
# https://stage-medicare.uhc.com/ - stage
# https://www.team-atest-medicare.ocp-elr-core-nonprod.optum.com/
