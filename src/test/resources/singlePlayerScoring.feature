Feature: run the single acceptance test cases

  Scenario: Row45
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls 3 SKULLS and 5 SWORDS
    Then PLayer dies with score 0

  Scenario: Row46
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and four PARROTS and three SWORDS
    And Player rerolls three SWORDS, get two SKULLS and one SWORD
    Then PLayer dies with score 0


  Scenario: Row47
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls two SKULL and four PARROTS and two SWORDS
    And Player rerolls two SWORDS, get one SKULL and one SWORD
    Then PLayer dies with score 0