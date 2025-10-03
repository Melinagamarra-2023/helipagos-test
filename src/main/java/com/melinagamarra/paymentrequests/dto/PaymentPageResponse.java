package com.melinagamarra.paymentrequests.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPageResponse {
    private List<PaymentResponse>content;
    private int totalPages;
    private long totalElements;
}
