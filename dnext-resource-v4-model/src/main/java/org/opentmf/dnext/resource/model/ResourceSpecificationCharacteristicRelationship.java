package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.RelationshipBase;
import org.opentmf.resource.model.IResourceSpecificationCharacteristicRelationship;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among ResourceSpecificationCharacteristics. The
 * specification characteristic is embedded within the specification whose ID
 * and href are in this entity, and identified by its ID.
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
    defaultImpl = ResourceSpecificationCharacteristicRelationship.class
)
public class ResourceSpecificationCharacteristicRelationship extends RelationshipBase implements IResourceSpecificationCharacteristicRelationship {

  /**
   * Unique identifier of the characteristic within the specification.
   */
  @SafeId
  @Size(max = 100)
  private String characteristicSpecificationId;

  /**
   * Hyperlink reference to the resource specification containing the target
   * characteristic.
   */
  private URI resourceSpecificationHref;

  /**
   * Unique identifier of the resource specification containing the target
   * characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String resourceSpecificationId;
}