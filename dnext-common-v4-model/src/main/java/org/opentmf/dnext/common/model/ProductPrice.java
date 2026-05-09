package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IProductPrice;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An amount, usually of money, that represents the actual price paid by a
 * Customer for a purchase, a rent or a lease of a Product. The price is valid
 * for a defined period of time.
 *
 * <p><br/>
 * <strong>Required:</strong> price, priceType<br/>
 * </p>
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
    defaultImpl = ProductPrice.class
)
@Required(fields = {"price", "priceType"})
public class ProductPrice extends CartPriceBase implements IProductPrice {

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid Price price;

  private @Valid ProductOfferingPriceRef productOfferingPrice;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("productPriceAlteration")
  private List<@Valid PriceAlteration> productPriceAlterations;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("productPriceCharacteristic")
  private List<@Valid Characteristic> productPriceCharacteristics;

  /**
   * Could be minutes, GB...
   */
  private @SafeText String unitOfMeasure;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}