package br.com.cwi.external.web.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentStatusResponse {

    private String id;
    private PaymentStatus status;

    public enum PaymentStatus {
        PENDENTE,
        APROVADO
    }
}
