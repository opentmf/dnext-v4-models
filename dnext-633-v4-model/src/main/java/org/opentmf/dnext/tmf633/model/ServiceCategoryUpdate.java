package org.opentmf.dnext.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.ServiceBase;
import org.opentmf.dnext.common.model.ServiceCandidateRef;
import org.opentmf.dnext.service.model.ServiceCategoryRef;
import org.opentmf.tmf633.model.IServiceCategoryUpdate;

/**
 * The ServiceCategory to be updated.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceCategoryUpdate.class
)
public class ServiceCategoryUpdate extends ServiceBase implements IServiceCategoryUpdate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  /**
   * List of child categories in the tree for in this category.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * Version of the parent category.
   */
  private @Valid ServiceCategoryRef parent;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

  /**
   * List of service candidates associated with this category.
   */
  @JsonProperty("serviceCandidate")
  private List<@Valid ServiceCandidateRef> serviceCandidates;
}