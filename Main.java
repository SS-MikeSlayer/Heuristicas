public class Main {

	static final double EU = 13800;  //Millones de años
	
	public static double log2(double x) {
		return Math.log(x)/Math.log(2);
	}
	
	public static void convertidor(double x) {
		double n = x;
		int cont = 0;   //Los resultados al momento de calcular están en nanosegundos. Este contador lleva el número de conversiones
		
		if(n>=Math.pow(10,9) && cont == 0)  {n = n/Math.pow(10,9);   cont = 3; }  //Si el número es muy grande, convierto de ns a segundos
	     else
		{   if(n>=1000 && cont == 0) {n=n/1000;   cont++; }   //Convierto a microsegundos
		        if(n>=1000 && cont == 1) {n=n/1000;   cont++; }   //Convierto a milisegundos
	                if(n>=1000  && cont == 2) {n=n/1000;   cont++; }   //Convierto a segundos
		}      
		          if(n>=3600 && cont == 3)  {n=n/3600;  cont = 5; }  //Si el número es muy grande, convierto segundos a horas
		       	    else
		       	   {    if(n>=60  && cont == 3) {n=n/60;   cont++; }   //Convierto a minutos
		 	   	  	        if(n>=60 && cont == 4) {n=n/60;   cont++; }   //Convierto a horas
		       	   }		 
		       	         if(n>=8640 && cont == 5) {n=n/8640;  cont = 8; }  //Si el número es muy grande, convierto horas a años
					else
					{
						    if(n>=24 && cont == 5) {n=n/24;   cont++; }   //Convierto a días
						  	    if(n>=30 && cont == 6) {n=n/30;   cont++; }   //Convierto a meses
				      		        if(n>=12 && cont == 7) {n=n/12;   cont++; }   //Convierto a años
					}
							     	    if(n>=1000000 && cont == 8) {n=n/1000000;   cont++; }   //Convierto a millones de años
								         	if(n>=EU && cont == 9) {n=n/EU;   cont++; }   //Convierto a edades del universo
										
			n = (double)Math.round(n * 1000) / 1000;  //Redondeamos n a 4 cifras significativas
									    	
			System.out.print(" " + n);
			
			switch(cont) {
			case 0: System.out.println(" ns"); break;
			case 1: System.out.println(" µs"); break;
			case 2: System.out.println(" ms"); break;
			case 3: System.out.println(" s"); break;
			case 4: System.out.println(" min"); break;
			case 5: System.out.println(" horas"); break;
			case 6: System.out.println(" días"); break;
			case 7: System.out.println(" meses"); break;
			case 8: System.out.println(" años"); break;
			case 9: System.out.println(" millones de años"); break;
			case 10: System.out.println(" edades del universo"); break;
			
			}
	}
	
	public static void main(String[] args) {
		
		long ini = System.nanoTime();
		
		 double n, aux=0;      //n es un valor fijo; aux se empleará para todas las operaciones 
			
			//AQUÍ SE DEFINE LA N. SE RECOMIENDA EMPLEAR Math.pow (base,potencia) SI ES UN NÚMERO ELEVADO BASE 2
			   
			 n = 30;    //Esta variable se modifica MANUALMENTE
			                                        
             System.out.println("n = " + n + "\n");     
            
             //DESDE AQUÍ EMPIEZAN LAS OPERACIONES
             
             aux = log2(n);
             System.out.print("T(n) = log2(n) : ");
             convertidor(aux);
             
             aux = Math.sqrt(n);
             System.out.print("T(n) = √n : ");
             convertidor(aux);
             
             aux = n;
             System.out.print("T(n) = n : ");
             convertidor(aux);
             
             aux = log2(n);
             aux = aux*n;
             System.out.print("T(n) = n*log2(n) : ");
             convertidor(aux);
             
             aux = n*n;
             System.out.print("T(n) = n^2 : ");
             convertidor(aux);
             
             aux = n*n*n;
             System.out.print("T(n) = n^3 : ");
             convertidor(aux);
             
             aux = Math.pow(2,n);
             System.out.print("T(n) = 2^n : ");
             convertidor(aux);
             
             aux = Math.pow(3,n);
             System.out.print("T(n) = 3^n : ");
             convertidor(aux);
             
             aux = Math.pow(n,n);
             System.out.print("T(n) = n^n : ");
             convertidor(aux);
    
            long fin = System.nanoTime();
            
            long tiempo = fin - ini;
            
            System.out.print("\nEste algoritmo se ejecutó en un tiempo de");  convertidor(tiempo);
	}   //Fin de main
}