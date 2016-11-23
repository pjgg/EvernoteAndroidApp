# Evernote Android App

En esta app se pretende abordar los siguientes puntos desde un punto de vista de consumo de API.

  - Exista una pantalla inicial de login, donde el usuario pueda introducir sus credenciales para tener acceso a su cuenta Evernote. (https://evernote.com/)

![alt text] [login]
![alt text] [credentials]

  - Una vez introducidos los credenciales, se mostrarán en pantalla todas las notas creadas por el usuario.

![alt text] [mainActivityEmpty]
![alt text] [orderNoteByTitle]

  - Dicha pantalla tendrá un menú desplegable con dos opciones. Una de ellas ordenará la lista por el título de la nota y la otra, por fecha de creación o modificación.

![alt text] [orderNoteByUpdateDate]

  - Al hacer tap sobre una nota, se accederá al contenido de la misma. No es necesario que las notas sean editables.

![alt text] [showNoteBody]

  - Existirá un botón para “añadir nota” que permitirá crear una (con título y cuerpo) y posteriormente, guardarla.

![alt text] [createNewNote]

  - Al crear una nota, se podrá elegir entre crearla mediante el teclado o bien escribir sobre la pantalla; donde un OCR convertirá la escritura en tipografía de computadora.(Not implemented yet).


[login]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/login.png
[credentials]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/credentials.png
[createNewNote]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/createNewNote.png
[mainActivityEmpty]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/mainActivityEmpty.png
[orderNoteByTitle]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/orderNoteByTitle.png
[orderNoteByUpdateDate]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/orderNoteByUpdateDate.png
[showNoteBody]: https://github.com/pjgg/EvernoteAndroidApp/blob/master/doc-img/showNoteBody.png
