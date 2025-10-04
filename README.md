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



▶️ Cómo levantar el servidor

Clonar el repositorio
Definir variables de entorno
Ejecutar:
./mvnw spring-boot:run

🤔 Decisiones técnicas

Variables de entorno para configuración
Se usan variables de entorno para la URL base y el Bearer Token, evitando exponer credenciales en el código y permitiendo portabilidad entre entornos.
Mapper para estructurar la respuesta
Se implementó la clase PaymentMapper, cuya responsabilidad es transformar un PaymentPageResponse (formato devuelto por la API externa, que contiene un content con la lista de pagos) en una lista de PaymentResponse más simple y usable internamente.
Dar más estructura y claridad a la respuesta que maneja la aplicación.

```yaml
🚀 Uso con Postman

GET {{base_url}}/payments?page=0&size=10
Authorization: {{api_token}}

GET {{base_url}}/payments/{id}
Authorization: {{api_token}}

POST {{base_url}}/payments/create
Authorization: {{api_token}}
{
    "importe": 2000,
    "fecha_vto": "2025-10-11",
    "recargo": 123456,
    "fecha_2do_vto": "2025-10-12",
    "descripcion": "Prueba",
    "referencia_externa": "TEST",
    "url_redirect": "https://www.helipagos.com",
    "webhook": "https://webhook.site/d8cced7a-2b90-4a21-930a-c52eaff1cd51",
    "qr": true
}


Estructura de carpetas

paymentrequests/
├── src/
│   ├── main/
│   │   ├── java/com/melinagamarra/paymentrequests/
            ├── config/
│   │   │   │   └── WebClientConfig.java      
│   │   │   ├── controller/
│   │   │   │   └── WebClientController.java  
│   │   │   ├── dto/
│   │   │   │   ├── PaymentRequest.java       
│   │   │   │   ├── PaymentResponse.java      
│   │   │   │   ├── PaymentPageResponse.java  
│   │   │   │   └── PaymentCreateResponse.java
│   │   │   ├── exception/
│   │   │   │   ├── ErrorResponse.java       
│   │   │   │   └── GlobalExceptionHandler.java 
│   │   │   ├── filter/
│   │   │   │   └── LoggingFilter.java        
│   │   │   ├── mapper/
│   │   │   │   └── PaymentMapper.java        
│   │   │   ├── service/
│   │   │   │   └── WebClientService.java     
│   │   │   └── PaymentrequestsApplication.java 
│   │   └── resources/
│   │       ├── application.yml               
│   │       ├── application-dev.yml           
│   │       └── application-test.yml                     
│   └── test/
│       └── java/com/melinagamarra/paymentrequests/
│           ├── service/
│              └── WebClientServiceTest.java   
├── pom.xml                                     
                                   


                              
                
