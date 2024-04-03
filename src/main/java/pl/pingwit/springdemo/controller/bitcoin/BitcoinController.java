package pl.pingwit.springdemo.controller.bitcoin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.springdemo.service.bitcoin.BitcoinService;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinController {

    private final BitcoinService bitcoinService;

    public BitcoinController(BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping
    public BCResponseDto getBCRate() {
        return new BCResponseDto(bitcoinService.getCurrentRateToUsd());
    }
}
