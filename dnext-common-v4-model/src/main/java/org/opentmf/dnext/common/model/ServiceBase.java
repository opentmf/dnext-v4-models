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
 *   <li>ProductOfferingPriceRefOrValue (620)</li>
 *   <li>ServiceCandidateUpdate (633)</li>
 *   <li>ServiceCatalogUpdate (633)</li>
 *   <li>ServiceCategoryUpdate (633)</li>
 *   <li>ServiceSpecificationUpdate (633)</li>
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
    defaultImpl = ServiceBase.class
)
public abstract class ServiceBase extends Extensible {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Used to indicate the current lifecycle status of the service candidate.
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

  /**
   * the version of service candidate.
   */
  private @SafeText String version;
}