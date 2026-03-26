package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-637: Product Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = PriceBase.class
)
public abstract class PriceBase extends NamedEntity {

  private @SafeText String advancedPricingMethod;

  private @SafeText String description;

  private @SafeText String priceType;

  private @SafeText String pricingCategory;

  private @Valid ProductOfferingPriceRef productOfferingPrice;

  private @SafeText String recurringChargePeriod;

  private Integer recurringChargePeriodCount;

  private Integer recurringChargePeriodLength;

  private @SafeText String salesTime;
}