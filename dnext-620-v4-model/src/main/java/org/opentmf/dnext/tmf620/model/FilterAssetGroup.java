package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = FilterAssetGroup.class
)
public class FilterAssetGroup extends Extensible {

  /**
   * The type of entity in the group, equivalent to {@literal @}type in the
   * <br/>entity definition. Must be a top-level managed entity. The filter
   * <br/>expression is applied to this entity type.
   */
  private @SafeText String entityType;

  /**
   * The filter expression that defines the entities to be exported, format of the
   * filter is as per the simple query parameter filter as defined in TMF630.
   */
  private @SafeText String filter;
}