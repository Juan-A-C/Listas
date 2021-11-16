package com.umanizales.listas_se.controller;


import com.umanizales.listas_se.controller.dto.ResponseDTO;
import com.umanizales.listas_se.model.Boy;
import com.umanizales.listas_se.service.ListDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path= "boysDe")
public class ControllerDE {
@Autowired
    private ListDeService listDeService;

    @PostMapping
    public ResponseEntity<ResponseDTO> adicionarNodeDE(@RequestBody Boy boy)
    {
        return listDeService.adicionarNodeDE(boy);
    }



    @GetMapping(path = "listBoyABC")
    public ResponseEntity<ResponseDTO> listBoy(){return listDeService.listBoy();}






}
