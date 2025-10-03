package com.melinagamarra.paymentrequests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreateResponse {

        @JsonProperty("id_sp")
        private Integer idSp;

        @JsonProperty("id_cliente")
        private Integer idCliente;

        @JsonProperty("estado")
        private String estado;

        @JsonProperty("referencia_externa")
        private String referenciaExterna;

        @JsonProperty("descripcion")
        private String descripcion;

        @JsonProperty("codigo_barra")
        private String codigoBarra;

        @JsonProperty("id_url")
        private String idUrl;

        @JsonProperty("checkout_url")
        private String checkoutUrl;

        @JsonProperty("short_url")
        private String shortUrl;

        @JsonProperty("fecha_creacion")
        private String fechaCreacion;

        @JsonProperty("fecha_vencimiento")
        private String fechaVencimiento;

        @JsonProperty("fecha_vencimiento_2do")
        private String fechaVencimiento2do;

        @JsonProperty("importe")
        private Integer importe;

        @JsonProperty("recargo")
        private Integer recargo;

        @JsonProperty("qr_data")
        private String qrData;

        @JsonProperty("referencia_externa_2")
        private String referenciaExterna2;

        @JsonProperty("url_redirect")
        private String urlRedirect;

        @JsonProperty("webhook")
        private String webhook;

        @JsonProperty("codigo_servicio")
        private Integer codigoServicio;

        @JsonProperty("numero_factura")
        private String numeroFactura;

        @JsonProperty("numero_conexion")
        private String numeroConexion;

        @JsonProperty("numero_terminal")
        private String numeroTerminal;

        @JsonProperty("numero_cliente")
        private String numeroCliente;

        @JsonProperty("numero_servicio")
        private String numeroServicio;

        @JsonProperty("nombre_usuario")
        private String nombreUsuario;

        @JsonProperty("apellido_usuario")
        private String apellidoUsuario;

        @JsonProperty("razon_social_usuario")
        private String razonSocialUsuario;

        @JsonProperty("numero_documento")
        private String numeroDocumento;

    }


