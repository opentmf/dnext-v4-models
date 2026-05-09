package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IEntitySpecificationRelationship;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A migration, substitution, dependency or exclusivity relationship
 * between/among entity specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = EntitySpecificationRelationship.class
)
@Required(fields = {"relationshipType", "href", "id"})
public class EntitySpecificationRelationship extends RelatedEntityRefOrValue implements IEntitySpecificationRelationship {

  /**
   * A specification for an association used by this relationship.
   */
  private @Valid AssociationSpecificationRef associationSpec;

  /**
   * Type of relationship such as migration, substitution, dependency,
   * exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which the entitySpecRelationship is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * Resource Specification version.
   */
  private @SafeText String version;
}