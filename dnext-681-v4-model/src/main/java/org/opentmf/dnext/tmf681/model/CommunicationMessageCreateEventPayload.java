package org.opentmf.dnext.tmf681.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class CommunicationMessageCreateEventPayload {

  /**
   * The involved resource data for the event.
   */
  private @Valid CommunicationMessage communicationMessage;
}