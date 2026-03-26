package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.resource.model.IResourceGraphSpecification;

/**
 * Resource graph specification.
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
    defaultImpl = ResourceGraphSpecification.class
)
public class ResourceGraphSpecification extends NamedEntity implements IResourceGraphSpecification {

  /**
   * Resource graph edge specifications.
   */
  @JsonProperty("connectionSpecification")
  private List<@Valid ConnectionSpecification> connectionSpecifications;

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Relationships to other resource graph specifications.
   */
  @JsonProperty("graphSpecificationRelationship")
  private List<@Valid ResourceGraphSpecificationRelationship> graphSpecificationRelationships;
}