package org.opentmf.dnext.tmf667.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.CharacteristicSpecification;
import org.opentmf.dnext.common.model.ConstraintRef;
import org.opentmf.dnext.common.model.EntitySpecificationRelationship;
import org.opentmf.dnext.common.model.SpecificationBase;
import org.opentmf.dnext.common.model.TargetEntitySchema;
import org.opentmf.tmf667.model.IDocumentSpecificationRefOrValue;

/**
 * A DocumentSpecificationRefOrValue where you can select between a
 * DocumentSpecification (by Value) or a DocumentSpecificationRef (by
 * Reference).
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
    defaultImpl = DocumentSpecificationRefOrValue.class
)
public class DocumentSpecificationRefOrValue extends SpecificationBase implements IDocumentSpecificationRefOrValue {

  /**
   * The actual type of the target instance when needed for disambiguation.
   */
  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * This is a list of constraint references applied to this specification.
   */
  @JsonProperty("constraint")
  private List<@Valid ConstraintRef> constraints;

  /**
   * Relationship to another specification.
   */
  @JsonProperty("entitySpecRelationship")
  private List<@Valid EntitySpecificationRelationship> entitySpecRelationships;

  /**
   * List of characteristics that the entity can take.
   */
  @JsonProperty("specCharacteristic")
  private List<@Valid CharacteristicSpecification> specCharacteristics;

  /**
   * The reference object to the schema and type of target entity which is
   * described by a specification.
   */
  private @Valid TargetEntitySchema targetEntitySchema;
}