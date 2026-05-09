package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IImportJobCreate;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * The ImportJob to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> url<br/>
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
    defaultImpl = ImportJobCreate.class
)
@Required(fields = {"url"})
public class ImportJobCreate extends Extensible implements IImportJobCreate {

  /**
   * Date at which the job was completed.
   */
  private OffsetDateTime completionDate;

  /**
   * Indicates the format of the imported data.
   */
  private @SafeText String contentType;

  /**
   * Date at which the job was created.
   */
  private OffsetDateTime creationDate;

  /**
   * Reason for failure if status is failed.
   */
  private @SafeText String errorLog;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * URL of the root resource where the content of the file specified by the
   * import job must be applied.
   */
  private @SafeText String path;

  /**
   * Status of the import job (not started, running, succeeded, failed).
   */
  private @SafeText String status;

  /**
   * URL of the file containing the data to be imported.
   */
  private URI url;
}