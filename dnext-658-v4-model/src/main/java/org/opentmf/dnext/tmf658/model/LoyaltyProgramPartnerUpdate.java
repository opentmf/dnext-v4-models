package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.AccountRef;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.CustomerBase;
import org.opentmf.dnext.common.model.PaymentMethodRef;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf658.model.ILoyaltyProgramPartnerUpdate;

/**
 * The LoyaltyProgramPartner to be updated.
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty, name<br/>
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
    defaultImpl = LoyaltyProgramPartnerUpdate.class
)
@Required(fields = {"name", "engagedParty"})
public class LoyaltyProgramPartnerUpdate extends CustomerBase implements ILoyaltyProgramPartnerUpdate {

  /**
   * List of: Account reference. An account may be a party account or a financial
   * account.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * The reference to the party engaged in this partnership.
   */
  private @Valid RelatedParty engagedParty;

  /**
   * The partner catalog category reference maps to a category containing the
   * partner product offerings.
   */
  @JsonProperty("partnerCatalog")
  private List<@Valid CategoryRef> partnerCatalogs;

  /**
   * List of: PaymentMethod reference. A payment method defines a specific mean of
   * payment (e.g. direct debit).
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;
}