package br.com.cwi.external.web.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class PaymentResponse {

    private String id;
}
