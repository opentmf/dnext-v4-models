package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf652.model.IExternalId;

/**
 * An identification of an entity that is owned by or originates in a software
 * system different from the current system, for example a ProductOrder handed
 * off from a commerce platform into an order handling system. The structure
 * identifies the system itself, the nature of the entity within the system
 * (e.g. class name) and the unique ID of the entity within the system. It is
 * anticipated that multiple external IDs can be held for a single entity, e.g.
 * if the entity passed through multiple systems on the way to the current
 * system. In this case the consumer is expected to sequence the IDs in the
 * array in reverse order of provenance, i.e. most recent system first in the
 * list.
 *
 * <p><br/>
 * <strong>Required:</strong> entityType, id, owner<br/>
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
    defaultImpl = ExternalId.class
)
@Required(fields = {"owner", "entityType", "id"})
public class ExternalId extends Entity implements IExternalId {

  /**
   * Type of the entity within the external system.
   */
  private @SafeText String entityType;

  /**
   * Name of the external system that owns the entity.
   */
  private @SafeText String owner;
}