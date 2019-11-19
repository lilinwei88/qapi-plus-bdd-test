@admin
Feature: Can I login to admin?
  Everybody wants to know whether we can login to qapi admin?

  Scenario Outline: Successful login to admin
    Given I am on the Login Page
    When <clientId> login with <userId> and <password>
    Then I should see admin page
    Examples:
      |clientId              |userId                    |password         |
      |""                    |"admin"                   |"P@$$w0rd"       |


  Scenario Outline: Failed login to admin using wrong credentials
    Given I am on the Login Page
    When <clientId> admin login with <userId> and <password>
    Then I should not see admin page
    Examples:
      |clientId              |userId                    |password         |
      |""                    |"admin"                   |"Password"       |
      |""                    |"larak625@gmail.com"      |"P@$$w0rd"       |