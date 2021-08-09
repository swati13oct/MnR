@globalComponent
Feature: 1.15 ACQ - To test SAM Icons in Blog Pages

  Scenario Outline: 1.19.1.4 To test the SAM icons on Acq site on <site> - <pagename>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And user opens the page to validate M&R Sites
      | pagename | <pagename> |
    Then the user validates whether call icon is visible
    #Then the user validates whether chat icon is visible on UHC
    Then the user validates whether chat icon is visible

 		@vbfGate1 #these are used in the gate and are taken from below examples
    Examples: 
      | pagename                                                                                                    | site |                                                         
      | medicare-articles/medicare-benefits-and-coverage.html                                                       | AARP |
      | medicare-articles/medicare-costs.html 																																			| AARP |

    @samChatRegressionAARPblog1
    Examples: 
      | pagename                                                                                                    | site |
      | medicare-articles.html                                                                                      | AARP |
      | medicare-articles/medicare-made-clear.html                                                                  | AARP |
      | medicare-articles/eligibility-and-enrollment.html                                                           | AARP |
      | medicare-articles/medicare-benefits-and-coverage.html                                                       | AARP |
      | medicare-articles/medicare-costs.html                                                                       | AARP |
      | medicare-articles/shopping-for-medicare.html                                                                | AARP |
      | medicare-articles/medicare-when-working-past-65.html                                                        | AARP |
      | medicare-articles/medicare-tips-and-faqs.html                                                               | AARP |
      | medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty                                             | AARP |
      | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65                          | AARP |
      | medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you                       | AARP |
      | medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period | AARP |
      | medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan                                      | AARP |
      | medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud                                            | AARP |
      | medicare-articles/what-will-medicare-cost-in-2020                                                           | AARP |
      | medicare-articles/what-is-retiree-health-coverage                                                           | AARP |
      | medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for                                    | AARP |
      | medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options                          | AARP |
      | medicare-articles/medicare-doesnt-cover-everything-what-you-need-know                                       | AARP |
      | medicare-articles/6-timely-medicare-tips-for-turning-65                                                     | AARP |

    @samChatRegressionAARPblog2
    Examples: 
      | pagename                                                                                  | site |
      | medicare-articles/should-i-get-part-b-if-im-working-past-65                               | AARP |
      | medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties                 | AARP |
      | medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage | AARP |
      | medicare-articles/do-i-need-medicare-with-spouses-employer-plan                           | AARP |
      | medicare-articles/5-ways-to-pay-your-medicare-part-b-premium                              | AARP |
      | medicare-articles/5-medicare-myths-set-straight                                           | AARP |
      | medicare-articles/when-can-you-start-getting-medicare                                     | AARP |
      | medicare-articles/is-medicare-mandatory                                                   | AARP |
      | medicare-articles/can-i-change-my-medicare-plan                                           | AARP |
      | medicare-articles/medicare-coverage-for-non-working-spouses                               | AARP |
      | medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time                     | AARP |
      | medicare-articles/decide-change-plan                                                      | AARP |
      | medicare-articles/medicare-coverage-for-mammograms                                        | AARP |
      | medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered                   | AARP |
      | medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period              | AARP |
      | medicare-articles/what-does-original-medicare-include                                     | AARP |
      | medicare-articles/what-is-creditable-drug-coverage                                        | AARP |
      | medicare-articles/safe-medicare-enrollment-during-COVID                                   | AARP |
      | medicare-articles/what-is-the-medicare-annual-enrollment-period                           | AARP |
      | medicare-articles/aep-change-or-renew                                                     | AARP |

    @samChatRegressionAARPblog3
    Examples: 
      | pagename                                                                                                              | site |
      | medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period | AARP |
      | medicare-articles/2-ways-to-prescription-drug-coverage                                                                | AARP |
      | medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan                                                        | AARP |
      | medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans                                                   | AARP |
      | medicare-articles/medicare-mistakes-that-could-be-costly                                                              | AARP |
      | medicare-articles/5-savvy-shopper-tips-help-get-medicare                                                              | AARP |
      | medicare-articles/which-vaccines-does-medicare-cover                                                                  | AARP |
      | medicare-articles/what-if-i-missed-my-initial-enrollment-period                                                       | AARP |
      | medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage                                             | AARP |
      | medicare-articles/turn-65-retire-sign-up-for-medicare-or-not                                                          | AARP |
      | medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare                                            | AARP |
      | medicare-articles/medicare-individuals-who-divorced-widowed                                                           | AARP |
      | medicare-articles/medicare-and-durable-medical-equipment-dme                                                          | AARP |
      | medicare-articles/3-simple-ways-to-change-medicare-plans                                                              | AARP |
      | medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips                                        | AARP |
      | medicare-articles/does-medicare-coverage-change-if-you-return-to-work                                                 | AARP |
      | medicare-articles/medicare-enrollment-for-veterans                                                                    | AARP |
      | medicare-articles/retiring-in-2020-what-to-know-about-medicare                                                        | AARP |
      | medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose                                         | AARP |
      | medicare-articles/how-do-tricare-and-medicare-work-together                                                           | AARP |
      | medicare-articles/youre-65-working-medicare                                                                           | AARP |

    @samChatRegressionAARPblog4
    Examples: 
      | pagename                                                                                        | site |
      | medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare             | AARP |
      | medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions               | AARP |
      | medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans                   | AARP |
      | medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67                     | AARP |
      | medicare-articles/renew-medicare-plan-open-enrollment                                           | AARP |
      | medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision   | AARP |
      | medicare-articles/should-you-change-your-medicare-plan                                          | AARP |
      | medicare-articles/what-happens-to-your-medicare-plan-if-you-move                                | AARP |
      | medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare                     | AARP |
      | medicare-articles/what-is-the-medicare-special-enrollment-period                                | AARP |
      | medicare-articles/wheres-my-original-medicare-card                                              | AARP |
      | medicare-articles/the-truth-your-medicare-part-b-premium                                        | AARP |
      | medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan                            | AARP |
      | medicare-articles/outpatient-mental-health-care-services                                        | AARP |
      | medicare-articles/medicare-increases-coverage-mental-health-care                                | AARP |
      | medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare                     | AARP |
      | medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan                   | AARP |
      | medicare-articles/saving-on-medicare-when-self-employed                                         | AARP |
      | medicare-articles/concrete-answers-10-common-medicare-questions                                 | AARP |
      | medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide | AARP |
      | medicare-articles/what-telehealth-services-does-medicare-offer                                  | AARP |
      | medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week    | AARP |
      | medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home    | AARP |
      | medicare-articles/what-s-the-difference-between-medicare-and-medicaid                           | AARP |
      | medicare-articles/how-to-appeal-a-medicare-decision                                             | AARP |

    @samChatRegressionAARPblog5
    Examples: 
      | pagename                                                                                     | site |
      | medicare-articles/how-avoid-paying-more-prescription-drug-coverage                           | AARP |
      | medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely                    | AARP |
      | medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me                    | AARP |
      | medicare-articles/good-news-medicare-part-b-covers-cataract-surgery                          | AARP |
      | medicare-articles/heart-healthy-help-medicare                                                | AARP |
      | medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period         | AARP |
      | medicare-articles/medicare-coverage-for-same-sex-couples                                     | AARP |
      | medicare-articles/how-to-evaluate-medicare-plan-costs                                        | AARP |
      | medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan                 | AARP |
      | medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier                   | AARP |
      | medicare-articles/understanding-your-medicare-plan                                           | AARP |
      | medicare-articles/how-to-save-on-prescription-drugs-with-medicare                            | AARP |
      | medicare-articles/10-tips-choosing-primary-care-doctor                                       | AARP |
      | medicare-articles/avoid-sticker-shock-medicare-billing                                       | AARP |
      | medicare-articles/does-medicare-part-a-cost-anything                                         | AARP |
      | medicare-articles/how-much-does-medicare-part-b-cost                                         | AARP |
      | medicare-articles/what-is-co-insurance                                                       | AARP |
      | medicare-articles/what-is-the-medicare-advantage-open-enrollment-period                      | AARP |
      | medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit | AARP |
      | medicare-articles/what-medicare-medical-savings-account-plan                                 | AARP |
      | medicare-articles/copd-medicare                                                              | AARP |

    @samChatRegressionAARPblog6 
    Examples: 
      | pagename                                                                  | site |
      | medicare-articles/decoding-medicare                                       | AARP |
      | medicare-articles/does-medicare-cover-a-colonoscopy                       | AARP |
      | medicare-articles/does-medicare-cover-blood-tests-for-cholesterol         | AARP |
      | medicare-articles/does-medicare-cover-diabetes-prevention-program         | AARP |
      | medicare-articles/does-medicare-cover-emergency-room-visits               | AARP |
      | medicare-articles/does-medicare-cover-home-blood-pressure-monitors        | AARP |
      | medicare-articles/does-medicare-cover-melanoma-screenings                 | AARP |
      | medicare-articles/home-health-care-those-medicare-who-cant-leave-home     | AARP |
      | medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear       | AARP |
      | medicare-articles/medicare-transportation-services                        | AARP |
      | medicare-articles/are-you-living-with-chronic-heart-failure               | AARP |
      | medicare-articles/how-prepare-your-medicare-wellness-visit                | AARP |
      | medicare-articles/will-medicare-cover-a-cpap-machine                      | AARP |
      | medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit | AARP |
      | medicare-articles/how-to-become-a-medicare-authorized-representative      | AARP |
      | medicare-articles/what-is-a-transition-refill                             | AARP |

    @samChatRegressionAARPblog7
    Examples: 
      | pagename                                                                        | site |
      | medicare-articles/got-coverage-for-the-new-year                                 | AARP |
      | medicare-articles/medicare-and-your-private-medical-information                 | AARP |
      | medicare-articles/medicare-memo-what-are-advance-directives                     | AARP |
      | medicare-articles/getting-a-knee-replaced-with-Medicare                         | AARP |
      | medicare-articles/2-ways-save-on-blood-sugar-test-strips                        | AARP |
      | medicare-articles/are-glaucoma-screenings-covered-by-medicare                   | AARP |
      | medicare-articles/colon-cancer-screening-tests-without-the-ouch                 | AARP |
      | medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered    | AARP |
      | medicare-articles/medicare-coverage-for-inpatient-rehabilitation                | AARP |
      | medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy       | AARP |
      | medicare-articles/medicare-coverage-for-prostate-cancer-screening               | AARP |
      | medicare-articles/medicare-part-benefit-periods-deductibles                     | AARP |
      | medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit | AARP |
      | medicare-articles/does-medicare-cover-allergy-testing                           | AARP |
      | medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might        | AARP |
      | medicare-articles/medicare-part-b-basics                                        | AARP |
      | medicare-articles/medicare-part-d-basics                                        | AARP |
      | medicare-articles/medicare-part-a-the-basics                                    | AARP |
      | medicare-articles/medicare-part-c-basics                                        | AARP |

    @samChatRegressionAARPblog8
    Examples: 
      | pagename                                                                                            | site |
      | medicare-articles/does-medicare-cover-a-chiropractor                                                | AARP |
      | medicare-articles/what-does-medicare-cover-after-a-stroke                                           | AARP |
      | medicare-articles/dual-special-needs-plans                                                          | AARP |
      | medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid                                   | AARP |
      | medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare                  | AARP |
      | medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos                           | AARP |
      | medicare-articles/medicare-parte-c-conceptos-basicos                                                | AARP |
      | medicare-articles/parte-a-de-medicare-conceptos-basicos                                             | AARP |
      | medicare-articles/parte-b-de-medicare-conceptos-basicos                                             | AARP |
      | medicare-articles/parte-d-de-medicare-conceptos-basicos                                             | AARP |
      | medicare-articles/what-is-a-pdp-prescription-drug-plan                                              | AARP |
      | medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs                          | AARP |
      | medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover                          | AARP |
      | medicare-articles/what-is-the-medicare-part-d-coverage-gap                                          | AARP |
      | medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget | AARP |
      | medicare-articles/medicare-part-d-costs-you-may-not-know-about                                      | AARP |
      | medicare-articles/new-medicare-follow-checklist-successful-start                                    | AARP |
      | medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation                       | AARP |
      | medicare-articles/how-to-compare-medicare-advantage-plan-costs                                      | AARP |

    @samChatRegressionUHCblog1
    Examples: 
      | pagename                                                                                                    | site |
      | medicare-articles.html                                                                                      | UHC  |
      | medicare-articles/medicare-made-clear.html                                                                  | UHC  |
      | medicare-articles/eligibility-and-enrollment.html                                                           | UHC  |
      | medicare-articles/medicare-benefits-and-coverage.html                                                       | UHC  |
      | medicare-articles/medicare-costs.html                                                                       | UHC  |
      | medicare-articles/shopping-for-medicare.html                                                                | UHC  |
      | medicare-articles/medicare-when-working-past-65.html                                                        | UHC  |
      | medicare-articles/medicare-tips-and-faqs.html                                                               | UHC  |
      | medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty                                             | UHC  |
      | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65                          | UHC  |
      | medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you                       | UHC  |
      | medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period | UHC  |
      | medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan                                      | UHC  |
      | medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud                                            | UHC  |
      | medicare-articles/what-will-medicare-cost-in-2020                                                           | UHC  |
      | medicare-articles/what-is-retiree-health-coverage                                                           | UHC  |
      | medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for                                    | UHC  |
      | medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options                          | UHC  |
      | medicare-articles/medicare-doesnt-cover-everything-what-you-need-know                                       | UHC  |
      | medicare-articles/6-timely-medicare-tips-for-turning-65                                                     | UHC  |

    @samChatRegressionUHCblog2
    Examples: 
      | pagename                                                                                  | site |
      | medicare-articles/should-i-get-part-b-if-im-working-past-65                               | UHC  |
      | medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties                 | UHC  |
      | medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage | UHC  |
      | medicare-articles/do-i-need-medicare-with-spouses-employer-plan                           | UHC  |
      | medicare-articles/5-ways-to-pay-your-medicare-part-b-premium                              | UHC  |
      | medicare-articles/5-medicare-myths-set-straight                                           | UHC  |
      | medicare-articles/when-can-you-start-getting-medicare                                     | UHC  |
      | medicare-articles/is-medicare-mandatory                                                   | UHC  |
      | medicare-articles/can-i-change-my-medicare-plan                                           | UHC  |
      | medicare-articles/medicare-coverage-for-non-working-spouses                               | UHC  |
      | medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time                     | UHC  |
      | medicare-articles/decide-change-plan                                                      | UHC  |
      | medicare-articles/medicare-coverage-for-mammograms                                        | UHC  |
      | medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered                   | UHC  |
      | medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period              | UHC  |
      | medicare-articles/what-does-original-medicare-include                                     | UHC  |
      | medicare-articles/what-is-creditable-drug-coverage                                        | UHC  |
      | medicare-articles/safe-medicare-enrollment-during-COVID                                   | UHC  |
      | medicare-articles/what-is-the-medicare-annual-enrollment-period                           | UHC  |
      | medicare-articles/aep-change-or-renew                                                     | UHC  |

    @samChatRegressionUHCblog3
    Examples: 
      | pagename                                                                                                              | site |
      | medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period | UHC  |
      | medicare-articles/2-ways-to-prescription-drug-coverage                                                                | UHC  |
      | medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan                                                        | UHC  |
      | medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans                                                   | UHC  |
      | medicare-articles/medicare-mistakes-that-could-be-costly                                                              | UHC  |
      | medicare-articles/5-savvy-shopper-tips-help-get-medicare                                                              | UHC  |
      | medicare-articles/which-vaccines-does-medicare-cover                                                                  | UHC  |
      | medicare-articles/what-if-i-missed-my-initial-enrollment-period                                                       | UHC  |
      | medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage                                             | UHC  |
      | medicare-articles/turn-65-retire-sign-up-for-medicare-or-not                                                          | UHC  |
      | medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare                                            | UHC  |
      | medicare-articles/medicare-individuals-who-divorced-widowed                                                           | UHC  |
      | medicare-articles/medicare-and-durable-medical-equipment-dme                                                          | UHC  |
      | medicare-articles/3-simple-ways-to-change-medicare-plans                                                              | UHC  |
      | medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips                                        | UHC  |
      | medicare-articles/does-medicare-coverage-change-if-you-return-to-work                                                 | UHC  |
      | medicare-articles/medicare-enrollment-for-veterans                                                                    | UHC  |
      | medicare-articles/retiring-in-2020-what-to-know-about-medicare                                                        | UHC  |
      | medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose                                         | UHC  |
      | medicare-articles/how-do-tricare-and-medicare-work-together                                                           | UHC  |
      | medicare-articles/youre-65-working-medicare                                                                           | UHC  |
      | medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare                                   | UHC  |
      | medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions                                     | UHC  |
      | medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans                                         | UHC  |
      | medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67                                           | UHC  |
      | medicare-articles/renew-medicare-plan-open-enrollment                                                                 | UHC  |
      | medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision                         | UHC  |
      | medicare-articles/should-you-change-your-medicare-plan                                                                | UHC  |
      | medicare-articles/what-happens-to-your-medicare-plan-if-you-move                                                      | UHC  |
      | medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare                                           | UHC  |
      | medicare-articles/what-is-the-medicare-special-enrollment-period                                                      | UHC  |
      | medicare-articles/wheres-my-original-medicare-card                                                                    | UHC  |
      | medicare-articles/the-truth-your-medicare-part-b-premium                                                              | UHC  |

    @samChatRegressionUHCblog4
    Examples: 
      | pagename                                                                                        | site |
      | medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan                            | UHC  |
      | medicare-articles/outpatient-mental-health-care-services                                        | UHC  |
      | medicare-articles/medicare-increases-coverage-mental-health-care                                | UHC  |
      | medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare                     | UHC  |
      | medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan                   | UHC  |
      | medicare-articles/saving-on-medicare-when-self-employed                                         | UHC  |
      | medicare-articles/concrete-answers-10-common-medicare-questions                                 | UHC  |
      | medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide | UHC  |
      | medicare-articles/what-telehealth-services-does-medicare-offer                                  | UHC  |
      | medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week    | UHC  |
      | medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home    | UHC  |
      | medicare-articles/what-s-the-difference-between-medicare-and-medicaid                           | UHC  |
      | medicare-articles/how-to-appeal-a-medicare-decision                                             | UHC  |
      | medicare-articles/how-avoid-paying-more-prescription-drug-coverage                              | UHC  |
      | medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely                       | UHC  |
      | medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me                       | UHC  |
      | medicare-articles/good-news-medicare-part-b-covers-cataract-surgery                             | UHC  |
      | medicare-articles/heart-healthy-help-medicare                                                   | UHC  |
      | medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period            | UHC  |
      | medicare-articles/medicare-coverage-for-same-sex-couples                                        | UHC  |
      | medicare-articles/how-to-evaluate-medicare-plan-costs                                           | UHC  |
      | medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan                    | UHC  |
      | medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier                      | UHC  |
      | medicare-articles/understanding-your-medicare-plan                                              | UHC  |
      | medicare-articles/how-to-save-on-prescription-drugs-with-medicare                               | UHC  |
      | medicare-articles/10-tips-choosing-primary-care-doctor                                          | UHC  |
      | medicare-articles/avoid-sticker-shock-medicare-billing                                          | UHC  |

    @samChatRegressionUHCblog5
    Examples: 
      | pagename                                                                                     | site |
      | medicare-articles/does-medicare-part-a-cost-anything                                         | UHC  |
      | medicare-articles/how-much-does-medicare-part-b-cost                                         | UHC  |
      | medicare-articles/what-is-co-insurance                                                       | UHC  |
      | medicare-articles/what-is-the-medicare-advantage-open-enrollment-period                      | UHC  |
      | medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit | UHC  |
      | medicare-articles/what-medicare-medical-savings-account-plan                                 | UHC  |
      | medicare-articles/copd-medicare                                                              | UHC  |
      | medicare-articles/decoding-medicare                                                          | UHC  |
      | medicare-articles/does-medicare-cover-a-colonoscopy                                          | UHC  |
      | medicare-articles/does-medicare-cover-blood-tests-for-cholesterol                            | UHC  |
      | medicare-articles/does-medicare-cover-diabetes-prevention-program                            | UHC  |
      | medicare-articles/does-medicare-cover-emergency-room-visits                                  | UHC  |
      | medicare-articles/does-medicare-cover-home-blood-pressure-monitors                           | UHC  |
      | medicare-articles/does-medicare-cover-melanoma-screenings                                    | UHC  |
      | medicare-articles/home-health-care-those-medicare-who-cant-leave-home                        | UHC  |
      | medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear                          | UHC  |
      | medicare-articles/medicare-transportation-services                                           | UHC  |

    @samChatRegressionUHCblog6
    Examples: 
      | pagename                                                                     | site |
      | medicare-articles/are-you-living-with-chronic-heart-failure                  | UHC  |
      | medicare-articles/how-prepare-your-medicare-wellness-visit                   | UHC  |
      | medicare-articles/will-medicare-cover-a-cpap-machine                         | UHC  |
      | medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit    | UHC  |
      | medicare-articles/how-to-become-a-medicare-authorized-representative         | UHC  |
      | medicare-articles/what-is-a-transition-refill                                | UHC  |
      | medicare-articles/got-coverage-for-the-new-year                              | UHC  |
      | medicare-articles/medicare-and-your-private-medical-information              | UHC  |
      | medicare-articles/medicare-memo-what-are-advance-directives                  | UHC  |
      | medicare-articles/getting-a-knee-replaced-with-Medicare                      | UHC  |
      | medicare-articles/2-ways-save-on-blood-sugar-test-strips                     | UHC  |
      | medicare-articles/are-glaucoma-screenings-covered-by-medicare                | UHC  |
      | medicare-articles/colon-cancer-screening-tests-without-the-ouch              | UHC  |
      | medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered | UHC  |
      | medicare-articles/medicare-coverage-for-inpatient-rehabilitation             | UHC  |

    @samChatRegressionUHCblog7
    Examples: 
      | pagename                                                                        | site |
      | medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy       | UHC  |
      | medicare-articles/medicare-coverage-for-prostate-cancer-screening               | UHC  |
      | medicare-articles/medicare-part-benefit-periods-deductibles                     | UHC  |
      | medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit | UHC  |
      | medicare-articles/does-medicare-cover-allergy-testing                           | UHC  |
      | medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might        | UHC  |
      | medicare-articles/medicare-part-b-basics                                        | UHC  |
      | medicare-articles/medicare-part-d-basics                                        | UHC  |
      | medicare-articles/medicare-part-a-the-basics                                    | UHC  |
      | medicare-articles/medicare-part-c-basics                                        | UHC  |
      | medicare-articles/does-medicare-cover-a-chiropractor                            | UHC  |
      | medicare-articles/what-does-medicare-cover-after-a-stroke                       | UHC  |
      | medicare-articles/dual-special-needs-plans                                      | UHC  |

    @samChatRegressionUHCblog8
    Examples: 
      | pagename                                                                                            | site |
      | medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid                                   | UHC  |
      | medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare                  | UHC  |
      | medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos                           | UHC  |
      | medicare-articles/medicare-parte-c-conceptos-basicos                                                | UHC  |
      | medicare-articles/parte-a-de-medicare-conceptos-basicos                                             | UHC  |
      | medicare-articles/parte-b-de-medicare-conceptos-basicos                                             | UHC  |
      | medicare-articles/parte-d-de-medicare-conceptos-basicos                                             | UHC  |
      | medicare-articles/what-is-a-pdp-prescription-drug-plan                                              | UHC  |
      | medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs                          | UHC  |
      | medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover                          | UHC  |
      | medicare-articles/what-is-the-medicare-part-d-coverage-gap                                          | UHC  |
      | medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget | UHC  |
      | medicare-articles/medicare-part-d-costs-you-may-not-know-about                                      | UHC  |
      | medicare-articles/new-medicare-follow-checklist-successful-start                                    | UHC  |
      | medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation                       | UHC  |
      | medicare-articles/how-to-compare-medicare-advantage-plan-costs                                      | UHC  |
