package org.opentmf.dnext.tmf683.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf683.model.IPartyInteractionAttributeValueChangeEvent;

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
    defaultImpl = PartyInteractionAttributeValueChangeEvent.class
)
public class PartyInteractionAttributeValueChangeEvent extends QuoteInformationRequiredEventBase implements IPartyInteractionAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyInteractionAttributeValueChangeEventPayload event;
}