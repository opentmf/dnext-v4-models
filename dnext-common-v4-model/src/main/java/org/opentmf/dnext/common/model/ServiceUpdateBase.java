package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 5 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>DocumentUpdate (667)</li>
 *   <li>PartnershipCreate (668)</li>
 *   <li>PartnershipUpdate (668)</li>
 *   <li>ResourceCreate (639)</li>
 *   <li>ResourceUpdate (639)</li>
 *   <li>ServiceUpdate (638)</li>
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
    defaultImpl = ServiceUpdateBase.class
)
public abstract class ServiceUpdateBase extends Extensible {

  /**
   * An explanatory text regarding this partnership.
   */
  private @SafeText String description;

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * The identifier of the partnership.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * An identifying name for the partnership.
   */
  private @SafeText String name;
}