package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.BillPresentationMediaUpdate;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf666.model.IBillingCycleSpecificationCreate;

/**
 * The BillingCycleSpecification to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = BillingCycleSpecificationCreate.class
)
@Required(fields = {"name"})
public class BillingCycleSpecificationCreate extends BillPresentationMediaUpdate implements IBillingCycleSpecificationCreate {

  /**
   * An offset of a billing/settlement date. The offset is expressed as number of
   * days with regard to the start of the billing/settlement period.
   */
  private Integer billingDateShift;

  /**
   * A billing time period. It can be recurring, for example: week, month, quarter
   * of year, year .
   */
  private @SafeText String billingPeriod;

  /**
   * An offset of a date through which charges previously received by the billing
   * system will appear on the bill. The offset is expressed as number of days
   * with regard to the start of the BillingPeriod.
   */
  private Integer chargeDateOffset;

  /**
   * An offset of a date through which credits previously received by the billing
   * system will appear on the bill. The offset is expressed as number of days
   * with regard to the start of the BillingPeriod.
   */
  private Integer creditDateOffset;

  /**
   * Frequency of the billing cycle (monthly for instance).
   */
  private @SafeText String frequency;

  /**
   * An offset of a customer bill mailing date. The offset is expressed as number
   * of days with regard to the start of the BillingPeriod.
   */
  private Integer mailingDateOffset;

  /**
   * An offset of a payment due date. The offset is expressed as number of days
   * with regard to the start of the BillingPeriod.
   */
  private Integer paymentDueDateOffset;

  /**
   * The time period that the contact medium is valid for.
   */
  private @Valid TimePeriod validFor;
}