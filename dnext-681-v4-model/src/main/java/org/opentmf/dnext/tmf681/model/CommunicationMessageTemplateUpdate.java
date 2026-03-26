package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 * The CommunicationMessage to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-681: Communication Management API</li>
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
    defaultImpl = CommunicationMessageTemplateUpdate.class
)
public class CommunicationMessageTemplateUpdate extends Extensible {

  /**
   * DNext Access-Control RelatedParty List like ownership etc.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * category of the entity.
   */
  private @SafeText String category;

  /**
   * The actual contents of the template object.
   */
  private @SafeText String content;

  /**
   * A narrative text describing Communication Message Template.
   */
  private @SafeText String description;

  /**
   * The name of the Communication Message Template.
   */
  private @SafeText String name;

  /**
   * State values for CommunicationMessageSpecification
   * <br/><p>Recommended values: working, active, inactive.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageSpecificationStateType
   */
  private @SafeText String state;

  /**
   * subcategory of the entity.
   */
  private @SafeText String subcategory;

  /**
   * The name of the Communication Template Engine. content must be compatible
   * with the templateEngine
   * <br/><p>Recommended values: thymeleaf.
   *
   * @see org.opentmf.dnext.tmf681.model.CommunicationMessageTemplateTemplateEngineType
   */
  private @SafeText String templateEngine;
}