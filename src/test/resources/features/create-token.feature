#language:es
Característica: Creación de token

  @regresion
  Escenario: Crear token
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
    Y que se envia un body 'token'
    Dado que se envia la petición POST al path auth
    Cuando se envia la petición recibo un código 200