package org.opentmf.dnext.common.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class FulfillmentSpecification extends PreFlow {

  /**
   * Post Flow FulfillmentSpecification.
   */
  private @Valid PostFlow postFlow;

  /**
   * Pre Flow FulfillmentSpecification.
   */
  private @Valid PreFlow preFlow;
}