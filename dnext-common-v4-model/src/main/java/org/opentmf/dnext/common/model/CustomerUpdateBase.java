package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-669: Party Role Management API</li>
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
    defaultImpl = CustomerUpdateBase.class
)
public abstract class CustomerUpdateBase extends Extensible {

  /**
   * A list of account references.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * A list of characteristics.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * A list of contact mediums.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * A list of credit profiles.
   */
  @JsonProperty("creditProfile")
  private List<@Valid CreditProfile> creditProfiles;

  private @SafeText String name;

  /**
   * A list of payment method references.
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;

  /**
   * A list of related parties (RelatedParty [*]). Related Entity reference. A
   * related party defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Used to track the lifecycle status of the customer.
   */
  private @SafeText String status;

  /**
   * A string providing an explanation on the value of the status lifecycle.
   */
  private @SafeText String statusReason;

  /**
   * A time period. The time period that the Customer is valid for.
   */
  private @Valid TimePeriod validFor;
}