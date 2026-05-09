package org.opentmf.dnext.tmf648.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AppointmentRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.common.model.ProductRefOrValue;
import org.opentmf.dnext.common.model.QuoteItemRelationship;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.customer.model.ProductOfferingQualificationItemRef;
import org.opentmf.tmf648.model.IQuoteItem;

/**
 * A quote items describe an action to be performed on a productOffering or a
 * product in order to get pricing elements and condition.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = QuoteItem.class
)
@Required(fields = {"action", "id"})
public class QuoteItem extends Extensible implements IQuoteItem {

  /**
   * Action to be performed on this quote item (add, modify, remove, etc.).
   */
  private @SafeText String action;

  /**
   * A reference to appointment(s) associated with this quote item.
   */
  @JsonProperty("appointment")
  private List<@Valid AppointmentRef> appointments;

  /**
   * A reference to attachment(s) associated with this quote item.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Identifier of the quote item (generally it is a sequence number 01, 02, 03,
   * ...).
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A list of quote prices.
   */
  @JsonProperty("itemTotalPrice")
  private List<@Valid QuotePrice> itemTotalPrices;

  /**
   * Free form text associated with the quote item.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A product to be created defined by value or existing defined by reference.
   * The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related
   * to the product entity and not the RelatedProductRefOrValue class itself.
   */
  private @Valid ProductRefOrValue product;

  private @Valid ProductOfferingRef productOffering;

  /**
   * A reference to a previously done POQ with item specified.
   */
  private @Valid ProductOfferingQualificationItemRef productOfferingQualificationItem;

  /**
   * Quantity asked for this quote item.
   */
  private Integer quantity;

  /**
   * A structure to embedded quote item within quote item.
   */
  @JsonProperty("quoteItem")
  private List<@Valid QuoteItem> quoteItems;

  /**
   * Authorization related to this quote item.
   */
  @JsonProperty("quoteItemAuthorization")
  private List<@Valid Authorization> quoteItemAuthorizations;

  /**
   * Characteristic of the given quote.
   */
  @JsonProperty("quoteItemCharacteristic")
  private List<@Valid Characteristic> quoteItemCharacteristics;

  /**
   * Price for this quote item.
   */
  @JsonProperty("quoteItemPrice")
  private List<@Valid QuotePrice> quoteItemPrices;

  /**
   * A relationship from item within a quote.
   */
  @JsonProperty("quoteItemRelationship")
  private List<@Valid QuoteItemRelationship> quoteItemRelationships;

  /**
   * A reference to a party playing a role in this quote item.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * State of the quote item : described in the state machine diagram.
   */
  private @SafeText String state;
}