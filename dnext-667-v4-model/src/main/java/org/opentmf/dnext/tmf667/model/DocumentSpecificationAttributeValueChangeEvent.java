package org.opentmf.dnext.tmf667.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.QuoteInformationRequiredEventBase;
import org.opentmf.tmf667.model.IDocumentSpecificationAttributeValueChangeEvent;

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
    defaultImpl = DocumentSpecificationAttributeValueChangeEvent.class
)
public class DocumentSpecificationAttributeValueChangeEvent extends QuoteInformationRequiredEventBase implements IDocumentSpecificationAttributeValueChangeEvent {

  /**
   * The event data structure.
   */
  private @Valid DocumentSpecificationAttributeValueChangeEventPayload event;
}