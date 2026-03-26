package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-common: common</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class ServiceSpecificationExtension {

  /**
   * FulfillmentSpecification.
   */
  private @Valid FulfillmentSpecification fulfillmentSpecification;

  /**
   * fulfillmentSpecificationOperation.
   */
  @JsonProperty("fulfillmentSpecificationOperation")
  private List<@Valid FulfillmentSpecificationOperation> fulfillmentSpecificationOperations;
}