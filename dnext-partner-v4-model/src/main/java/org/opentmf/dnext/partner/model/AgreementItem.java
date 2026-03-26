package org.opentmf.dnext.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.ProductOfferingRef;
import org.opentmf.dnext.common.model.ProductRef;
import org.opentmf.partner.model.IAgreementItem;

/**
 * A part of the agreement expressed in terms of a product offering and possibly
 * including specific terms and conditions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementItem.class
)
public class AgreementItem extends Entity implements IAgreementItem {

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * The list of products indirectly referred by this agreement item (since an
   * agreement item refers primarily to product offerings).
   */
  @JsonProperty("product")
  private List<@Valid ProductRef> products;

  /**
   * The list of product offerings referred by this agreement item.
   */
  @JsonProperty("productOffering")
  private List<@Valid ProductOfferingRef> productOfferings;

  /**
   * List of: Aspects of the agreement not formally specified elsewhere in the
   * agreement and that cannot be captured elsewhere in a formal notation, or
   * automatically monitored and require a more human level of management.
   */
  @JsonProperty("termOrCondition")
  private List<@Valid AgreementTermOrCondition> termOrConditions;
}