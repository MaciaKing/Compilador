package compilador.sintactic;

public class descripcion {

    public tipoDescripcion tipoDesc;
    public tipoSub tipoS;
    public int tamaño;
    public int limiteInf;
    public int limiteSup;
    public boolean teParametres;
    public String id;
    public String valor; //Si es falso no tiene valor, si es verdadero tiene valor
    public int np;
    public int nv;
    public int cantParamInt = 0;
    public int cantParamBool = 0;
    public Etiqueta etP;

    //Constructor vacio
    public descripcion() {

    }

    //Constructor dtipus
    public descripcion(tipoDescripcion dt, tipoSub ts, int tamaño, int limiteInf, int limiteSup) {
        this.tipoDesc = dt;
        this.tipoS = ts;
        this.tamaño = tamaño;
        this.limiteInf = limiteInf;
        this.limiteSup = limiteSup;
    }

    //Contructor para variables 
    public descripcion(tipoDescripcion dt, tipoSub ts) {
        this.tipoDesc = dt;
        this.tipoS = ts;
    }

    //Constructor para constantes
    public descripcion(tipoDescripcion dt, String valor, tipoSub ts) {
        this.tipoDesc = dt;
        this.valor = valor;
        this.tipoS = ts;
    }

    //Constructor para subprogramas
    public descripcion(tipoDescripcion dt, int np, boolean tp, Etiqueta e) {
        this.tipoDesc = dt;
        this.np = np;
        this.teParametres = tp;
        this.etP = e;
    }

    //Constructor para arg
    public descripcion(tipoDescripcion dt, int nv, tipoSub ts) {
        this.tipoDesc = dt;
        this.nv = nv;
        this.tipoS = ts;
    }

    public void setTipusSub(tipoSub ts) {
        this.tipoS = ts;
    }
    
}
