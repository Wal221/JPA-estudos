package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
	
        //como meu ID e gerado automaticamente pelo meu JPA, logo os ID que estavam iniciado com numeros
		//deverão ser agora nulos 
		Pessoa p1 = new Pessoa(null,"Walmir","walmir@gmail.com");
		Pessoa p2 = new Pessoa(null,"Joao","Joao@gmail.com");
		Pessoa p3 = new Pessoa(null,"Lucas","lucas@gmail.com");
		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("exemplo-jpa");
		//com essa instancia aqui toda a minha conexão com bacno de dados ja esta feita,e todo o contexto de persistencia de dados
		//também ja esta implementado
		EntityManager em = enf.createEntityManager();
		
		//Quando o banco de dados não faz uma simples operação que e de leitura no banco de dados
		//temos que iniciar uma transção
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		//Para confirma a transação
		em.getTransaction().commit();
	    System.out.println("Pronto!!");
		
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
