package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Synthesized abstract parent for 153 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AgreementCreateEvent (651)</li>
 *   <li>AgreementDeleteEvent (651)</li>
 *   <li>AgreementSpecificationCreateEvent (651)</li>
 *   <li>AgreementSpecificationDeleteEvent (651)</li>
 *   <li>AgreementSpecificationStateChangeEvent (651)</li>
 *   <li>AgreementStateChangeEvent (651)</li>
 *   <li>BillingAccountStateChangeEvent (666)</li>
 *   <li>CancelProductOrderCreateEvent (622)</li>
 *   <li>CancelProductOrderStateChangeEvent (622)</li>
 *   <li>CancelResourceOrderCreateEvent (652)</li>
 *   <li>CancelResourceOrderStateChangeEvent (652)</li>
 *   <li>CancelServiceOrderCreateEvent (641)</li>
 *   <li>CancelServiceOrderStateChangeEvent (641)</li>
 *   <li>CatalogBatchEvent (620)</li>
 *   <li>CatalogCreateEvent (620)</li>
 *   <li>CatalogDeleteEvent (620)</li>
 *   <li>CatalogStateChangeEvent (620)</li>
 *   <li>CategoryCreateEvent (620)</li>
 *   <li>CategoryDeleteEvent (620)</li>
 *   <li>CategoryStateChangeEvent (620)</li>
 *   <li>CustomerCreateEvent (629)</li>
 *   <li>CustomerDeleteEvent (629)</li>
 *   <li>CustomerStateChangeEvent (629)</li>
 *   <li>DocumentBatchEvent (667)</li>
 *   <li>DocumentChangeEvent (667)</li>
 *   <li>DocumentCreateEvent (667)</li>
 *   <li>DocumentDeleteEvent (667)</li>
 *   <li>DocumentSpecificationCreateEvent (667)</li>
 *   <li>DocumentSpecificationDeleteEvent (667)</li>
 *   <li>ExportJobCreateEvent (634)</li>
 *   <li>ExportJobStateChangeEvent (634)</li>
 *   <li>FinancialAccountCreateEvent (666)</li>
 *   <li>FinancialAccountDeleteEvent (666)</li>
 *   <li>FinancialAccountStateChangeEvent (666)</li>
 *   <li>GeographicAddressValidationStateChangeEvent (673)</li>
 *   <li>ImportJobCreateEvent (634)</li>
 *   <li>ImportJobStateChangeEvent (634)</li>
 *   <li>IndividualCreateEvent (632)</li>
 *   <li>IndividualDeleteEvent (632)</li>
 *   <li>IndividualStateChangeEvent (632)</li>
 *   <li>LoyaltyActionCreateEvent (658)</li>
 *   <li>LoyaltyActionDeleteEvent (658)</li>
 *   <li>LoyaltyActionUpdateEvent (658)</li>
 *   <li>LoyaltyConditionCreateEvent (658)</li>
 *   <li>LoyaltyConditionDeleteEvent (658)</li>
 *   <li>LoyaltyConditionUpdateEvent (658)</li>
 *   <li>LoyaltyEventTypeCreateEvent (658)</li>
 *   <li>LoyaltyEventTypeDeleteEvent (658)</li>
 *   <li>LoyaltyEventTypeUpdateEvent (658)</li>
 *   <li>LoyaltyProgramMemberCreateEvent (658)</li>
 *   <li>LoyaltyProgramMemberDeleteEvent (658)</li>
 *   <li>LoyaltyProgramMemberUpdateEvent (658)</li>
 *   <li>LoyaltyProgramPartnerCreateEvent (658)</li>
 *   <li>LoyaltyProgramPartnerDeleteEvent (658)</li>
 *   <li>LoyaltyProgramPartnerUpdateEvent (658)</li>
 *   <li>LoyaltyProgramProductCreateEvent (658)</li>
 *   <li>LoyaltyProgramProductDeleteEvent (658)</li>
 *   <li>LoyaltyProgramProductSpecCreateEvent (658)</li>
 *   <li>LoyaltyProgramProductSpecDeleteEvent (658)</li>
 *   <li>LoyaltyProgramProductSpecUpdateEvent (658)</li>
 *   <li>LoyaltyProgramProductUpdateEvent (658)</li>
 *   <li>LoyaltyRuleCreateEvent (658)</li>
 *   <li>LoyaltyRuleDeleteEvent (658)</li>
 *   <li>LoyaltyRuleUpdateEvent (658)</li>
 *   <li>OrganizationCreateEvent (632)</li>
 *   <li>OrganizationDeleteEvent (632)</li>
 *   <li>OrganizationStateChangeEvent (632)</li>
 *   <li>PartnershipChangeEvent (668)</li>
 *   <li>PartnershipCreateEvent (668)</li>
 *   <li>PartnershipDeleteEvent (668)</li>
 *   <li>PartnershipSpecificationChangeEvent (668)</li>
 *   <li>PartnershipSpecificationCreateEvent (668)</li>
 *   <li>PartnershipSpecificationDeleteEvent (668)</li>
 *   <li>PartyAccountStateChangeEvent (666)</li>
 *   <li>PartyInteractionCreateEvent (683)</li>
 *   <li>PartyInteractionDeleteEvent (683)</li>
 *   <li>PartyInteractionStatusChangeEvent (683)</li>
 *   <li>PartyRoleCreateEvent (669)</li>
 *   <li>PartyRoleDeleteEvent (669)</li>
 *   <li>PartyRoleStateChangeEvent (669)</li>
 *   <li>PaymentCreateEvent (676)</li>
 *   <li>PaymentDeleteEvent (676)</li>
 *   <li>PaymentMethodCreateEvent (670)</li>
 *   <li>PaymentMethodDeleteEvent (670)</li>
 *   <li>PaymentMethodStatusChangeEvent (670)</li>
 *   <li>PaymentStateChangeEvent (676)</li>
 *   <li>ProductBatchEvent (637)</li>
 *   <li>ProductCreateEvent (637)</li>
 *   <li>ProductDeleteEvent (637)</li>
 *   <li>ProductOfferingCreateEvent (620)</li>
 *   <li>ProductOfferingDeleteEvent (620)</li>
 *   <li>ProductOfferingPriceCreateEvent (620)</li>
 *   <li>ProductOfferingPriceDeleteEvent (620)</li>
 *   <li>ProductOfferingPriceStateChangeEvent (620)</li>
 *   <li>ProductOfferingStateChangeEvent (620)</li>
 *   <li>ProductOrderCreateEvent (622)</li>
 *   <li>ProductOrderDeleteEvent (622)</li>
 *   <li>ProductOrderStateChangeEvent (622)</li>
 *   <li>ProductSpecificationCreateEvent (620)</li>
 *   <li>ProductSpecificationDeleteEvent (620)</li>
 *   <li>ProductSpecificationStateChangeEvent (620)</li>
 *   <li>ProductStateChangeEvent (637)</li>
 *   <li>PromotionCreateEvent (671)</li>
 *   <li>PromotionDeleteEvent (671)</li>
 *   <li>PromotionStateChangeEvent (671)</li>
 *   <li>QuoteCreateEvent (648)</li>
 *   <li>QuoteDeleteEvent (648)</li>
 *   <li>QuoteStateChangeEvent (648)</li>
 *   <li>RefundCreateEvent (676)</li>
 *   <li>RefundDeleteEvent (676)</li>
 *   <li>RefundStateChangeEvent (676)</li>
 *   <li>ResourceCandidateChangeEvent (634)</li>
 *   <li>ResourceCandidateCreateEvent (634)</li>
 *   <li>ResourceCandidateDeleteEvent (634)</li>
 *   <li>ResourceCatalogChangeEvent (634)</li>
 *   <li>ResourceCatalogCreateEvent (634)</li>
 *   <li>ResourceCatalogDeleteEvent (634)</li>
 *   <li>ResourceCategoryChangeEvent (634)</li>
 *   <li>ResourceCategoryCreateEvent (634)</li>
 *   <li>ResourceCategoryDeleteEvent (634)</li>
 *   <li>ResourceCreateEvent (639)</li>
 *   <li>ResourceDeleteEvent (639)</li>
 *   <li>ResourceOrderCreateEvent (652)</li>
 *   <li>ResourceOrderDeleteEvent (652)</li>
 *   <li>ResourceOrderStateChangeEvent (652)</li>
 *   <li>ResourceSpecificationChangeEvent (634)</li>
 *   <li>ResourceSpecificationCreateEvent (634)</li>
 *   <li>ResourceSpecificationDeleteEvent (634)</li>
 *   <li>ResourceStateChangeEvent (639)</li>
 *   <li>ServiceCandidateChangeEvent (633)</li>
 *   <li>ServiceCandidateCreateEvent (633)</li>
 *   <li>ServiceCandidateDeleteEvent (633)</li>
 *   <li>ServiceCatalogBatchEvent (633)</li>
 *   <li>ServiceCatalogChangeEvent (633)</li>
 *   <li>ServiceCatalogCreateEvent (633)</li>
 *   <li>ServiceCatalogDeleteEvent (633)</li>
 *   <li>ServiceCategoryChangeEvent (633)</li>
 *   <li>ServiceCategoryCreateEvent (633)</li>
 *   <li>ServiceCategoryDeleteEvent (633)</li>
 *   <li>ServiceCreateEvent (638)</li>
 *   <li>ServiceDeleteEvent (638)</li>
 *   <li>ServiceOrderCreateEvent (641)</li>
 *   <li>ServiceOrderDeleteEvent (641)</li>
 *   <li>ServiceOrderJeopardyEvent (641)</li>
 *   <li>ServiceOrderMilestoneEvent (641)</li>
 *   <li>ServiceOrderStateChangeEvent (641)</li>
 *   <li>ServiceSpecificationChangeEvent (633)</li>
 *   <li>ServiceSpecificationCreateEvent (633)</li>
 *   <li>ServiceSpecificationDeleteEvent (633)</li>
 *   <li>ServiceStateChangeEvent (638)</li>
 *   <li>SettlementAccountStateChangeEvent (666)</li>
 *   <li>ShoppingCartCreateEvent (663)</li>
 *   <li>ShoppingCartDeleteEvent (663)</li>
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
    defaultImpl = QuoteCreateEventBase.class
)
public abstract class QuoteCreateEventBase extends EventBase {

  /**
   * List of: Access policy constraint data.
   */
  @JsonProperty("accessPolicyConstraint")
  private List<@Valid AccessPolicyConstraintData> accessPolicyConstraints;

  /**
   * Authentication context of the event.
   */
  private @Valid Auth auth;

  /**
   * The name of the object related to the event.
   */
  private @SafeText String objectName;

  /**
   * The IP address of the origin of the event.
   */
  private @SafeText String originIp;

  /**
   * The time the event occurred.
   */
  private OffsetDateTime timeOccurred;

  /**
   * Trace context of the event.
   */
  private @Valid Trace trace;
}