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

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class JPAContext implements IContext{

	
	private EntityManagerFactory _emf;
    private EntityManager _em;
    
    private EntityTransaction _tx;
    private int _txcount;

    private ICountryRepository _countryRepository;
    private IStudentRepository _studentRepository;
    private ICourseRepository _courseRepository;
    
    
    protected List helperQueryImpl(String jpql, Object... params)
    {
    	Query q = _em.createQuery(jpql);

		for(int i = 0; i < params.length; ++i)
			q.setParameter(i+1, params[i]);
		
		return q.getResultList();
    }
    protected class CountryRepository implements IRepository<Country, Collection<Country>, Long> {

		@Override
		public Country findByKey(Long key) {
			return _em.createNamedQuery("Country.findByKey",Country.class)
					 .setParameter("key", key)
	            	  .getSingleResult();
					
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<Country> find(String jpql, Object... params) {
			
			return helperQueryImpl( jpql, params);
		}
    	
    }
    
    protected class StudentRepository implements IStudentRepository
    {

		@Override
		public Student findByKey(Integer key) {
			return _em.createNamedQuery("Student.findByKey",Student.class)
					 .setParameter("key", key)
	            	  .getSingleResult();
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<Student> find(String jpql, Object... params) {
			
			return helperQueryImpl( jpql, params);
		}
    	
		@Override
		public Collection<Student> getEntolledStudents(Course c){
			return _em.createNamedQuery("Student.EnrolledInCourse",Student.class)
			 .setParameter("key", c.getCourseId())
			 .getResultList();
		}
    }
    
    protected class CourseRepository implements IRepository<Course, Collection<Course>, Long> {

		@Override
		public Course findByKey(Long key) {
			return _em.createNamedQuery("Course.findByKey",Course.class)
					 .setParameter("key", key)
	            	  .getSingleResult();
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<Course> find(String jpql, Object... params) {
			return helperQueryImpl( jpql, params);
		}
    	
    }
    
	@Override
	public void beginTransaction() {
		if(_tx == null)
		{
			_tx = _em.getTransaction();
			_tx.begin();
			_txcount=0;
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
	public void flush() {
		_em.flush();
	}

	public JPAContext() {
		this("dal-v6");
	}
	
	public JPAContext(String persistentCtx) 
	{
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

	@Override
	public ICountryRepository getCountries() {
		return _countryRepository;
	}

	@Override
	public IStudentRepository getStudents() {
		
		return _studentRepository;
	}
	@Override
	public ICourseRepository getCourses() {
		return _courseRepository;
	}
}
