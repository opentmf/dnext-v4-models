package org.opentmf.dnext.tmf639.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.ResourceCreate;

/**
 * The Bulk Resource to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> baseResource, bulkCharacteristic, itemCount<br/>
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
    defaultImpl = BulkResourceCreate.class
)
@Required(fields = {"baseResource", "bulkCharacteristic", "itemCount"})
public class BulkResourceCreate extends Extensible {

  /**
   * The base part of the resource that will be present in all created entities.
   */
  private @Valid ResourceCreate baseResource;

  /**
   * An array of ResourceCharacteristicTemplate objects that will be used to
   * generate a ResourceCharacteristic type object for each entity.
   */
  @JsonProperty("bulkCharacteristic")
  private List<@Valid BulkCharacteristic> bulkCharacteristics;

  /**
   * The name of the resource characteristic to be used as resource ID instead of
   * Auto ID generation.
   */
  private @SafeText String identifierCharacteristicName;

  /**
   * The number of resources that will be created.
   */
  private Integer itemCount;

  /**
   * An arbitrary string that is added to all the created resources as an external
   * reference.
   */
  private @SafeText String jobReference;
}