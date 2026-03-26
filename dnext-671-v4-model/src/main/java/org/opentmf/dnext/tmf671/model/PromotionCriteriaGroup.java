package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.tmf671.model.IPromotionCriteriaGroup;

/**
 * Set of group criteria to promotion. Fulfilling these criteria, parties will
 * receice benefits.
 *
 * <p><br/>
 * <strong>Required:</strong> criteria<br/>
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
    defaultImpl = PromotionCriteriaGroup.class
)
@Required(fields = {"criteria"})
public class PromotionCriteriaGroup extends Entity implements IPromotionCriteriaGroup {

  /**
   * List of: Set of criteria to be followed by all parties.
   */
  @JsonProperty("criteria")
  private List<@Valid PromotionCriteria> criterias;

  /**
   * Logical relation followed by all criteria.
   */
  private @SafeText String criteriaLogicalRelationship;

  /**
   * Name of the group to be easily identified.
   */
  private @SafeText String groupName;
}