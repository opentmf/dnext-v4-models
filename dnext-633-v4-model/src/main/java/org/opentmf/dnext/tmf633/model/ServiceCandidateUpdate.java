package org.opentmf.dnext.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.ServiceSpecificationRef;
import org.opentmf.dnext.service.model.ServiceBase;
import org.opentmf.dnext.service.model.ServiceCategoryRef;
import org.opentmf.tmf633.model.IServiceCandidateUpdate;

/**
 * The ServiceCandidate to be updated.
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
    defaultImpl = ServiceCandidateUpdate.class
)
public class ServiceCandidateUpdate extends ServiceBase implements IServiceCandidateUpdate {

  /**
   * List of categories for this candidate.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * The service specification implied by this candidate.
   */
  private @Valid ServiceSpecificationRef serviceSpecification;
}