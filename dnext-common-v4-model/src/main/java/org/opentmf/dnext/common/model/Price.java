package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPrice;

/**
 * Provides all amounts (tax included, duty free, tax rate), used currency and
 * percentage to apply for Price Alteration.
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
    defaultImpl = Price.class
)
public class Price extends Entity implements IPrice {

  /**
   * All taxes excluded amount (expressed in the given currency).
   */
  private @Valid Money dutyFreeAmount;

  /**
   * Percentage to apply for ProdOfferPriceAlteration.
   */
  private BigDecimal percentage;

  /**
   * Tax.
   */
  @JsonProperty("tax")
  private List<@Valid TaxItem> taxes;

  /**
   * All taxes included amount (expressed in the given currency).
   */
  private @Valid Money taxIncludedAmount;

  /**
   * Tax rate.
   */
  private BigDecimal taxRate;
}