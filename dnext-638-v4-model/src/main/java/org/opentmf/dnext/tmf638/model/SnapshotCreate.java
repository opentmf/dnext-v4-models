package org.opentmf.dnext.tmf638.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The snapshot request body.
 *
 * <p><br/>
 * <strong>Required:</strong> orderId, orderItemId<br/>
 * </p>
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
@Required(fields = {"orderId", "orderItemId"})
public class SnapshotCreate {

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
}