package com.app.rdv.repository;

import com.app.rdv.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {

    List<Rdv> findAllByOrderByDateRdvAsc();

    List<Rdv> findAllByPatientIdAndMedecinId(int id1, int id2);

    Rdv findByPatientIdAndDateRdv(int id, LocalDateTime ldt);

    Rdv findByMedecinIdAndDateRdv(int id, LocalDateTime ldt);
}
