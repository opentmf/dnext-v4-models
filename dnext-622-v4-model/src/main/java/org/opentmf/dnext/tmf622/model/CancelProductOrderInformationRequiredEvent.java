package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf622.model.ICancelProductOrderInformationRequiredEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
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
    defaultImpl = CancelProductOrderInformationRequiredEvent.class
)
public class CancelProductOrderInformationRequiredEvent extends QuoteInformationRequiredEventBase implements ICancelProductOrderInformationRequiredEvent {

  /**
   * The event data structure.
   */
  private @Valid CancelProductOrderInformationRequiredEventPayload event;
}