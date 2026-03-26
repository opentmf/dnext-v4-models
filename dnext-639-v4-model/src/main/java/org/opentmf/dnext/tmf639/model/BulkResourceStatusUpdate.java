package org.opentmf.dnext.tmf639.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 * The Bulk Resource to be updated.
 *
 * <p><br/>
 * <strong>Required:</strong> itemCount<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = BulkResourceStatusUpdate.class
)
@Required(fields = {"itemCount"})
public class BulkResourceStatusUpdate extends Extensible {

  private @Valid BulkCharacteristic bulkCharacteristic;

  /**
   * The number of resources that will be created.
   */
  private Integer itemCount;

  /**
   * An arbitrary string that is added to all the created resources as an external
   * reference.
   */
  private @SafeText String jobReference;

  private @SafeText String resourceStatus;
}