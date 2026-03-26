package org.opentmf.dnext.tmf620.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.product.model.ProductSpecification;
import org.opentmf.tmf620.model.IProductSpecificationStateChangeEventPayload;

/**
 * The event data structure.
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
public class ProductSpecificationStateChangeEventPayload implements IProductSpecificationStateChangeEventPayload {

  private @Valid ProductSpecification productSpecification;
}