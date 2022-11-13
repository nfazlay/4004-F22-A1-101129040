Feature: run the multiplayer acceptance test cases

  Scenario: Start the server and add players and check if three players added
    Given That the server is initiated
    And Three players are added
    When I query server for number of players
    Then it is 3
    And close server

    Scenario: Row130
      Given That the server is initiated
      And Three players are added
      And Player 1 picks FC CAPTAIN
      And Player 1 rolls 7 swords and 1 skull
      And Player 2 picks FC SKULL 1
      And Player 2 rolls 7 swords and 1 skull
      And Player 3 picks FC COIN
      And Player 3 rolls 3 skulls and 5 monkeys
      And Calculate score of all players
      And find winner
      Then I find that "Player 1" is the winner
      And close server

    Scenario: row134
      Given That the server is initiated
      And Three players are added
      And Player 1 picks FC CAPTAIN
      And Player 1 rolls 7 swords and 1 skull
      And Player 2 picks FC COIN
      And Player 2 rolls 3 skulls and 5 monkeys
      And Player 3 picks FC CAPTAIN
      And Player 3 rolls 6 skulls and 2 parrots
      And Player 3 sets islandOfSkulls points
      And Calculate score of all players
      And Deduct score of Player 1
      And Deduct score of Player 2
      And Player 1 picks FC COIN
      And Player 1 rolls 4 monkeys and 4 parrots
      And Calculate score of all players
      And find winner
      Then I find that "Player 1" is the winner
      And close server

  Scenario: Row142
    Given That the server is initiated
    And Three players are added
    And Player 1 picks FC CAPTAIN
    And Player 1 rolls 3 skulls and 5 monkeys
    And Player 2 picks FC CAPTAIN
    And Player 2 rolls 7 swords and 1 skull
    And Player 3 picks FC SKULL 1
    And Player 3 rolls 7 swords and 1 skull
    And Player 1 picks FC CAPTAIN
    And Player 1 rolls 8 swords
    And Calculate score of all players
    And find winner
    Then I find that "Player 1" is the winner
    And close server


  Scenario: Row147
    Given That the server is initiated
    And Three players are added
    And Player 1 picks FC COIN
    And Player 1 rolls 6 swords and 2 skulls
    And Player 2 picks FC SORCERESS
    And Player 2 rolls 7 skull and 1 coin
    And Player 2 rerolls 1 skull to parrot using Sorceress
    And Player 2 rerolls coin and parrot to get two skulls
    And Player 2 sets islandOfSkulls points
    And Deduct score of Player 1
    And Calculate score of all players
    And find winner
    Then I find that "Player 1" is the winner
    And close server

