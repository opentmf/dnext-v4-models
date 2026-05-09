package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf658.model.ILoyaltyProgramPartnerUpdateEvent;

/**
 * The event data.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = LoyaltyProgramPartnerUpdateEvent.class
)
public class LoyaltyProgramPartnerUpdateEvent extends QuoteCreateEventBase implements ILoyaltyProgramPartnerUpdateEvent {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid LoyaltyProgramPartnerUpdateEventPayload event;
}