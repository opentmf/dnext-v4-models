package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>CartPrice (663)</li>
 *   <li>OrderPrice (622)</li>
 *   <li>PriceAlteration (622, 637, 648, 658, 663)</li>
 *   <li>ProductPrice (622, 637, 648, 658, 663)</li>
 *   <li>QuotePrice (648)</li>
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
    defaultImpl = CartPriceBase.class
)
public abstract class CartPriceBase extends Extensible {

  private @SafeText String advancedPricingMethod;

  private @SafeText String description;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  private @SafeText String name;

  private @SafeText String priceType;

  private @SafeText String pricingCategory;

  private @SafeText String recurringChargePeriod;

  private Integer recurringChargePeriodCount;

  private Integer recurringChargePeriodLength;

  private @SafeText String salesTime;
}