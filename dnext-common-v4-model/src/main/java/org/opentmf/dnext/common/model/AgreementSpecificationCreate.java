package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IAgreementSpecificationCreate;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The AgreementSpecification to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> attachment, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementSpecificationCreate.class
)
@Required(fields = {"attachment", "name"})
public class AgreementSpecificationCreate extends SpecificationBase implements IAgreementSpecificationCreate {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Status reason for above status.
   */
  private @SafeText String lifecycleStatusReason;

  private @Valid CategoryRef serviceCategory;

  /**
   * List of: A characteristic quality or distinctive feature of an agreement.
   */
  @JsonProperty("specificationCharacteristic")
  private List<@Valid AgreementSpecCharacteristic> specificationCharacteristics;

  /**
   * List of: A relationship between agreement specifications. Typical
   * relationships are substitution and dependency.
   */
  @JsonProperty("specificationRelationship")
  private List<@Valid AgreementSpecificationRelationship> specificationRelationships;
}