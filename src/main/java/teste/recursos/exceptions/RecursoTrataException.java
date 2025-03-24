package teste.recursos.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import teste.Servico.exceptions.ExceptionRecursoNãoEncontrado;

@ControllerAdvice
public class RecursoTrataException {
@ExceptionHandler(ExceptionRecursoNãoEncontrado.class)	
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(ExceptionRecursoNãoEncontrado e, HttpServletRequest requisicao){
	String mensagemErro = "Recurso não encontrado"; 
	HttpStatus status = HttpStatus.NOT_FOUND;
	// status.value() precisa ser assim pra transformar em inteiro
	ErroPadrao erro = new ErroPadrao(Instant.now(), status.value(), mensagemErro, e.getMessage(), requisicao.getRequestURI());
	return ResponseEntity.status(status).body(erro);
	}
}
