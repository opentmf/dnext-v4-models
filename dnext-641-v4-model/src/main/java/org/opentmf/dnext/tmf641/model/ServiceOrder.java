package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.tmf641.model.IServiceOrder;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> serviceOrderItem<br/>
 * </p>
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
    defaultImpl = ServiceOrder.class
)
@Required(fields = {"serviceOrderItem"})
public class ServiceOrder extends ServiceOrderCreate implements IServiceOrder {

  /**
   * Effective delivery date amended by the provider.
   */
  private OffsetDateTime completionDate;

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  /**
   * Expected delivery date amended by the provider.
   */
  private OffsetDateTime expectedCompletionDate;

  private Boolean isOngoingInflightOrderChange;

  private OffsetDateTime orderDate;

  private Boolean pointOfNoReturnIFOC;

  private @Valid EntityRef relatedInflightOrderChange;

  private Integer revision;

  /**
   * Date when the order was started for processing.
   */
  private OffsetDateTime startDate;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}