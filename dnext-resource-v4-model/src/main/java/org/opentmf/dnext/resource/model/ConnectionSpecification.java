package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.resource.model.IConnectionSpecification;

/**
 * A specification for an edge in a resource graph.
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
    defaultImpl = ConnectionSpecification.class
)
public class ConnectionSpecification extends NamedEntity implements IConnectionSpecification {

  /**
   * Association type.
   */
  private @SafeText String associationType;

  /**
   * Specifications for resource graph vertices connected by this edge.
   */
  @JsonProperty("endpointSpecification")
  private List<@Valid EndpointSpecificationRef> endpointSpecifications;
}