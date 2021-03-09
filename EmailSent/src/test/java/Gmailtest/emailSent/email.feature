Feature: Email
We Will Login to google account and compose a new mail with attachment.
  
  Scenario: Send email with attachment
    Given Login page is opened for Gmail
    When Enter email as "testingpower62@gmail.com"
    And Click on Next button
    Then Password Screen should open
    When Enter password as "ZXc!157SFq"
    And Click on Next Pwd_button
    Then Gmail Inbox should open and Compose button should be present
    When Click on compose button
    And Enter recipients name as "rubishdaniel@gmail.com"
    And Enter Subject as "Welcome to new world"
    And Enter Message Body as "How are you?"
    And Attach attachment
    And Click Send button
    Then Email should be sent out.
