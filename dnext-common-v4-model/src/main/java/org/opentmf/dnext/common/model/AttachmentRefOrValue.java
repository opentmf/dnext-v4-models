package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAttachmentRefOrValue;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * An attachment by value or by reference. An attachment complements the
 * description of an element, for example through a document, a video, a
 * picture.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-629: Customer Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-663: Shopping Cart Management API</li>
 *   <li>TMF-666: Account Management API</li>
 *   <li>TMF-667: Document Management API</li>
 *   <li>TMF-668: Partnership Type</li>
 *   <li>TMF-669: Party Role Management API</li>
 *   <li>TMF-670: Payment Method Management API</li>
 *   <li>TMF-671: Promotion Management API</li>
 *   <li>TMF-683: Party Interaction Management API</li>
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
    defaultImpl = AttachmentRefOrValue.class
)
@JsonTypeName("Attachment")
@Required(fields = {"id"})
public class AttachmentRefOrValue extends AttachmentRef implements IAttachmentRefOrValue {

  /**
   * Attachment type such as video, picture.
   */
  private @SafeText String attachmentType;

  /**
   * List of service/resourse categories associated with this catalog.
   */
  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * The content of the attachment.
   */
  private @SafeText String content;

  private Boolean isRef;

  /**
   * Attachment mime type such as extension file for video, picture and document.
   */
  private @SafeText String mimeType;

  /**
   * The size of the attachment.
   */
  private @Valid Quantity size;

  /**
   * The period of time for which the attachment is valid.
   */
  private @Valid TimePeriod validFor;

  /**
   * The version of the attachment.
   */
  private @SafeText String version;
}