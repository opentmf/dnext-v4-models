package org.opentmf.dnext.tmf676.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.Payment;
import org.opentmf.tmf676.model.IPaymentDeleteEventPayload;

/**
 * The event data structure.
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
public class PaymentDeleteEventPayload implements IPaymentDeleteEventPayload {

  /**
   * The Payment resource represents a performed payment. It contains both
   * information about the payment and the payment method used to perform it.
   */
  private @Valid Payment payment;
}