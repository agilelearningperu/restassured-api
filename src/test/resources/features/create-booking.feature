#language:es
Característica: Creación de booking

  @regresion
  Escenario: Crear booking
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
    Y que se envia un body 'booking'
    Dado que se envia la petición POST al path booking
    Cuando se envia la petición recibo un código 200