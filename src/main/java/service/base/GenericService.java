package service.base;

import dto.GenericDto;
import response.Data;
import response.ResponseEntity;

import java.io.Serializable;
import java.util.List;


/**
 * @param <D> dto
 * @param <K> primary key
 */
public interface GenericService<D extends GenericDto, K extends Serializable> {

    ResponseEntity<Data<D>> get(K id);

    ResponseEntity<Data<List<D>>> getAll();

}
