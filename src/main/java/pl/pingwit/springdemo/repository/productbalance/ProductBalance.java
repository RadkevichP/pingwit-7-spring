package pl.pingwit.springdemo.repository.productbalance;

import jakarta.persistence.*;

@Entity
@Table(name = "products_balance")
public class ProductBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_balance_id_generator")
    @SequenceGenerator(name = "products_balance_id_generator", sequenceName = "products_balance_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "balance")
    private Integer balance;

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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
