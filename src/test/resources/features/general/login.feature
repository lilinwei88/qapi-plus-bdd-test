@member
Feature: Can I login to qapi?
  Everybody wants to know whether we can login to qapi?

  Scenario Outline: Successful login
    Given I am on the Login Page
    When login with <userId> and <password>
    Then I should see homepage
    Examples:
      |userId                       |password         |
      |"alexluo0591@gmail.com"      |"Polyphia2333"   |


  Scenario Outline: Failed login using wrong credentials
    Given I am on the Login Page
    When login with <userId> and <password>
    Then I should not see homepage
    Examples:
      |userId                    |password         |
      |"larak625@gmail.com"      |"Password"       |
      |"lilin5@gmail.com"        |"P@$$w0rd"       |