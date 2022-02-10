package validator.base;

import dto.BaseGenericDto;
import dto.GenericDto;

import java.io.Serializable;


/**
 * @param <CD> create dto
 * @param <UD> update dto
 * @param <K>  primary key
 */
public abstract class GenericValidator<
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable> implements BaseGenericValidator {

    public abstract void validKey(K id);

    public abstract void validOnCreate(CD dto);

    public abstract void validOnUpdate(UD dto);

}
