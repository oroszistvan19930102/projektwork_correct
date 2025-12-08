Feature: Withdraw
  Background:
    Given the user is loged in to the Digital Bank System
    And the user navigates to "Withdraw" in the left menu

  Rule: After successful withdraw the withdraw details should be displayed
    Scenario Outline: Successful withdraw
      When the user selects the source account "<Source Account>"
      And the user types the withdraw amount "<Withdraw Amount>"
      And the user clicks on the "Submit" button
      Then the withdraw details should be displayed

      Examples:
        | Source Account  | Withdraw Amount  |
        | MyChecking1     | 500.05           |
        | MySaving3       | 130.00           |

  Rule: If the withdraw amount is bigger than the amount on the source account a warning message should be displayed
    Scenario Outline: Unsuccessful withdraw
      When the user selects the source account "<Source Account>"
      And the user types the withdraw amount "<Withdraw Amount>"
      And the user clicks on the "Submit" button
      Then a warning message should be displayed

      Examples:
        | Source Account  | Withdraw Amount     |
        | MyChecking1     | 500000.05           |
        | MySaving3       | 130000.00           |