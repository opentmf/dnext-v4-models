package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Duration;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.Quantity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf620.model.IPOPAlteration;

/**
 * Is an amount, usually of money, that modifies the price charged for an order
 * item.
 *
 * <p><br/>
 * <strong>Required:</strong> price, priceType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = POPAlteration.class
)
@Required(fields = {"price", "priceType"})
public class POPAlteration extends NamedEntity implements IPOPAlteration {

  /**
   * A time interval in a given unit of time.
   */
  private @Valid Duration applicationDuration;

  /**
   * A narrative that explains in detail the semantics of this order item price
   * alteration.
   */
  private @SafeText String description;

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid ProductPriceValue price;

  /**
   * A category that describes the price such as recurring, one time and usage.
   */
  private @SafeText String priceType;

  /**
   * Priority level for applying this alteration among all the defined alterations
   * on the order item price.
   */
  private Integer priority;

  /**
   * Could be month, week...
   */
  private @SafeText String recurringChargePeriod;

  private @Valid Quantity unitOfMeasure;

  private @Valid TimePeriod validFor;
}