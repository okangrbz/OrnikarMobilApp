
Feature: Ornikar CréérUnCompte Demo

  @TestSmoke
  Scenario: TC01 L'utilisateur peut créer son compte sur app Ornikar.
    Given L'utilisateur se rend à l'app Ornikar
    When L'utilisateur clique sur le bouton Je m'inscris gratuitment.
    And  L'utilisateur renseigne ses informations
    And L'utilisateur coche deux cases d'acceptations
    And L'utilisateur tape sur le bouton Valide
    Then L'utilisateur confirme qu il est bien connecté au site en vérifiant son nom qui s'affiche sur la page confirmation.