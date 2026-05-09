package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf671.model.IPromotionCreateEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
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
    defaultImpl = PromotionCreateEvent.class
)
public class PromotionCreateEvent extends QuoteCreateEventBase implements IPromotionCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid PromotionCreateEventPayload event;
}