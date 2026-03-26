package org.opentmf.dnext.tmf651.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.AgreementSpecification;
import org.opentmf.tmf651.model.IAgreementSpecificationCreateEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class AgreementSpecificationCreateEventPayload implements IAgreementSpecificationCreateEventPayload {

  /**
   * A template of an agreement that can be used when establishing partnerships.
   */
  private @Valid AgreementSpecification agreementSpecification;
}