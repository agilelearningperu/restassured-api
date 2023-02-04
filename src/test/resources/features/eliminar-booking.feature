#language:es
Característica: Eliminar de booking

  Antecedentes: Login
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
    Y que se envia un body 'token'
    Dado que se envia la petición POST al path auth
    Cuando se envia la petición recibo un código 200
    Y guardar el token

  Escenario: Eliminar booking
    Dado que se envia headers
      | atributo     | valor            |
      | Content-Type | application/json |
    Y agregar la sesión al header
    Y que se envia un body 'booking'
    Dado que se envia la petición DELETE al path booking/10809
    Cuando se envia la petición recibo un código 201