package org.opentmf.dnext.tmf683.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf683.model.IPartyInteractionDeleteEventPayload;

/**
 * The event data structure.
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
public class PartyInteractionDeleteEventPayload implements IPartyInteractionDeleteEventPayload {

  private @Valid PartyInteraction partyInteraction;
}