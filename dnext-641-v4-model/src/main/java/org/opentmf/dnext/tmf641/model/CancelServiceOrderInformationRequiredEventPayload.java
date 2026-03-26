package org.opentmf.dnext.tmf641.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf641.model.ICancelServiceOrderInformationRequiredEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CancelServiceOrderInformationRequiredEventPayload implements ICancelServiceOrderInformationRequiredEventPayload {

  /**
   * Request for cancellation an existing Service order.
   */
  private @Valid CancelServiceOrder cancelServiceOrder;
}