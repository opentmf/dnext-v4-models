package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
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
    defaultImpl = BundledGroupProductOfferingOption.class
)
public class BundledGroupProductOfferingOption extends Extensible {

  /**
   * The minimum total number of instances of the child offerings directly of
   * hierarchically in the group that should be instantiated.
   */
  private Integer numberRelOfferLowerLimit;

  /**
   * The maximum total number of instances of the child offerings directly of
   * hierarchically in the group that should be instantiated.
   */
  private Integer numberRelOfferUpperLimit;
}