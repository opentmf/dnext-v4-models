package org.opentmf.dnext.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.Quantity;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TimePeriod;

/**
 * The Attachment to be updated.
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
    defaultImpl = AttachmentUpdate.class
)
public class AttachmentUpdate extends Extensible {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * Attachment type such as video, picture.
   */
  private @SafeText String attachmentType;

  /**
   * Reference to the category. A set of classifications for the attachment types.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * Description of the attachment.
   */
  private @SafeText String description;

  /**
   * External reference of the shopping cart or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * The mimeType of the attachment.
   */
  private @SafeText String mimeType;

  /**
   * Name of the attachment.
   */
  private @SafeText String name;

  /**
   * The size in Bytes of the document or attachment. If this component
   * <br/>contains the embedded data then the size is the size of the embedded
   * data; if
   * <br/>it is a reference without the data then it is the size of the referenced
   * document.
   */
  private @Valid Quantity size;

  /**
   * The URL of the attachment.
   */
  private URI url;

  /**
   * The period for which the Attachment is valid.
   */
  private @Valid TimePeriod validFor;
}