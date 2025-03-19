Feature: search and place the order for Products

Scenario: search experiance for the product search in both home and offer Page
Given User is on greenCart Landing Page
When user searched with ShortName "tom" and extracted actual product name
Then user searched for same shortname "Tom" in offer page
And validate product name in offer page matches with Landing page