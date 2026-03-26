package org.opentmf.dnext.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.BillingAccountRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.ContactMedium;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.PriceAlteration;
import org.opentmf.dnext.common.model.RelatedChannel;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.customer.model.PaymentRef;
import org.opentmf.tmf663.model.IShoppingCartUpdate;

/**
 * The ShoppingCart to be updated.
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
    defaultImpl = ShoppingCartUpdate.class
)
public class ShoppingCartUpdate extends Entity implements IShoppingCartUpdate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * A reference to an agreement defined in the context of the product order.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

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
   * List of: Related channel to another entity. May be online web, mobile app,
   * social ,etc.
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * List of: An individual or an organization used as a contact point for a given
   * account and accessed via some contact medium.
   */
  @JsonProperty("contact")
  private List<@Valid Contact> contacts;

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * List of: If an immediate payment has been done at the product order
   * submission, the payment information are captured and stored (as a reference)
   * in the order.
   */
  @JsonProperty("payment")
  private List<@Valid PaymentRef> payments;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid PriceAlteration> priceAlterations;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested order delivery date from the requester perspective.
   */
  private OffsetDateTime requestedOrderCompletionDate;

  /**
   * Order fulfillment start date wished by the requester. This is used when, for
   * any reason, requester cannot allow seller to begin to operationally begin the
   * fulfillment before a date.
   */
  private OffsetDateTime requestedOrderStartDate;

  /**
   * Characteristic of the given shopping cart.
   */
  @JsonProperty("shoppingCartCharacteristic")
  private List<@Valid Characteristic> shoppingCartCharacteristics;

  /**
   * Used to track the lifecycle status of the customer
   * <br/><p>Recommended values: cancelled, completed, checkedOut,
   * partiallyCheckedOut, active.
   *
   * @see org.opentmf.dnext.tmf663.model.ShoppingCartStatusType
   */
  private @SafeText String status;

  /**
   * A string providing an explanation on the value of the status lifecycle.
   */
  private @SafeText String statusReason;
}