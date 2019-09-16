# Decapsulate Json

En la clase MainActivity se ejecutan los endpoints de nuestro servicio REST, serializando el JSON recibido a POJOs de nuestro modelo. Como podemos ver el JSON se encuentra encapsulado en la llave "content" para el caso de los endpoints que retornan un array.

[Aquí](https://medium.com/@barcochrist/desencapsular-json-con-retrofit-y-gson-en-android-java-kotlin-94e23f71621) puedes revisar la publicación completa donde te explico cual es el problema y la solución que plantéo.
