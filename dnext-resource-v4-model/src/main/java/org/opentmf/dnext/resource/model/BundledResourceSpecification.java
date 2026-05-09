package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.BundledFeatureSpecification;

/**
 * A type of ResourceSpecification that belongs to a grouping of
 * ResourceSpecifications made available to the market. It inherits of all
 * attributes of ResourceSpecification.
 *
 * <p><br/>
 * <strong>Required:</strong> href, id<br/>
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
    defaultImpl = BundledResourceSpecification.class
)
@Required(fields = {"href", "id"})
public class BundledResourceSpecification extends BundledFeatureSpecification {

  /**
   * Version of the BundledResourceSpecification.
   */
  private @SafeText String version;
}