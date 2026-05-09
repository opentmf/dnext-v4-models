package org.opentmf.dnext.tmf637.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.LoyaltyActionBase;
import org.opentmf.dnext.common.model.Product;

/**
 * A snapshot of a Product entity at a specific point in time.
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ProductSnapshot.class
)
public class ProductSnapshot extends LoyaltyActionBase {

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

  private Long revision;

  /**
   * Timestamp when the snapshot was created.
   */
  private OffsetDateTime snapshotCreatedAt;

  /**
   * The complete Product entity captured at the snapshot time.
   */
  private @Valid Product snapshotObject;
}