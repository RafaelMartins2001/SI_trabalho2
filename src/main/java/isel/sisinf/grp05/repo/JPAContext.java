/*
MIT License

Copyright (c) 2022, Nuno Datia, ISEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package isel.sisinf.grp05.repo;

import java.util.Collection;
import java.util.List;

import isel.sisinf.grp05.model.Cliente.Cliente;
import isel.sisinf.grp05.model.Course.Course;
import jakarta.persistence.*;

public class JPAContext implements IContext{
	private EntityManagerFactory _emf;
    private EntityManager _em;
    
    private EntityTransaction _tx;
    private int _txcount;

    private CourseRepository _courseRepository;
	private ClienteRepository _clienteRepository;
    
    public List helperQueryImpl(String jpql, Object... params) {
    	Query q = _em.createQuery(jpql);

		for(int i = 0; i < params.length; ++i)
			q.setParameter(i+1, params[i]);
		
		return q.getResultList();
    }

    protected class CourseRepository implements IRepository<Course, Collection<Course>, Long> {
		@Override
		public Course findByKey(Long key) {
			return _em.createNamedQuery("Course.findByKey", Course.class)
					 .setParameter("key", key)
	            	  .getSingleResult();
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<Course> find(String jpql, Object... params) {
			return helperQueryImpl( jpql, params);
		}
    }

	protected class ClienteRepository implements IRepository<Cliente, Collection<Cliente>, Integer> {
		@Override
		public Cliente findByKey(Integer key) {
			return null;
		}

		@Override
		public Collection<Cliente> find(String jpql, Object... params) {
			return null;
		}

		@Override
		public Cliente create(Cliente entity) {
			return null;
		}

		@Override
		public Cliente read(Integer id) {
			return null;
		}

		@Override
		public Cliente update(Cliente entity) {
			return null;
		}

		@Override
		public Cliente delete(Cliente entity) {
			return null;
		}
	}

	@Override
	public void notifyInsert(Object e) {

	}

	@Override
	public void notifyUpdate(Object e) {

	}

	@Override
	public void notifyDelete(Object e) {

	}

	@Override
	public void beginTransaction() {
		if(_tx == null) {
			_tx = _em.getTransaction();
			_tx.begin();
			_txcount = 0;
		}
		++_txcount;
	}

	@Override
	public void commit() {
		--_txcount;
		if(_txcount==0 && _tx != null)
		{
			_tx.commit();
			_tx = null;
		}
	}

	@Override
	public void rollback() {
		--_txcount;
		if(_txcount==0 && _tx != null)
		{
			_tx.rollback();
			_tx = null;
		}
	}

	@Override
	public void flush() {
		_em.flush();
	}

	public JPAContext() {
		this("g05");
	}
	
	public JPAContext(String persistentCtx) {
		super();
	
		this._emf = Persistence.createEntityManagerFactory(persistentCtx);
		this._em = _emf.createEntityManager();
		this._courseRepository = new CourseRepository();
	}

	@Override
	public void close() throws Exception {
        if(_tx != null)
        	_tx.rollback();
        _em.close();
        _emf.close();
	}

	//Example using a scalar function
	public java.math.BigDecimal rand_fx(int seed) {

		StoredProcedureQuery namedrand_fx =
				_em.createNamedStoredProcedureQuery("namedrand_fx");
		namedrand_fx.setParameter(1, seed);
		namedrand_fx.execute();

		return (java.math.BigDecimal)namedrand_fx.getOutputParameterValue(2);
	}

	public Collection<Student> fromCountry(int country) {
		StoredProcedureQuery q = _em.createNamedStoredProcedureQuery("namedfromCountry");
		q.setParameter(1, country);
		q.execute();

		List<Object[]> tmp = (List<Object[]>) q.getResultList();

		Collection<Student> ret = new ArrayList<Student>();

		for(Object[] s : tmp) {
			Student st = new Student((Integer)s[0],(String)s[1],(java.util.Date)s[2],((String)s[3]).charAt(0),this.getCountries().findByKey((long)(Integer)s[4])  );
			_em.merge(st);
			ret.add( st);
		}

		return ret;

	}


	public List<Student> fromCountry2(int country) {
		return _em.createNamedStoredProcedureQuery("altnamedfromCountry").setParameter(1, country).getResultList();
	}
}
