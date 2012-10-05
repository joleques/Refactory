package rs.com.pedido.original;

/* solução para a estoria pedidos.txt*/

public class Pedido {

	private Long numero;
	private String status;
	
	
	public Pedido(Long numero, String status) {
		super();
		this.numero = numero;
		this.status = status;
	}


	public String informarStatusDoPedido(){
		if(status.equals("PR")){
			return "O pedido "+numero+" foi realizado e eguarda a confirmação do pagamento.";
		}else if(status.equals("PA")){
			return "O pedido "+numero+" foi autorizado e logo estará sendo enviado para transprotadora.";
		}else if(status.equals("PE")){
			return "O pedido "+numero+" foi esta sendo preparado para o envio.";
		}else if(status.equals("PT")){
			return "O pedido "+numero+" já em poder da transportadora.";
		}else if(status.equals("PE")){
			return "O pedido "+numero+" entregue com sucesso.";
		}
		return null;
	}
		
	public void mudarStatus(String novoStatus) throws Exception{
		if(novoStatus != null && !novoStatus.equals("")){
			this.status = novoStatus;
			if(status.equals("PR")){
				enviarEmail("Enviando email para confirmar que o pedido foi realizado");
			}else if(status.equals("PA")){
				enviarEmail("Enviando email para confirmar o recebimento do pagamento do pedido");
			}else if(status.equals("PE")){
				enviarEmail("Enviando email informar que o pedido esta sendo preparado para ser entregue");
			}else if(status.equals("PT")){
				enviarEmail("Enviando email informar que já esta de posse da transportadora o pedido");
			}else if(status.equals("PE")){
				enviarEmail("Enviando email para confirmar a entrega do pedido");
			}else{
				throw new Exception("Tipo Passado Invalido.");
			}
		}else{
			throw new Exception("Tipo Passado esta nulo ou vazio.");
		}
	}

	private void enviarEmail(String mensagem){
		System.out.println(mensagem);
	}
	
}
