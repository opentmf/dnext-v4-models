package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.ConstraintRef;
import org.opentmf.dnext.common.model.Quantity;
import org.opentmf.dnext.common.model.ServiceSpecificationRef;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf620.model.IProductOfferingPriceRefOrValue;

/**
 * A new product offering price being created by value or a reference to an
 * existing product offering price that already created. The polymorphic
 * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the product
 * offering price and not to this ReforValue structure.
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
    defaultImpl = ProductOfferingPriceRefOrValue.class
)
public class ProductOfferingPriceRefOrValue extends ServiceSpecificationRef implements IProductOfferingPriceRefOrValue {

  /**
   * The Constraint resource represents a policy/rule applied to
   * ProductOfferingPrice.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Description of the productOfferingPrice.
   */
  private @SafeText String description;

  /**
   * the last update time of this ProductOfferingPrice.
   */
  private OffsetDateTime lastUpdate;

  /**
   * the lifecycle status of this ProductOfferingPrice.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Provides all amounts (tax included, duty free, tax rate), used currency and
   * percentage to apply for Price Alteration.
   */
  private @Valid ProductPriceValue price;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid POPAlteration> priceAlterations;

  /**
   * A category that describes the price charge, such as recurring, penalty, One
   * time fee and so forth.
   */
  private @SafeText String priceType;

  /**
   * The period type to repeat the application of the price
   * <br/>Could be month, week...
   */
  private @SafeText String recurringChargePeriod;

  /**
   * the period of the recurring charge: 1, 2, ... .It sets to zero if it is not
   * applicable.
   */
  private Integer recurringChargePeriodLength;

  private @Valid Quantity unitOfMeasure;

  private @Valid TimePeriod validFor;
}