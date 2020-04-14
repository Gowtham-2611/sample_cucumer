Feature: To validate Advance screen in Trade capture

  #EA-69, 71, 75, 117, 143, 153, 148
  @Advance
  Scenario: Validating ST-FIX with Amortschedule
    Given User enters Credentials to LogIn
      | Username            | Password  |
      | phani@epsiloncs.com | ep$!l0nC$ |
    Then user clicks on "Trade Capture" option
    Then user select the "Advance" option
    Then user validate new pop window with "Untitled/Draft" title
    Then user select 'ST-FIX' from "Product" textbox under "Key Attributes"
    Then user enters "0d" in "Start Date" textbox under "Key Attributes"
    Then user enters "1k" in "Amount" textbox under "Key Attributes"
    Then user select 'BANK OF NY' from "Member" textbox under "Key Attributes"
    #Then I validate "Start Date" textbox under "Key Attributes" should populate "Current Date"
    Then I validate "Amount" textbox under "Key Attributes" should populate "1,000"
    And user right click under "TradingEvents" section
    Then user click "Add" option in advance
    Then user click on userinfo "icon"
    Then user verify "Amort Exercise schedule" screen is displayed
    Then user click the Amort "Generate" Button
    Then I enter "10" in "Notification, days" textbox
    And The user select "CALL" from "Call/Put" dropdown
    And The user select "Long" from "Holder" dropdown
    Then user click the Exercise "Generate" Button
    Then I click on emenu button of "Date" column under "AMORT SCHEDULE"
    And user selects "Pin Column" under emenu button
    And user selects "Pin Right" under emenu button
    Then the user click on Filter icon under "AMORT SCHEDULE"
    Then the user click on "Date" option from Filter
    And user selects "(Select All)" in filter
    Then the user click on Grid icon under "AMORT SCHEDULE"
    And selects "Reset Layout" options
    Then user clicks on "close" button
    Then user verify new "confirmation window" is populated
    And user click the "Yes" button
    Then user verify "Amortexercise Schedule" Icon button Grey to Orange

  @Advance
  Scenario: Validating Search button in Trade Capture/Advance
    Given User enters Credentials to LogIn
      | Username            | Password  |
      | phani@epsiloncs.com | ep$!l0nC$ |
    Then user clicks on "Trade Capture" option
    Then user select the "Advance" option
    And user click "search" button in advance
    And user enter "2020-01-03-0001" in Search textbox
    And user verify "2020-01-03-0001" with title in advance
    And user enter "ST-FIX" in Search textbox
    And user verify "ST-FIX" with title in advance

  @Advance
  Scenario: Validating LT-FIX with Amortschedule
    Given User enters Credentials to LogIn
      | Username            | Password  |
      | phani@epsiloncs.com | ep$!l0nC$ |
    Then user clicks on "Trade Capture" option
    Then user select the "Advance" option
    Then user validate new pop window with "Untitled/Draft" title
    Then user select 'LT-FIX' from "Product" textbox under "Key Attributes"
