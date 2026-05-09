package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AgreementItemRef;
import org.opentmf.dnext.common.model.BillingAccountRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.LoyaltyAccountRef;
import org.opentmf.dnext.common.model.LoyaltyProgramProductSpecRef;
import org.opentmf.dnext.common.model.ProductBase;
import org.opentmf.dnext.common.model.ProductRefOrValue;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.RelatedPlaceRefOrValue;
import org.opentmf.dnext.common.model.RelatedProductOrderItem;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf658.model.ILoyaltyProgramProductCreate;

/**
 * The LoyaltyProgramProduct to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> loyaltyAccount, loyaltyProgramMember, loyaltyProgramProductSpec, name, validFor<br/>
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
    defaultImpl = LoyaltyProgramProductCreate.class
)
@Required(fields = {"loyaltyProgramProductSpec", "validFor", "loyaltyProgramMember", "name", "loyaltyAccount"})
public class LoyaltyProgramProductCreate extends ProductBase implements ILoyaltyProgramProductCreate {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * List of: Agreement reference. An agreement represents a contract or
   * arrangement, either written or verbal and sometimes enforceable by law, such
   * as a service level agreement or a customer price agreement. An agreement
   * involves a number of other business entities, such as products, services, and
   * resources and/or their specifications.
   */
  @JsonProperty("agreement")
  private List<@Valid AgreementItemRef> agreements;

  /**
   * BillingAccount reference. A BillingAccount is a detailed description of a
   * bill structure.
   */
  private @Valid BillingAccountRef billingAccount;

  /**
   * Name value pairs of product characteristics.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  private Boolean customerVisible;

  /**
   * Reference to a loyalty account.
   */
  private @Valid LoyaltyAccountRef loyaltyAccount;

  /**
   * The member that has authorised the is earning the loyalty currency.
   */
  private @Valid LoyaltyProgramMember loyaltyProgramMember;

  private @Valid LoyaltyProgramProductSpecRef loyaltyProgramProductSpec;

  /**
   * List of: Related Entity reference. A related place defines a place described
   * by reference or by value linked to a specific entity. The polymorphic
   * attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to the place
   * entity and not the RelatedPlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid RelatedPlaceRefOrValue> places;

  /**
   * List of: A product to be created defined by value or existing defined by
   * reference. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType
   * are related to the product entity and not the RelatedProductRefOrValue class
   * itself.
   */
  @JsonProperty("product")
  private List<@Valid ProductRefOrValue> products;

  /**
   * List of: RelatedProductOrderItem (ProductOrder item) .The product order item
   * which triggered product creation/change/termination.
   */
  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  /**
   * The condition of the product, such as planned, designed, activated,
   * disconnected.
   */
  private @SafeText String productStatus;

  private @Valid TimePeriod validFor;
}