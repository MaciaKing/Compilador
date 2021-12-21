package compilador.sintactic;

public class descripcion {
    
    public tipoDescripcion tipoDesc;
    public tipoSub tipoS;
    public int tamaño;
    public int limiteInf;
    public int limiteSup;
    public boolean teParametres;
    public String id;
    public boolean valor = false; //Si es falso no tiene valor, si es verdadero tiene valor
    //Constructor vacio
    public descripcion(){
        
    }
    //Constructor dtipus
    public descripcion(tipoDescripcion dt, tipoSub ts , int tamaño, int limiteInf, int limiteSup){
        this.tipoDesc = dt;
        this.tipoS = ts;
        this.tamaño = tamaño;
        this.limiteInf = limiteInf;
        this.limiteSup = limiteSup;
    }
    //Contructor para definiciones 
    public descripcion(tipoDescripcion dt, tipoSub ts){
        this.tipoDesc = dt;
        this.tipoS = ts;
    }
}