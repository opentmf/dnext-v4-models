package org.opentmf.dnext.tmf633.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf633.model.IServiceCategoryDeleteEventPayload;

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
public class ServiceCategoryDeleteEventPayload implements IServiceCategoryDeleteEventPayload {

  /**
   * The (service) category resource is used to group service candidates in
   * logical containers. Categories can contain other categories.
   */
  private @Valid ServiceCategory serviceCategory;
}