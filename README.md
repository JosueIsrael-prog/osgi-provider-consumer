Proyecto OSGi Provider & Consumer

Universidad de Las Américas (UDLA) – Ingeniería de Software

Este proyecto implementa dos bundles OSGi que demuestran el registro y consumo de servicios dentro del contenedor Apache Karaf (v4.4.8) usando Java 17 y Maven Bundle Plugin.

 Estructura del proyecto

/provider → Contiene la interfaz y la implementación del servicio (HelloService)
/consumer → Consume el servicio HelloService registrado por el provider
/install.txt → Instrucciones de despliegue

 Tecnologías utilizadas

Java 17

Apache Karaf 4.4.8

Maven 3.9+

OSGi Core 6.0.0

Apache Felix Maven Bundle Plugin 5.1.8

 Compilación y empaquetado

Ejecuta los siguientes comandos desde la raíz del proyecto:

mvn -f provider clean package
mvn -f consumer clean package

Esto generará los archivos:
provider/target/provider-1.0.0.jar
consumer/target/consumer-1.0.0.jar

 Ejecución en Apache Karaf

Abre Karaf 4.4.8 con el archivo personalizado:
karaf17.cmd

Instala los bundles:
bundle:install -s file:///C:/OSGI/lab/provider/target/provider-1.0.0.jar
bundle:install -s file:///C:/OSGI/lab/consumer/target/consumer-1.0.0.jar

Verifica el registro del servicio:
service:list | grep -i HelloService

Si deseas reiniciar el consumer:
bundle:restart 55

 Clases principales

HelloService.java → Define la interfaz del servicio.
HelloServiceImpl.java → Implementa el servicio que provee el provider.
ProviderActivator.java → Registra el servicio en el contexto OSGi.
ConsumerActivator.java → Obtiene y utiliza el servicio registrado.

 Ejemplo de salida en Karaf

[provider] HelloService registrado correctamente
[consumer] HelloService encontrado

 Autor

Josué Cevallos
 ji8792752@gmail.com

 Repositorio GitHub

 Información adicional

Este trabajo demuestra conceptos de arquitectura modular y dinámica en OSGi, donde los bundles pueden instalarse, actualizarse o reiniciarse sin detener el contenedor principal.

© 2025 Universidad de Las Américas – Ingeniería de Software
