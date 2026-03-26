package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * An identified part of the order. A service order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id, orderId, resource<br/>
 * </p>
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
    defaultImpl = DetachedResourceOrderItem.class
)
@Required(fields = {"orderId", "resource", "action", "id"})
public class DetachedResourceOrderItem extends ResourceOrderItem {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Identifier of the ResourceOrder that contains this DetachedProductOrderItem.
   */
  @SafeId
  @Size(max = 100)
  private String orderId;
}