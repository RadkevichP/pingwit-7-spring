package pl.pingwit.springdemo.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.springdemo.controller.smallorder.CreateSmallOrderInputDto;
import pl.pingwit.springdemo.repository.smallorder.SmallOrder;

@Component
public class SmallOrderConverter {


    public SmallOrder toEntity(CreateSmallOrderInputDto inputDto) {
        SmallOrder smallOrder = new SmallOrder();

        smallOrder.setProductId(inputDto.getProduct());
        smallOrder.setQuantity(inputDto.getQuantity());

        return smallOrder;
    }
}
