Feature: Can I login to qapi?
  Everybody wants to know whether we can login to qapi?

  Scenario Outline: Successful login
    Given qa environment is up
    When <clientId> login with <userId> and <password>
    Then I should see homepage
    Examples:
      |clientId                  |userId                    |password         |
      |"qate"                    |"larak625@gmail.com"      |"P@$$w0rd"       |


  Scenario Outline: Failed login using wrong credentials
    Given qa environment is up
    When <clientId> login with <userId> and <password>
    Then I should not see homepage
    Examples:
      |clientId                  |userId                    |password         |
      |"qate"                    |"larak625@gmail.com"      |"Password"       |
      |"qate"                    |"lilin5@gmail.com"        |"P@$$w0rd"       |