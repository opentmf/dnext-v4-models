package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf666.model.IBillingCycleSpecificationRefOrValue;

/**
 * An attachment by value or by reference.
 *
 * <p><br/>
 * <strong>Required:</strong> isRef, name<br/>
 * </p>
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
    defaultImpl = BillingCycleSpecificationRefOrValue.class
)
@Required(fields = {"isRef", "name"})
public class BillingCycleSpecificationRefOrValue extends BillPresentationMediaRefOrValue implements IBillingCycleSpecificationRefOrValue {

  /**
   * An offset of a billing/settlement date.
   */
  private Integer billingDateShift;

  /**
   * A billing time period. It can be recurring, for example: week, month, quarter
   * of year, year.
   */
  private @SafeText String billingPeriod;

  /**
   * An offset of a date through which charges previously received by the billing
   * system will appear on the bill.
   */
  private Integer chargeDateOffset;

  /**
   * An offset of a date through which credits previously received by the billing
   * system will appear on the bill.
   */
  private Integer creditDateOffset;

  /**
   * An offset of a billing/settlement date.
   */
  private Integer dateShift;

  /**
   * Frequency of the billing cycle (monthly for instance).
   */
  private @SafeText String frequency;

  /**
   * An offset of a customer bill mailing date.
   */
  private Integer mailingDateOffset;

  /**
   * An offset of a payment due date.
   */
  private Integer paymentDueDateOffset;

  /**
   * . The period for which the billing specification cycle is valid.
   */
  private @Valid TimePeriod validFor;
}