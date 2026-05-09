package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.CartTermBase;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf620.model.IPricingLogicAlgorithm;

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
    defaultImpl = PricingLogicAlgorithm.class
)
public class PricingLogicAlgorithm extends CartTermBase implements IPricingLogicAlgorithm {

  /**
   * id of corresponding PricingLogicAlgorithm specification.
   */
  @SafeId
  @Size(max = 100)
  private String plaSpecId;

  /**
   * The period for which the entity is valid.
   */
  private @Valid TimePeriod validFor;
}