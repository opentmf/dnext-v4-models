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
import org.opentmf.dnext.common.model.LoyaltyEarnCreateBase;
import org.opentmf.dnext.common.model.LoyaltyProgramMemberRef;
import org.opentmf.dnext.common.model.LoyaltyProgramProductRef;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.UsageSpecificationRef;
import org.opentmf.dnext.product.model.RatedProductUsage;
import org.opentmf.dnext.product.model.UsageCharacteristic;
import org.opentmf.tmf658.model.ILoyaltyEarnCreate;

/**
 * The LoyaltyEarn to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> description, loyaltyProgramMember, loyaltyProgramProduct, quantity<br/>
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
    defaultImpl = LoyaltyEarnCreate.class
)
@Required(fields = {"quantity", "loyaltyProgramProduct", "loyaltyProgramMember", "description"})
public class LoyaltyEarnCreate extends LoyaltyEarnCreateBase implements ILoyaltyEarnCreate {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Reference to the loyalty program member earning the loyalty currency.
   */
  private @Valid LoyaltyProgramMemberRef loyaltyProgramMember;

  /**
   * Reference to the loyalty program product to which the member is enrolled and
   * from which the loyalty earnings originate.
   */
  private @Valid LoyaltyProgramProductRef loyaltyProgramProduct;

  /**
   * The virtual currency or points earnings for this earn event.
   */
  private @Valid Money quantity;

  /**
   * List of: An occurrence of employing a product for its intended purpose with
   * all rating details.
   */
  @JsonProperty("ratedProductUsage")
  private List<@Valid RatedProductUsage> ratedProductUsages;

  /**
   * Status values for LoyaltyBurn
   * <br/><p>Recommended values: received, rejected, recycled, guided, rated,
   * rerated, billed.
   *
   * @see org.opentmf.dnext.tmf658.model.LoyaltyBurnStatusType
   */
  private @SafeText String status;

  /**
   * List of: Provides the value of a given characteristic.
   */
  @JsonProperty("usageCharacteristic")
  private List<@Valid UsageCharacteristic> usageCharacteristics;

  /**
   * Date of usage.
   */
  private OffsetDateTime usageDate;

  /**
   * UsageSpecification reference. UsageSpecification is a detailed description of
   * a usage event that are of interest to the business and can have charges
   * applied to it. It is comprised of characteristics, which define all
   * attributes known for a particular type of usage.
   */
  private @Valid UsageSpecificationRef usageSpecification;

  /**
   * Type of usage.
   */
  private @SafeText String usageType;
}