package service.base;

import repository.base.BaseGenericRepository;
import validator.base.BaseGenericValidator;


/**
 * @param <R> repository
 * @param <V> validator
 */
public abstract class AbstractService<
        R extends BaseGenericRepository,
        V extends BaseGenericValidator> implements BaseGenericService {

    protected R repository;
    protected V validator;

    public AbstractService(R repository, V validator) {
        this.repository = repository;
        this.validator = validator;
    }

}
