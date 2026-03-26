package org.opentmf.dnext.tmf652.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AppointmentRef;
import org.opentmf.dnext.common.model.InflightOrderChangeUpdate;
import org.opentmf.dnext.common.model.ResourceRefOrValue;
import org.opentmf.dnext.common.model.ResourceSpecificationRef;

/**
 * The ResourceOrder to be updated.
 *
 * <p><br/>
 * <strong>Required:</strong> action<br/>
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
    defaultImpl = DetachedResourceOrderItemUpdate.class
)
@Required(fields = {"action"})
public class DetachedResourceOrderItemUpdate extends InflightOrderChangeUpdate {

  /**
   * Can be "add" / "modify" / "no_change"/ "delete".
   */
  private @SafeText String action;

  /**
   * Refers an appointment, such as a Customer presentation or internal meeting or
   * site visit.
   */
  private @Valid AppointmentRef appointment;

  @JsonProperty("orderItemRelationship")
  private List<@Valid ResourceOrderItemRelationship> orderItemRelationships;

  /**
   * Quantity ordered.
   */
  private Integer quantity;

  private @Valid ResourceRefOrValue resource;

  private @Valid ResourceSpecificationRef resourceSpecification;
}