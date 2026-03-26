package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.EntityRef;

/**
 * A Resource Order is a request to provision a set of Resources (logical and
 * physical) triggered by the request to provision a Service through a Service
 * Order.
 *
 * <p><br/>
 * <strong>Required:</strong> orderItem<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = ChangedResourceOrder.class
)
@Required(fields = {"orderItem"})
public class ChangedResourceOrder extends ResourceOrderUpdate {

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Date when the order was created.
   */
  private OffsetDateTime orderDate;

  private @Valid EntityRef relatedInflightOrderChange;
}