package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.ChannelRef;
import org.opentmf.dnext.common.model.ConstraintRef;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.MarketSegmentRef;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.PlaceRef;
import org.opentmf.dnext.common.model.Quantity;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TaxItem;
import org.opentmf.dnext.product.model.CatalogUpdateBase;

/**
 * The ProductOfferingPrice to be updated.
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
    defaultImpl = ProductOfferingPriceUpdate.class
)
public class ProductOfferingPriceUpdate extends CatalogUpdateBase {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private @SafeText String advancedPricingMethod;

  /**
   * this object represents a bundle relationship from a bundle product offering
   * price (parent) to a simple product offering price (child). A simple product
   * offering price may participate in more than one bundle relationship.
   */
  @JsonProperty("bundledPopRelationship")
  private List<@Valid BundledProductOfferingPriceRelationship> bundledPopRelationships;

  @JsonProperty("channel")
  private List<@Valid ChannelRef> channels;

  /**
   * The Constraint resource represents a policy/rule applied to
   * ProductOfferingPrice.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * The installment plan for the payment.
   */
  private @Valid InstallmentPlan installmentPlan;

  /**
   * A flag indicating if this ProductOfferingPrice is composite (bundle) or not.
   */
  private Boolean isBundle;

  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  /**
   * Percentage to apply for ProductOfferPriceAlteration (Discount).
   */
  private BigDecimal percentage;

  /**
   * Place defines the places where the products are sold or delivered.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRef> places;

  /**
   * Product Offering Prices related to this Product Offering Price, for example a
   * price alteration such as allowance or discount.
   */
  @JsonProperty("popRelationship")
  private List<@Valid ProductOfferingPriceRelationship> popRelationships;

  /**
   * The amount of money that characterizes the price.
   */
  private @Valid Money price;

  /**
   * A category that describes the price, such as recurring, discount, allowance,
   * penalty, and so forth.
   */
  private @SafeText String priceType;

  /**
   * Indicates the category of the price type, (ex, instalment, allowance,
   * penalty….. ).
   */
  private @SafeText String pricingCategory;

  /**
   * The PricingLogicAlgorithm entity represents an instantiation of an interface
   * specification to external rating function (without a modeled behavior in
   * SID). Some of the parameters of the interface definition may be already set
   * (such as price per unit) and some may be gathered during the rating process
   * from the event (such as call duration) or from ProductCharacteristicValues
   * (such as assigned bandwidth).
   */
  @JsonProperty("pricingLogicAlgorithm")
  private List<@Valid PricingLogicAlgorithm> pricingLogicAlgorithms;

  /**
   * A use of the ProductSpecificationCharacteristicValue by a
   * ProductOfferingPrice to which additional properties (attributes) apply or
   * override the properties of similar properties contained in
   * ProductSpecificationCharacteristicValue. It should be noted that
   * characteristics which their value(s) addressed by this object must exist in
   * corresponding product specification. The available characteristic values for
   * a ProductSpecificationCharacteristic in a Product specification can be
   * modified at the ProductOffering and ProductOfferingPrice level. The list of
   * values in ProductSpecificationCharacteristicValueUse is a strict subset of
   * the list of values as defined in the corresponding product specification
   * characteristics.
   */
  @JsonProperty("prodSpecCharValueUse")
  private List<@Valid ProductSpecificationCharacteristicValueUse> prodSpecCharValueUses;

  @JsonProperty("productOfferingPriceCharacteristic")
  private List<@Valid ProductOfferingPriceCharacteristic> productOfferingPriceCharacteristics;

  /**
   * A list of conditions under which a ProductOfferingPrice is made available to
   * Customers. For instance, a Product Offering Price can be offered with
   * multiple commitment periods.
   */
  @JsonProperty("productOfferingTerm")
  private List<@Valid ProductOfferingTerm> productOfferingTerms;

  private Integer recurringChargePeriodCount;

  /**
   * the period of the recurring charge: 1, 2, ... .It sets to zero if it is not
   * applicable.
   */
  private Integer recurringChargePeriodLength;

  /**
   * The period to repeat the application of the price Could be month, week...
   */
  private @SafeText String recurringChargePeriodType;

  /**
   * Indicates when the pricing should be handled. (ex. upfront payment, billing
   * ….).
   */
  private @SafeText String salesTime;

  /**
   * An amount of money levied on the price of a Product by a legislative body.
   */
  @JsonProperty("tax")
  private List<@Valid TaxItem> taxes;

  /**
   * A number and unit representing how many (for instance 1 dozen) of an
   * ProductOffering is available at the offered price. Its meaning depends on the
   * priceType. It could be a price, a rate, or a discount.
   */
  private @Valid Quantity unitOfMeasure;
}