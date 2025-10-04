package com.melinagamarra.paymentrequests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    @JsonProperty("id_sp")
    private Integer idSp;

    @JsonProperty("codigo_barra")
    private String codigoBarra;

    @JsonProperty("estado_pago")
    private String estadoPago;

    @JsonProperty("medio_pago")
    private String medioPago;

    private String descripcion;
    private Double importe;

    @JsonProperty("importe_vencido")
    private Double importeVencido;

    @JsonProperty("importe_pagado")
    private Double importePagado;

    private Integer cuotas;

    @JsonProperty("referencia_externa")
    private String referenciaExterna;

    @JsonProperty("fecha_pago")
    private String fechaPago;

    @JsonProperty("fecha_acreditacion")
    private String fechaAcreditacion;

    @JsonProperty("fecha_creacion")
    private String fechaCreacion;

    @JsonProperty("fecha_actualizacion")
    private String fechaActualizacion;

    @JsonProperty("fecha_vencimiento")
    private String fechaVencimiento;

    @JsonProperty("segunda_fecha_vencimiento")
    private String segundaFechaVencimiento;

}
