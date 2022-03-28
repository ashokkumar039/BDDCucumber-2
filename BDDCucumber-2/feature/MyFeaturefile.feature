@MyTest
Feature: Smoke and Regression of Banking Application

  @Smoke_Test
  Scenario: Verify Login Functionality
    Given Open chrome and start application with "https://demo.guru99.com/V1/index.php"
    When I enter valid username as "mngr394612" and password as "veremUt"
    And I click the login button
    Then User should be able to login successfully

  @Regression_Test
  Scenario Outline: Verify User in Banking Application
    Given Open chrome and start application "https://demo.guru99.com/V1/index.php"
    When I enter username with "<UserName>" and password with "<Password>"
    And I click login button
    Then I verify the in step

    Examples: 
      | UserName   | Password |
      | mngr394612 | veremUt  |
      | NoName     | cvmkfnv  |
      | Blankk     | cv546nv  |
