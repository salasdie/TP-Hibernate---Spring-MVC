package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PaisesTest extends SpringTest {

    //2- Hacer con junit un test que busque todos los países de habla inglesa. 
    @Test
    @Transactional
    @Rollback(true)
    public void paisesHablaInglesa() {
        Session session = getSession();

        Continente oceania = new Continente();
        Continente america = new Continente();

        oceania.setNombre("Oceania");
        america.setNombre("America");

        session.save(oceania);
        session.save(america);

        Pais argentina = new Pais("argentina", 50000000, "Castellano", "Buenos Aires", america);
        Pais brasil = new Pais("brasil", 50000000, "Portugues", "Brasilia", america);
        Pais estadosUnidos = new Pais("Estados Unidos", 50000000, "Ingles", "Washington", america);
        Pais australia = new Pais("Australia", 50000000, "Ingles", "Canberra", oceania);

        session.save(argentina);
        session.save(brasil);
        session.save(estadosUnidos);
        session.save(australia);

        List<Pais> getPaisesHablaInglesa = getSession().createCriteria(Pais.class)
                .add(Restrictions.eq("idioma", "Ingles")).list();
        assertThat(getPaisesHablaInglesa.size()).isEqualTo(2);
    }


    //3- Hacer con junit un test que busque todos los países del continente europeo. 
    @Test
    @Transactional
    @Rollback(true)

    public void todosLosPaisesEuropeos() {
        Session session = getSession();

        Continente europa = new Continente();
        Continente america = new Continente();

        europa.setNombre("Europa");
        america.setNombre("America");

        session.save(europa);
        session.save(america);

        Pais italia = new Pais("Italia", 50000000, "Italiano", "Roma", europa);
        Pais argentina = new Pais("argentina", 50000000, "Castellano", "Buenos Aires", america);
        Pais brasil = new Pais("brasil", 50000000, "Portugues", "Brasilia", america);

        session.save(italia);
        session.save(argentina);
        session.save(brasil);


        List<Pais> getTodosLosPaisesEuropeos = getSession().createCriteria(Pais.class)
                .createAlias("continente", "continente")
                .add(Restrictions.eq("continente.nombre", "Europa")).list();
        assertThat(getTodosLosPaisesEuropeos.size()).isEqualTo(1);


    }
}