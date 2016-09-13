Feature: Find people

Scenario: Facebook Login
Given I got credentials form file "facebook/credentials.txt"
And I go to facebook address
And I log in
Then I get driver cookies
And create new life