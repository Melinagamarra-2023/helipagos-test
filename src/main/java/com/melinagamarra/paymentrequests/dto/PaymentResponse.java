package com.melinagamarra.paymentrequests.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private Integer id_sp;
    private String codigo_barra;
    private String estado_pago;
    private String medio_pago;
    private String descripcion;
    private Double importe;
    private Double importe_vencido;
    private Double importe_pagado;
    private Integer cuotas;
    private String referencia_externa;
    private String fecha_pago;
    private String fecha_acreditacion;
    private String fecha_creacion;
    private String fecha_actualizacion;
    private String fecha_vencimiento;
    private String segunda_fecha_vencimiento;

}
