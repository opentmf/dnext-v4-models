package org.opentmf.dnext.tmf668.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf668.model.IPartnershipChangeEventPayload;

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
public class PartnershipChangeEventPayload implements IPartnershipChangeEventPayload {

  /**
   * A partnership represents a formalized collaboration between various parties,
   * each party playing a role in the partnership. The parties playing a role in
   * the partnership represented by the Partner entity. The structure of a
   * partnership is specified by a PartnershipSpecification which contain all the
   * information for the setup of the partnership, including the list of
   * identified roles and the agreement that should apply.
   */
  private @Valid Partnership partnership;
}