package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.resource.model.IEndpointSpecificationRef;

/**
 * A specification for a vertex in a resource graph.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = EndpointSpecificationRef.class
)
public class EndpointSpecificationRef extends RelatedEntityRefOrValue implements IEndpointSpecificationRef {

  /**
   * Connection point specification reference. A connection point provides a
   * service access point (SAP) for input and/or output of the resource function.
   */
  private @Valid ConnectionPointSpecificationRef connectionPointSpecification;

  /**
   * Directionality: true when endpoint is a source, false when a sink. If true
   * for all endpoints, connectivity is bidirectional. Default is true.
   */
  private Boolean isRoot;
}