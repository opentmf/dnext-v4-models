package org.opentmf.dnext.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.ExternalIdentifier;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.RelatedEntity;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.tmf667.model.IDocumentCreate;

/**
 * The Document to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = DocumentCreate.class
)
@Required(fields = {"name"})
public class DocumentCreate extends NamedEntity implements IDocumentCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("binaryAttachment")
  private List<@Valid AttachmentRefOrValue> binaryAttachments;

  @JsonProperty("category")
  private List<@Valid CategoryRef> categories;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("characteristic")
  private List<@Valid Characteristic> characteristics;

  /**
   * The date and time the document was created.
   */
  private OffsetDateTime creationDate;

  /**
   * free-text description of the document.
   */
  private @SafeText String description;

  @JsonProperty("document")
  private List<@Valid DocumentRef> documents;

  @JsonProperty("documentRelationship")
  private List<@Valid DocumentRef> documentRelationships;

  /**
   * A DocumentSpecificationRefOrValue where you can select between a
   * DocumentSpecification (by Value) or a DocumentSpecificationRef (by
   * Reference).
   */
  private @Valid DocumentSpecificationRefOrValue documentSpecification;

  /**
   * Name of the document type.
   */
  private @SafeText String documentType;

  /**
   * List of: An identification of an entity that is owned by or originates in a
   * software system different from the current system.
   */
  @JsonProperty("externalIdentifier")
  private List<@Valid ExternalIdentifier> externalIdentifiers;

  /**
   * External reference of the shopping cart or reference in other system.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * The date and time the document was last modified.
   */
  private OffsetDateTime lastUpdate;

  /**
   * The life cycle state of the document.
   */
  private @SafeText String lifecycleState;

  /**
   * List of: A reference to an entity, where the type of the entity is not known
   * in advance.
   */
  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntity> relatedEntities;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * Possible values for the status of a Document.
   */
  private @SafeText String status;

  /**
   * A particular form or variety of an artefact that is different from others or
   * from the original. The form represents differences in properties that
   * characterize an artefact, that are not enough to warrant creating a new
   * artefact.
   */
  private @SafeText String version;
}