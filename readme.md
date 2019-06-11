# Swing sisasisa OSIOSI
### JFrame
Es una clase  que se encarga de dibujar y configurar la ventana donde sucederá la magia, viene de la superclase
```java
javax.swing.JFrame
```
Para usarlo tendremos que crear una clase Ventana que herede de JFrame:
```java
public class Ventana extends JFrame{ //clase que hereda (extends) JFrame
}
```
Ahora algunas referencias para configurar nuestro JFrame
```java
.setTitle("String") //le pone un string de título a esa mondá de ventana.
.setSize(300, 400) //Le ajusta el tamaño a eso
.setResizable(true) //Hace que la ventana sea redimensionable
.setVisible(true) //Pone la visibilidad en verdadero
//ATENCION, al cerrar la ventana, el programa sigue abierto, por lo que toca ordenar que se acabe el programa
//al cerrar el programa
.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) //El comportamiento al cerrar la ventana
```
#### Container
Es el contenedor dentro de la ventana que se encarga de agrupar "Componentes" Botones, etiquetas.

##### Layout
Objeto que se encarga de gestionar la ubicación de los "Componentes"

###### Componentes
Todo lo que se le pone al contenedor de la ventana, organizado por el objeto Layout


Usualmente se crea un método que inicializa toda la interfaz gráfica (dibuja componentes, parametriza) la ventana.

Se debe
- Definir el container
- Establecer el layout
- Agregar componentes gráficos


Los componentes que se van a poner son ATRIBUTOS de la clase, y toca importarlos


- Se declara el componente
```java
private JLabel rotulo;
```
- se crea en el método de inicialización
```java
rotulo = new JLabel();
```
- Se añade el componente 
```java
this.add(rotulo)
```
aldo, en el .add() se puede agregar la configuración del layout
```java
this.add(rotulo, BorderLayout.NORTH)
```

## Definir el contenedor
```java
Container container = getContentPane();
container.setLayout(new FLowLayout);
```

# Eventos

- Cualquier elemento gráfico es una fuente de evento 

### Escucha
Toca crear una clase Estucha, se usa una escucha para múltiples objetos gráficos.
Esta escucha transfiere la acción realizada en el objeto a un evento que actúa según lo programado.


1. La fuente recibe la acción y la ejecuta (?
2. La el evento recibe la escucha y actúa con la acción
3. La escucha recibe la interacción
