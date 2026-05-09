package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 7 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>Customer (629)</li>
 *   <li>CustomerCreate (629)</li>
 *   <li>CustomerUpdate (629)</li>
 *   <li>LoyaltyProgramPartnerCreate (658)</li>
 *   <li>LoyaltyProgramPartnerUpdate (658)</li>
 *   <li>Partner (668)</li>
 *   <li>PartyRoleCreate (669)</li>
 *   <li>PartyRoleUpdate (669)</li>
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
    defaultImpl = CustomerBase.class
)
public abstract class CustomerBase extends Extensible {

  /**
   * A list of agreement references.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

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

  /**
   * Url used to reference the customer.
   */
  private URI href;

  /**
   * Unique identifier of the customer.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A word, term, or phrase by which the Customer is known and distinguished from
   * other Customers.
   */
  private @SafeText String name;

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