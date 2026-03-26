package org.opentmf.dnext.tmf676.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AccountRef;
import org.opentmf.dnext.common.model.ChannelRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.PaymentItem;
import org.opentmf.dnext.common.model.PaymentMethodRefOrValue;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The Payment to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-676: Payment Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PaymentUpdate {

  /**
   * Account reference. An account may be a party account or a financial account.
   */
  private @Valid AccountRef account;

  /**
   * Amount to be paid (net of taxes).
   */
  private @Valid Money amount;

  /**
   * Authorization code retrieved from an external payment gateway that could be
   * used for conciliation.
   */
  private @SafeText String authorizationCode;

  private @Valid ChannelRef channel;

  /**
   * A list of characteristics.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * Unique identifier in the client for the payment in case it is needed to
   * correlate.
   */
  @SafeId
  @Size(max = 100)
  private String correlatorId;

  /**
   * Text describing the contents of the payment.
   */
  private @SafeText String description;

  /**
   * Screen name of the payment.
   */
  private @SafeText String name;

  private @Valid RelatedParty payer;

  /**
   * Date when the payment was performed.
   */
  private OffsetDateTime paymentDate;

  /**
   * List of: The paymentItem is the result of lettering process. It enables to
   * assign automatically or manually part of incoming payment amount to a bill.
   */
  @JsonProperty("paymentItem")
  private List<@Valid PaymentItem> paymentItems;

  /**
   * link to the resource that holds information about the payment mean used to
   * complete the operation.
   */
  private @Valid PaymentMethodRefOrValue paymentMethod;

  /**
   * Status of the payment.
   */
  private @SafeText String status;

  /**
   * Date when the status was recorded.
   */
  private OffsetDateTime statusDate;

  /**
   * Tax applied.
   */
  private @Valid Money taxAmount;

  /**
   * Amount to be paid (including taxes).
   */
  private @Valid Money totalAmount;
}