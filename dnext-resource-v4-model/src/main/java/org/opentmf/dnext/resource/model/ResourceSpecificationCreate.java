package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.BundledResourceSpecification;
import org.opentmf.dnext.common.model.ResourceSpecificationExtension;
import org.opentmf.resource.model.IResourceSpecificationCreate;

/**
 * Creates a ResourceSpecification.
 *
 * <p><br/>
 * <strong>Required:</strong> id, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ResourceSpecificationCreate.class
)
@Required(fields = {"name", "id"})
public class ResourceSpecificationCreate extends ResourceSpecificationBase implements IResourceSpecificationCreate {

  /**
   * A type of ResourceSpecification that belongs to a grouping of
   * ResourceSpecifications made available to the market. It inherits of all
   * attributes of ResourceSpecification.
   */
  @JsonProperty("bundledResourceSpecification")
  private List<@Valid BundledResourceSpecification> bundledResourceSpecifications;

  /**
   * ResourceSpecification model has been extended.
   */
  private @Valid ResourceSpecificationExtension pExtension;

  private @Valid ResourceSpecificationExtension pextension;

  public ResourceSpecificationExtension getPExtension() {
    return pExtension;
  }

  public void setPExtension(ResourceSpecificationExtension pExtension) {
    this.pExtension = pExtension;
  }

  public ResourceSpecificationExtension getPextension() {
    return pextension;
  }

  public void setPextension(ResourceSpecificationExtension pextension) {
    this.pextension = pextension;
  }
}