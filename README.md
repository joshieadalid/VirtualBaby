# VirtualBaby
Primer proyecto para Análisis y Diseño de Sistemas
# Instalación
## Programas
* Java JDK 18 (Semeru)
* Este proyecto está basado en Jakarta 6.0.0
* El contenedor de Servlets es Apache Tomcat 10.1.5
* El controlador JDBC es MariaDB 3.1.2
* El sistema constructor de dependencias es Maven.
* El gestor de la base de datos es phpMyAdmin 5.2.0 o MySQL por el puerto '3306'
  * Server: Localhost via UNIX socket
  * Server type: MariaDB
  * Server connection: SSL is not being used Documentation
  * Server version: 10.4.27-MariaDB - Source distribution
  * Protocol version: 10
  * User: root@localhost
    * La clase controladora personalizada está pensada con una base de datos con contraseña "root"
  * Server charset: cp1252 West European (latin1)  
  * Apache/2.4.54 (Unix) OpenSSL/1.1.1s PHP/8.2.0 mod_perl/2.0.12 Perl/v5.34.1
  * Database client version: libmysql - mysqlnd 8.2.0
  * PHP extension: mysqli Documentation curl Documentation mbstring Documentation
  * PHP version: 8.2.0
La url del despliegue es: http://localhost:8080/VirtualBaby_war/

Instrucciones:
1. Descarga e instala el JDK 18 Semeru de Java. Asegúrate de agregar Java al PATH del sistema.
2. Descarga e instala Apache Tomcat 10.1.5. Extrae los archivos de la distribución en una carpeta de tu elección.
3. Descarga el controlador JDBC de MariaDB 3.1.2 y copia el archivo JAR en la carpeta "lib" dentro de la carpeta de instalación de Tomcat.
4. Descarga e instala Maven. Asegúrate de agregar Maven al PATH del sistema.
5. Descarga e instala phpMyAdmin 5.2.0 o MySQL en el puerto 3306.
6. Crea una base de datos en phpMyAdmin con el nombre "VirtualBaby".
7. Descarga el archivo WAR de VirtualBaby desde la URL de despliegue http://localhost:8080/VirtualBaby_war/.
8. Abre una terminal y navega hasta la carpeta que contiene el archivo WAR descargado.
9. Ejecuta el siguiente comando para compilar el proyecto usando Maven:
```mvn package```
10. Copia el archivo WAR generado en la carpeta "webapps" dentro de la carpeta de instalación de Tomcat.
11. Inicia Tomcat ejecutando el siguiente comando desde la carpeta "bin" de la instalación de Tomcat:
```catalina run```
Abre un navegador y accede a la URL http://localhost:8080/VirtualBaby_war/ para ejecutar la aplicación.

Nota: Asegúrate de que el servidor de base de datos esté funcionando y configurado correctamente para que la aplicación se conecte correctamente. Además, si se requiere alguna contraseña para
acceder al servidor de base de datos, asegúrate de actualizar la configuración de la aplicación para que coincida con la contraseña correcta.
