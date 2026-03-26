package org.opentmf.dnext.tmf681.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The CommunicationMessageTemplate to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> category, content, name, state<br/>
 * </p>
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
    defaultImpl = CommunicationMessageTemplateCreate.class
)
@Required(fields = {"name", "state", "category", "content"})
public class CommunicationMessageTemplateCreate extends CommunicationMessageTemplateUpdate {

  /**
   * Unique identifier of Entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}