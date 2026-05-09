package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.EntityRef;
import org.opentmf.tmf652.model.IResourceOrder;

/**
 * A Resource Order is a request to provision a set of Resources (logical and
 * physical) triggered by the request to provision a Service through a Service
 * Order.
 *
 * <p><br/>
 * <strong>Required:</strong> orderItem<br/>
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
    defaultImpl = ResourceOrder.class
)
@Required(fields = {"orderItem"})
public class ResourceOrder extends ResourceOrderCreate implements IResourceOrder {

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private @Valid EntityRef relatedInflightOrderChange;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}