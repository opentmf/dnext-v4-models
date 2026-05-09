package org.opentmf.dnext.tmf671.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.tmf671.model.IPromotionCriteria;

/**
 * Set of criteria to be followed by all parties.
 *
 * <p><br/>
 * <strong>Required:</strong> criteriaOperator, criteriaParameter, criteriaValue<br/>
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
    defaultImpl = PromotionCriteria.class
)
@Required(fields = {"criteriaOperator", "criteriaParameter", "criteriaValue"})
public class PromotionCriteria extends Extensible implements IPromotionCriteria {

  /**
   * Logic operator of this criteria instruction: '=' or '>' or '<' or '>=' or
   * '<=' or '<>'.
   */
  private @SafeText String criteriaOperator;

  /**
   * The parameter (factor) of the criteria.The basic factors are abstracted from
   * these data sources.There are several detail parameters.
   */
  private @SafeText String criteriaParameter;

  /**
   * The value is filled for the comparison of the criteria.
   */
  private @SafeText String criteriaValue;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}