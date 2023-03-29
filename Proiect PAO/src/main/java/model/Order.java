package model;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Order {
    private Integer OrderId;
    private Integer ClientId;
    private Integer DriverId;
    private Integer LocationId;
    private static Integer OrderNumber = 0;
    private Double Price;
    private Double DriverTip;
    private String OrderingTime;
    private String ReceivingTime;
    private Boolean Canceled;

    public Order(Integer orderId, Integer clientId, Integer driverId, Integer locationId, Double price, Double driverTip, String orderingTime, String receivingTime) {
        OrderId = orderId;
        ClientId = clientId;
        DriverId = driverId;
        LocationId = locationId;
        Price = price;
        DriverTip = driverTip;
        OrderingTime = orderingTime;
        ReceivingTime = receivingTime;
        Canceled = false;
        OrderNumber += 1;
    }
}
