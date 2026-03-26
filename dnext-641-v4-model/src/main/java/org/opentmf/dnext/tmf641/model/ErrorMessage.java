package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf641.model.IErrorMessage;

/**
 * represents an Error.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-641: Service Ordering Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@ToString(callSuper = true)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ErrorMessage.class
)
public class ErrorMessage extends Entity implements IErrorMessage {

  /**
   * error code.
   */
  private @SafeText String code;

  /**
   * More details and corrective actions related to the error.
   */
  private @SafeText String message;

  /**
   * Explanation of the reason for the error.
   */
  private @SafeText String reason;

  /**
   * URI of documentation describing the error.
   */
  private URI referenceError;

  /**
   * error code extension like sys-ABC-2001.
   */
  private @SafeText String status;
}