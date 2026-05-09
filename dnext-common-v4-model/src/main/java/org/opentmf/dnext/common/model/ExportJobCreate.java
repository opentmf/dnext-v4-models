package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IExportJobCreate;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeUrl;

/**
 * The ExportJob to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> url<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
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
    defaultImpl = ExportJobCreate.class
)
@Required(fields = {"url"})
public class ExportJobCreate extends ImportJobCreate implements IExportJobCreate {

  /**
   * Used to scope the exported data.
   */
  @SafeUrl
  @Size(max = 500)
  private String query;
}