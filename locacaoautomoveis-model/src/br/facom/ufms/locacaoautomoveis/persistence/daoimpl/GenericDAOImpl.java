package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.GenericDAO;
import br.facom.ufms.locacaoautomoveis.utils.EntityManagerUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Classe abstrata parametrizada que implementa a interface Dao.
 *
 * @author heverson.vasconcelos
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    /**
     * Metodo para retornar a classe do parametro T
     *
     * @return Classe especificada por T
     */
    public abstract Class<T> getDomainClass();

    @Override
    public void create(T obj) {
        EntityManagerUtil.insert(obj);

    }

    @Override
    public T retrieve(ID id) {
        return (T) EntityManagerUtil.getEntityManager().find(getDomainClass(), id);

    }

    @Override
    public List<T> list() {
        String queryS = "SELECT obj FROM " + getDomainClass().getSimpleName() + " obj";
        Query query = EntityManagerUtil.createQuery(queryS);

        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public T delete(T obj) {
        obj = (T) EntityManagerUtil.update(obj);
        EntityManagerUtil.remove(obj);

        return obj;

    }

    @Override
    public T update(T obj) {
        T objReturn = null;

        if (obj != null) {
            objReturn = (T) EntityManagerUtil.update(obj);
        }

        return objReturn;
    }

    @PreDestroy
    @Override
    public void finalizeAccess() {
        EntityManagerUtil.close();
    }
}
