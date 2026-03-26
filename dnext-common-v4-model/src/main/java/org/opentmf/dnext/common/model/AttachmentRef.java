package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAttachmentRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Attachment reference. An attachment complements the description of an element
 * (for instance a product) through video, pictures.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = AttachmentRef.class
)
@Required(fields = {"id"})
public class AttachmentRef extends EntityRef implements IAttachmentRef {

  /**
   * A narrative text describing the content of the attachment.
   */
  private @SafeText String description;

  /**
   * Link to the attachment media/content.
   */
  private URI url;
}