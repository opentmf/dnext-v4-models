package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.BillingAccountRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.ContactMedium;
import org.opentmf.dnext.common.model.InflightOrderChangeUpdate;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.RelatedChannel;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.customer.model.PaymentRef;
import org.opentmf.dnext.customer.model.ProductOfferingQualificationRef;
import org.opentmf.dnext.customer.model.ShoppingCartRef;

/**
 * The ProductOrder to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> productOrderItem<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
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
    defaultImpl = ProductOrderCreate.class
)
@Required(fields = {"productOrderItem"})
public class ProductOrderCreate extends InflightOrderChangeUpdate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * A reference to an agreement defined in the context of the product order.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  private @SafeText String batchWorkflowName;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Used to categorize the order from a business perspective that can be useful
   * for the OM system (e.g. "enterprise", "residential", ...).
   */
  private @SafeText String category;

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

  /**
   * Description of the product order.
   */
  private @SafeText String description;

  /**
   * ID given by the consumer and only understandable by him (to facilitate his
   * searches afterwards).
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * Unique identifier of a product Order entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * List of: Extra information about a given entity.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * Contact attached to the order to send back information regarding this order.
   */
  private @SafeText String notificationContact;

  /**
   * Characteristic of the given productOrder.
   */
  @JsonProperty("orderCharacteristic")
  private List<@Valid Characteristic> orderCharacteristics;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("orderTotalPrice")
  private List<@Valid OrderPrice> orderTotalPrices;

  /**
   * List of: If an immediate payment has been done at the product order
   * submission, the payment information are captured and stored (as a reference)
   * in the order.
   */
  @JsonProperty("payment")
  private List<@Valid PaymentRef> payments;

  private Boolean pointOfNoReturn;

  /**
   * A way that can be used by consumers to prioritize orders in OM system (from 0
   * to 4 : 0 is the highest priority, and 4 the lowest).
   */
  private @SafeText String priority;

  /**
   * List of: It's a productOfferingQualification that has been executed
   * previously.
   */
  @JsonProperty("productOfferingQualification")
  private List<@Valid ProductOfferingQualificationRef> productOfferingQualifications;

  /**
   * The error(s) cause an order status change.
   */
  @JsonProperty("productOrderErrorMessage")
  private List<@Valid ProductOrderErrorMessage> productOrderErrorMessages;

  /**
   * List of: An identified part of the order. A product order is decomposed into
   * one or more order items.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid ProductOrderItem> productOrderItems;

  /**
   * A list of jeopardy alerts related to this order.
   */
  @JsonProperty("productOrderJeopardyAlert")
  private List<@Valid ProductOrderJeopardyAlert> productOrderJeopardyAlerts;

  /**
   * A list of milestones related to this order.
   */
  @JsonProperty("productOrderMilestone")
  private List<@Valid ProductOrderMilestone> productOrderMilestones;

  /**
   * List of: It's a Quote that has been executed previously.
   */
  @JsonProperty("quote")
  private List<@Valid QuoteRef> quotes;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Requested delivery date from the requester perspective.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Order fulfillment start date wished by the requester. This is used when, for
   * any reason, requester cannot allow seller to begin to operationally begin the
   * fulfillment before a date.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * List of: It's a Shopping Cart that has been executed previously.
   */
  @JsonProperty("shoppingCart")
  private List<@Valid ShoppingCartRef> shoppingCarts;

  private @SafeText String stateReason;
}