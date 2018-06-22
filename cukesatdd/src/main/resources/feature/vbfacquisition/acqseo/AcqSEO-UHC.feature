@BAT_GateFeature
@AcqSEO
@BlayerAcqSEO
Feature:2.01-VBF-Acq-To test 301 redirects in UMS site Blayer
@UHCloadUrl
Scenario Outline:To verify httpfox should not list more than 3 permanent 301 redirects in UMS site Blayer
Given load the UMS Blayer medicare solutions acquisition site page url
|URL|<url>|

Examples:
|url|
|http://www.ci-uhcmedicaresolutions.uhc.com//|



