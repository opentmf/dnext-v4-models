package org.opentmf.dnext.tmf634.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.dnext.common.model.ImportJob;
import org.opentmf.tmf634.model.IImportJobStateChangeEventPayload;

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
public class ImportJobStateChangeEventPayload implements IImportJobStateChangeEventPayload {

  /**
   * Represents a task used to import resources from a file.
   */
  private @Valid ImportJob importJob;
}