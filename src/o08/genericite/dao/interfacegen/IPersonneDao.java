package o08.genericite.dao.interfacegen;

import classes.Personne;

public interface IPersonneDao extends IGenericDao<Personne> {

	Personne birthay(long id);
}
