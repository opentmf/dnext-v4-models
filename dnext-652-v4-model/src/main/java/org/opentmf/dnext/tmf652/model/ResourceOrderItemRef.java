package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.tmf652.model.IResourceOrderItemRef;

/**
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
    defaultImpl = ResourceOrderItemRef.class
)
public class ResourceOrderItemRef extends ResourceOrderRef implements IResourceOrderItemRef {

  /**
   * Identifier of the line item.
   */
  @SafeId
  @Size(max = 100)
  private String itemId;

  /**
   * Link to the order to which this item belongs to.
   */
  private URI resourceOrderHref;

  /**
   * Identifier of the order that this item belongs to.
   */
  @SafeId
  @Size(max = 100)
  private String resourceOrderId;
}