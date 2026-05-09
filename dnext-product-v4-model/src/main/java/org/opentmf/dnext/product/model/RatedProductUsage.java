package org.opentmf.dnext.product.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.Money;
import org.opentmf.dnext.common.model.ProductRef;
import org.opentmf.product.model.IRatedProductUsage;

/**
 * An occurrence of employing a product for its intended purpose with all rating
 * details.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = RatedProductUsage.class
)
public class RatedProductUsage extends Extensible implements IRatedProductUsage {

  private Boolean billed;

  private @Valid Money bucketValueConvertedInAmount;

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
   * Boolean indicating if usage have been billed or not.
   */
  private Boolean isBilled;

  /**
   * Indicates if the rated amount is exempt of tax.
   */
  private Boolean isTaxExempt;

  /**
   * Type of tariff applied.
   */
  private @SafeText String offerTariffType;

  private @Valid ProductRef productRef;

  /**
   * Type of amount.
   */
  private @SafeText String ratingAmountType;

  /**
   * Date of usage rating.
   */
  private OffsetDateTime ratingDate;

  private @Valid Money taxExcludedRatingAmount;

  private Boolean taxExempt;

  private @Valid Money taxIncludedRatingAmount;

  /**
   * Tax rate.
   */
  private BigDecimal taxRate;

  /**
   * Tag value: [usage]: the usage is always rated outside a usage bundle
   * [included usage]: the usage is rated inside a usage bundle [non included
   * usage]: the usage bundle is exhausted. The usage is rated outside the usage
   * bundle.
   */
  private @SafeText String usageRatingTag;
}