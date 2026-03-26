package org.opentmf.dnext.customer.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.IProductOfferingQualificationItemRef;
import org.opentmf.dnext.common.model.EntityRef;

/**
 * It's a productOfferingQualification item that has been executed previously.
 *
 * <p><br/>
 * <strong>Required:</strong> id, productOfferingQualificationId<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
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
    defaultImpl = ProductOfferingQualificationItemRef.class
)
@Required(fields = {"productOfferingQualificationId", "id"})
public class ProductOfferingQualificationItemRef extends EntityRef implements IProductOfferingQualificationItemRef {

  /**
   * Reference of the related entity.
   */
  private URI productOfferingQualificationHref;

  /**
   * Unique identifier of a related entity.
   */
  @SafeId
  @Size(max = 100)
  private String productOfferingQualificationId;

  /**
   * Name of the related entity.
   */
  private @SafeText String productOfferingQualificationName;
}