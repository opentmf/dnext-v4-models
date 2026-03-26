package org.opentmf.dnext.tmf652.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf652.model.ICancelResourceOrderInformationRequiredEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CancelResourceOrderInformationRequiredEventPayload implements ICancelResourceOrderInformationRequiredEventPayload {

  /**
   * Request for cancellation an existing resource order.
   */
  private @Valid CancelResourceOrder cancelResourceOrder;
}