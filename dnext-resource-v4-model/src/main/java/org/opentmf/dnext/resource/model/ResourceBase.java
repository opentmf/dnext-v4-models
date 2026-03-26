package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.BundledResourceSpecification;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-resource: resource</li>
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
    defaultImpl = ResourceBase.class
)
public abstract class ResourceBase extends BundledResourceSpecification {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Date and time of the last update of this REST resource.
   */
  private OffsetDateTime lastUpdate;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}