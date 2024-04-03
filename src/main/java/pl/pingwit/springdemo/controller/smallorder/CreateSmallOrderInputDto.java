package pl.pingwit.springdemo.controller.smallorder;

public class CreateSmallOrderInputDto {

    private Integer product;
    private Integer quantity;

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
