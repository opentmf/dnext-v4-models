package org.opentmf.dnext.tmf639.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Characteristic;
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
    defaultImpl = BulkResourceCharacteristicUpdate.class
)
@Required(fields = {"itemCount"})
public class BulkResourceCharacteristicUpdate extends Extensible {

  /**
   * Used to identify a set of resources based on RangeTuple.
   */
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

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("resourceCharacteristicToUpsert")
  private List<@Valid Characteristic> resourceCharacteristicToUpserts;
}