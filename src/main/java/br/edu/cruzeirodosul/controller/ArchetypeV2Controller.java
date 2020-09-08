package br.edu.cruzeirodosul.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/archetype")
@CrossOrigin
@Api(value = "Archetype 2", tags = { "Versao Archetype 2" })
public class ArchetypeV2Controller {
	
	private static Logger log = LoggerFactory.getLogger(ArchetypeV2Controller.class);
	
	@Autowired
	MessageSource messageSource;
	
	
	@ApiOperation(value = "Controller ", notes = "Archetype Versão 2 - Controller", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
			@ApiResponse(code = 401, message = "Não autorizado para visualizar"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{id}")
	public ResponseEntity<String>  get(@PathVariable(name = "id") String id) {
		log.info(messageSource.getMessage("archetype.msg.return.ok",null, LocaleContextHolder.getLocale()));
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
