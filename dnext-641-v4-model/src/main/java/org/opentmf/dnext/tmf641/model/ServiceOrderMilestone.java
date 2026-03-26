package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.tmf641.model.IServiceOrderMilestone;

/**
 * ServiceOrderMilestone represents an action or event marking a significant
 * change or stage in processing of a service order.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ServiceOrderMilestone.class
)
public class ServiceOrderMilestone extends NamedEntity implements IServiceOrderMilestone {

  /**
   * free-text description of the Milestone.
   */
  private @SafeText String description;

  /**
   * A string represents the message of the milestone.
   */
  private @SafeText String message;

  /**
   * A date time( DateTime). The date that the milestone happens.
   */
  private OffsetDateTime milestoneDate;

  /**
   * A list of order item references corresponded to this milestone.
   */
  @JsonProperty("serviceOrderItem")
  private List<@Valid ServiceOrderItemRef> serviceOrderItems;

  /**
   * The milestone status.
   */
  private @SafeText String status;
}