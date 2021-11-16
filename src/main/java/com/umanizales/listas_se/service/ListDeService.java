package com.umanizales.listas_se.service;

import com.umanizales.listas_se.controller.dto.ResponseDTO;
import com.umanizales.listas_se.model.Boy;
import com.umanizales.listas_se.model.ListDE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListDeService {
    private ListDE listDE;

    public ListDeService() {
        listDE = new ListDE();
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy)
    {
        listDE.adicionarNodeDE(boy);
        return new ResponseEntity<>(
                new ResponseDTO("Niño adicionado",true, null),
                HttpStatus.OK);

    }
    public ResponseEntity<ResponseDTO> listBoys()
    {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listDE.getHead(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> invertList()
    {
        listDE.invertirDE();
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listDE.getHead(), null),
                HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> addBoytoStart(Boy boy)
    {
        listDE.adicionarAlInicio(boy);
        return new ResponseEntity<>(
                new ResponseDTO("Niño adicionado",true, null),
                HttpStatus.OK);

    }






    public ResponseEntity<ResponseDTO> changeXtremes()
    {
        listDE.invertirDE();
        return new ResponseEntity<>(
                new ResponseDTO("satisfactorio",true, null),
                HttpStatus.OK);

    }

    public ResponseEntity<ResponseDTO> listBoy( )
    {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listDE.listBoys(), null),
                HttpStatus.OK);
    }



    public ResponseEntity<ResponseDTO> adicionarNodeDE(Boy boy) {
        return new ResponseEntity<>(
                new ResponseDTO("Niño adicionado",true, null),
                HttpStatus.OK);
    }
}
