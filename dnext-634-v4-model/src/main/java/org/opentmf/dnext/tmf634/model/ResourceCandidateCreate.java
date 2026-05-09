package org.opentmf.dnext.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ResourceSpecificationRef;
import org.opentmf.dnext.resource.model.ResourceBase;
import org.opentmf.tmf634.model.IResourceCandidateCreate;

/**
 * The ResourceCandidate to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> id, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ResourceCandidateCreate.class
)
@Required(fields = {"name", "id"})
public class ResourceCandidateCreate extends ResourceBase implements IResourceCandidateCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * The categories in which this candidate is exposed.
   */
  @JsonProperty("category")
  private List<@Valid ResourceCategoryRef> categories;

  /**
   * The detailed specification for this candidate.
   */
  private @Valid ResourceSpecificationRef resourceSpecification;
}