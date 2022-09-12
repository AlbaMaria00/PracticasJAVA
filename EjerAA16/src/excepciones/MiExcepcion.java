package excepciones;

public class MiExcepcion extends Exception{
    
    private int codigoError;
     
    public MiExcepcion(int codigoError){
        super();
        this.codigoError=codigoError;
    }
     
    @Override
    public String getMessage(){
         
        String mensaje="";
         
        switch(codigoError){
            case 111:
                mensaje="Error, el archivo no termina en txt";
                break;
//            case 222:
//                mensaje="Error, el numero esta entre 11 y 20";
//                break;
//            case 333:
//                mensaje="Error, el numero esta entre 21 y 30";
//                break;
        }
         
        return mensaje;
         
    }
     
}