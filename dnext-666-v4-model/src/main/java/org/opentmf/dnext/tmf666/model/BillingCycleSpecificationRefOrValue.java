package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
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
public class BillingCycleSpecificationRefOrValue extends BillingCycleSpecification implements IBillingCycleSpecificationRefOrValue {

  /**
   * g. The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * An offset of a billing/settlement date.
   */
  private Integer dateShift;

  private Boolean isRef;
}