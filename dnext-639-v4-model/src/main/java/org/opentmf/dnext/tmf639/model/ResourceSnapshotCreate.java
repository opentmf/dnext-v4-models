package org.opentmf.dnext.tmf639.model;

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
 *   <li>TMF-639: Resource Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"orderId", "orderItemId"})
public class ResourceSnapshotCreate {

  /**
   * Order ID.
   */
  @SafeId
  @Size(max = 100)
  private String orderId;

  /**
   * Order Item ID.
   */
  @SafeId
  @Size(max = 100)
  private String orderItemId;

  /**
   * Parent Order ID (required if parentOrderType provided).
   */
  @SafeId
  @Size(max = 100)
  private String parentOrderId;

  /**
   * Parent Order Item ID (required if parentOrderType provided).
   */
  @SafeId
  @Size(max = 100)
  private String parentOrderItemId;

  /**
   * Parent Order Type (optional).
   */
  private @SafeText String parentOrderType;
}