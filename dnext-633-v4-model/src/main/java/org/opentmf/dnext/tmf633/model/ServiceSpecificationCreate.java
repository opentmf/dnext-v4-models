package org.opentmf.dnext.tmf633.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.tmf633.model.IServiceSpecificationCreate;

/**
 * The ServiceSpecification to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceSpecificationCreate.class
)
@Required(fields = {"name"})
public class ServiceSpecificationCreate extends ServiceSpecificationUpdate implements IServiceSpecificationCreate {

  /**
   * Date and time of the last update of the specification.
   */
  private OffsetDateTime lastUpdate;
}