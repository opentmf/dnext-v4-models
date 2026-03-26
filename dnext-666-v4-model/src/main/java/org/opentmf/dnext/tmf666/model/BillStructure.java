package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf666.model.IBillStructure;

/**
 * The structure of the bill for party accounts (billing or settlement).
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
    defaultImpl = BillStructure.class
)
public class BillStructure extends Entity implements IBillStructure {

  /**
   * A billing cycle specification ref or value
   * (BillingCycleSpecificationRefOrValue). An attachment by value or by
   * reference.
   */
  private @Valid BillingCycleSpecificationRefOrValue cycleSpecification;

  /**
   * An attachment by value or by reference.
   */
  private @Valid BillFormatRefOrValue format;

  private @SafeText String preferredBillingCurrency;

  /**
   * A list of bill presentation media ref or values
   * (BillPresentationMediaRefOrValue [*]). An attachment by value or by
   * reference.
   */
  @JsonProperty("presentationMedia")
  private List<@Valid BillPresentationMediaRefOrValue> presentationMedias;
}