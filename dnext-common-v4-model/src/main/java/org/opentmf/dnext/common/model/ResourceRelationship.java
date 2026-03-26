package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IResourceRelationship;
import org.opentmf.commons.validation.constraints.Required;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> resource<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-639: Resource Inventory Management API</li>
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
    defaultImpl = ResourceRelationship.class
)
@Required(fields = {"resource"})
public class ResourceRelationship extends CharacteristicRelationship implements IResourceRelationship {

  /**
   * When the related resource is a ResourceSpecificationRef, this field is
   * populated with the ResourceSpecificationRef. When the related resource is a
   * ResourceOrderItemRef, this field is populated with the ResourceOrderItemRef.
   */
  private @Valid ResourceRefOrValue resource;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("resourceRelationshipCharacteristic")
  private List<@Valid Characteristic> resourceRelationshipCharacteristics;
}