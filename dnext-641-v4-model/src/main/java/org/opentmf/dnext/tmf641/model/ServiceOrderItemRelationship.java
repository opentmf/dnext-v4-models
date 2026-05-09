package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.ServiceOrderItemRef;
import org.opentmf.tmf641.model.IServiceOrderItemRelationship;

/**
 * Linked service order item to the one containing this attribute.
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
    defaultImpl = ServiceOrderItemRelationship.class
)
public class ServiceOrderItemRelationship extends Extensible implements IServiceOrderItemRelationship {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A service order item in relationship with this order item.
   */
  private @Valid ServiceOrderItemRef orderItem;

  /**
   * The type of related order item, can be: dependency if the order item needs to
   * be not started until another order item is complete.
   */
  private @SafeText String relationshipType;
}