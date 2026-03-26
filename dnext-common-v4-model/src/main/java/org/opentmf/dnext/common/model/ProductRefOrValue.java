package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IProductRefOrValue;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A product to be created defined by value or existing defined by reference.
 * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
 * to the product entity and not the RelatedProductRefOrValue class itself.
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
    defaultImpl = ProductRefOrValue.class
)
public class ProductRefOrValue extends AccountRef implements IProductRefOrValue {

  /**
   * Agreement linked to the product.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementItemRef> agreements;

  /**
   * Billing account linked to the product.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * If true, the product is a ProductBundle which is an instantiation of a
   * BundledProductOffering. If false, the product is a ProductComponent which is
   * an instantiation of a SimpleProductOffering.
   */
  private Boolean isBundle;

  /**
   * If true, the product is visible by the customer.
   */
  private Boolean isCustomerVisible;

  /**
   * Is the date when the product was ordered.
   */
  private OffsetDateTime orderDate;

  /**
   * Related place linked to the product.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * Product linked to the product.
   */
  @JsonProperty("product")
  private List<@Valid ProductRefOrValue> products;

  /**
   * Product characteristic linked to the product.
   */
  @JsonProperty("productCharacteristic")
  private List<@Valid Characteristic> productCharacteristics;

  /**
   * Product offering linked to the product.
   */
  private @Valid ProductOfferingRef productOffering;

  /**
   * Product order item linked to the product.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  /**
   * Product price linked to the product.
   */
  @JsonProperty("productPrice")
  private List<@Valid ProductPrice> productPrices;

  /**
   * Product relationship linked to the product.
   */
  @JsonProperty("productRelationship")
  private List<@Valid ProductRelationship> productRelationships;

  /**
   * Is the serial number for the product. This is typically applicable to
   * tangible products e.g. Broadband Router.
   */
  private @SafeText String productSerialNumber;

  /**
   * Product specification linked to the product.
   */
  private @Valid ProductSpecificationRef productSpecification;

  /**
   * Product term linked to the product.
   */
  @JsonProperty("productTerm")
  private List<@Valid ProductTerm> productTerms;

  private @SafeText String randomAtt;

  /**
   * Realizing resource linked to the product.
   */
  @JsonProperty("realizingResource")
  private List<@Valid ResourceRef> realizingResources;

  /**
   * Realizing service linked to the product.
   */
  @JsonProperty("realizingService")
  private List<@Valid ServiceRef> realizingServices;

  /**
   * Related entity linked to the product.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  /**
   * Related party linked to the product.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Is the date from which the product starts.
   */
  private OffsetDateTime startDate;

  /**
   * Status of the product.
   */
  private @SafeText String status;

  /**
   * Status reason of the product.
   */
  private @SafeText String statusReason;

  /**
   * Is the date when the product was terminated.
   */
  private OffsetDateTime terminationDate;
}