package org.opentmf.dnext.tmf667.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf667.model.IDocumentSpecificationDeleteEventPayload;

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
public class DocumentSpecificationDeleteEventPayload implements IDocumentSpecificationDeleteEventPayload {

  /**
   * A document specification reference.
   */
  private @Valid DocumentSpecification documentSpecification;
}