package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * InflightOrderChange is a request to submit an Inflight Order Change request
 * that includes the updated productOrder.
 *
 * <p><br/>
 * <strong>Required:</strong> changedProductOrder<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-622: Product Ordering Management API</li>
 *   <li>TMF-641: Service Ordering Management API</li>
 *   <li>TMF-652: Resource Order Management API</li>
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
    defaultImpl = InflightOrderChange.class
)
@Required(fields = {"changedProductOrder"})
public class InflightOrderChange extends Entity {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private Integer revision;

  /**
   * Possible values for the status of the inflight order change.
   */
  private @SafeText String state;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;
}