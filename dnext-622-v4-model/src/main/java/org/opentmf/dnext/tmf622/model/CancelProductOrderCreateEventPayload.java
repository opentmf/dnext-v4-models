package org.opentmf.dnext.tmf622.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf622.model.ICancelProductOrderCreateEventPayload;

/**
 * The event data structure.
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
public class CancelProductOrderCreateEventPayload implements ICancelProductOrderCreateEventPayload {

  /**
   * Request for cancellation an existing product order.
   */
  private @Valid CancelProductOrder cancelProductOrder;
}