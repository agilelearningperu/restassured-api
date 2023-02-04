#language:es
Característica: Actualización de booking

  Antecedentes: Login
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
    Y que se envia un body 'token'
    Dado que se envia la petición POST al path auth
    Cuando se envia la petición recibo un código 200
    Y guardar el token

  @regresion
  Escenario: actualizar todo el booking
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
      | Accept       | application/json |
    Y agregar la sesión al header
    Y que se envia un body 'booking'
    Dado que se envia la petición PUT al path booking/1262
    Cuando se envia la petición recibo un código 200

  Escenario: actualizar todo el booking
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
      | Accept       | application/json |
    Y agregar la sesión al header
    Y que se envia un body 'booking'
    Dado que se envia la petición PATCH al path booking/1262
    Cuando se envia la petición recibo un código 200