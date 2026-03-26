package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPaymentMethodRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * link to the resource that holds information about the payment mean used to
 * complete the operation.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = PaymentMethodRefOrValue.class
)
@Required(fields = {"atType", "name"})
public class PaymentMethodRefOrValue extends AccountRef implements IPaymentMethodRefOrValue {

  /**
   * Reference to the accounts that are linked to the payment method. May be a
   * party account or a financial account.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * Review: Authorization code provided by a financial institution. Typically
   * this would be populated for recurring payments using the method, as payments
   * have an authorization code of their own.
   */
  private @SafeText String authorizationCode;

  /**
   * If the method is the preferred one by the owner. Typically used when querying
   * for the payment methods of a specific customer or account.
   */
  private Boolean isPreferred;

  private Boolean preferred;

  /**
   * Reference to the customer or party that owns that payment method or can use
   * it.
   */
  private @Valid RelatedParty relatedParty;

  /**
   * Reference to a place for billing or delivery address, if different to that of
   * the related party.
   */
  private @Valid RelatedPlace relatedPlace;

  /**
   * Status of the payment method.
   */
  private @SafeText String status;

  /**
   * The last time the payment method status changed.
   */
  private OffsetDateTime statusDate;

  /**
   * The reason for the last status change.
   */
  private @SafeText String statusReason;

  /**
   * Date interval in which the payment method is valid.
   */
  private @Valid TimePeriod validFor;
}