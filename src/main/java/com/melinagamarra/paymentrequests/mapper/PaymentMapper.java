package com.melinagamarra.paymentrequests.mapper;

import com.melinagamarra.paymentrequests.dto.PaymentPageResponse;
import com.melinagamarra.paymentrequests.dto.PaymentResponse;
import org.springframework.stereotype.Component;


@Component
public class PaymentMapper {
    public PaymentResponse toPaymentResponse(PaymentPageResponse pageResponse) {
        PaymentResponse paymentResponse = null;
        if (pageResponse != null && !pageResponse.getContent().isEmpty()) {
            paymentResponse = PaymentResponse.builder()
                    .idSp(pageResponse.getContent().get(0).getIdSp())
                    .descripcion(pageResponse.getContent().get(0).getDescripcion())
                    .cuotas(pageResponse.getContent().get(0).getCuotas())
                    .codigoBarra(pageResponse.getContent().get(0).getCodigoBarra())
                    .estadoPago(pageResponse.getContent().get(0).getEstadoPago())
                    .medioPago(pageResponse.getContent().get(0).getMedioPago())
                    .importe(pageResponse.getContent().get(0).getImporte())
                    .importeVencido(pageResponse.getContent().get(0).getImporteVencido())
                    .importePagado(pageResponse.getContent().get(0).getImportePagado())
                    .referenciaExterna(pageResponse.getContent().get(0).getReferenciaExterna())
                    .fechaPago(pageResponse.getContent().get(0).getFechaPago())
                    .fechaAcreditacion(pageResponse.getContent().get(0).getFechaAcreditacion())
                    .fechaCreacion(pageResponse.getContent().get(0).getFechaCreacion())
                    .fechaActualizacion(pageResponse.getContent().get(0).getFechaActualizacion())
                    .fechaVencimiento(pageResponse.getContent().get(0).getFechaVencimiento())
                    .segundaFechaVencimiento(pageResponse.getContent().get(0).getSegundaFechaVencimiento())
                    .build();
        }
        return paymentResponse;
    }
}
