package org.opentmf.dnext.tmf667.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf667.model.IDocumentBatchEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-667: Document Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class DocumentBatchEventPayload implements IDocumentBatchEventPayload {

  /**
   * Document is a tangible output from an activity. It is an attachment for other
   * API’s. The document itself can
   * <br/>be provided as a message payload or attachment, or as a location
   * reference (URL).
   */
  private @Valid Document document;
}