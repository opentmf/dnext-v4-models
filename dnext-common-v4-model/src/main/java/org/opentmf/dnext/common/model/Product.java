package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IProduct;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A product offering procured by a customer or other interested party playing a
 * party role. A product is realized as one or more service(s) and / or
 * resource(s).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-637: Product Inventory Management API</li>
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
    defaultImpl = Product.class
)
public class Product extends ProductUpdate implements IProduct {

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private @SafeText String randomAtt;

  private Integer revision;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}