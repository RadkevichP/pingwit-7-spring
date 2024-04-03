package pl.pingwit.springdemo.controller.bitcoin;

import java.math.BigDecimal;

public class BCResponseDto {

    private final BigDecimal rate;


    public BCResponseDto(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
