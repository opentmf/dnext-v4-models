package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-common: common</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PreFlow {

  /**
   * Add FulfillmentSpecification.
   */
  private @SafeText String add;

  /**
   * Delete FulfillmentSpecification.
   */
  private @SafeText String delete;

  /**
   * Modify FulfillmentSpecification.
   */
  private @SafeText String modify;

  /**
   * Modify Migration FulfillmentSpecification.
   */
  @JsonProperty("modify.Migration")
  private @SafeText String modifyMigration;

  /**
   * Modify Relocation FulfillmentSpecification.
   */
  @JsonProperty("modify.Relocation")
  private @SafeText String modifyRelocation;

  /**
   * Modify Takeover FulfillmentSpecification.
   */
  @JsonProperty("modify.Takeover")
  private @SafeText String modifyTakeover;

  /**
   * Status Change FulfillmentSpecification.
   */
  private @SafeText String statusChange;

  /**
   * Status Change Resume FulfillmentSpecification.
   */
  @JsonProperty("statusChange.Resume")
  private @SafeText String statusChangeResume;

  /**
   * Status Change Suspend FulfillmentSpecification.
   */
  @JsonProperty("statusChange.Suspend")
  private @SafeText String statusChangeSuspend;
}