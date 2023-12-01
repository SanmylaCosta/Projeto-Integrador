package domain;

public class Roteirista_filme {

        private int cod_roteiristaFilme;
        private Roteirista roteirista; 
        private Filme filme;

        
        public Roteirista_filme(int cod_roteiristaFilme, Roteirista roteirista, Filme filme) {
            this.cod_roteiristaFilme = cod_roteiristaFilme;
            this.roteirista = roteirista;
            this.filme = filme;
        }
        public int getcod_roteiristaFilme() {
            return cod_roteiristaFilme;
        }
        public void setcod_roteiristaFilme(int cod_roteiristaFilme) {
            this.cod_roteiristaFilme = cod_roteiristaFilme;
        }
        public Roteirista getRoteirista() {
            return roteirista;
        }
        public void setRoteirista(Roteirista roteirista) {
            this.roteirista = roteirista;
        }
        public Filme getFilme() {
            return filme;
        }
        public void setFilme(Filme filme) {
            this.filme = filme;
        }
        @Override
        public String toString() {
            return "Roteirista_filme [cod_roteiristaFilme=" + cod_roteiristaFilme + ", roteirista=" + roteirista
                    + ", filme=" + filme + "]";
        } 
    

    
       
    }
    

