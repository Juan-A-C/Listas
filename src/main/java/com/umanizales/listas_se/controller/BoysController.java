package com.umanizales.listas_se.controller;


import com.umanizales.listas_se.controller.dto.ResponseDTO;
import com.umanizales.listas_se.model.Boy;
import com.umanizales.listas_se.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "boys")
public class BoysController {
@Autowired
    private ListSeService listSeService;

    @PostMapping
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody Boy boy)
    {
        return listSeService.addBoy(boy);
    }
    @GetMapping
    public ResponseEntity<ResponseDTO> listBoys(){return listSeService.listBoys();}




    @GetMapping(path = "invert")
    public ResponseEntity<ResponseDTO> invertList()
    {
        return listSeService.invertList();
    }
    @PostMapping(path="addToStart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody Boy boy)
    {
        return listSeService.addBoy(boy);
    }

    @PostMapping(path = "addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody List<Boy> boys)
    {
        for(Boy boy:boys)
        {
            listSeService.addBoy(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio,",
                listSeService.listBoys(),null), HttpStatus.OK);
    }
    @GetMapping(path="getcount")
    public ResponseEntity<ResponseDTO> getCount()
    {
        return listSeService.getCount();
    }
    @GetMapping(path="count")
    public ResponseEntity<ResponseDTO> count()
    {
        return listSeService.Count();
    }
    @GetMapping(path = "free")
    public ResponseEntity<ResponseDTO> listBoysFree(){return listSeService.listBoysFree();}

    @GetMapping(path="changextremes")
    public ResponseEntity<ResponseDTO> changeXtremes() {
        return listSeService.changeXtremes();
    }



}

