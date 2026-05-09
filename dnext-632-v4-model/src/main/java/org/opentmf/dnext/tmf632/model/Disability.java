package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf632.model.IDisability;

/**
 * Lack or inadequate strength or ability.
 *
 * <p><br/>
 * <strong>Required:</strong> disabilityCode, disabilityName<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = Disability.class
)
@Required(fields = {"disabilityCode", "disabilityName"})
public class Disability extends Extensible implements IDisability {

  /**
   * Code of the disability.
   */
  private @SafeText String disabilityCode;

  /**
   * Name of the disability.
   */
  private @SafeText String disabilityName;

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

  private @Valid TimePeriod validFor;
}