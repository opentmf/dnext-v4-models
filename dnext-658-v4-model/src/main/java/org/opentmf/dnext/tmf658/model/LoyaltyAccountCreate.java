package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AccountBalance;
import org.opentmf.dnext.common.model.AccountRelationship;
import org.opentmf.dnext.common.model.Contact;
import org.opentmf.dnext.common.model.LoyaltyEarnCreateBase;
import org.opentmf.dnext.common.model.LoyaltyProgramProductRef;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TaxExemptionCertificate;
import org.opentmf.tmf658.model.ILoyaltyAccountCreate;

/**
 * The LoyaltyAccount to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = LoyaltyAccountCreate.class
)
@Required(fields = {"name"})
public class LoyaltyAccountCreate extends LoyaltyEarnCreateBase implements ILoyaltyAccountCreate {

  /**
   * List of: Balances linked to the account.
   */
  @JsonProperty("accountBalance")
  private List<@Valid AccountBalance> accountBalances;

  /**
   * List of: Significant connection between accounts. For instance an aggregating
   * account for a list of shop branches each having its own billing account.
   */
  @JsonProperty("accountRelationship")
  private List<@Valid AccountRelationship> accountRelationships;

  /**
   * A categorization of an account, such as individual, joint, and so forth,
   * whose instances share some of the same characteristics. Note: for flexibility
   * we use a String here but an implementation may use an enumeration with a
   * limited list of valid values.
   */
  private @SafeText String accountType;

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * List of: An individual or an organization used as a contact point for a given
   * account and accessed via some contact medium.
   */
  @JsonProperty("contact")
  private List<@Valid Contact> contacts;

  /**
   * The maximum amount of money that may be charged on an account.
   */
  private @Valid Money creditLimit;

  /**
   * Date of last modification of the account.
   */
  private OffsetDateTime lastModified;

  private @Valid LoyaltyProgramProductRef loyaltyProgramProduct;

  /**
   * Name of the account.
   */
  private @SafeText String name;

  /**
   * Contains the lifecycle state such as: Active, Closed, Suspended and so on.
   */
  private @SafeText String state;

  /**
   * List of: A tax exemption certificate represents a tax exemption granted to a
   * party (individual or organization) by a tax jurisdiction which may be a city,
   * state, country,... An exemption has a certificate identifier (received from
   * the jurisdiction that levied the tax) and a validity period. An exemption is
   * per tax types and determines for each type of tax what portion of the tax is
   * exempted (partial by percentage or complete) via the tax definition.
   */
  @JsonProperty("taxExemption")
  private List<@Valid TaxExemptionCertificate> taxExemptions;
}