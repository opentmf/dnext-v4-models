package org.opentmf.dnext.tmf634.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf634.model.IResourceCandidateDeleteEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceCandidateDeleteEventPayload implements IResourceCandidateDeleteEventPayload {

  /**
   * ResourceCandidate is an entity that makes a resource specification available
   * to a catalog. A ResourceCandidate and its associated resource specification
   * may be published - made visible - in any number of resource catalogs, or in
   * none.
   */
  private @Valid ResourceCandidate resourceCandidate;
}