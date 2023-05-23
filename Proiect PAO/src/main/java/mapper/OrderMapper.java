package mapper;

import model.Car;
import model.Order;
import model.enums.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderMapper {
    private static final OrderMapper INSTANCE = new OrderMapper();

    private OrderMapper() {
    }

    public static OrderMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Order> mapToOrder(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Order.builder()
                            .OrderId(resultSet.getInt(1))
                            .ClientId(resultSet.getInt(2))
                            .DriverId(resultSet.getInt(3))
                            .LocationId(resultSet.getInt(4))
                            .Price(resultSet.getDouble(5))
                            .DriverTip(resultSet.getDouble(6))
                            .OrderingTime(resultSet.getString(7))
                            .ReceivingTime(resultSet.getString(8))
                            .Canceled(resultSet.getBoolean(9))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Order> mapToOrderList(ResultSet resultSet) throws SQLException {
        List<Order> OrderList = new ArrayList<>();
        while (resultSet.next()) {
            OrderList.add(
                    Order.builder()
                            .OrderId(resultSet.getInt(1))
                            .ClientId(resultSet.getInt(2))
                            .DriverId(resultSet.getInt(3))
                            .LocationId(resultSet.getInt(4))
                            .Price(resultSet.getDouble(5))
                            .DriverTip(resultSet.getDouble(6))
                            .OrderingTime(resultSet.getString(7))
                            .ReceivingTime(resultSet.getString(8))
                            .Canceled(resultSet.getBoolean(9))
                            .build()
            );
        }

        return OrderList;
    }
}
