package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf620.model.IProductOfferingPriceCreate;

/**
 * The ProductOfferingPrice to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = ProductOfferingPriceCreate.class
)
@Required(fields = {"name"})
public class ProductOfferingPriceCreate extends ProductOfferingPriceUpdate implements IProductOfferingPriceCreate {

  /**
   * the last update time of this ProductOfferingPrice.
   */
  private OffsetDateTime lastUpdate;

  private @SafeText String version;
}