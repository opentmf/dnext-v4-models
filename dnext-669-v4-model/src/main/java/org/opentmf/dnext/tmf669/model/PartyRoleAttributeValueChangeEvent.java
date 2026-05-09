package org.opentmf.dnext.tmf669.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf669.model.IPartyRoleAttributeValueChangeEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = PartyRoleAttributeValueChangeEvent.class
)
public class PartyRoleAttributeValueChangeEvent extends QuoteInformationRequiredEventBase implements IPartyRoleAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid PartyRoleAttributeValueChangeEventPayload event;
}