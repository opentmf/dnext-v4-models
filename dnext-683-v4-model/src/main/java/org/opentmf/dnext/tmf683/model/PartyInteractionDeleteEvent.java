package org.opentmf.dnext.tmf683.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf683.model.IPartyInteractionDeleteEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-683: Party Interaction Management API</li>
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
    defaultImpl = PartyInteractionDeleteEvent.class
)
public class PartyInteractionDeleteEvent extends QuoteCreateEventBase implements IPartyInteractionDeleteEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyInteractionDeleteEventPayload event;
}