package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IFeatureSpecificationRelationship;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * Relationship between feature specifications.
 *
 * <p><br/>
 * <strong>Required:</strong> featureId, name, parentSpecificationId, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = FeatureSpecificationRelationship.class
)
@Required(fields = {"relationshipType", "parentSpecificationId", "name", "featureId"})
public class FeatureSpecificationRelationship extends RelationshipBase implements IFeatureSpecificationRelationship {

  /**
   * Unique identifier of the target feature specification.
   */
  @SafeId
  @Size(max = 100)
  private String featureId;

  /**
   * Hyperlink reference to the parent specification containing the target
   * feature.
   */
  private URI parentSpecificationHref;

  /**
   * Unique identifier of the parent specification containing the target feature.
   */
  @SafeId
  @Size(max = 100)
  private String parentSpecificationId;

  /**
   * Hyperlink reference to the resource specification containing the target
   * feature.
   */
  private URI resourceSpecificationHref;

  /**
   * Unique identifier of the resource specification containing the target
   * feature.
   */
  @SafeId
  @Size(max = 100)
  private String resourceSpecificationId;
}