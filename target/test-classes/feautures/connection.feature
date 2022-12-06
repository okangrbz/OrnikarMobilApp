
Feature: Ornikar CréérUnCompte Demo

  @TestcréerMoncompte
  Scenario: TC01 L'utilisateur peut créer son compte sur app Ornikar.
    Given L'utilisateur se rend à l'app Ornikar
    When  L'utilisateur accepte les cookies.
    When L'utilisateur clique sur le premier bouton Je m'inscris gratuitment.
    When L'utilisateur clique sur le bouton Je m'inscris gratuitment.
    When  L'utilisateur renseigne ses informations
    And L'utilisateur coche deux cases d'acceptations
    And L'utilisateur tape sur le bouton Valide
    Then L'utilisateur confirme qu il est bien connecté au site en vérifiant son nom qui s'affiche sur la page confirmation.