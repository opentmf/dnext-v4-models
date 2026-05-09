package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IRelatedServiceOrderItem;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * RelatedServiceOrderItem (a ServiceOrder item) .The service order item which
 * triggered service creation/change/termination.
 *
 * <p><br/>
 * <strong>Required:</strong> itemId, serviceOrderId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
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
    defaultImpl = RelatedServiceOrderItem.class
)
@Required(fields = {"itemId", "serviceOrderId"})
public class RelatedServiceOrderItem extends ServiceOrderItemRef implements IRelatedServiceOrderItem {

  /**
   * Action of the order item for this service.
   */
  private @SafeText String itemAction;

  /**
   * role of the service order item for this service.
   */
  private @SafeText String role;
}