package org.opentmf.dnext.tmf658.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf658.model.ILoyaltyProgramProductSpecCreateEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class LoyaltyProgramProductSpecCreateEventPayload implements ILoyaltyProgramProductSpecCreateEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid LoyaltyProgramProductSpec loyaltyProgramProductSpec;
}