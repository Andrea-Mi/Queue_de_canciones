Simulación Tipo Spotify con Cola FIFO en Java

Este proyecto implementa una simulación de reproducción musical tipo Spotify utilizando una estructura de datos Cola (FIFO) desarrollada completamente desde cero en Java.

Se trabajó con arquitectura modular usando Maven, separando la estructura de datos en una librería independiente (queue) y un proyecto consumidor (queueHandler).

Librería de Cola

Se implementó una cola enlazada genérica QueueLinked con:

Clase Node

Referencias privadas head y tail

Variable interna size

Métodos: enqueue(), dequeue(), peek(), isEmpty(), size()

Complejidad O(1) en enqueue y dequeue

Excepción IllegalStateException al hacer dequeue() en cola vacía

No se utilizaron estructuras del JDK como Queue, LinkedList o ArrayDeque.

Instalación de la librería:

cd queue mvn clean install

Simulación de Reproducción

Se creó una clase Song con:

title

artist

duration (5–30 segundos)

priority (1 = alta, 2 = normal)

La simulación reproduce cada canción segundo a segundo usando:

Thread.sleep(1000);

Se muestran logs en consola:

[LOG] Starting playlist...

[LOG] Now playing: ...

Progreso por segundo

[LOG] Finished: ...

[LOG] Playlist finished.

La ejecución es completamente desde consola.

Sistema de Prioridad

Se implementó una clase MusicQueue con dos colas internas:

Alta prioridad

Prioridad normal

Las canciones con prioridad 1 se reproducen antes que las de prioridad 2, respetando FIFO dentro de cada grupo.

No se utilizó PriorityQueue.

🚀 Extensiones Implementadas

Se implementaron las siguientes mejoras:

Contador total de canciones reproducidas

Tiempo total acumulado reproducido

Barra de progreso visual

Cómo Ejecutar

Instalar librería:

cd queue mvn clean install

Compilar y ejecutar el handler:

cd queueHandler mvn clean package mvn exec:java