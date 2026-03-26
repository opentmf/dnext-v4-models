package org.opentmf.dnext.tmf670.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.PaymentMethod;
import org.opentmf.tmf670.model.IPaymentMethodDeleteEventPayload;

/**
 * The event data structure.
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
public class PaymentMethodDeleteEventPayload implements IPaymentMethodDeleteEventPayload {

  /**
   * Defines a specific method of payment (e.g. direct debit with all details
   * associated).
   */
  private @Valid PaymentMethod paymentMethod;
}