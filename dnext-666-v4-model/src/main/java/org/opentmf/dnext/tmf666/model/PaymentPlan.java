package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.PaymentMethodRef;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf666.model.IPaymentPlan;

/**
 * Defines a plan for payment (when a party wants to spread his payments).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = PaymentPlan.class
)
public class PaymentPlan extends Entity implements IPaymentPlan {

  /**
   * . Number of payments used to spread the global payment.
   */
  private Integer numberOfPayments;

  /**
   * Frequency of the payments, such as monthly and bimonthly.
   */
  private @SafeText String paymentFrequency;

  /**
   * PaymentMethod reference. A payment method defines a specific mean of payment
   * (e.g. direct debit).
   */
  private @Valid PaymentMethodRef paymentMethod;

  /**
   * . Type of payment plan.
   */
  private @SafeText String planType;

  /**
   * Priority of the payment plan.
   */
  private Integer priority;

  /**
   * Status of the payment plan (effective, ineffective).
   */
  private @SafeText String status;

  /**
   * A money (Money). Amount paid.
   */
  private @Valid Money totalAmount;

  /**
   * Validity period of the payment plan.
   */
  private @Valid TimePeriod validFor;
}