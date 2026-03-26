package org.opentmf.dnext.tmf632.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf632.model.IOrganizationDeleteEventPayload;

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
public class OrganizationDeleteEventPayload implements IOrganizationDeleteEventPayload {

  /**
   * Organization represents a group of people identified by shared interests or
   * purpose. Examples include business, department and enterprise. Because of the
   * complex nature of many businesses, both organizations and organization units
   * are represented by the same data.
   */
  private @Valid Organization organization;
}