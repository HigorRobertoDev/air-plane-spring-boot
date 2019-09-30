package com.airport.airplane.controllers;

import com.airport.airplane.dto.airplane.input.AirPlaneDTO;
import com.airport.airplane.model.AirPlane;
import com.airport.airplane.service.AirPlaneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airplane")
public class AirPlaneController {

    @Autowired
    AirPlaneService airPlaneService;

    @ApiOperation(
            value = "Cadastrar uma nova Aeronave",
            response = AirPlane.class,
            notes = "Essa operação salva um novo registro com as informações da Aeronave."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna um Airplane com uma mensagem de sucesso",
                    response = AirPlane.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Caso tenhamos algum erro vamos retornar um Airplane com a Exception",
                    response = AirPlane.class
            )
    })
    @PostMapping
    public ResponseEntity<AirPlane> saveAirPlane(@RequestBody AirPlaneDTO input) {
        return new ResponseEntity<>(
                airPlaneService.save(input),
                HttpStatus.CREATED
        );
    }

    @ApiOperation(
            value = "Consultar uma Aeronave por ID",
            response = AirPlane.class,
            notes = "Essa operação consulta um registro com as informações da Aeronave."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um Airplane",
                    response = AirPlane.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Caso tenhamos algum erro vamos retornar um Airplane com a Exception",
                    response = AirPlane.class
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<AirPlane> findAirPlaneById(@PathVariable int id) {
        return new ResponseEntity<>(
            airPlaneService.findAirPlaneById(id),
            HttpStatus.OK
        );
    }

    @ApiOperation(
            value = "Lista de Aeronaves com uma paginação básica",
            response = AirPlane.class,
            notes = "Essa operação consulta vários registros com as informações da Aeronave usando uma paginação básica."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna uma lista de Airplane",
                    response = AirPlane.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Caso tenhamos algum erro vamos retornar um Airplane com a Exception",
                    response = AirPlane.class
            )
    })
    @GetMapping
    public ResponseEntity<List<AirPlane>> findAllAirPlaneByPagination(
            @RequestParam(defaultValue = "0") String min,
            @RequestParam(defaultValue = "10") String max
    ) {
        return new ResponseEntity<>(
                airPlaneService.findByPagination(min, max),
                HttpStatus.OK
        );
    }

    @ApiOperation(
            value = "Faz a alteração do registro da Aeronave",
            response = AirPlane.class,
            notes = "Essa operação altera o registro da Aeronave."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um Airplane",
                    response = AirPlane.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Caso tenhamos algum erro vamos retornar um Airplane com a Exception",
                    response = AirPlane.class
            )
    })
    @PutMapping
    public ResponseEntity<AirPlane> updateAirPlane(@RequestBody AirPlane input) {
        return new ResponseEntity<>(
                airPlaneService.update(input),
                HttpStatus.OK
        );
    }

    @ApiOperation(
            value = "Deleta um registro da Aeronave",
            response = AirPlane.class,
            notes = "Essa operação deleta o registro da Aeronave."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Não tem retorno",
                    response = AirPlane.class
            ),
            @ApiResponse(
                    code = 500,
                    message = "Caso tenhamos algum erro vamos retornar um Airplane com a Exception",
                    response = AirPlane.class
            )
    })
    @DeleteMapping("/{id}")
    public void deleteAirPlane(@PathVariable int id) {
        airPlaneService.delete(id);
    }

}
