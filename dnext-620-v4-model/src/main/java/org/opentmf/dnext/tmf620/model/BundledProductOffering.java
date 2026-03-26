package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.product.model.BundledProductSpecification;
import org.opentmf.tmf620.model.IBundledProductOffering;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
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
    defaultImpl = BundledProductOffering.class
)
@Required(fields = {"id"})
public class BundledProductOffering extends BundledProductSpecification implements IBundledProductOffering {

  /**
   * A bundled product offer option (BundledProdOfferOption).
   * <br/>A set of numbers that specifies the lower and upper limits
   * <br/>for a ProductOffering that can be procured as part of the
   * <br/>related BundledProductOffering. Values can range from 0
   * <br/>to unbounded.
   */
  private @Valid BundledProductOfferingOption bundledProductOfferingOption;
}