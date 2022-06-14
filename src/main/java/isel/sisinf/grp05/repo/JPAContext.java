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

import isel.sisinf.grp05.model.ClienteI.ClienteIRepository;
import isel.sisinf.grp05.model.alarme.AlarmeRepository;
import isel.sisinf.grp05.model.alarms.AlarmsRepository;
import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.model.cliente.ClienteRepository;
import isel.sisinf.grp05.model.clienteP.ClientePRepository;
import isel.sisinf.grp05.model.gps.GpsRepository;
import isel.sisinf.grp05.model.grupoZV.GrupoZVRepository;
import isel.sisinf.grp05.model.registoI.RegistoIRepository;
import isel.sisinf.grp05.model.registoNP.RegistoNPRepository;
import isel.sisinf.grp05.model.registoP.RegistoPRepository;
import isel.sisinf.grp05.model.veiculo.VeiculoRepository;
import isel.sisinf.grp05.model.zv.ZVRepository;
import jakarta.persistence.*;


public class JPAContext implements IContext{
	private EntityManagerFactory _emf;
    private EntityManager _em;
    
    private EntityTransaction _tx;
    private int _txcount;

	public ClienteRepository _clienteRepository;
	public ClienteIRepository _clienteIRepository;
	public AlarmeRepository _alarmeRepository;
	public AlarmsRepository _alarmsRepository;
	public ClientePRepository _clientePRepository;
	public GpsRepository _gpsRepository;
	public GrupoZVRepository _grupoZVRepository;
	public RegistoIRepository _registoIRepository;
	public RegistoNPRepository _registoNPRepository;
	public RegistoPRepository _registoPRepository;
	public VeiculoRepository _veiculoRepository;
	public ZVRepository _zvRepository;
    
    public List helperQueryImpl(String jpql, Object... params) {
    	Query q = _em.createQuery(jpql);

		for(int i = 0; i < params.length; ++i)
			q.setParameter(i+1, params[i]);
		
		return q.getResultList();
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

	@Override
	public void close() throws Exception {
		if(_tx != null)
			_tx.rollback();
		_em.close();
		_emf.close();
	}

	public JPAContext() {
		this("g05");
	}

	public JPAContext(String persistentCtx) {
		super();
		this._emf = Persistence.createEntityManagerFactory(persistentCtx);
		this._em = _emf.createEntityManager();

		this._clienteRepository = new ClienteRepository(_em);
		this._clienteIRepository = new ClienteIRepository(_em);
		this._alarmeRepository = new AlarmeRepository(_em);
		this._alarmsRepository = new AlarmsRepository(_em);
		this._clientePRepository = new ClientePRepository(_em);
		this._gpsRepository = new GpsRepository(_em);
		this._grupoZVRepository = new GrupoZVRepository(_em);
		this._registoIRepository = new RegistoIRepository(_em);
		this._registoNPRepository = new RegistoNPRepository(_em);
		this._registoPRepository = new RegistoPRepository(_em);
		this._veiculoRepository = new VeiculoRepository(_em);
		this._zvRepository = new ZVRepository(_em);
	}
}
