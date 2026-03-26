package org.opentmf.dnext.tmf648.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.BillingAccountRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.ContactMedium;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.Note;
import org.opentmf.dnext.common.model.PriceAlteration;
import org.opentmf.dnext.common.model.RelatedChannel;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.dnext.customer.model.PaymentRef;
import org.opentmf.dnext.customer.model.ProductOfferingQualificationRef;

/**
 * The Quote to be updated.
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
    defaultImpl = QuoteUpdate.class
)
public class QuoteUpdate extends Extensible {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * A reference to an agreement defining the context of the quote.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

  /**
   * A list of attachments.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * An authorization provided for the quote.
   */
  @JsonProperty("authorization")
  private List<@Valid Authorization> authorizations;

  /**
   * A reference to a billing account to provide quote context information.
   */
  @JsonProperty("billingAccount")
  private List<@Valid BillingAccountRef> billingAccounts;

  /**
   * Used to categorize the quote from a business perspective that can be useful
   * for the CRM system (e.g. "enterprise", "residential", ...).
   */
  private @SafeText String category;

  /**
   * A list of channels Could be Online or Offline store.
   */
  @JsonProperty("channel")
  private List<@Valid RelatedChannel> channels;

  /**
   * Information contact related to the quote requester.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * Description of the quote.
   */
  private @SafeText String description;

  /**
   * Date when the quote has been completed.
   */
  private OffsetDateTime effectiveQuoteCompletionDate;

  private OffsetDateTime expectedFulfillmentCompletionDate;

  /**
   * this is the date wished by the requester to have the requested quote item
   * delivered.
   */
  private OffsetDateTime expectedFulfillmentStartDate;

  /**
   * This is expected date - from quote supplier - to be able to send back a
   * response for this quote.
   */
  private OffsetDateTime expectedQuoteCompletionDate;

  /**
   * ID given by the consumer and only understandable by him (to facilitate his
   * searches afterwards).
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * An indicator which when the value is "true" means that requester expects to
   * get quoting result immediately in the response. If the indicator is true then
   * the response code of 200 indicates the operation is successful otherwise a
   * task is created with a response 201.
   */
  private Boolean instantSyncQuote;

  /**
   * Free form text associated with the quote.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A list of payment references.
   */
  @JsonProperty("payment")
  private List<@Valid PaymentRef> payments;

  /**
   * List of: Is an amount, usually of money, that modifies the price charged for
   * an order item.
   */
  @JsonProperty("priceAlteration")
  private List<@Valid PriceAlteration> priceAlterations;

  /**
   * A reference to a previously done product offering qualification.
   */
  @JsonProperty("productOfferingQualification")
  private List<@Valid ProductOfferingQualificationRef> productOfferingQualifications;

  /**
   * Characteristic of the given quote.
   */
  @JsonProperty("quoteCharacteristic")
  private List<@Valid Characteristic> quoteCharacteristics;

  /**
   * An item of the quote - it is used to describe an operation on a product to be
   * quoted.
   */
  @JsonProperty("quoteItem")
  private List<@Valid QuoteItem> quoteItems;

  /**
   * A reference to a party playing a role in this quote (customer, seller,
   * requester, etc.).
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * This is requested date - from quote requester - to get a complete response
   * for this quote.
   */
  private OffsetDateTime requestedQuoteCompletionDate;

  /**
   * State of the quote: described in the state-machine diagram. 
   * <br/><p>Recommended values: inProgress, pending, cancelled, approved,
   * accepted, rejected.
   *
   * @see org.opentmf.dnext.tmf648.model.QuoteUpdateStateType
   */
  private @SafeText String state;

  /**
   * Quote validity period.
   */
  private @Valid TimePeriod validFor;
}