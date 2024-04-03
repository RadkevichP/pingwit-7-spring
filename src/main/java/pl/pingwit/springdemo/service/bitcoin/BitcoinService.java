package pl.pingwit.springdemo.service.bitcoin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class BitcoinService {

    private final String url;
    private final RestTemplate restTemplate;

    public BitcoinService(@Value("${pingwit.bitcoin.rate.url}") String url,
                          RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public BigDecimal getCurrentRateToUsd() {
        BitcoinApiResponse response = restTemplate.getForObject(url, BitcoinApiResponse.class);
        return response.getRates().getUsdRate().getRate();
    }
}
