package model;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class OrderReview {
    private Integer OrderReviewId;
    private Integer OrderId;
    private Integer NumberOfStarsAwarded;

    private String Complaints;
}
