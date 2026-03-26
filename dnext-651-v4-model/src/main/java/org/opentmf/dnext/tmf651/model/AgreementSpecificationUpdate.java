package org.opentmf.dnext.tmf651.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AgreementSpecCharacteristic;
import org.opentmf.dnext.common.model.AgreementSpecificationRelationship;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.CategoryRef;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.partner.model.AgreementTermOrCondition;
import org.opentmf.tmf651.model.IAgreementSpecificationUpdate;

/**
 * The AgreementSpecification to be updated.
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
    defaultImpl = AgreementSpecificationUpdate.class
)
public class AgreementSpecificationUpdate extends AgreementTermOrCondition implements IAgreementSpecificationUpdate {

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
   * If true, this agreement specification is a grouping of other agreement
   * specifications. The list of bundled agreement specifications is provided by
   * the specificationRelationship property.
   */
  private Boolean isBundle;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Indicates the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Status reason for above status.
   */
  private @SafeText String lifecycleStatusReason;

  /**
   * Name of the agreement specification.
   */
  private @SafeText String name;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

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

  private @SafeText String version;
}