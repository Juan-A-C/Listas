package com.umanizales.listas_se.service;

import com.umanizales.listas_se.controller.dto.ResponseDTO;
import com.umanizales.listas_se.model.Boy;
import com.umanizales.listas_se.model.ListSE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListSeService {
    private ListSE listBoys;

    public ListSeService() {
        listBoys = new ListSE();
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy)
    {
        listBoys.add(boy);
        return new ResponseEntity<>(
                new ResponseDTO("Niño adicionado",true, null),
                HttpStatus.OK);

    }
    public ResponseEntity<ResponseDTO> listBoys()
    {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listBoys.getHead(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> invertList()
    {
        listBoys.invert();
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listBoys.getHead(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> addBoytoStart(Boy boy)
    {
        listBoys.addToStar(boy);
        return new ResponseEntity<>(
                new ResponseDTO("Niño adicionado",true, null),
                HttpStatus.OK);

    }

    public ResponseEntity<ResponseDTO> getCount()
    {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listBoys.getCount(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> Count()
    {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listBoys.count(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> listBoysFree()
    {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listBoys.list(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> changeXtremes()
    {
        listBoys.changeXtremes();
        return new ResponseEntity<>(
                new ResponseDTO("satisfactorio",true, null),
                HttpStatus.OK);

    }
}
