package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IServiceSpecRelationship;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A dependency, substitution or exclusivity relationship between/among service
 * specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id, relationshipType<br/>
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
    defaultImpl = ServiceSpecRelationship.class
)
@Required(fields = {"relationshipType", "href", "id"})
public class ServiceSpecRelationship extends RelatedEntityRefOrValue implements IServiceSpecRelationship {

  /**
   * Type of relationship such as dependency, substitution or exclusivity.
   */
  private @SafeText String relationshipType;

  /**
   * The period for which the serviceSpecRelationship is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * Resource Specification version.
   */
  private @SafeText String version;
}