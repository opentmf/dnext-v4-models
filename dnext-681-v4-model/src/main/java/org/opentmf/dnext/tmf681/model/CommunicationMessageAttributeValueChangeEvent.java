package org.opentmf.dnext.tmf681.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.DNextEventBase;

/**
 * communicationMessage updateChange Event payload.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-681: Communication Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CommunicationMessageAttributeValueChangeEvent extends DNextEventBase {

  /**
   * The event payload linked to the involved resource object.
   */
  private @Valid CommunicationMessageAttributeValueChangeEventPayload event;
}