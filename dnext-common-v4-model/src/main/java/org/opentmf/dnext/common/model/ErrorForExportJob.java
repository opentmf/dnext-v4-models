package org.opentmf.dnext.common.model;

import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
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
public class ErrorForExportJob {

  /**
   * error code.
   */
  private @SafeText String code;

  /**
   * error message.
   */
  private @SafeText String message;

  /**
   * error reason.
   */
  private @SafeText String reason;

  /**
   * error referenceError.
   */
  private URI referenceError;

  /**
   * error status.
   */
  private @SafeText String status;
}