package org.opentmf.dnext.tmf652.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf652.model.IResourceOrderDeleteEventPayload;

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
public class ResourceOrderDeleteEventPayload implements IResourceOrderDeleteEventPayload {

  /**
   * A Resource Order is a request to provision a set of Resources (logical and
   * physical) triggered by the request to provision a Service through a Service
   * Order.
   */
  private @Valid ResourceOrder resourceOrder;
}