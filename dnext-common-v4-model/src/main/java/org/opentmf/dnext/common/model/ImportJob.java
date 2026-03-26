package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IImportJob;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Represents a task used to import resources from a file.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ImportJob.class
)
public class ImportJob extends ImportJobCreate implements IImportJob {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private Boolean allowedActiveOrLaunchedState;

  /**
   * Identifier for referenced object. If true will continue import if referenced
   * object is in the database.
   */
  private Boolean continueImportIfExists;

  /**
   * Job error details.
   */
  private @Valid ErrorForImportJob error;

  /**
   * To allow importing only Active and Launched entities.
   */
  private Boolean isAllowedActiveOrLaunchedState;

  /**
   * Identifier of the import job type.Either be Single Mode or Hierarchical Mode.
   */
  private @SafeText String jobMode;

  /**
   * name for the import job.
   */
  private @SafeText String name;

  /**
   * Requester identification details.
   */
  private @Valid Requester requester;
}