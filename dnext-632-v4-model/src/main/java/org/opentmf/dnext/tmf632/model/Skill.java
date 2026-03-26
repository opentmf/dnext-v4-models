package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf632.model.ISkill;

/**
 * Skills evaluated for an individual with a level and possibly with a limited
 * validity when an obsolescence is defined (Ex: the first-aid certificate first
 * level is limited to one year and an update training is required each year to
 * keep the level).
 *
 * <p><br/>
 * <strong>Required:</strong> skillCode, skillName<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = Skill.class
)
@Required(fields = {"skillName", "skillCode"})
public class Skill extends Entity implements ISkill {

  /**
   * A free text comment linked to the evaluation done.
   */
  private @SafeText String comment;

  /**
   * Level of expertise in a skill evaluated for an individual.
   */
  private @SafeText String evaluatedLevel;

  /**
   * Code of the skill.
   */
  private @SafeText String skillCode;

  /**
   * Name of the skill such as Java language,….
   */
  private @SafeText String skillName;

  private @Valid TimePeriod validFor;
}