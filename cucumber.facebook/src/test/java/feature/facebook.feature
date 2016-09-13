Feature: Find people

Scenario: Facebook Login
Given I got credentials form file "facebook/credentials.txt"
And I go to "https://www.facebook.com" address
And I log in