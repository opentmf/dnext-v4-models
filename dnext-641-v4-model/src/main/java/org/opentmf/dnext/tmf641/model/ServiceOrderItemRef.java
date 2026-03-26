package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf641.model.IServiceOrderItemRef;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> itemId<br/>
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
    defaultImpl = ServiceOrderItemRef.class
)
@Required(fields = {"itemId"})
public class ServiceOrderItemRef extends Entity implements IServiceOrderItemRef {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Identifier of the line item.
   */
  @SafeId
  @Size(max = 100)
  private String itemId;

  /**
   * Link to the order to which this item belongs to.
   */
  private URI serviceOrderHref;

  /**
   * Identifier of the order that this item belongs to.
   */
  @SafeId
  @Size(max = 100)
  private String serviceOrderId;
}