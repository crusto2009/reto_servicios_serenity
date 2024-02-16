#language: es

  #Comentarios por post Id
Característica: Supervisar titulos vacios de las publicaciones.
  @GetServiceTodos
  Escenario: Validar  titulos de las publicaciones no esten vacios
    Cuando accedo al titulo de publicacion atraves del endpoint
    Entonces valido que el texto del titulo no este vacio