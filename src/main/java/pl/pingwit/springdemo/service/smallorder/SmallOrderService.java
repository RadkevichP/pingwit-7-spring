package pl.pingwit.springdemo.service.smallorder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pingwit.springdemo.controller.smallorder.CreateSmallOrderInputDto;
import pl.pingwit.springdemo.converter.SmallOrderConverter;
import pl.pingwit.springdemo.exception.PingwitNotFoundException;
import pl.pingwit.springdemo.repository.productbalance.ProductBalance;
import pl.pingwit.springdemo.repository.productbalance.ProductBalanceRepository;
import pl.pingwit.springdemo.repository.smallorder.SmallOrder;
import pl.pingwit.springdemo.repository.smallorder.SmallOrderRepository;

@Service
public class SmallOrderService {

    private final SmallOrderConverter converter;
    private final SmallOrderRepository orderRepository;
    private final ProductBalanceRepository productBalanceRepository;

    public SmallOrderService(SmallOrderConverter converter, SmallOrderRepository orderRepository, ProductBalanceRepository productBalanceRepository) {
        this.converter = converter;
        this.orderRepository = orderRepository;
        this.productBalanceRepository = productBalanceRepository;
    }

    @Transactional
    public Integer createOrder(CreateSmallOrderInputDto inputDto) {
        // сохранить заказ в БД
        SmallOrder entity = converter.toEntity(inputDto);
        SmallOrder savedOrder = orderRepository.save(entity);

        // изменить баланс в БД
        // прочитать начальный баланс,
        // отнять от него количество из заказа,
        // сохранить в БД
        ProductBalance productBalance = productBalanceRepository.findByProductId(inputDto.getProduct())
                .orElseThrow(() -> new PingwitNotFoundException("Balance not found!"));

        int updatedBalance = productBalance.getBalance() - savedOrder.getQuantity();
        productBalance.setBalance(updatedBalance);
        productBalanceRepository.save(productBalance);

        return savedOrder.getId();
    }

}
