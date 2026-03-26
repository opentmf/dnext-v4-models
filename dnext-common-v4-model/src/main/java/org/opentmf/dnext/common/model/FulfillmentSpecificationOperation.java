package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

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
public class FulfillmentSpecificationOperation {

  private Boolean bypassInventoryTasks;

  /**
   * Cancel Flow FulfillmentSpecification.
   */
  private @SafeText String cancelFlow;

  /**
   * Stores inventory steps of fulfillment will be skipped or not.
   */
  private Boolean isBypassInventoryTasks;

  /**
   * Fulfillment Specification Operation Type.
   */
  private @SafeText String operationType;

  /**
   * Post Flow FulfillmentSpecification.
   */
  private @SafeText String postFlow;

  /**
   * Pre Flow FulfillmentSpecification.
   */
  private @SafeText String preFlow;

  /**
   * Relation definition between product specifications.
   */
  @JsonProperty("relatedSpecifications")
  private List<@Valid RelatedSpecification> relatedSpecificationses;
}