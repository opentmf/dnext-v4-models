package org.opentmf.dnext.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 * A ProductOrderJeopardyAlert represents a predicted exception during a product
 * order processing that would brings risk to complete successfully the order.
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
    defaultImpl = ProductOrderJeopardyAlert.class
)
public class ProductOrderJeopardyAlert extends Extensible {

  /**
   * The exception associated with this jeopardy alert.
   */
  private @SafeText String exception;

  /**
   * identifier of the JeopardyAlert.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A date time( DateTime). The date that the alert issued.
   */
  private OffsetDateTime jeopardyDate;

  /**
   * A string represents the type of jeopardy/risk like Normal, Hazard, Critical,
   * ...
   */
  private @SafeText String jeopardyType;

  /**
   * A string represents the message of the alert.
   */
  private @SafeText String message;

  /**
   * A string used to give a name to the jeopardy alert.
   */
  private @SafeText String name;

  /**
   * A list of order item references corresponded to this alert.
   */
  @JsonProperty("productOrderItem")
  private List<Object> productOrderItems;
}