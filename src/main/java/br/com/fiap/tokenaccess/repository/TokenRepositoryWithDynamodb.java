package br.com.fiap.tokenaccess.repository;

import br.com.fiap.tokenaccess.repository.orm.TokenOrm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepositoryWithDynamodb extends CrudRepository<TokenOrm, String> {
}
