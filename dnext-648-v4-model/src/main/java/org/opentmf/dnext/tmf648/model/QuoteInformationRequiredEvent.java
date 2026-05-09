package org.opentmf.dnext.tmf648.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf648.model.IQuoteInformationRequiredEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = QuoteInformationRequiredEvent.class
)
public class QuoteInformationRequiredEvent extends QuoteInformationRequiredEventBase implements IQuoteInformationRequiredEvent {

  /**
   * The event data structure.
   */
  private @Valid QuoteInformationRequiredEventPayload event;
}