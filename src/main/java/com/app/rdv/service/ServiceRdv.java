package com.app.rdv.service;

import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv{

    private RdvRepository rdvRepository;
    @Override
    public Rdv addRdv(Rdv rdv) {

        Rdv rdv1 = rdvRepository.findByPatientIdAndDateRdv(rdv.getPatient().getId(), rdv.getDateRdv());
        Rdv rdv2 = rdvRepository.findByMedecinIdAndDateRdv(rdv.getMedecin().getId(), rdv.getDateRdv());
        if(rdv1==null && rdv2==null)
            return rdvRepository.save(rdv);
        else
            return null;
    }

    @Override
    public List<Rdv> getAllRdvs() {
        //return rdvRepository.findAll();
        return rdvRepository.findAllByOrderByDateRdvAsc();
    }

    @Override
    public List<Rdv> findRdvsByIds(int id1, int id2) {
        return rdvRepository.findAllByPatientIdAndMedecinId(id1,id2);
    }

    @Override
    public List<Rdv> findRdvsByDate(String date) {
        List<Rdv> result = new ArrayList<>();

        LocalDate date1 = LocalDate.parse(date);
        List<Rdv> rdvList = rdvRepository.findAllByOrderByDateRdvAsc();
        for (Rdv rdv: rdvList){
            LocalDate date2 = rdv.getDateRdv().toLocalDate();
            if(date2.isEqual(date1))
                result.add(rdv);
        }

        return result;
    }
}
