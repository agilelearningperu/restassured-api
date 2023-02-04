#language:es
Característica: GET Booking

  Escenario: Consulta booking
    Dado que se envia la petición GET al path booking
    Cuando se envia la petición recibo un código 200
    Entonces se valida el esquema de la respuesta con el archivo 'getbooking-schema'

  Escenario: Consulta booking especifico
    Dado que se envia la petición GET al path booking/1621
    Cuando se envia la petición recibo un código 200
    Entonces se valida el esquema de la respuesta con el archivo 'getbookingid-schema'
    Y validar valores de la respuesta de booking
      | nombre    | apellido | precio | deposito | fecha_inicio | fecha_fin | informacion |
      | Alexander |          |        |          |              |           |             |

  @regresion
  Esquema del escenario: Consultas booking
    Dado que se envia la petición <method> al path <path>
    Cuando se envia la petición recibo un código <codigo>
    Entonces se valida el esquema de la respuesta con el archivo '<schema>'

    Ejemplos: booking
      | method | path        | codigo | schema              |
      | GET    | booking     | 200    | getbooking-schema   |
      | GET    | booking/245 | 200    | getbookingid-schema |