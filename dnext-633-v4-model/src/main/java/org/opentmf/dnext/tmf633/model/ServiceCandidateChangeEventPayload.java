package org.opentmf.dnext.tmf633.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf633.model.IServiceCandidateChangeEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceCandidateChangeEventPayload implements IServiceCandidateChangeEventPayload {

  /**
   * ServiceCandidate is an entity that makes a service specification available to
   * a catalog. A ServiceCandidate and its associated service specification may be
   * published - made visible - in any number of service catalogs, or in none. One
   * service specification can be composed of other service specifications.
   */
  private @Valid ServiceCandidate serviceCandidate;
}