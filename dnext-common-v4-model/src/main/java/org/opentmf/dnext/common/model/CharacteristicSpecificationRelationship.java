package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ICharacteristicSpecificationRelationship;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * An aggregation, migration, substitution, dependency or exclusivity
 * relationship between/among Characteristic specifications. The specification
 * characteristic is embedded within the specification whose ID and href are in
 * this entity, and identified by its ID.
 *
 * <p><br/>
 * <strong>Required:</strong> name, parentSpecificationHref, parentSpecificationId, relationshipType<br/>
 * </p>
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = CharacteristicSpecificationRelationship.class
)
@Required(fields = {"relationshipType", "parentSpecificationId", "name", "parentSpecificationHref"})
public class CharacteristicSpecificationRelationship extends RelationshipBase implements ICharacteristicSpecificationRelationship {

  /**
   * Unique identifier of the characteristic within the specification.
   */
  @SafeId
  @Size(max = 100)
  private String characteristicSpecificationId;

  /**
   * Hyperlink reference to the parent specification containing the target
   * characteristic.
   */
  private URI parentSpecificationHref;

  /**
   * Unique identifier of the parent specification containing the target
   * characteristic.
   */
  @SafeId
  @Size(max = 100)
  private String parentSpecificationId;
}