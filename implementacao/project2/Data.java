/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

 /**
  * Classe Data para uso próprio.
  */
public class Data{
    private static final Data MINDATA;
    private static Data maxData;
    
    /** Constante para validação de dias do mês */
    private static final int[] DIASDOMES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    /** atributos usuais de uma data */
    private int dia, mes, ano;
    
    
    static{
        MINDATA = new Data(true);
        maxData = MINDATA;
    }       
    

    /**
     * Construtor privado para iniciar a data mínima
     */
    private Data(boolean minimo){
        if(minimo){
            this.dia = this.mes = 1;
            this.ano = 1900;
        }
        else{
            Data aux = new Data();
            this.dia = aux.dia;
            this.mes = aux.mes;
            this.ano = aux.ano;
        } 
    }
    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }


    /**
     * Construtor padrão. Retorna data sempre válida
     * @param d Dia 
     * @param m Mês 
     * @param a Ano
     */
    public Data(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.ano = a;
        if (!this.dataValida()){     //se a data não é válida... (método da própria classe)
            this.dia = MINDATA.getDia();
            this.mes = MINDATA.getMes();
            this.ano = MINDATA.getAno();
        }
        if (this.maisRecente(maxData)){
              maxData.dia = this.dia;
              maxData.mes = this.mes;
              maxData.ano = this.ano;
        }
    }
    
    /**
     * Construtor vazio. Retorna data com 1 dia a mais que a data mais avançada já criada.
     */
    public Data(){
        maxData = maxData.acrescentaDias(1);
        this.dia = maxData.dia;
        this.mes = maxData.mes;
        this.ano = maxData.ano;
    }        
    
    
    /**
     * Retorna se o ano é bissexto.
     *  Para regras do ano bissexto:
     * http://educacao.uol.com.br/disciplinas/matematica/ano-bissexto-eles-se-repetem-a-cada-4-anos.htm
     * http://www.sogeografia.com.br/Curiosidades/?pg=4
     * @return V/F para ano bissexto
     */
    public boolean anoBissexto(){
    
        if(this.ano%100==0) 
              return ((this.ano%400)==0);         //ano divisível por 400 --> bissexto
        else 
              return((this.ano%4)==0);              
    }

    /**
     * Verificação interna de data válida.
     * @return V/F para datas válidas ou não
     */
    private boolean dataValida()
    {
        boolean resposta = true;        //resposta sobre a validade
        if(this.ano<1900)
            resposta = false;
        else{
           if (this.mes < 1 || this.mes > 12)                           //mês<1 ou mês>12 --> data inválida
               resposta = false;
           else { 
                   if (this.anoBissexto()) //senão, caso de 29/02 em ano bissexto --> data válida
                          DIASDOMES[2] = 29;
                   if (this.dia > DIASDOMES[this.mes])                //senao, verifica validade de acordo com o mês atual
                           resposta = false;
                   DIASDOMES[2] = 28;
                }
        }                       
        return resposta;    //retorna a resposta obtida
    }

    /**
     * Acrescenta N dias à data. Retorna nova data, sem modificar esta.
     * @param quant Dias a acrescentar
     * @return Nova data com os dias acrescentados
     */
    public Data acrescentaDias(int quant){
        Data aux = new Data(this.dia, this.mes, this.ano);

        aux.dia += quant;      //acrescenta a quantidade ao dia atual e, em seguida, devemos ajustar mês e ano

        if (aux.anoBissexto()) DIASDOMES[2] = 29; //se o ano é bissexto, altera fevereiro para 29 dias

        while (aux.dia > DIASDOMES[aux.mes]){     //enquanto os dias ultrapassam o limite de dias do mês atual... ajustar

            aux.dia = aux.dia - DIASDOMES[aux.mes]; // desconta a quantidade de dias do mês       
            aux.mes++; //avança o mês
            
            if (aux.mes > 12)      //se passar de 12 meses...
            {
                aux.mes = aux.mes - 12;       //desconta-se 1 ano
                aux.ano++;                     //avança o ano.
                if (aux.anoBissexto()) DIASDOMES[2] = 29; //verifica se o novo ano é bissexto para ajustar os dias de fevereiro.
                else DIASDOMES[2] = 28;
            }
        }
        return aux;
    }

    /**
     * Verifica se esta data é mais recente (mais avançada) que outra
     * @param outra A data a ser comparada
     * @return V/F caso esta data seja mais recente (avançada)
     */
    public boolean maisRecente(Data outra){
       
        if(this.ano > outra.ano) 
              return true;
        else if(this.ano < outra.ano)
              return false;
        
        if(this.mes > outra.mes)
              return true;
        else if(this.mes < outra.mes)
              return false;
              
        if(this.dia > outra.dia)
              return true;
        else 
              return false;
    }		
    
    @Override
    /**
     * Data formatada com DD/MM/AAAA
     */
    public String toString(){
        
        return (String.format("%02d",this.dia)+ "/" + String.format("%02d",this.mes)+ "/" + String.format("%4d",this.ano));
    }

    



    
}

