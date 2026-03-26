package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * RelatedResourceOrderItem (a ResourceOrder item) .The resource order item
 * which triggered resource creation/change/termination.
 *
 * <p><br/>
 * <strong>Required:</strong> itemId, resourceOrderId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-common: common</li>
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
    defaultImpl = RelatedResourceOrderItem.class
)
@Required(fields = {"itemId", "resourceOrderId"})
public class RelatedResourceOrderItem extends Extensible {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * Action of the order item for this resource.
   */
  private @SafeText String itemAction;

  /**
   * Identifier of the order item where the resource was managed.
   */
  @SafeId
  @Size(max = 100)
  private String itemId;

  /**
   * Reference of the related entity.
   */
  private URI resourceOrderHref;

  /**
   * Unique identifier of a related entity.
   */
  @SafeId
  @Size(max = 100)
  private String resourceOrderId;

  /**
   * Role of the resource order item for this resource.
   */
  private @SafeText String role;
}