package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Duration;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf620.model.IProductOfferingTerm;

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
    defaultImpl = ProductOfferingTerm.class
)
public class ProductOfferingTerm extends NamedEntity implements IProductOfferingTerm {

  /**
   * Description of the productOfferingTerm.
   */
  private @SafeText String description;

  /**
   * Duration of the productOfferingTerm.
   */
  private @Valid Duration duration;

  /**
   * The period for which the productOfferingterm is valid.
   */
  private @Valid TimePeriod validFor;
}