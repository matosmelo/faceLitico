package br.com.matosmelo.facelitico.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.matosmelo.facelitico.infra.CriadorDeSession;
import br.com.matosmelo.facelitico.model.Litico;

@Component
public class LiticoDao {

	private final Session session;

	public LiticoDao() {
		// Aquisição de sessão
		this.session = CriadorDeSession.getSession();

	}

	// Salva
	public void salva(Litico litico) {
		Transaction tx = session.beginTransaction();
		session.save(litico);
		tx.commit();
	}

	// Altera
	public void alteraLitico() {
		Litico litico = carregaLitico();
		Transaction tx = session.beginTransaction();
		litico.setNome("Laly");
		litico.setPartido("Velho");
		session.update(litico);
		tx.commit();
	}

	// Remove litico
	public void removeLitico() {
		Litico litico = carregaLitico();
		Transaction tx = session.beginTransaction();
		session.delete(litico);
		tx.commit();
	}

	// Carrega
	private Litico carregaLitico() {
		Litico litico = (Litico) session.load(Litico.class, 4L);
		return litico;
	}

	// Lista tudo
	public List<Litico> listaTudo() {
		return this.session.createCriteria(Litico.class).list();
	}

	// Lê litico no banco pelo id
	public Litico carrega(Long id) {
		return (Litico) this.session.load(Litico.class, id);
	}

	// Atualiza o litico no banco
	public void atualiza(Litico litico) {
		Transaction tx = session.beginTransaction();
		this.session.update(litico);
		tx.commit();
	}

	// Remove litico do banco
	public void remove(Litico litico) {
		Transaction tx = session.beginTransaction();
		this.session.delete(litico);
		tx.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Litico> busca(String nome) {
		return session.createCriteria(Litico.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}
	// @SuppressWarnings("unchecked")
	// public List<Litico> busca(String nome) {
	// return this.session.createQuery(
	// "select nome from Litico as nome where nome=" + nome).list();
	// }

	// public List<Litico> busca(String nome) {
	// return session.createCriteria(Litico.class)
	// .add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
	// .list();
	// }

}
