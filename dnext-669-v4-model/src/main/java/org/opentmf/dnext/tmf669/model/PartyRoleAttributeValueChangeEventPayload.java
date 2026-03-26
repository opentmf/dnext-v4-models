package org.opentmf.dnext.tmf669.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.PartyRole;
import org.opentmf.tmf669.model.IPartyRoleAttributeValueChangeEventPayload;

/**
 * The event data structure.
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
public class PartyRoleAttributeValueChangeEventPayload implements IPartyRoleAttributeValueChangeEventPayload {

  /**
   * The part played by a party in a given context.
   */
  private @Valid PartyRole partyRole;
}