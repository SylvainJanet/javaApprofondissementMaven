package o08.genericite.dao.interfacegen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classes.Personne;

public class PersonneDao implements IPersonneDao {

	@Override
	public List<Personne> findAll(Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> findAll(int page, int maxByPage, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> findByDescription(String search, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne findById(long id, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne insert(Personne p, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Personne p, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id, Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count(Connection cnx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Personne birthay(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
