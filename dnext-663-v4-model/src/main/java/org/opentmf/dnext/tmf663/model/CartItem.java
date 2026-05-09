package org.opentmf.dnext.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.CartItemRelationship;
import org.opentmf.dnext.common.model.CartTerm;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.ProductOfferingQualificationRef;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.common.model.ProductRefOrValue;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.customer.model.CartItemBase;

/**
 * An identified part of the shopping cart. A shopping cart is decomposed into
 * one or more shopping cart item. Cart item represents a product offering or
 * bundled product offering that user wish to purchase, as well as the pricing
 * of the product offering, reference to product in case of configured
 * characteristic or installation address. Cart items can be related to other
 * cart item to related bundled offerings or reference cart Items to a shipping
 * options.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id, itemPrice<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = CartItem.class
)
@Required(fields = {"action", "itemPrice", "id"})
public class CartItem extends CartItemBase {

  private @SafeText String action;

  private @SafeText String actionReason;

  /**
   * Complements the description of an element (for instance a product) through
   * video, pictures...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: An identified part of the shopping cart. A shopping cart is
   * decomposed into one or more shopping cart item. Cart item represents a
   * product offering or bundled product offering that user wish to purchase, as
   * well as the pricing of the product offering, reference to product in case of
   * configured characteristic or installation address. Cart items can be related
   * to other cart item to related bundled offerings or reference cart Items to a
   * shipping options.
   */
  @JsonProperty("cartItem")
  private List<@Valid CartItem> cartItems;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("cartItemCharacteristic")
  private List<@Valid Characteristic> cartItemCharacteristics;

  /**
   * List of: Relationship among cart items mainly other than hierarchical
   * relationships such as "RelyOn", "DependentOn", "Shipping" etc.
   */
  @JsonProperty("cartItemRelationship")
  private List<@Valid CartItemRelationship> cartItemRelationships;

  /**
   * List of: An individual or an organization used as a contact point for a given
   * account and accessed via some contact medium.
   */
  @JsonProperty("contact")
  private List<@Valid Contact> contacts;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the customer for this item. May represent the total price of the shopping
   * cart or the total of the cart item depending on the relation.
   */
  @JsonProperty("itemPrice")
  private List<@Valid CartPrice> itemPrices;

  @JsonProperty("itemTerm")
  private List<@Valid CartTerm> itemTerms;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the customer for this item. May represent the total price of the shopping
   * cart or the total of the cart item depending on the relation.
   */
  @JsonProperty("itemTotalPrice")
  private List<@Valid CartPrice> itemTotalPrices;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  private @Valid ProductOfferingRef productOffering;

  /**
   * It's a productOfferingQualification that has been executed previously.
   */
  private @Valid ProductOfferingQualificationRef productOfferingQualificationItem;

  /**
   * QualificationState values for CartItem
   * <br/><p>Recommended values: initial, qualified, unqualified.
   *
   * @see org.opentmf.dnext.tmf663.model.CartItemQualificationStateType
   */
  private @SafeText String qualificationState;

  @JsonProperty("qualificationStateReason")
  private List<@Valid QualificationStateReason> qualificationStateReasons;

  private Integer quantity;

  /**
   * A list of related entity in relationship with this service.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  private @SafeText String status;

  private @SafeText String statusReason;
}