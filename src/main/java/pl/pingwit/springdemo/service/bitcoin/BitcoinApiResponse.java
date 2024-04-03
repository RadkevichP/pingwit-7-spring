package pl.pingwit.springdemo.service.bitcoin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinApiResponse {

    @JsonProperty("bpi")
    private BitcoinCurrencyRates rates;

    public BitcoinCurrencyRates getRates() {
        return rates;
    }

    public void setRates(BitcoinCurrencyRates rates) {
        this.rates = rates;
    }
}
