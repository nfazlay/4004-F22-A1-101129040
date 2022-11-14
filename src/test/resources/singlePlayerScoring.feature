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

  Scenario: Row54
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three MONKEYS and three SWORDS and two SKULLS
    Then PLayer scores 300

  Scenario: Row55
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three DIAMONDS and two SKULLS and one MONKEY and one SWORD and one PARROT
    Then PLayer scores 500

  Scenario: Row56
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls four GOLD COIN and two SKULLS and two SWORDS
    Then PLayer scores 700

  Scenario: Row57
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three SWORDS and four PARROTS and one SKULL
    Then PLayer scores 400

  Scenario: Row58
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and two GOLD COIN and two PARROTS and three SWORDS
    And Player rerolls two PARROTS, get one SWORD and one GOLD COIN
    Then PLayer scores 800

  Scenario: Row59
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls one SKULL and two GOLD COIN and two PARROTS and three SWORDS
    And Player rerolls two PARROTS, get one SWORD and one GOLD COIN
    Then PLayer scores 1200

  Scenario: Row60
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls one SKULL and two MONKEY and two PARROTS and three SWORDS
    And Player rerolls two MONKEYS, get one SKULL and one SWORD
    And Player rerolls two MONKEYS, get one SWORD and one MONKEY
    Then PLayer scores 600

  Scenario: Row62
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls six MONKEYS and two SKULL
    Then PLayer scores 1100

  Scenario: Row63
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls seven PARROTS and one SKULL
    Then PLayer scores 2100

  Scenario: Row64
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls eight GOLD COINS
    Then PLayer scores 5400

  Scenario: Row65
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls eight GOLD COINS
    Then PLayer scores 5400

  Scenario: Row66
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls eight SWORDS
    Then PLayer scores 9000

  Scenario: Row67
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls six MONKEYS and two SWORDS
    And Player rerolls two SWORDS, get two MONKEYS
    Then PLayer scores 4600

  Scenario: Row68
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls six MONKEYS and two SWORDS
    And Player rerolls two SWORDS, get two MONKEYS
    Then PLayer scores 400