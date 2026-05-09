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
 * Synthesized abstract parent for 36 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>AgreementAttributeValueChangeEvent (651)</li>
 *   <li>AgreementSpecificationAttributeValueChangeEvent (651)</li>
 *   <li>BillingAccountAttributeValueChangeEvent (666)</li>
 *   <li>CancelProductOrderInformationRequiredEvent (622)</li>
 *   <li>CancelResourceOrderInformationRequiredEvent (652)</li>
 *   <li>CancelServiceOrderInformationRequiredEvent (641)</li>
 *   <li>CatalogAttributeValueChangeEvent (620)</li>
 *   <li>CategoryAttributeValueChangeEvent (620)</li>
 *   <li>CustomerAttributeValueChangeEvent (629)</li>
 *   <li>DocumentSpecificationAttributeValueChangeEvent (667)</li>
 *   <li>FinancialAccountAttributeValueChangeEvent (666)</li>
 *   <li>IndividualAttributeValueChangeEvent (632)</li>
 *   <li>OrganizationAttributeValueChangeEvent (632)</li>
 *   <li>PartyAccountAttributeValueChangeEvent (666)</li>
 *   <li>PartyInteractionAttributeValueChangeEvent (683)</li>
 *   <li>PartyRoleAttributeValueChangeEvent (669)</li>
 *   <li>PaymentAttributeValueChangeEvent (676)</li>
 *   <li>PaymentMethodAttributeValueChangeEvent (670)</li>
 *   <li>ProductAttributeValueChangeEvent (637)</li>
 *   <li>ProductOfferingAttributeValueChangeEvent (620)</li>
 *   <li>ProductOfferingPriceAttributeValueChangeEvent (620)</li>
 *   <li>ProductOrderAttributeValueChangeEvent (622)</li>
 *   <li>ProductOrderInformationRequiredEvent (622)</li>
 *   <li>ProductSpecificationAttributeValueChangeEvent (620)</li>
 *   <li>PromotionAttributeValueChangeEvent (671)</li>
 *   <li>QuoteAttributeValueChangeEvent (648)</li>
 *   <li>QuoteInformationRequiredEvent (648)</li>
 *   <li>RefundAttributeValueChangeEvent (676)</li>
 *   <li>ResourceAttributeValueChangeEvent (639)</li>
 *   <li>ResourceOrderAttributeValueChangeEvent (652)</li>
 *   <li>ResourceOrderInformationRequiredEvent (652)</li>
 *   <li>ServiceAttributeValueChangeEvent (638)</li>
 *   <li>ServiceOrderAttributeValueChangeEvent (641)</li>
 *   <li>ServiceOrderInformationRequiredEvent (641)</li>
 *   <li>SettlementAccountAttributeValueChangeEvent (666)</li>
 *   <li>ShoppingCartAttributeValueChangeEvent (663)</li>
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
    defaultImpl = QuoteInformationRequiredEventBase.class
)
public abstract class QuoteInformationRequiredEventBase extends AttributeValueChangeEventBase {

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