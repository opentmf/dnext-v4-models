package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AppointmentRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.BillingAccountRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.OrderItemRelationship;
import org.opentmf.dnext.common.model.OrderTerm;
import org.opentmf.dnext.common.model.ProductOfferingQualificationRef;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.common.model.ProductRefOrValue;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.dnext.customer.model.CartItemBase;
import org.opentmf.dnext.customer.model.ProductOfferingQualificationItemRef;
import org.opentmf.tmf622.model.IProductOrderItem;

/**
 * An identified part of the order. A product order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Required:</strong> action<br/>
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
    defaultImpl = ProductOrderItem.class
)
@Required(fields = {"action"})
public class ProductOrderItem extends CartItemBase implements IProductOrderItem {

  private @SafeText String action;

  /**
   * Reason explanation of the productOrderItem action.
   */
  private @SafeText String actionReason;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * List of: An individual or an organization used as a contact point for a given
   * account and accessed via some contact medium.
   */
  @JsonProperty("contact")
  private List<@Valid Contact> contacts;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("itemPrice")
  private List<@Valid OrderPrice> itemPrices;

  /**
   * List of: Description of a productTerm linked to this orderItem. This
   * represents a commitment with a duration.
   */
  @JsonProperty("itemTerm")
  private List<@Valid OrderTerm> itemTerms;

  /**
   * List of: An amount, usually of money, that represents the actual price paid
   * by the Customer for this item or this order.
   */
  @JsonProperty("itemTotalPrice")
  private List<@Valid OrderPrice> itemTotalPrices;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("orderItemCharacteristic")
  private List<@Valid Characteristic> orderItemCharacteristics;

  /**
   * An identified part of the order. A product order is decomposed into one or
   * more order items.
   */
  private @Valid ProductOrderItem preInflightOrderChangeProductOrderItem;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  /**
   * List of: A product to be created defined by value or existing defined by
   * reference. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType
   * are related to the product entity and not the RelatedProductRefOrValue class
   * itself.
   */
  @JsonProperty("productList")
  private List<@Valid ProductRefOrValue> productLists;

  private @Valid ProductOfferingRef productOffering;

  /**
   * It's a productOfferingQualification item that has been executed previously.
   */
  private @Valid ProductOfferingQualificationItemRef productOfferingQualificationItem;

  /**
   * List of: An identified part of the order. A product order is decomposed into
   * one or more order items.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid ProductOrderItem> productOrderItems;

  /**
   * A list of order items embedded to this order item.
   */
  @JsonProperty("productOrderItemErrorMessage")
  private List<@Valid ProductOrderItemErrorMessage> productOrderItemErrorMessages;

  @JsonProperty("productOrderItemRelationship")
  private List<@Valid OrderItemRelationship> productOrderItemRelationships;

  /**
   * List of: It's a productOfferingQualification that has been executed
   * previously.
   */
  @JsonProperty("qualification")
  private List<@Valid ProductOfferingQualificationRef> qualifications;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  /**
   * It's a Quote item that has been executed previously.
   */
  private @Valid QuoteItemRef quoteItem;

  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  /**
   * State of the order item : described in the state machine diagram, can be
   * "acknowledged",     "rejected"     "pending",     "held",     "inProgress",  
   * "cancelled",     "completed",     "failed",     "partial",    
   * "assessingCancellation",     "pendingCancellation".
   */
  private @SafeText String state;

  private @SafeText String stateReason;
}