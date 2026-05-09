package org.opentmf.dnext.tmf637.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The Snapshot request data.
 *
 * <p><br/>
 * <strong>Required:</strong> orderId, orderItemId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-637: Product Inventory Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@Required(fields = {"orderId", "orderItemId"})
public class ProductSnapshotCreate {

  /**
   * The order ID associated with this snapshot.
   */
  @SafeId
  @Size(max = 100)
  private String orderId;

  /**
   * The order item ID associated with this snapshot.
   */
  @SafeId
  @Size(max = 100)
  private String orderItemId;
}