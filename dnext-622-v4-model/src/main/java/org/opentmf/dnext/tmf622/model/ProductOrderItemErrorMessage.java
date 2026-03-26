package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 * A ProductOrderItemErrorMessage represents an error that causes a status
 * change in a product order item.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
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
    defaultImpl = ProductOrderItemErrorMessage.class
)
public class ProductOrderItemErrorMessage extends Extensible {

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

  /**
   * Date when the error happened.
   */
  private OffsetDateTime timestamp;
}