package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.IPointOfInteraction;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * POI consists of hardware and software which enables a Cardholder and/or an
 * Acceptor to perform a Local Card transaction. This is also referred to as a
 * Physical/EMV Terminal. It may be Attended or Unattended.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-676: Payment Management API</li>
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
    defaultImpl = PointOfInteraction.class
)
public class PointOfInteraction extends Entity implements IPointOfInteraction {

  /**
   * Key entry code that tells the processor how the transaction was captured.
   */
  private @SafeText String modeOfEntry;

  /**
   * A POI is a Physical POI or a Remote POI, as a resource.
   */
  private @Valid ResourceRef resource;

  /**
   * The reference number used to identify a given transaction that allow the
   * Acceptor or Acquirer to keep track of their transactions.
   */
  private @SafeText String retrievalReferenceNumber;

  /**
   * Date time related to the POI transaction.
   */
  private OffsetDateTime transactionDate;
}