package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf658.model.ILoyaltyProgramMemberCreateEvent;

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
    defaultImpl = LoyaltyProgramMemberCreateEvent.class
)
public class LoyaltyProgramMemberCreateEvent extends QuoteCreateEventBase implements ILoyaltyProgramMemberCreateEvent {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid LoyaltyProgramMemberCreateEventPayload event;
}