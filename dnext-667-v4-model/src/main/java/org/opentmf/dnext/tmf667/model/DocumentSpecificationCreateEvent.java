package org.opentmf.dnext.tmf667.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteCreateEventBase;
import org.opentmf.tmf667.model.IDocumentSpecificationCreateEvent;

/**
 * The notification data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = DocumentSpecificationCreateEvent.class
)
public class DocumentSpecificationCreateEvent extends QuoteCreateEventBase implements IDocumentSpecificationCreateEvent {

  /**
   * The event data structure.
   */
  private @Valid DocumentSpecificationCreateEventPayload event;
}