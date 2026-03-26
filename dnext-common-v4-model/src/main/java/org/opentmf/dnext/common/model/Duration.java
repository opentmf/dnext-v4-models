package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IDuration;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A time interval in a given unit of time.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = Duration.class
)
public class Duration extends Entity implements IDuration {

  /**
   * Time interval (number of seconds, minutes, hours, etc.).
   */
  private Integer amount;

  /**
   * Unit of time (seconds, minutes, hours, etc.).
   */
  private @SafeText String units;
}