package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.resource.model.IResourceFunctionSpecification;

/**
 * Resource function specifications.
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
    defaultImpl = ResourceFunctionSpecification.class
)
public class ResourceFunctionSpecification extends LogicalResourceSpecification implements IResourceFunctionSpecification {

  /**
   * A type of ResourceFunctionSpecification that belongs to a grouping of
   * ResourceFunctionSpecifications made available to the market. It inherits of
   * all attributes of ResourceFunctionSpecification.
   */
  @JsonProperty("bundledResourceFunctionSpecification")
  private List<@Valid BundledResourceFunctionSpecification> bundledResourceFunctionSpecifications;

  /**
   * External connection point specifications. These are the service access points
   * (SAP) where inputs and outputs of the function are available.
   */
  @JsonProperty("connectionPointSpecification")
  private List<@Valid ConnectionPointSpecificationRef> connectionPointSpecifications;

  /**
   * Internal connectivity potential specifications.
   */
  @JsonProperty("connectivitySpecification")
  private List<@Valid ResourceGraphSpecification> connectivitySpecifications;
}