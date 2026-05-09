package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf658.model.ILoyaltyActionDeleteEvent;

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
    defaultImpl = LoyaltyActionDeleteEvent.class
)
public class LoyaltyActionDeleteEvent extends QuoteCreateEventBase implements ILoyaltyActionDeleteEvent {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid LoyaltyActionDeleteEventPayload event;
}