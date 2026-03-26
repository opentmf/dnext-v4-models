package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.AgreementRef;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.CustomerUpdateBase;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The LoyaltyProgramPartner to be created.
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
    defaultImpl = LoyaltyProgramPartnerCreate.class
)
@Required(fields = {"name", "engagedParty"})
public class LoyaltyProgramPartnerCreate extends CustomerUpdateBase {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  @JsonProperty("agreement")
  private List<@Valid AgreementRef> agreements;

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
}