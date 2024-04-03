package pl.pingwit.springdemo.service.bitcoin;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinCurrencyRates {

    @JsonProperty("USD")
    private BitcoinRate usdRate;

    @JsonProperty("GBP")
    private BitcoinRate gbpRate;

    @JsonProperty("EUR")
    private BitcoinRate eurRate;

    public BitcoinRate getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(BitcoinRate usdRate) {
        this.usdRate = usdRate;
    }

    public BitcoinRate getGbpRate() {
        return gbpRate;
    }

    public void setGbpRate(BitcoinRate gbpRate) {
        this.gbpRate = gbpRate;
    }

    public BitcoinRate getEurRate() {
        return eurRate;
    }

    public void setEurRate(BitcoinRate eurRate) {
        this.eurRate = eurRate;
    }
}
