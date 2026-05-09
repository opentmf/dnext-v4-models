package org.opentmf.dnext.tmf683.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf683.model.IPartyInteractionCreate;

/**
 * The PartyInteraction to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> channel, direction, interactionDate, reason, status<br/>
 * </p>
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
    defaultImpl = PartyInteractionCreate.class
)
@Required(fields = {"interactionDate", "reason", "channel", "direction", "status"})
public class PartyInteractionCreate extends PartyInteractionUpdate implements IPartyInteractionCreate {

  /**
   * Specifies who started the interaction. It might be the party or the
   * enterprise exposing this API. Possible descriptions are “inbound” and
   * “outbound”.
   */
  private @SafeText String direction;
}