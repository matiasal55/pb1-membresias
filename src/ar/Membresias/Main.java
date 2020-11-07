import ar.Membresias.Artista;
import ar.Membresias.Membresia;

import java.util.Scanner;

public class Main{
    public static void main(String [] args) {
        // Inicialiće teclado
        Scanner teclado=new Scanner(System.in);
        // Bandas
        Artista aquiver=Artista.AQUIVERT;
        Artista hiraeth=Artista.HIRAETH;
        Artista iridescent=Artista.IRIDESCENDT;
        // Inicializacion membresia
        Membresia free=new Membresia("Free",0,"Acceso a previews de álbumes, transmisiones en vivo sin posibilidad de realizar comentarios,\nsubtítulos solo disponibles para contenido que no sea en vivo.\n *Solo para uso en dispositivos móviles");
        Membresia gold=new Membresia("Gold",20,"Acceso a todos los álbumes en formato standard, transmisiones en vivo con posibilidad de \nrealizar comentarios, subtítulos disponibles para contenido en vivo. \n*Para uso en dispositivos móviles y web");
        Membresia platinum=new Membresia("Platinum",30,"Acceso a todos los álbumes en formato standard, transmisiones en vivo con posibilidad de \nrealizar comentarios, subtítulos disponibles para contenido en vivo.\n*Para uso en dispositivos móviles, web y SmartTv");
        // Opcion de artista ingresada por el usuario
        int opcionArtista;
        // Opcion de membresía ingresada por el usuario
        int opcionMembresia=0;
        // Suma el total de los importes
        int totalCompra=0;
        // El while lo hago por si el usuario, estando en el menú de membresias, quiere volver al menú de artistas
        while(opcionMembresia==0) {
            // Para que muestre el mensaje de Ingrese una opcion valida
            int banderaError=0;
            // De primera el usuario ingresa una opcion.
            do {
                // Esto evita que se muestre la primera vez
                if(banderaError>0)
                    System.out.println("Ingrese una opcion válida");
                // Llama al método ubicado más abajo
                menuPrincipal(aquiver, hiraeth, iridescent);
                opcionArtista = teclado.nextInt();
                // Activa la visualizacion del mensaje en caso que se ingrese una opción incorrecta
                banderaError++;

            } while (opcionArtista < 0 || opcionArtista > 3); // Si el usuario elige una opcion incorrecta vuelve a solicitar que ingrese una opción
            // Si el usuario ingresa Salir, sale del sistema con un mensaje previo
            if (opcionArtista == 0) {
                System.out.println("Muchas gracias por su visita");
                System.exit(0);
            }
            // Inicializa la variable con null porque me lo pidió el programa
            // Guarda el artista elegido
            Artista artistaElegido=null;
            // Asigna el valor del artista elegido en función de la opción que ingresa el usuario
            switch (opcionArtista){
                case 1: artistaElegido=aquiver;break;
                case 2: artistaElegido=hiraeth;break;
                case 3: artistaElegido=iridescent;
            }
            // Vuelve a ser cero para el próximo ingreso
            banderaError=0;
            // Misma situación que cuando elige el artista. Acá elige la opción de membresía
            do {
                if(banderaError>0)
                    System.out.println("Ingrese una opcion válida");
                menuMembresias(free, gold, platinum);
                opcionMembresia = teclado.nextInt();
                banderaError++;
            } while (opcionMembresia < 0 || opcionMembresia > 3);
            // En caso que el usuario elija volver al menú principal se dirige al comienzo del while
            // Sino, se guarda la membresia elegida en funcion de la opcion elegida por el usuario
            if(opcionMembresia!=0){
                Membresia membresiaElegida=null;
                switch (opcionMembresia){
                    case 1: membresiaElegida=free;break;
                    case 2: membresiaElegida=gold;break;
                    case 3: membresiaElegida=platinum;
                }
                // Informacion de la membresia elegida
                System.out.println("Membresia membresiaElegida: ");
                System.out.println("Artista: "+artistaElegido);
                System.out.println("Membresia: "+membresiaElegida.getNombre());
                System.out.println("Precio: "+membresiaElegida.getPrecio());
                // Se va sumando al total
                totalCompra+=membresiaElegida.getPrecio();
                // Nueva membresia?
                System.out.println("Desea agregar una nueva membresia: \n1 - Si\n2 - No");
                int opcionNuevaMembresia=teclado.nextInt();
                // Si elige adquirir una nueva membresia, se asigna cero a opcionMembresia para que no salga del while
                // Si elige no adquirir mas membresias, la variable opcionMembresia no es cero porque habia elegido una membresia, por ende sale del while.
                if(opcionNuevaMembresia==1)
                    opcionMembresia=0;
            }

        }
        // Informa el total y se despide
        System.out.println("Su total es de: "+totalCompra);
        System.out.println("Muchas gracias por su compra");
    }

    public static void menuPrincipal(Artista artista1, Artista artista2, Artista artista3){
        System.out.println("Bienvenido al Sistema de membresías. En primer lugar elija una de nuestros artistas: ");
        System.out.println("Tené en cuenta que una vez que compres tu membresía solo la vas a poder utilizar para el artista que seleccionaste.");
        System.out.println("1 - "+artista1);
        System.out.println("2 - "+artista2);
        System.out.println("3 - "+artista3);
        System.out.println("0 - Salir");
    }

    public static void menuMembresias(Membresia membresia1, Membresia membresia2, Membresia membresia3){
        System.out.println("Una vez elegido el artista, elija una de nuestras membresias");
        System.out.println("1 - "+membresia1.getNombre());
        System.out.println("Precio: USD "+membresia1.getPrecio());
        System.out.println(membresia1.getDetalles());
        System.out.println("2 - "+membresia2.getNombre());
        System.out.println("Precio: USD "+membresia2.getPrecio());
        System.out.println(membresia2.getDetalles());
        System.out.println("3 - "+membresia3.getNombre());
        System.out.println("Precio: USD "+membresia3.getPrecio());
        System.out.println(membresia3.getDetalles());
        System.out.println("0 - Volver al menú principal");
    }
}