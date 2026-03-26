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
 * ProductOrderMilestone represents an action or event marking a significant
 * change or stage in processing of a product order.
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
    defaultImpl = ProductOrderMilestone.class
)
public class ProductOrderMilestone extends Extensible {

  /**
   * free-text description of the Milestone.
   */
  private @SafeText String description;

  /**
   * identifier of the Milestone.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A string represents the message of the milestone.
   */
  private @SafeText String message;

  /**
   * A date time( DateTime). The date that the milestone happens.
   */
  private OffsetDateTime milestoneDate;

  /**
   * A string used to give a name to the milestone.
   */
  private @SafeText String name;

  /**
   * A list of order item references corresponded to this alert.
   */
  @JsonProperty("productOrderItem")
  private List<Object> productOrderItems;

  /**
   * The milestone status.
   */
  private @SafeText String status;
}