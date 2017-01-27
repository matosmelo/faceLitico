package br.com.matosmelo.facelitico.testes;

import br.com.matosmelo.facelitico.dao.LiticoDao;
import br.com.matosmelo.facelitico.model.Litico;

public class AdicaoDeLitico {

	public static void main(String[] args) {

		// Criação do litico
		Litico litico = criaLitico();

		// Adição do litico ao banco
		new LiticoDao().salva(litico);

	}

	private static Litico criaLitico() {
		Litico litico = new Litico();
		litico.setNome("Teste");
		litico.setPartido("Teste partido");
		return litico;
	}

}
