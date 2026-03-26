package org.opentmf.dnext.tmf632.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf632.model.IIndividualCreateEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class IndividualCreateEventPayload implements IIndividualCreateEventPayload {

  /**
   * Individual represents a single human being (a man, woman or child). The
   * individual can be a customer, an employee or any other person that the
   * organization needs to store information about.
   */
  private @Valid Individual individual;
}