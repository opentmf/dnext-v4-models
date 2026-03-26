package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.tmf620.model.IProductPriceValue;

/**
 * Provides all amounts (tax included, duty free, tax rate), used currency and
 * percentage to apply for Price Alteration.
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
    defaultImpl = ProductPriceValue.class
)
public class ProductPriceValue extends Entity implements IProductPriceValue {

  private @Valid Money dutyFreeAmount;

  /**
   * Percentage to apply for ProdOfferPriceAlteration.
   */
  private BigDecimal percentage;

  /**
   * Tax category.
   */
  private @SafeText String taxCategory;

  private @Valid Money taxIncludedAmount;

  /**
   * Tax rate.
   */
  private BigDecimal taxRate;
}