package org.opentmf.dnext.resource.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.resource.model.IResourceSpecificationChangeEventPayload;

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
public class ResourceSpecificationChangeEventPayload implements IResourceSpecificationChangeEventPayload {

  /**
   * Resources are physical or non-physical components (or some combination of
   * these) within an enterprise’s infrastructure or inventory. They are typically
   * consumed or used by services (for example a physical port assigned to a
   * service) or contribute to the realization of a Product (for example, a SIM
   * card). They can be drawn from the Application, Computing and Network domains,
   * and include, for example, Network Elements, software, IT systems, content and
   * information, and technology components. A ResourceSpecification is an
   * abstract base class for representing a generic means for implementing a
   * particular type of Resource. In essence, a ResourceSpecification defines the
   * common attributes and relationships of a set of related Resources, while
   * Resource defines a specific instance that is based on a particular
   * ResourceSpecification.
   */
  private @Valid ResourceSpecification resourceSpecification;
}