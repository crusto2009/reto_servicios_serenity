#language: es

  #Comentarios por post Id
Característica: Visualizar todos los comentarios relacionados con un postId.
  @GetServiceCommentsForId
  Escenario: Obtener comentarios para un postId específico
    Cuando se realiza una solicitud GET al servicio comentarios  con un postId
    Entonces se debe recibir una respuesta con la información de todos los comentarios relacionados con el postId
