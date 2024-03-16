package pl.pingwit.springdemo.repository;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Integer id;
    private LocalDate date;
    private List<OrderItem> orderItemList;
}
