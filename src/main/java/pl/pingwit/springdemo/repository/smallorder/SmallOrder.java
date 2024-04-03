package pl.pingwit.springdemo.repository.smallorder;

import jakarta.persistence.*;

@Entity
@Table(name = "small_orders")
public class SmallOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "small_order_id_generator")
    @SequenceGenerator(name = "small_order_id_generator", sequenceName = "small_order_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
