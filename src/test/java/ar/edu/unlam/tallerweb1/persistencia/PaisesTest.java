package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion; 

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        Pais argentina = new Pais("Argentina", 50000000, "Castellano", "buenos aires", america);
        Pais brasil = new Pais("Brasil", 50000000, "Portugues", "brasilia", america);
        Pais estadosUnidos = new Pais("Estados Unidos", 50000000, "Ingles", "washington", america);
        Pais australia = new Pais("Australia", 50000000, "Ingles", "canberra", oceania);

        session.save(argentina);
        session.save(brasil);
        session.save(estadosUnidos);
        session.save(australia);

        List<Pais> getPaisesHablaInglesa = session.createCriteria(Pais.class)
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


        List<Pais> getTodosLosPaisesEuropeos = session.createCriteria(Pais.class)
                .createAlias("continente", "continente")
                .add(Restrictions.eq("continente.nombre", "Europa")).list();
        assertThat(getTodosLosPaisesEuropeos.size()).isEqualTo(1);


    }
    
    //4- Hacer con junit un test que busque todos los pa�ses cuya capital est�n al norte del tr�pico de c�ncer.
    @Test
    @Transactional
    @Rollback(true)
    public void capitalNorteDeCancer() {
        Session session = getSession();
        
        Continente oceania = new Continente();
        Continente america = new Continente();

        oceania.setNombre("Oceania");
        america.setNombre("America");

        session.save(oceania);
        session.save(america);        

        Pais argentina = new Pais("Argentina", 50000000, "Castellano", "buenos aires", america);
        Pais brasil = new Pais("Brasil", 50000000, "Portugues", "brasilia", america);
        Pais estadosUnidos = new Pais("Estados Unidos", 50000000, "Ingles", "washington", america);
        Pais australia = new Pais("Australia", 50000000, "Ingles", "canberra", oceania);
        
        session.save(argentina);
        session.save(brasil);
        session.save(estadosUnidos);
        session.save(australia);
        
        Ubicacion ubicacionBuenosAires = new Ubicacion(-34.6157437,-58.5733857);
        Ubicacion ubicacionBrasilia = new Ubicacion(-15.7750836, -48.0772954);
        Ubicacion ubicacionWashington = new Ubicacion(38.8935128, -77.1546626);
        Ubicacion ubicacionCanberra = new Ubicacion(-35.2813043, 149.1204446);

        session.save(ubicacionBuenosAires);
        session.save(ubicacionBrasilia);
        session.save(ubicacionWashington);
        session.save(ubicacionCanberra);
        
        Ciudad buenosAires = new Ciudad("buenos aires", ubicacionBuenosAires, argentina);
        Ciudad brasilia = new Ciudad("brasilia", ubicacionBrasilia, brasil);
        Ciudad washington = new Ciudad("washington", ubicacionWashington, estadosUnidos);
        Ciudad canberra = new Ciudad("canberra", ubicacionCanberra, australia);
        
        session.save(buenosAires);
        session.save(brasilia);
        session.save(washington);
        session.save(canberra);


        List<Pais> Paises = session.createCriteria(Pais.class).list();
        
        List<Pais> paisesConCapitalNorteCancer = new ArrayList<Pais>();
        for (Pais pais : Paises) {
        	if (session.createCriteria(Ciudad.class).createAlias("ubicacionGeografica", "ubicacion")
        			.add(Restrictions.eq("nombre", pais.getCapital()))
        			.add(Restrictions.gt("ubicacion.latitud", new Double(23.43722)))
        			.uniqueResult() != null) {
        		
        		paisesConCapitalNorteCancer.add(pais);
        	}
		}
        assertThat(paisesConCapitalNorteCancer.size()).isEqualTo(1);
    }
    
    //5- Hacer con junit un test que busque todas las ciudades del hemisferio sur
    @Test
    @Transactional
    @Rollback(true)
    public void ciudadesHemisferioSur() {
        Session session = getSession();
        
        Continente oceania = new Continente();
        Continente america = new Continente();

        oceania.setNombre("Oceania");
        america.setNombre("America");
        session.save(oceania);
        session.save(america);        

        Pais argentina = new Pais("Argentina", 50000000, "Castellano", "buenos aires", america);
        Pais brasil = new Pais("Brasil", 50000000, "Portugues", "brasilia", america);
        Pais estadosUnidos = new Pais("Estados Unidos", 50000000, "Ingles", "washington", america);
        Pais australia = new Pais("Australia", 50000000, "Ingles", "canberra", oceania);        
        session.save(argentina);
        session.save(brasil);
        session.save(estadosUnidos);
        session.save(australia);
        
        Ubicacion ubicacionBuenosAires = new Ubicacion(-34.6157437,-58.5733857);
        Ubicacion ubicacionBrasilia = new Ubicacion(-15.7750836, -48.0772954);
        Ubicacion ubicacionWashington = new Ubicacion(38.8935128, -77.1546626);
        Ubicacion ubicacionCanberra = new Ubicacion(-35.2813043, 149.1204446);
        session.save(ubicacionBuenosAires);
        session.save(ubicacionBrasilia);
        session.save(ubicacionWashington);
        session.save(ubicacionCanberra);
        
        Ciudad buenosAires = new Ciudad("buenos aires", ubicacionBuenosAires, argentina);
        Ciudad brasilia = new Ciudad("brasilia", ubicacionBrasilia, brasil);
        Ciudad washington = new Ciudad("washington", ubicacionWashington, estadosUnidos);
        Ciudad canberra = new Ciudad("canberra", ubicacionCanberra, australia);        
        session.save(buenosAires);
        session.save(brasilia);
        session.save(washington);
        session.save(canberra);


        List<Ciudad> ciudadesHemisferioSur = session.createCriteria(Ciudad.class)
        		.createAlias("ubicacionGeografica", "ubicacion")
        		.add(Restrictions.lt("ubicacion.latitud", new Double(0))).list();
        
        assertThat(ciudadesHemisferioSur.size()).isEqualTo(3);
    }
    
    
}