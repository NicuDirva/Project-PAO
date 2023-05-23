package mapper;

import model.Car;
import model.Order;
import model.OrderReview;
import model.enums.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderReviewMapper {
    private static final OrderReviewMapper INSTANCE = new OrderReviewMapper();

    private OrderReviewMapper() {
    }

    public static OrderReviewMapper getInstance() {
        return INSTANCE;
    }

    public Optional<OrderReview> mapToOrderReview(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    OrderReview.builder()
                            .OrderReviewId(resultSet.getInt(1))
                            .OrderId(resultSet.getInt(2))
                            .NumberOfStarsAwarded(resultSet.getInt(3))
                            .Complaints(resultSet.getString(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<OrderReview> mapToOrderReviewList(ResultSet resultSet) throws SQLException {
        List<OrderReview> OrderReviewList = new ArrayList<>();
        while (resultSet.next()) {
            OrderReviewList.add(
                    OrderReview.builder()
                            .OrderReviewId(resultSet.getInt(1))
                            .OrderId(resultSet.getInt(2))
                            .NumberOfStarsAwarded(resultSet.getInt(3))
                            .Complaints(resultSet.getString(4))
                            .build()
            );
        }

        return OrderReviewList;
    }
}
