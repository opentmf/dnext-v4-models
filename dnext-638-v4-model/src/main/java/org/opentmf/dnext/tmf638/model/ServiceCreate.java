package org.opentmf.dnext.tmf638.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The Service to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> serviceSpecification, state<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-638: Service Inventory Management API</li>
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
    defaultImpl = ServiceCreate.class
)
@Required(fields = {"serviceSpecification", "state"})
public class ServiceCreate extends ServiceUpdate {

  /**
   * Unique identifier of a service entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Date when the service was created (whatever its status).
   */
  private OffsetDateTime serviceDate;
}