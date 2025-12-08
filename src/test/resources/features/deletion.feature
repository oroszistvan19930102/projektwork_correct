Feature: Deletion of all data
  Background:
    Given the user is loged in to the Digital Bank System

    Scenario:
      When the user navigates to the profile menu
      And clicks on "Delete Data"
      Then an empty dashboard should be displayed