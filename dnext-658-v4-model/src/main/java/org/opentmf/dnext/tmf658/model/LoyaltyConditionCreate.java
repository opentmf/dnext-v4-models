package org.opentmf.dnext.tmf658.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf658.model.ILoyaltyConditionCreate;

/**
 * The LoyaltyCondition to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> attribute, operator, value<br/>
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
    defaultImpl = LoyaltyConditionCreate.class
)
@Required(fields = {"attribute", "value", "operator"})
public class LoyaltyConditionCreate extends Entity implements ILoyaltyConditionCreate {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * The attribute to evaluate.
   */
  private @SafeText String attribute;

  /**
   * Comparison operator to be used in the evaluation.
   */
  private @SafeText String operator;

  /**
   * The value of the attribute to be evaluated.
   */
  private @SafeText String value;
}