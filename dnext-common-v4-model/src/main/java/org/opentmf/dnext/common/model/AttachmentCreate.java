package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The Attachment to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> attachmentType, mimeType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = AttachmentCreate.class
)
@Required(fields = {"attachmentType", "mimeType"})
public class AttachmentCreate extends AttachmentUpdate {

  /**
   * Unique identifier for this particular attachment.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}