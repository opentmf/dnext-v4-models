package org.opentmf.dnext.tmf637.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementItemRef;
import org.opentmf.dnext.common.model.BillingAccountRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.common.model.ProductPrice;
import org.opentmf.dnext.common.model.ProductRefOrValue;
import org.opentmf.dnext.common.model.ProductRelationship;
import org.opentmf.dnext.common.model.ProductSpecificationRef;
import org.opentmf.dnext.common.model.ProductTerm;
import org.opentmf.dnext.common.model.ProductUpdateBase;
import org.opentmf.dnext.common.model.RelatedChannel;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.RelatedPlaceRefOrValue;
import org.opentmf.dnext.common.model.RelatedProductOrderItem;
import org.opentmf.dnext.common.model.ResourceRef;
import org.opentmf.dnext.common.model.ServiceRef;

/**
 * The Product to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-637: Product Inventory Management API</li>
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
    defaultImpl = ProductUpdate.class
)
public class ProductUpdate extends ProductUpdateBase {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * List of: Agreement reference. An agreement represents a contract or
   * arrangement, either written or verbal and sometimes enforceable by law, such
   * as a service level agreement or a customer price agreement. An agreement
   * involves a number of other business entities, such as products, services, and
   * resources and/or their specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementItemRef> agreements;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * List of: Related channel to another entity. May be online web, mobile app,
   * social ,etc.
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * Is the expected expiry date when the product was ordered.
   */
  private OffsetDateTime expectedExpiryDate;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * If true, the product is visible by the customer.
   */
  private Boolean isCustomerVisible;

  /**
   * Is the date when the product was ordered.
   */
  private OffsetDateTime orderDate;

  /**
   * List of: Related Entity reference. A related place defines a place described
   * by reference or by value linked to a specific entity. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place
   * entity and not the RelatedPlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * List of: A product to be created defined by value or existing defined by
   * reference. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType
   * are related to the product entity and not the RelatedProductRefOrValue class
   * itself.
   */
  @JsonProperty("product")
  private List<@Valid ProductRefOrValue> products;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("productCharacteristic")
  private List<@Valid Characteristic> productCharacteristics;

  private @Valid ProductOfferingRef productOffering;

  /**
   * List of: RelatedProductOrderItem (ProductOrder item) .The product order item
   * which triggered product creation/change/termination.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by a Customer for a purchase, a rent or a lease of a Product. The price is
   * valid for a defined period of time.
   */
  @JsonProperty("productPrice")
  private List<@Valid ProductPrice> productPrices;

  /**
   * List of: Linked products to the one instantiate, such as [bundled] if the
   * product is a bundle and you want to describe the bundled products inside this
   * bundle; [reliesOn] if the product needs another already owned product to rely
   * on (e.g. an option on an already owned mobile access product) [targets] or
   * [isTargeted] (depending on the way of expressing the link) for any other kind
   * of links that may be useful.
   */
  @JsonProperty("productRelationship")
  private List<@Valid ProductRelationship> productRelationships;

  /**
   * Is the serial number for the product. This is typically applicable to
   * tangible products e.g. Broadband Router.
   */
  private @SafeText String productSerialNumber;

  private @Valid ProductSpecificationRef productSpecification;

  /**
   * List of: Description of a productTerm linked to this product. This represents
   * a commitment with a duration.
   */
  @JsonProperty("productTerm")
  private List<@Valid ProductTerm> productTerms;

  @JsonProperty("realizingResource")
  private List<@Valid ResourceRef> realizingResources;

  /**
   * List of: Service reference, for when Service is used by other entities.
   */
  @JsonProperty("realizingService")
  private List<@Valid ServiceRef> realizingServices;

  private @SafeText String status;

  /**
   * Reason explanation of the product status.
   */
  private @SafeText String statusReason;

  /**
   * Is the date when the product was terminated.
   */
  private OffsetDateTime terminationDate;
}