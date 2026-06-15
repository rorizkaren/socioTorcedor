package entidades;


 //Interface que define o contrato para qualquer classe que precise de autenticação no sistema.
 
public interface Autenticavel {
    /**
     * Método abstrato que obriga as classes que a implementam a fornecer uma lógica de validação de senha.
     * @param senha A senha digitada pelo usuário para validação.
     * @return true se a senha estiver correta, false caso contrário.
     */
    public boolean autenticar(String senha);
}