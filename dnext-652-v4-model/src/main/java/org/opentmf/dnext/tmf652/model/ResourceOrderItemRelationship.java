package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.CharacteristicRelationship;
import org.opentmf.tmf652.model.IResourceOrderItemRelationship;

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
    defaultImpl = ResourceOrderItemRelationship.class
)
public class ResourceOrderItemRelationship extends CharacteristicRelationship implements IResourceOrderItemRelationship {

  private @Valid ResourceOrderItemRef orderItem;
}