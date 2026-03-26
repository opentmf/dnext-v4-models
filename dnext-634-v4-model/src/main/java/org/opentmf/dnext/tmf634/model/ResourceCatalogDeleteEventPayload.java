package org.opentmf.dnext.tmf634.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf634.model.IResourceCatalogDeleteEventPayload;

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
public class ResourceCatalogDeleteEventPayload implements IResourceCatalogDeleteEventPayload {

  /**
   * The root entity for resource catalog management. A resource catalog is a
   * group of resource specifications made available through resource candidates
   * that an organization provides to the consumers (internal consumers like its
   * employees or B2B customers or B2C customers).
   */
  private @Valid ResourceCatalog resourceCatalog;
}