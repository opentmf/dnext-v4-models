package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Resource;
import org.opentmf.resource.model.IPhysicalResource;

/**
 * Physical resource is a type of resource that describes the common set of
 * attributes shared by all concrete physical resources (e.g. EQUIPMENT) in the
 * inventory.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
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
    defaultImpl = PhysicalResource.class
)
@JsonTypeName("PhysicalResource")
@Required(fields = {"href", "id"})
public class PhysicalResource extends Resource implements IPhysicalResource {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * This is a string attribute that defines the date of manufacture of this item
   * in the fixed format "dd/mm/yyyy". This is an optional attribute.
   */
  private OffsetDateTime manufactureDate;

  /**
   * This defines the current power status of the hardware item. Values include: 
   * 0: Unknown  1: Not Applicable  2: No Power Applied  3: Full Power Applied  4:
   * Power Save - Normal  5: Power Save - Degraded  6: Power Save - Standby  7:
   * Power Save - Critical  8: Power Save - Low Power Mode  9: Power Save -
   * Unknown 10: Power Cycle 11: Power Warning 12: Power Off.
   */
  private @SafeText String powerState;

  /**
   * This is a string that represents a manufacturer-allocated number used to
   * identify different instances of the same hardware item. The ModelNumber and
   * PartNumber attributes are used to identify different types of hardware items.
   * This is a REQUIRED attribute.
   */
  private @SafeText String serialNumber;

  /**
   * This is a string that identifies the version of this physical resource. This
   * is an optional attribute.
   */
  private @SafeText String versionNumber;
}