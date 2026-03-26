package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAttachment;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-667: Document Management API</li>
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
    defaultImpl = Attachment.class
)
@Required(fields = {"id"})
public class Attachment extends NamedEntity implements IAttachment {

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
   * The actual contents of the attachment object, if embedded, encoded as base64.
   */
  private @SafeText String content;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * A narrative text describing the content of the attachment.
   */
  private @SafeText String description;

  /**
   * External reference of the shopping cart or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Attachment mime type such as extension file for video, picture and document.
   */
  private @SafeText String mimeType;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * The size of the attachment.
   */
  private @Valid Quantity size;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;

  /**
   * Uniform Resource Locator, is a web page address (a subset of URI).
   */
  private URI url;

  /**
   * The period of time for which the attachment is valid.
   */
  private @Valid TimePeriod validFor;
}