package mk.ukim.finki.lab1.lab1.model;

import lombok.Data;

@Data
public class Order {
    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(String balloonColor, String clientName, String clientAddress) {
        this.balloonColor = balloonColor;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }
}
