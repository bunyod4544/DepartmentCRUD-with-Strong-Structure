package repository.base;

import dto.BaseGenericDto;
import dto.GenericDto;

import java.io.Serializable;

public interface GenericCrudRepository<
        D extends BaseGenericDto,
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable> extends GenericRepository<D, K> {
    K create(CD dto);

    Boolean update(UD dto);

    Boolean delete(K id);
}
