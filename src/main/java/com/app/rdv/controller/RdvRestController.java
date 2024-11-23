package com.app.rdv.controller;

import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rdv/")
public class RdvRestController {

    private IServiceRdv iServiceRdv;

    @PostMapping("add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Rdv add(@RequestBody Rdv rdv){
        return iServiceRdv.addRdv(rdv);
    }

    @GetMapping("all")
    public List<Rdv> allRdv(){
        return iServiceRdv.getAllRdvs();
    }

    @GetMapping("{idp}/{idm}")
    public List<Rdv> findRdvByPatientAndMedecin(@PathVariable int idp, @PathVariable int idm){
        return iServiceRdv.findRdvsByIds(idp,idm);
    }

    @GetMapping("{date}")
    public List<Rdv> findRdvByDate(@PathVariable String date){
        return iServiceRdv.findRdvsByDate(date);
    }
}
