package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.RelatedEntityRefOrValue;
import org.opentmf.tmf652.model.IResourceOrderItem;

/**
 * An identified part of the order. A resource order is decomposed into one or
 * more order items.
 *
 * <p><br/>
 * <strong>Required:</strong> action, id, resource<br/>
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
    defaultImpl = ResourceOrderItem.class
)
@Required(fields = {"resource", "action", "id"})
public class ResourceOrderItem extends DetachedResourceOrderItemUpdate implements IResourceOrderItem {

  /**
   * Complements the description of an element (for instance a resource) (for
   * instance a resource) through video, pictures ...
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  private @SafeText String category;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Identifier of item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A list of order items embedded to this order item.
   */
  @JsonProperty("orderItem")
  private List<@Valid ResourceOrderItem> orderItems;

  /**
   * Characteristic of the given resourceOrderItem.
   */
  @JsonProperty("orderItemCharacteristic")
  private List<@Valid Characteristic> orderItemCharacteristics;

  /**
   * An identified part of the order. A resource order is decomposed into one or
   * more order items.
   */
  private @Valid ResourceOrderItem preInflightOrderChangeResourceOrderItem;

  /**
   * A list of related entity in relationship with this service order item.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;
}