package com.devsuperior.dsmeta.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entidades.Venda;
import com.devsuperior.dsmeta.repositorio.VendaRepositorio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServico {
	
	//value busca uma variavel de ambiente que espeficar aqui, irá buscar o valor e guardar na variavel de ambiente
	@Value("${twilio.sid}")
	private String twilioSid;
	
	@Value("${twilio.key}")
	private String twilioKey;
	
	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;
	
	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	public void enviarSms(Long VendaId) {
		
		Venda venda = vendaRepositorio.findById(VendaId).get();
		
		String data = venda.getData().getMonthValue() + "/" + venda.getData().getYear();
		
		String msg = "O Vendedor " + venda.getNomeVendedor() + " foi destaque em " + data + " com um total de R$ " + String.format("%.2f", venda.getQuantiaVendida());
		
		Twilio.init(twilioSid, twilioKey);
		
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Message message = Message.creator(to, from, msg).create();
		
		System.out.println(message.getSid());
		
	}

}
