package org.opentmf.dnext.tmf676.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf676.model.IRefundCreateEventPayload;

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
public class RefundCreateEventPayload implements IRefundCreateEventPayload {

  /**
   * The Refund resource represents a performed Refund. It contains both
   * information about the refund and the payment method used to perform it.
   */
  private @Valid Refund refund;
}