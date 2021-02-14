# Oposiciones
Una aplicación de escritorio creada para hacer unas oposiciones en un servidor de _roleplay_.

## Requisitos previos
* JDK 8 o JDK 11
* Librería de GSON 
* Librería Lombok
* Java RE 8+
* Conexión a internet

_Todas las dependencias están incluidas en [el pom.xml](https://github.com/Wikijito7/oposiciones/blob/master/pom.xml) incluido en el repositorio y son necesarias si vas
a abrir el proyecto dentro del código_

## Cómo funciona
Al abrir la aplicación intenta leer un _json_ que está guardado en [el repositorio de mi web](https://github.com/Wikijito7/Wikijito7.github.io). Tras hacer la lectura, 
muestra en una ventana las diferentes preguntas. Además de esto, aparece un cuadro de texto para poner una nota sobre su respuesta y distintos _radiochecks_ para puntuar su 
respuesta del 1 al 10.

En el caso de no tener conexión a internet o no encontrarse el _json_ online disponible, existe la posibilidad de hacer la lectura de las distintas preguntas desde local, 
siempre y cuando se encuente disponible en la carpeta _pregunta_ en la raiz en la que se encuentra el _jar_ y, dentro de esta carpeta, un archivo _preguntas.json_ con el formato
de preguntas. Este formato tiene que ser identico [al archivo de ejemplo dentro de este repositorio](https://github.com/Wikijito7/oposiciones/blob/master/pregunta/preguntas.json).

## Proyecto sin finalizar
Este programa está sin finalizar, la lectura del archivo .json, el uso de las preguntas y la generación con todo lo hecho está finalizado, pero puede tener algún fallo o no
funcionar lo mejor posible. 

## Licencia
¡Puedes usar la aplicación o el código de la misma donde quieras! No es necesario, pero estaría bien una pequeña mención.
