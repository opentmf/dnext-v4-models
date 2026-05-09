package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>ResourceCandidateCreate (634)</li>
 *   <li>ResourceCandidateUpdate (634)</li>
 *   <li>ResourceCatalogCreate (634)</li>
 *   <li>ResourceCatalogUpdate (634)</li>
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
public abstract class ResourceBase extends Extensible {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of a resource candidate.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date and time of the last update of this REST resource.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Used to indicate the current lifecycle status of the resource candidate.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;

  private @SafeText String version;
}