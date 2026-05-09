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
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>FeatureRelationship (638, 639, 641, 652)</li>
 *   <li>FeatureSpecification (633, 634)</li>
 *   <li>OtherNameOrganization (632)</li>
 *   <li>TaxDefinition (632, 658)</li>
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
    defaultImpl = TaxDefinitionBase.class
)
public abstract class TaxDefinitionBase extends Extensible {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the target feature.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * This is the name of the target feature.
   */
  private @SafeText String name;

  /**
   * The period for which this feature relationship is valid.
   */
  private @Valid TimePeriod validFor;
}