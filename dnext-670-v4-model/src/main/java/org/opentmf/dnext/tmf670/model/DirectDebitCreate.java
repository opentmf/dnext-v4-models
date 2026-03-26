package org.opentmf.dnext.tmf670.model;

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
import org.opentmf.dnext.common.model.AttachmentRefOrValue;

/**
 * Direct Debit is a fully automated payment instrument which is generally used
 * for recurrent payments. It allows a creditor to initiate the payment order.
 * In doing so, it exempts the debtor from having to send a separate payment
 * order at each due date.
 *
 * <p><br/>
 * <strong>Required:</strong> @type<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-670: Payment Method Management API</li>
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
    defaultImpl = DirectDebitCreate.class
)
@Required(fields = {"atType"})
public class DirectDebitCreate extends BankAccountTransferCreate {

  /**
   * attachment.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * The date on which the (e)Mandate has been cancelled by the Debtor or the
   * Creditor.
   */
  private OffsetDateTime cancellationDate;

  /**
   * The first debit date. The debit date of the collection is the day when the
   * payment of the Debtor is due to the Creditor.
   */
  private OffsetDateTime firstDebitDate;

  /**
   * The last debit date. The debit date of the collection is the day when the
   * payment of the Debtor is due to the Creditor.
   */
  private OffsetDateTime lastDebitDate;

  /**
   * The identification code of the Scheme e.g., core/b2b.
   */
  private @SafeText String mandateCategory;

  /**
   * Unique mandate reference.
   */
  @SafeId
  @Size(max = 100)
  private String mandateId;

  /**
   * The status of the mandate(Active/Inactive/Pending).
   */
  private @SafeText String mandateStatus;

  /**
   * The date of the mandate status change.
   */
  private OffsetDateTime mandateStatusDate;

  /**
   * The type of mandate e.g., single-use(single)/multi-use(recurring).
   */
  private @SafeText String mandateType;

  /**
   * A reference that the party can later use to identify the direct debit.
   */
  private @SafeText String reference;

  /**
   * The (e)Mandate electronic signature data.
   */
  private @SafeText String signature;

  /**
   * The date of signing of the (e)Mandate.
   */
  private OffsetDateTime signatureDate;
}