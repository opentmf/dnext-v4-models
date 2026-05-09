package org.opentmf.dnext.resource.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.BundledFeatureSpecification;

/**
 * A type of ResourceFunctionSpecification that belongs to a grouping of
 * ResourceFunctionSpecifications made available to the market. It inherits of
 * all attributes of ResourceFunctionSpecification.
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
    defaultImpl = BundledResourceFunctionSpecification.class
)
public class BundledResourceFunctionSpecification extends BundledFeatureSpecification {

  /**
   * The version given to the target resource specification instance.
   */
  private @SafeText String version;
}