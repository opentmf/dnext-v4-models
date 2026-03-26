package org.opentmf.dnext.tmf663.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.DNextEventBase;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ShoppingCartStateChangeEvent extends DNextEventBase {

  /**
   * The event data structure.
   */
  private @Valid ShoppingCartStateChangeEventPayload event;

  /**
   * Reference of the ProcessFlow.
   */
  private URI href;

  /**
   * Identifier of the Process flow.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}