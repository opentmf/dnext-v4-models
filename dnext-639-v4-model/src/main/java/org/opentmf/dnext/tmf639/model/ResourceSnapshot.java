package org.opentmf.dnext.tmf639.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.LoyaltyActionBase;
import org.opentmf.dnext.common.model.Resource;

/**
 * Snapshot entity that preserves a full copy of the Resource in snapshotObject
 * (composition pattern).
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ResourceSnapshot.class
)
public class ResourceSnapshot extends LoyaltyActionBase {

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
   * Parent Order ID.
   */
  @SafeId
  @Size(max = 100)
  private String parentOrderId;

  /**
   * Parent Order Item ID.
   */
  @SafeId
  @Size(max = 100)
  private String parentOrderItemId;

  /**
   * Parent Order Type.
   */
  private @SafeText String parentOrderType;

  /**
   * Version number of the entity.
   */
  private Long revision;

  /**
   * Snapshot creation timestamp.
   */
  private OffsetDateTime snapshotCreatedAt;

  /**
   * Full resource object preserved at snapshot creation time (composition
   * pattern).
   */
  private @Valid Resource snapshotObject;
}