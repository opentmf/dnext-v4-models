package org.opentmf.dnext.tmf668.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf668.model.IPartnershipSpecificationDeleteEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-668: Partnership Type</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PartnershipSpecificationDeleteEventPayload implements IPartnershipSpecificationDeleteEventPayload {

  /**
   * A partnership specification contains all the information for the setup of a
   * partnership of a given kind. This includes the list of identified role types
   * for the partnership with the corresponding agreement specifications.
   */
  private @Valid PartnershipSpecification partnershipSpecification;
}