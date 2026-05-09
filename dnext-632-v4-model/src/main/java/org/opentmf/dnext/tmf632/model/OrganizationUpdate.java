package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.dnext.partner.model.IndividualCreateBase;
import org.opentmf.tmf632.model.IOrganizationUpdate;

/**
 * The Organization to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
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
    defaultImpl = OrganizationUpdate.class
)
public class OrganizationUpdate extends IndividualCreateBase implements IOrganizationUpdate {

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

  private @Valid TimePeriod existsDuring;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Industry information for related entity.
   */
  private @SafeText String industry;

  /**
   * If value is true, the organization is the head office.
   */
  private Boolean isHeadOffice;

  /**
   * If value is true, the organization is a legal entity known by a national
   * referential.
   */
  private Boolean isLegalEntity;

  /**
   * Organization name (department name for example).
   */
  private @SafeText String name;

  /**
   * Type of the name : Co, Inc, Ltd,….
   */
  private @SafeText String nameType;

  /**
   * List of: Child references of an organization in a structure of organizations.
   */
  @JsonProperty("organizationChildRelationship")
  private List<@Valid OrganizationChildRelationship> organizationChildRelationships;

  /**
   * List of: Represents our registration of information used as proof of identity
   * by an organization.
   */
  @JsonProperty("organizationIdentification")
  private List<@Valid OrganizationIdentification> organizationIdentifications;

  /**
   * Parent references of an organization in a structure of organizations.
   */
  private @Valid OrganizationParentRelationship organizationParentRelationship;

  /**
   * Type of Organization (company, department...).
   */
  private @SafeText String organizationType;

  /**
   * List of: Keeps track of other names, for example the old name of an
   * organization.
   */
  @JsonProperty("otherName")
  private List<@Valid OtherNameOrganization> otherNames;

  /**
   * Name that the organization (unit) trades under.
   */
  private @SafeText String tradingName;
}