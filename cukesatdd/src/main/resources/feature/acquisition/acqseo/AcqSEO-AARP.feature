@AcqSEO @UlayerAcqSEO
Feature: 2.02-VBF-Acq-To test 301 redirects in AARP site Ulayer

  @AARPloadUrl @regressionAARP
  Scenario Outline: To Verify httpfox should not list more than 3 permanent 301 redirects in AARP site
    Given load the AARP Ulayer medicare acquisition site page url
      | URL | <url> |

    @SEO @checkSEO
    Examples:
      | url                                            |
      | http://www.stage-aarpmedicareplans.uhc.com/    |
      | http://www.stage-uhcmedicaresolutions.uhc.com/ |

