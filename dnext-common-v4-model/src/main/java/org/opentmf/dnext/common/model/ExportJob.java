package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IExportJob;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.commons.validation.constraints.SafeUrl;

/**
 * Represents a task used to export resources to a file.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = ExportJob.class
)
public class ExportJob extends ImportJobCreate implements IExportJob {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private Boolean allowedActiveOrLaunchedState;

  /**
   * Job error details.
   */
  private @Valid ErrorForExportJob error;

  /**
   * Used to add the related data.
   */
  private @SafeText String includeRelatedObjects;

  /**
   * To allow importing only Active and Launched entities.
   */
  private Boolean isAllowedActiveOrLaunchedState;

  /**
   * jobMode.
   */
  private @SafeText String jobMode;

  /**
   * Defines a group of assets (entities) which can be exported.
   */
  private @Valid AssetGroup managedAssetGroup;

  /**
   * name for the export job.
   */
  private @SafeText String name;

  /**
   * Used to scope the exported data.
   */
  @SafeUrl
  @Size(max = 500)
  private String query;

  /**
   * Requester identification details.
   */
  private @Valid Requester requester;
}