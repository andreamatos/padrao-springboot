package br.edu.cruzeirodosul.controller;

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

import br.edu.cruzeirodosul.response.FaqResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/faq")
@CrossOrigin
@Api(value = "Este endpoint consiste no tratamento das perguntas e respostas", tags = { "FAQ" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
        @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
        @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
        @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
})

public class FaqController {
	
	private static Logger log = LoggerFactory.getLogger(FaqController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
			@ApiResponse(code = 401, message = "Não autorizado para visualizar"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/geral/{idSetor}/")
    @ApiOperation(value = "FAQ geral",
    notes = "FAQ geral retorna todas as perguntas e respostas cadastradas por setor",
    response = FaqResponse[].class)
	
	public ResponseEntity<String>  get(@PathVariable(name = "id") String id) {
		log.info(messageSource.getMessage("archetype.msg.return.ok",null, LocaleContextHolder.getLocale()));
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
