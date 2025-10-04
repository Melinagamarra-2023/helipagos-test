# HeliPagos – Prueba Técnica

Proyecto **Spring Boot** para consumir la API de **Helipagos** utilizando `WebClient`.  
Se incluyen **tests unitarios** con `MockWebServer` para validar la integración con la API de manera desacoplada.

---

## 🚀 Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.5.6**
  - Spring WebFlux (`WebClient`)
  - Spring MVC
  - Spring Validation
- **JUnit 5**
- **Mockito**
- **MockWebServer** (simulación de la API externa)

---

## ⚙️ Configuración

### Variables de entorno
El cliente `WebClient` utiliza variables de entorno para conectarse a la API de Helipagos:

- `HELIPAGOS_BASE_URL`: https://sandbox.helipagos.com  
- `HELIPAGOS_API_TOKEN`: El token será provisto por la administración de Helipagos

Ejemplo en `application.yml`:


▶️ Cómo levantar el servidor

Clonar el repositorio
Definir variables de entorno
Ejecutar:
./mvnw spring-boot:run

🧪 Cómo correr los tests

Ejecutar:
./mvnw clean test
Esto dispara los tests unitarios ubicados en src/test/java/com/melinagamarra/paymentrequests/service/WebClientServiceTest.java.

🤔 Decisiones técnicas
Variables de entorno para configuración
Se usan variables de entorno para la URL base y el Bearer Token, evitando exponer credenciales en el código y permitiendo portabilidad entre entornos.
Mapper para estructurar la respuesta
Se implementó la clase PaymentMapper, cuya responsabilidad es transformar un PaymentPageResponse (formato devuelto por la API externa, que contiene un content con la lista de pagos) en una lista de PaymentResponse más simple y usable internamente.
Dar más estructura y claridad a la respuesta que maneja la aplicación.


##Estructura de carpetas

paymentrequests/
├── src/
│   ├── main/
│   │   ├── java/com/melinagamarra/paymentrequests/
│   │   │   ├── controller/
│   │   │   │   └── WebClientController.java     # Exposición de endpoints REST
│   │   │   ├── service/
│   │   │   │   └── WebClientService.java        # Lógica de consumo de la API Helipagos
│   │   │   ├── dto/
│   │   │   │   ├── PaymentRequest.java          # Request interno
│   │   │   │   ├── PaymentResponse.java         # Response interno
│   │   │   │   ├── PaymentPageResponse.java     # Response externo con content
│   │   │   │   └── PaymentCreateResponse.java   # Response al crear pago
│   │   │   ├── mapper/
│   │   │   │   └── PaymentMapper.java           # Conversión de respuestas externas a internas
│   │   │   └── PaymentrequestsApplication.java  # Clase principal Spring Boot
│   │   └── resources/
│   │       ├── application.yml                  # Configuración general
│   │       ├── application-dev.yml              # Configuración para desarrollo
│   │       └── application-test.yml             # Configuración para tests
│   └── test/
│       └── java/com/melinagamarra/paymentrequests/
│           ├── service/
│               └── WebClientServiceTest.java    # Tests unitarios con MockWebServer
│           
│                
├── pom.xml                                      
└── README.md                                    
                
