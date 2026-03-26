package org.opentmf.dnext.tmf671.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf671.model.IPromotionDeleteEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class PromotionDeleteEventPayload implements IPromotionDeleteEventPayload {

  /**
   * Promotion is used to provide the additional discount, voucher, bonus or gift
   * to the customer who meets the pre-defined criteria. Using promotion, the
   * enterprise is able to attract the users and encourage more consumption,
   * especially continuous purchases. Normally Promotion is not regarded as one
   * type of product or product offering. It is often applied when the customer
   * buys the product offerings with the price or amount surpassing the certain
   * limit.
   */
  private @Valid Promotion promotion;
}