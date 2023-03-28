package model;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class DiscountCoupon {
    private Integer CouponId;
    private Integer PremiumPackageID;
    private String DateOfExpiration;
    private String CouponCode;
    private Integer DiscountPercent;

}
