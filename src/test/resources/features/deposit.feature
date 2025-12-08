Feature: Deposit
  Background:
    Given the user is loged in to the Digital Bank System
    And the user navigates to "Deposit" in the left menu

  Rule: After successful deposit the deposit details should be displayed
    Scenario Outline: Successful deposit
      When the user selects the target account "<Target Account>"
      And the user types the deposit amount "<Deposit Amount>"
      And the user clicks on the "Submit" button
      Then the deposit details should be displayed

      Examples:
        | Target Account  | Deposit Amount  |
        | MyChecking1     | 500.05          |
        | MySaving3       | 130.00          |

  Rule: After the deposit amount is left empty, a warning message should be displayed
    Scenario Outline: Unsuccessful deposit
      When the user selects the target account "<Target Account>"
      And the user clicks on the "Submit" button
      Then a warning message should be displayed

      Examples:
        | Target Account  |
        | MyChecking1     |
        | MySaving3       |