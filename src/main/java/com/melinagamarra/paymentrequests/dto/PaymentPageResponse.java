package com.melinagamarra.paymentrequests.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentPageResponse {
    private List<PaymentResponse> content;
    private int totalPages;
    private long totalElements;
}
