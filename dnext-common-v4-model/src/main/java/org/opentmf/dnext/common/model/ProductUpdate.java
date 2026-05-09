package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IProductUpdate;
import org.opentmf.commons.validation.constraints.SafeText;

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
public class ProductUpdate extends ProductBase implements IProductUpdate {

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
   * List of: RelatedProductOrderItem (ProductOrder item) .The product order item
   * which triggered product creation/change/termination.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  /**
   * Reason explanation of the product status.
   */
  private @SafeText String statusReason;
}