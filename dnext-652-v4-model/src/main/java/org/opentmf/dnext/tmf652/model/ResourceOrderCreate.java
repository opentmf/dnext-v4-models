package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.tmf652.model.IResourceOrderCreate;

/**
 * The Resource Order to be created.
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
    defaultImpl = ResourceOrderCreate.class
)
@Required(fields = {"orderItem"})
public class ResourceOrderCreate extends ResourceOrderUpdate implements IResourceOrderCreate {

  /**
   * Date when the order was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Date when the order was created.
   */
  private OffsetDateTime orderDate;
}