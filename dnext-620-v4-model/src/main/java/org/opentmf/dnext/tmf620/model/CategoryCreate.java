package org.opentmf.dnext.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.tmf620.model.ICategoryCreate;

/**
 * The Category to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = CategoryCreate.class
)
@Required(fields = {"name"})
public class CategoryCreate extends CategoryUpdate implements ICategoryCreate {

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime lastUpdate;

  private @SafeText String version;
}