package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.ProductOfferingRef;

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
public class OfferingFulfillmentOperation {

  /**
   * Offering Fulfillment Cancel FLow.
   */
  private @SafeText String cancelFlow;

  /**
   * Offering Fulfillment Operation Type.
   */
  private @SafeText String operationType;

  /**
   * Offering Fulfillment Post Flow.
   */
  private @SafeText String postFlow;

  /**
   * Offering Fulfillment Pre Flow.
   */
  private @SafeText String preFlow;

  /**
   * Relation definiton between offerings.
   */
  @JsonProperty("relatedOfferings")
  private List<@Valid ProductOfferingRef> relatedOfferingses;

  /**
   * Relation definiton between offerings.
   */
  private @SafeText String relation;
}