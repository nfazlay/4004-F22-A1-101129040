Feature: run the single acceptance test cases

  Scenario: Single player Scoring Row45
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls 3 SKULLS and 5 SWORDS
    Then PLayer dies with score 0

  Scenario: Single player Scoring Row46
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and four PARROTS and three SWORDS
    And Player rerolls three SWORDS, get two SKULLS and one SWORD
    Then PLayer dies with score 0

  Scenario: Single player Scoring Row47
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls two SKULL and four PARROTS and two SWORDS
    And Player rerolls two SWORDS, get one SKULL and one SWORD
    Then PLayer dies with score 0

  Scenario: Single player Scoring Row48
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and four PARROTS and three SWORDS
    And Player rerolls three SWORDS, get one SKULL and two MONKEY
    And Player rerolls two MONKEYS, get one SKULL and one MONKEY
    Then PLayer dies with score 0

  Scenario: Single player Scoring Row50
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and two PARROTS and three SWORDS and two GOLD COIN
    And Player rerolls two PARROTS, get two GOLD COIN
    And Player rerolls three SWORDS, get three GOLD COIN
    Then PLayer scores 4800

  Scenario: Single player Scoring Row52
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls two MONKEYS and two PARROTS and two DIAMONDS and two GOLD COIN
    Then PLayer scores 800

  Scenario: Single player Scoring Row53
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls two MONKEYS and two SKULLS and two SWORDS and two PARROTS
    And Player rerolls two PARROTS, get one SWORD and one MONKEY
    Then PLayer scores 300

  Scenario: Single player Scoring Row54
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three MONKEYS and three SWORDS and two SKULLS
    Then PLayer scores 300

  Scenario: Single player Scoring Row55
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three DIAMONDS and two SKULLS and one MONKEY and one SWORD and one PARROT
    Then PLayer scores 500

  Scenario: Single player Scoring Row56
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls four GOLD COIN and two SKULLS and two SWORDS
    Then PLayer scores 700

  Scenario: Single player Scoring Row57
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three SWORDS and four PARROTS and one SKULL
    Then PLayer scores 400

  Scenario: Single player Scoring Row58
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and two GOLD COIN and two PARROTS and three SWORDS
    And Player rerolls two PARROTS, get one SWORD and one GOLD COIN
    Then PLayer scores 800

  Scenario: Single player Scoring Row59
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls one SKULL and two GOLD COIN and two PARROTS and three SWORDS
    And Player rerolls two PARROTS, get one SWORD and one GOLD COIN
    Then PLayer scores 1200

  Scenario: Single player Scoring Row60
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and two MONKEY and two PARROTS and three SWORDS
    And Player rerolls two MONKEYS, get one SKULL and one SWORD
    And Player rerolls two PARROTS, get one SWORD and one MONKEY
    Then PLayer scores 600

  Scenario: Single player Scoring Row62
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls six MONKEYS and two SKULL
    Then PLayer scores 1100

  Scenario: Single player Scoring Row63
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls seven PARROTS and one SKULL
    Then PLayer scores 2100

  Scenario: Single player Scoring Row64
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls eight GOLD COINS
    Then PLayer scores 5400

  Scenario: Single player Scoring Row65
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls eight GOLD COINS
    Then PLayer scores 5400

  Scenario: Single player Scoring Row66
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls eight SWORDS
    Then PLayer scores 9000

  Scenario: Single player Scoring Row67
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls six MONKEYS and two SWORDS
    And Player rerolls two SWORDS, get two MONKEYS
    Then PLayer scores 4600

  Scenario: Single player Scoring Row68
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls two MONKEYS and two SKULLS and two SWORDS and two PARROTS
    And Player rerolls two PARROTS, get two DIAMOND
    Then PLayer scores 400

  Scenario: Single player Scoring Row69
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls two MONKEYS and two SKULLS and two SWORDS and one DIAMOND and one PARROT
    And Player rerolls two MONKEYS, get two DIAMONDS
    Then PLayer scores 500

  Scenario: Single player Scoring Row70
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls one SKULL and two GOLD COIN and one MONKEY and one PARROT and three SWORDS
    And Player rerolls three SWORDS, get one GOLD COIN and one MONKEY and one PARROT
    Then PLayer scores 600

  Scenario: Single player Scoring Row71
    Given That a player is initialized
    When Player picks DIAMOND
    And Player rolls one SKULL and two GOLD COIN and one MONKEY and one PARROT and three SWORDS
    And Player rerolls three SWORDS, get one GOLD COIN and one MONKEY and one PARROT
    Then PLayer scores 500

  Scenario: Single player Scoring Row72
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls four MONKEYS and two COINS and two SKULLS
    Then PLayer scores 600

  Scenario: Row77
    Given That a player is initialized
    When Player picks SORCERESS
    And Player rolls two DIAMONDS and one SWORD and one MONKEY and one COIN and three PARROTS
    And Player rerolls three PARROTS, gets one SKULL and two MONKEYS
    And Player rerolls one SKULL, get one MONKEY
    Then PLayer scores 500

  Scenario: Row78
    Given That a player is initialized
    When Player picks SORCERESS
    And Player rolls three SKULLS and three PARROTS and two SWORDS
    And Player rerolls one SKULL, get one PARROT
    And Player rerolls two SWORDS, get two PARROTS
    Then PLayer scores 1000

  Scenario: Row79
    Given That a player is initialized
    When Player picks SORCERESS
    And Player rolls one SKULL and four PARROTS and three MONKEYS
    And Player rerolls three MONKEYS, get one SKULL and two PARROTS
    And Player rerolls one SKULL and get one PARROT
    Then PLayer scores 2000

  Scenario: Row82
    Given That a player is initialized
    When Player picks MONKEY
    And Player rolls three MONKEYS and three PARROTS and one SKULL and one GOLD COIN
    Then PLayer scores 1100

  Scenario: Row83
    Given That a player is initialized
    When Player picks MONKEY
    And Player rolls two MONKEYS and two SWORDS and two PARROTS and GOLD COIN
    And Player rerolls two SWORDS, get one MONKEY and one PARROT
    Then PLayer scores 1700

  Scenario: Row84
    Given That a player is initialized
    When Player picks MONKEY
    And Player rolls three SKULLS and three MONKEYS and two PARROT
    Then PLayer dies with score 0

  Scenario: Row87
    Given That a player is initialized
    When Player picks CHEST
    And Player rolls three PARROTS and two SWORDS and two DIAMONDS and one COIN
    And Player puts two DIAMONDS and one GOLD COIN in chest
    And Player rerolls two SWORDS, get two PARROTS
    And Player puts five PARROTS and take out two DIAMONDS and one COIN fom chest
    And Player rerolls two DIAMONDS and one GOLD COIN, gets one SKULL and one GOLD COIN and one PARROT
    Then PLayer scores 1100

  Scenario: Row92
    Given That a player is initialized
    When Player picks CHEST
    And Player rolls two SKULLS and three PARROTS and three COINS
    And Player puts three COINS in chest
    And Player rerolls three PARROTS, get two DIAMONDS and one GOLD COIN
    And Player puts one COIN in chest
    And Player rerolls two DIAMONDS, gets one SKULL and one GOLD COIN
    Then PLayer scores 600 from chest

  Scenario: Full chest Row97
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three MONKEYS and three SWORDS and one DIAMOND and one PARROT
    Then PLayer scores 400

  Scenario: Full chest Row98
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls three MONKEYS and three SWORDS and two GOLD COINS
    Then PLayer scores 1800

  Scenario: Full chest Row99
    Given That a player is initialized
    When Player picks GOLD card
    And Player rolls three MONKEYS and four SWORDS and one DIAMOND
    Then PLayer scores 1000

  Scenario: Full chest Row100
    Given That a player is initialized
    When Player picks BATTLE 2 300
    And Player rolls four MONKEYS and one SWORD and two PARROTS and one GOLD COIN
    And Player rerolls two PARROTS, get one GOLD COIN and one SWORD
    Then PLayer scores 1200

  Scenario: Full chest Row103
    Given That a player is initialized
    When Player picks MONKEY
    And Player rolls two MONKEYS and one PARROT and two COIN and three DIAMONDS
    Then PLayer scores 1200

  Scenario: Skulls Island and Skull Fortune Cards Row106
    Given That a player is initialized
    When Player picks SKULL 2
    And Player rolls one SKULL and seven SWORDS
    Then PLayer dies with score 0

  Scenario: Skulls Island and Skull Fortune Cards Row107
    Given That a player is initialized
    When Player picks SKULL 1
    And Player rolls two SKULL and six SWORDS
    Then PLayer dies with score 0

  Scenario: Skulls Island and Skull Fortune Cards Row108
    Given That a player is initialized
    When Player picks SKULL 2
    And Player rolls two SKULL and three PARROTS and three MONKEYS
    And Player rerolls three PARROTS, get two SKULLS and one SWORD
    And Player rerolls one SWORD and threee MONKEYS, get three SKULL and one COIN
    Then Other players lose 900 points
    And PLayer dies with score 0

  Scenario: Skulls Island and Skull Fortune Cards Row110
    Given That a player is initialized
    When Player picks CAPTAIN card
    And Player rolls five SKULL and three MONKEYS
    And Player rerolls three MONKEYS, get two SKULLS and one COIN
    Then Other players lose 1400 points

  Scenario: Skulls Island and Skull Fortune Cards Row111
    Given That a player is initialized
    When Player picks SKULL 2
    And Player rolls three SKULL and five SWORDS
    And Player rerolls five SWORDS, get five GOLD COIN
    Then Other players lose 500 points
