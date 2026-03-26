package org.opentmf.dnext.tmf666.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.tmf666.model.ISettlementAccountStateChangeEventPayload;

/**
 * The event data structure.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
public class SettlementAccountStateChangeEventPayload implements ISettlementAccountStateChangeEventPayload {

  /**
   * Account used for billing or for settlement purposes concerning a given party
   * (an organization or an individual). It is a specialization of entity Account.
   */
  private @Valid SettlementAccount settlementAccount;
}