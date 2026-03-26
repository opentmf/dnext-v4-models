package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf671.model.IPromotionPattern;

/**
 * Contains the conditions and benefits of the promotion toan eligible party.
 *
 * <p><br/>
 * <strong>Required:</strong> action, criteriaGroup<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-671: Promotion Management API</li>
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
    defaultImpl = PromotionPattern.class
)
@Required(fields = {"criteriaGroup", "action"})
public class PromotionPattern extends NamedEntity implements IPromotionPattern {

  /**
   * List of: Action of the promotion. When the customer meets the conditions in
   * the promotion pattern, the customer can be given the benefits in the action.
   */
  @JsonProperty("action")
  private List<@Valid PromotionAction> actions;

  /**
   * List of: Set of group criteria to promotion. Fulfilling these criteria,
   * parties will receice benefits.
   */
  @JsonProperty("criteriaGroup")
  private List<@Valid PromotionCriteriaGroup> criteriaGroups;

  /**
   * Logical relation followed by the criteria group.
   */
  private @SafeText String criteriaGroupLogicalRelationship;

  /**
   * Small description to clarify the pattern details.
   */
  private @SafeText String description;

  /**
   * Priority. Smaller number means high.
   */
  private Integer priority;

  /**
   * The period for which the promotion pattern is valid.
   */
  private @Valid TimePeriod validFor;
}