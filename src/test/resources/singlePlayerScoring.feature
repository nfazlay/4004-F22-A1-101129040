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

  Scenario: Row48
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and four PARROTS and three SWORDS
    And Player rerolls three SWORDS, get one SKULL and two MONKEY
    And Player rerolls two MONKEYS, get one SKULL and one MONKEY
    Then PLayer dies with score 0

  Scenario: Row50
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and two PARROTS and three SWORDS and two GOLD COIN
    And Player rerolls two PARROTS, get two GOLD COIN
    And Player rerolls three SWORDS, get three GOLD COIN
    Then PLayer scores 4800

  Scenario: Row52
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls two MONKEYS and two PARROTS and two DIAMONDS and two GOLD COIN
    Then PLayer scores 800

  Scenario: Row53
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls two MONKEYS and two SKULLS and two SWORDS and two PARROTS
    And Player rerolls two PARROTS, get one SWORD and one MONKEY
    Then PLayer scores 300