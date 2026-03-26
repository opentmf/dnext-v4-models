package org.opentmf.dnext.tmf634.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.ExportJob;
import org.opentmf.tmf634.model.IExportJobCreateEventPayload;

/**
 * The event data structure.
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
public class ExportJobCreateEventPayload implements IExportJobCreateEventPayload {

  /**
   * Represents a task used to export resources to a file.
   */
  private @Valid ExportJob exportJob;
}