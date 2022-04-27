@AcqSEO
Feature: 2.02-VBF-Acq-To test 301 redirects in Medicare sites

  @SEOloadUrl @regressionAARP @regressionUHC
  Scenario Outline: To Verify httpfox should not list more than 3 permanent 301 redirects in Medicare sites
    Given load the Medicare acquisition site page url
      | URL | <url> |

    @SEO
    Examples:
      | url                                            |
      | http://www.stage-aarpmedicareplans.uhc.com/    |
      | http://www.stage-uhcmedicaresolutions.uhc.com/ |

