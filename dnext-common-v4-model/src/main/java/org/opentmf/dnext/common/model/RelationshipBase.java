package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 9 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AgreementSpecificationRelationship (651)</li>
 *   <li>CharacteristicSpecificationRelationship (633)</li>
 *   <li>FeatureSpecificationCharacteristicRelationship (633, 634)</li>
 *   <li>FeatureSpecificationRelationship (633, 634)</li>
 *   <li>ProductOfferingPriceCharacteristicRelationship (620)</li>
 *   <li>ProductSpecificationCharacteristicRelationship (620, 658)</li>
 *   <li>ResourceSpecificationCharacteristicRelationship (634)</li>
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
    defaultImpl = RelationshipBase.class
)
public abstract class RelationshipBase extends Extensible {

  /**
   * Reference of the related entity.
   */
  private URI href;

  /**
   * Unique identifier of the agreement item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Name of the related entity.
   */
  private @SafeText String name;

  /**
   * Type of relationship such as, substitution or dependency.
   */
  private @SafeText String relationshipType;

  private @Valid TimePeriod validFor;
}