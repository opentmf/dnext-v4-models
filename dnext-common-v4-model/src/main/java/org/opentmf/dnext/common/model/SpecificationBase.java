package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 6 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AgreementSpecificationCreate (651)</li>
 *   <li>AgreementSpecificationUpdate (651)</li>
 *   <li>DocumentSpecification (667)</li>
 *   <li>DocumentSpecificationRefOrValue (667)</li>
 *   <li>LoyaltyProgramProductSpecUpdate (658)</li>
 *   <li>ProductSpecification (620)</li>
 *   <li>ResourceSpecificationCreate (634)</li>
 *   <li>ResourceSpecificationUpdate (634)</li>
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
    defaultImpl = SpecificationBase.class
)
public abstract class SpecificationBase extends Extensible {

  /**
   * A narrative that explains in detail what the agreement specification is
   * about.
   */
  private @SafeText String description;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the agreement specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * If true, this agreement specification is a grouping of other agreement
   * specifications. The list of bundled agreement specifications is provided by
   * the specificationRelationship property.
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the agreement specification.
   */
  private @SafeText String name;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  private @Valid TimePeriod validFor;

  private @SafeText String version;
}