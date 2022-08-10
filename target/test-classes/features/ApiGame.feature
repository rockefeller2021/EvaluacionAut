@Apigame

  Feature: prueba de api de juegos en linea

    @Escenario1
    Scenario: Operador lista de juegos en linea
      Given que la aplicacion esta operativa
      When obtiene la lista: 1 de juegos suscritos
      Then valida que la respuesta es 200
    @Escenario2

    Scenario: Operador no encuentra cun juego en la lista
      Given que la aplicacion esta operativa
      When obtiene al juego: 521 suscrito
      Then valida la respuesta es 404
















