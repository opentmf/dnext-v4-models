package org.opentmf.dnext.tmf638.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.LoyaltyActionBase;
import org.opentmf.dnext.common.model.Service;

/**
 * ServiceSnapshot entity for storing inventory item state at a specific moment.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
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
    defaultImpl = ServiceSnapshot.class
)
public class ServiceSnapshot extends LoyaltyActionBase {

  /**
   * Order ID associated with this snapshot.
   */
  @SafeId
  @Size(max = 100)
  private String orderId;

  /**
   * Order item ID associated with this snapshot.
   */
  @SafeId
  @Size(max = 100)
  private String orderItemId;

  /**
   * Parent order ID for nested orders.
   */
  @SafeId
  @Size(max = 100)
  private String parentOrderId;

  /**
   * Parent order item ID for nested orders.
   */
  @SafeId
  @Size(max = 100)
  private String parentOrderItemId;

  /**
   * Parent order type for nested orders.
   */
  private @SafeText String parentOrderType;

  private Long revision;

  /**
   * Timestamp when snapshot was created.
   */
  private OffsetDateTime snapshotCreatedAt;

  /**
   * The full service entity at the time of snapshot.
   */
  private @Valid Service snapshotObject;
}