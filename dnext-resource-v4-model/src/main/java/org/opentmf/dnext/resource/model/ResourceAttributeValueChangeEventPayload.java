package org.opentmf.dnext.resource.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.Resource;
import org.opentmf.resource.model.IResourceAttributeValueChangeEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ResourceAttributeValueChangeEventPayload implements IResourceAttributeValueChangeEventPayload {

  /**
   * Resource is an abstract entity that describes the common set of attributes
   * shared by all concrete resources (e.g. TPE, EQUIPMENT) in the inventory.
   */
  private @Valid Resource resource;
}