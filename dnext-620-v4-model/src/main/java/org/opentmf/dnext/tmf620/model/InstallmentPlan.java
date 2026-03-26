package org.opentmf.dnext.tmf620.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The installment plan for the payment.
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
public class InstallmentPlan {

  /**
   * The number of times to repeat the application of the installment.
   */
  private Integer installmentCount;

  /**
   * Defines the period of the installment together with periodType... set to zero
   * if not applicable.
   */
  private Integer periodLength;

  /**
   * Defines the period of the installment together with periodLength... can be
   * month, week ...etc.
   */
  private @SafeText String periodType;
}