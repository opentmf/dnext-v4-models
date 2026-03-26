package org.opentmf.dnext.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.ResourceCandidateRef;
import org.opentmf.tmf634.model.IResourceCategoryUpdate;

/**
 * The ResourceCategory to be updated.
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
    defaultImpl = ResourceCategoryUpdate.class
)
public class ResourceCategoryUpdate extends ResourceCatalogUpdate implements IResourceCategoryUpdate {

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * parent category.
   */
  private @Valid ResourceCategoryRef parent;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

  /**
   * List of resource candidates accessible via this category.
   */
  @JsonProperty("resourceCandidate")
  private List<@Valid ResourceCandidateRef> resourceCandidates;
}