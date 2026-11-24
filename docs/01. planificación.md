# 1. Planificación
## 1.1. Planteamiento del problema
En el GameCenter, el encargado registra en un cuaderno qué computadoras y consolas están alquiladas y borra las anotaciones cuando los clientes se retiran. Para controlar la duración de cada alquiler, calcula la hora de término y utiliza el cronómetro de su celular o computadora. Este proceso le toma tiempo y le dificulta saber de un vistazo qué máquinas están disponibles y cuándo quedarán libres las que están en uso.
El encargado también tiene dificultades para organizar los torneos, ya que debe revisar sus anotaciones para identificar qué clientes integran cada equipo y en qué torneo participa. Además, para conocer los ingresos de un período, debe revisar el cuaderno y sumar manualmente los cobros por alquileres e inscripciones. Estas tareas aumentan el tiempo que dedica al registro y la consulta de las operaciones del local.

## 1.2. Objetivo general
Desarrollar un sistema permita al encargado del GameCenter gestionar los clientes, las máquinas y sus tarifas de alquiler, controlar los alquileres, organizar equipos y torneos, y consultar los ingresos del local, para reducir el tiempo dedicado al registro manual y facilitar el seguimiento de las operaciones.

## 1.3. Alcance del sistema
El sistema permitirá al encargado del GameCenter realizar las siguientes operaciones:

| **Área funcional** | **Operaciones incluídas**                                                                                                                                                                                                                                                                                              |
| ------------------ | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Clientes           | Registrar clientes, buscarlos por DNI, modificar sus datos, listarlos y consultar su historial de operaciones.                                                                                                                                                                                                         |
| Máquinas y tipos   | Registrar y listar máquinas, modificar sus datos, cambiar su condición administrativa y actualizar la tarifa por hora de cada tipo de máquina.                                                                                                                                                                         |
| Alquileres         | Registrar alquileres, calcular el importe, el vuelto y la hora de término, y confirmar el pago. Consultar los alquileres activos y el historial. El sistema finalizará cada alquiler al vencer el tiempo y permitirá al encargado finalizarlo antes, previa confirmación.                                              |
| Equipos            | Crear, modificar y listar equipos formados por cinco clientes registrados, y consultar sus integrantes.                                                                                                                                                                                                                |
| Torneos            | Crear y listar torneos, definir cupos y premios, modificar el costo de inscripción e inscribir equipos. Consultar los equipos inscritos, crear las llaves de enfrentamientos y registrar los resultados hasta determinar al ganador. El encargado podrá eliminar un torneo que aún no tenga inscripciones ni partidas. |

