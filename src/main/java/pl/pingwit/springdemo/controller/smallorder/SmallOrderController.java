package pl.pingwit.springdemo.controller.smallorder;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.springdemo.service.smallorder.SmallOrderService;

@RestController
@RequestMapping("/small-order")
public class SmallOrderController {

    private final SmallOrderService orderService;

    public SmallOrderController(SmallOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Integer createSmallOrder(@RequestBody CreateSmallOrderInputDto inputDto) {
        return orderService.createOrder(inputDto);
    }
}
