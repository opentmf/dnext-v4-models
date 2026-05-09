package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf641.model.ICancelServiceOrderCreateEvent;

/**
 * The notification data structure.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = CancelServiceOrderCreateEvent.class
)
public class CancelServiceOrderCreateEvent extends QuoteCreateEventBase implements ICancelServiceOrderCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid CancelServiceOrderCreateEventPayload event;
}