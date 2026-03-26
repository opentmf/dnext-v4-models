package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPaymentItem;
import org.opentmf.commons.validation.constraints.Required;

/**
 * The paymentItem is the result of lettering process. It enables to assign
 * automatically or manually part of incoming payment amount to a bill.
 *
 * <p><br/>
 * <strong>Required:</strong> item<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = PaymentItem.class
)
@Required(fields = {"item"})
public class PaymentItem extends Entity implements IPaymentItem {

  /**
   * Amount to be paid (net of taxes).
   */
  private @Valid Money amount;

  private @Valid EntityRef item;

  /**
   * Tax applied.
   */
  private @Valid Money taxAmount;

  /**
   * Amount to be paid (including taxes).
   */
  private @Valid Money totalAmount;
}