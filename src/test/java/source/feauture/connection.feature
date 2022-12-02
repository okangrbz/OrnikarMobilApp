@Uitest
Feature: Ornikar CréérUnCompte Demo

  @Testconnect
  Scenario: TC01 L'utilisateur peut créer son compte sur app Ornikar.
    Given L'utilisateur se rend à l'app Ornikar
    When  L'utilisateur accepte les cookies.
    When  L'utilisateur clique sur la barre de Client et Vendeur
    And L'utilisateur clique sur Se connecter.
    And L'utilisateur entre son adresse mail
    And L'utilisateur entre son mot de passe
    Then L'utilisateur test la fonction de connexion en cliquant sur Connexion.
    And L'utilisateur confirme qu il est bien connecté au site en vérifiant la date d enregistrement.