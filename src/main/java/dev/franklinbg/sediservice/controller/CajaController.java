package dev.franklinbg.sediservice.controller;

import dev.franklinbg.sediservice.entity.Caja;
import dev.franklinbg.sediservice.entity.dto.CajaWithDetallesDTO;
import dev.franklinbg.sediservice.service.CajaService;
import dev.franklinbg.sediservice.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("caja")
public class CajaController {
    private final CajaService service;

    public CajaController(CajaService service) {
        this.service = service;
    }

    @GetMapping("byusuarioid/{idU}")
    public GenericResponse<Caja> getByUserId(@PathVariable int idU) {
        return service.findByUsuarioId(idU);
    }

    @PostMapping("open")
    public GenericResponse<CajaWithDetallesDTO> open(@RequestBody CajaWithDetallesDTO dto) {
        return service.open(dto);
    }
}