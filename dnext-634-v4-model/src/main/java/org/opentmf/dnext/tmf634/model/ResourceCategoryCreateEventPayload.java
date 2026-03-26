package org.opentmf.dnext.tmf634.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf634.model.IResourceCategoryCreateEventPayload;

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
public class ResourceCategoryCreateEventPayload implements IResourceCategoryCreateEventPayload {

  /**
   * The (resource) category resource is used to group resource candidates in
   * logical containers. Categories can contain other categories.
   */
  private @Valid ResourceCategory resourceCategory;
}