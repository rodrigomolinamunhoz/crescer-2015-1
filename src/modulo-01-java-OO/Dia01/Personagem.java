import java.util.*;
/**
 * Escreva a descrição da classe pai Personagem aqui.
 * 
 * @author Rodrigo Molina
 * @version 10/04/2015
 */
public class Personagem
{
    protected Status status = Status.VIVO;
    protected int vida;
    protected String nome;
    protected int experiencia;
    protected  ArrayList<ItemDoInventario> list = new ArrayList<ItemDoInventario>();
    
    public Personagem(String nome, int vida){
        this.nome = nome;
        this.vida = vida;
    }
    
    protected Status getStatus(){
        return status;
    }
    
    protected int getVida(){
        return vida;
    }
    
    protected String getNome() {
        return nome;
    }
    
    protected int getExperiencia() {
        return experiencia;
    }
    
    protected ArrayList<ItemDoInventario> getItens() {
        return this.list;
    }
    
     /**
   * Adiciona um item ao inventário.
   * 
   * @param item Item a ser adicionado.
   */
   protected void adicionarItem(ItemDoInventario i){ 
        this.list.add(i);
   } 
   
   /**
   * Remove o item do inventário do orc.
   * 
   * @param item Item a ser perdido do inventário.
   */
   protected void perderItem(ItemDoInventario i){ 
        this.list.remove(i);
   } 
   
     protected ItemDoInventario getItemComMaiorQuantidade() {
        
        ItemDoInventario itemMaiorQuantidade = null;
        
        boolean temItens = !this.list.isEmpty();       
        if (temItens) {
            itemMaiorQuantidade = this.list.get(0);
            
            for (int i = 1; i < this.list.size(); i++) {
                ItemDoInventario itemAtual = this.list.get(i);
                boolean encontreiAMaiorQuantidade =
                    itemAtual.getQuantidade() > itemMaiorQuantidade.getQuantidade();
                
                if (encontreiAMaiorQuantidade) {
                    // atualizar a minha referência para o maior parcial
                    itemMaiorQuantidade = itemAtual;
                }
            }
        }
        
        return itemMaiorQuantidade;
   }
   
   /**
   * Concatena as descrições dos itens, separados por vírgula.
   * 
   * SEM ESPAÇO ENTRE AS VÍRGULAS E SEM PONTO FINAL
   * 
   * @return Descrições. Ex:
   * 
   * "Adaga,Escudo,Bracelete”
   */
   protected String getDescricaoItens(){
      StringBuilder builder = new StringBuilder();
      
      int numeroItens = this.list.size();
        
       for (int i = 0; i < numeroItens; i++){
           ItemDoInventario itemAtual = this.list.get(i);     
           boolean éUltimoIncice = i == numeroItens - 1;  
           builder.append(éUltimoIncice ? itemAtual.getDescricao() : itemAtual.getDescricao() + ",");
      }
      // C#
       //foreach (ItemDoInventario item in this.itens) { }
       
       /*
        * Utilizando FOREACH!!
       for (ItemDoInventario itemAtual : this.itens) {
           int i = this.itens.indexOf(itemAtual);
           int numeroDeItens = this.itens.size();
           boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
           builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
       }
       */
      
      /*
       * JavaScript
      for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
      }
      */
      
     /*
      * WHILE (ENQUANTO)
      int i = 0;
      int numeroDeItens = this.itens.size();    
      while (i < numeroDeItens) {
          ItemDoInventario itemAtual = this.itens.get(i);
          boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
          builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
          );
          //
          i++;
      }
      
     
     int i = 0;
     int numeroDeItens = this.itens.size();
     do {
         if (numeroDeItens > 0) {
             ItemDoInventario itemAtual = this.itens.get(i);
              boolean éÚltimoÍndice = i == numeroDeItens - 1;
               
              builder.append(
                    éÚltimoÍndice ?
                    itemAtual.getDescricao() :
                    itemAtual.getDescricao() + ","
              );
         }
         i++;
     } while(i < numeroDeItens);
     
     */
      return builder.toString(); 
    }
   
   protected void ordenarItens(){
        for (int i = 0; i < this.list.size(); i++){
            for (int j = 0; j < this.list.size()-1; j++){
                ItemDoInventario itemJ = this.list.get(j); 
                ItemDoInventario itemJDois = this.list.get(j+1);
               
                boolean precisaTrocar =
                    itemJ.getQuantidade() > itemJDois.getQuantidade();
                
               if (precisaTrocar){
                        this.list.set(j, itemJDois); 
                        this.list.set(j + 1, itemJ); 
               }
            } 
        }
   }
}
