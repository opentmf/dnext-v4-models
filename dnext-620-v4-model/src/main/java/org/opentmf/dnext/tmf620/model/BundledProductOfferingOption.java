package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.tmf620.model.IBundledProductOfferingOption;

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
    defaultImpl = BundledProductOfferingOption.class
)
public class BundledProductOfferingOption extends Extensible implements IBundledProductOfferingOption {

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Default number of product offerings that should
   * <br/>be procured as part of the related BundledProductOffering.
   */
  private Integer numberRelOfferDefault;

  /**
   * Lower limit for a product offering that can be
   * <br/>procured as part of the related BundledProductOffering.
   */
  private Integer numberRelOfferLowerLimit;

  /**
   * Upper limit for a product offering that can be
   * <br/>procured as part of the related BundledProductOffering.
   */
  private Integer numberRelOfferUpperLimit;
}