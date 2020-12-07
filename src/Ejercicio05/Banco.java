package Ejercicio05;

public class Banco {
    // 5. Crear un programa en java que gestione la entrada de los hilos en secciones críticas
    //con semáforos. En nuestras secciones críticas solo puede entrar un hilo.
    //Para este programa tendremos 4 hilos y unas cantidades asociadas (Andrea 5000,
    //Leonardo 4000, Sansón 6000, Sara 7000). El banco tendrá una variable global
    //“dinero” que representará el dinero global que tiene el banco. Los hilos entrarán a las
    //cámaras acorazadas(secciones críticas) y harán operaciones.
    //Los hilos deberán ejecutarse y hacer lo siguiente:
    //- Avisar de la entrada en el banco.
    //- Avisar que va a solicitar entrada a la cámara acorazada.
    //Dentro de la primera zona crítica:
    //- Avisar la entrada en la cámara acorazada.
    //- Sumar la cantidad del hilo 2 veces al dinero del banco.
    //- Sumarle 1000 al dinero del banco.
    //- Avisar de la salida de la cámara acorazada.
    //Dentro de la segunda zona crítica:
    //- Avisar de la entrada en la cámara acorazada PLUS.
    //- Multiplicar por 2 la cantidad del banco.
    //- Restar la cantidad del hilo a la del banco.
    //- Avisar de la salida de la cámara acorazada PLUS.
    //
    //Todos los hilos avisarán de su nombre al entrar y salir del banco, así como cada vez
    //que realicen una operación.
    //El hilo principal deberá decir cuánto dinero queda al final en la cámara acorazada
    //después del paso de todos los hilos.
}
