package org.opentmf.dnext.tmf629.model;

import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Customer History.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class CustomerHistory {

  /**
   * Date time of the change, using IETC-RFC-3339 format.
   */
  private OffsetDateTime changeDate;

  /**
   * Unique identifier of the Customer.
   */
  @SafeId
  @Size(max = 100)
  private String customerId;

  /**
   * Snapshot of customer object after changes.
   */
  private @SafeText String snapshot;

  /**
   * Status of customer after changes.
   */
  private @SafeText String status;

  /**
   * Status reason of the change.
   */
  private @SafeText String statusReason;

  /**
   * User who made the changes on Customer.
   */
  private @SafeText String user;
}