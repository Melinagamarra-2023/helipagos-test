package com.melinagamarra.paymentrequests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    @Min(value = 1, message = "El importe debe ser mayor a 0")
    @JsonProperty("importe")
    private Integer importe;

    @NotBlank(message = "La fecha de vencimiento no puede estar vacía")
    @JsonProperty("fecha_vto")
    private String fechaVto;

    @Min(value = 0, message = "El recargo no puede ser negativo")
    @JsonProperty("recargo")
    private Integer recargo;

    @JsonProperty("fecha_2do_vto")
    private String fecha2doVto;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, message = "La descripción debe tener al menos 5 caracteres")
    @JsonProperty("descripcion")
    private String descripcion;

    @NotBlank(message = "La referencia externa no puede estar vacía")
    @JsonProperty("referencia_externa")
    private String referenciaExterna;

    @NotBlank(message = "La URL de redirección no puede estar vacía")
    @JsonProperty("url_redirect")
    private String urlRedirect;

    //@NotBlank(message = "El webhook no puede estar vacío")
    @JsonProperty("webhook")
    private String webhook;

    @JsonProperty("qr")
    private boolean qr;

}

