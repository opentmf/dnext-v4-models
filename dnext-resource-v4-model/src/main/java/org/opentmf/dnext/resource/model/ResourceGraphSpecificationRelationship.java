package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.CharacteristicRelationship;
import org.opentmf.dnext.common.model.ResourceGraphSpecificationRef;
import org.opentmf.resource.model.IResourceGraphSpecificationRelationship;

/**
 * Describes link between resource graph specifications.
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
    defaultImpl = ResourceGraphSpecificationRelationship.class
)
public class ResourceGraphSpecificationRelationship extends CharacteristicRelationship implements IResourceGraphSpecificationRelationship {

  /**
   * A reference to the related resource graph specification.
   */
  private @Valid ResourceGraphSpecificationRef resourceGraph;
}