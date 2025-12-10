Feature: Transaction
  Background:
    Given the user is logged in to the Digital Bank System

  @successful_transaction
  Rule: After successful transaction the transaction details should be displayed
    Scenario Outline: Successful transaction
      When the user navigates to "<Transaction>"
      And the user selects the target account "<Target Account>"
      And the user types the amount "<Amount>"
      And the user allows the transaction
      Then the transaction details should be displayed

      Examples:
        | Target Account  | Amount  | Transaction  |
        | MyChecking1     | 500.05  | Deposit      |
        | MySaving3       | 130.00  | Deposit      |
        | MyChecking1     | 500.05  | Withdraw     |
        | MySaving3       | 130.00  | Withdraw     |

  @unsuccessful_transaction
  Rule: After the transaction amount is left empty, a warning message should be displayed
    Scenario Outline: Unsuccessful transaction
      When the user navigates to "<Transaction>"
      And the user selects the target account "<Target Account>"
      And the user allows the transaction
      Then a warning message should be displayed

      Examples:
        | Target Account     | Transaction  |
        | MyChecking1        | Deposit      |
        | MySaving3          | Deposit      |
        | MyChecking1        | Withdraw     |
        | MySaving3          | Withdraw     |