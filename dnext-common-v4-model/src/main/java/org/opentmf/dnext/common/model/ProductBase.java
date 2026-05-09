package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>LoyaltyProgramProductCreate (658)</li>
 *   <li>LoyaltyProgramProductUpdate (658)</li>
 *   <li>ProductCreate (637)</li>
 *   <li>ProductUpdate (637)</li>
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
    defaultImpl = ProductBase.class
)
public abstract class ProductBase extends Extensible {

  /**
   * An explanation of what the product is.
   */
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
   * A word, term, or phrase by which the product is known and distinguished from
   * other products.
   */
  private @SafeText String name;

  /**
   * Is the date when the product was ordered.
   */
  private OffsetDateTime orderDate;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("productCharacteristic")
  private List<@Valid Characteristic> productCharacteristics;

  private @Valid ProductOfferingRef productOffering;

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

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Is the date from which the product starts.
   */
  private OffsetDateTime startDate;

  /**
   * Is the lifecycle status of the product.
   * <br/><p>Recommended values: created, pendingActive, cancelled, active,
   * pendingTerminate, terminated, suspended, aborted.
   *
   * @see org.opentmf.dnext.tmf658.model.LoyaltyProgramProductStatusType
   */
  private @SafeText String status;

  /**
   * Is the date when the product was terminated.
   */
  private OffsetDateTime terminationDate;
}