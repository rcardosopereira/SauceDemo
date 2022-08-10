Feature: SauceDemo Site
  Scenario: Access the web site with the standard user - Positive test
    Given The access to the page
    When I put the username and password
      |username|password|
      |standard_user|secret_sauce|
    And I click in the login button
    And I add to cart the bike light
    And I click in the shopping cart
    And I click in the checkout button
    And I fill in my personal information
    And I click in the finish button
    Then I see the checkout complete

  Scenario: Access the web site with the locked user - Negative test
    Given The access to the page
    When I put the username and password
      |username|password|
      |locked_out_user|secret_sauce|
    Then I click in the login

