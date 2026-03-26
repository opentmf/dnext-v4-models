package org.opentmf.dnext.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.CharacteristicRelationship;
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
public class ServiceOrderItemRelationship extends CharacteristicRelationship implements IServiceOrderItemRelationship {

  /**
   * A service order item in relationship with this order item.
   */
  private @Valid ServiceOrderItemRef orderItem;
}