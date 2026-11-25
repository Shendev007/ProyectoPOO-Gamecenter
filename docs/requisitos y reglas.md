# 2. Análisis de requisitos
Los requisitos funcionales (RF) describen las operaciones que el sistema permite realizar. Las reglas de negocio (RN) establecen las condiciones que deben cumplirse en esas operaciones. Ambos se organizan por módulo.
## 2.1. Clientes
### 2.1.1. Requisitos funcionales

| Código | Requisito funcional                                                                                                                                      |
| ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RF-01  | El sistema debe permitir al encargado registrar un cliente con su DNI y nombre. Durante el registro, el encargado puede añadir un teléfono y un nametag. |
| RF-02  | El sistema debe permitir al encargado buscar un cliente por DNI y consultar sus datos.                                                                   |
| RF-03  | El sistema debe permitir al encargado editar los siguientes datos de un cliente registrado: DNI, teléfono y nametag.                                     |
| RF-04  | El sistema debe permitir al encargado consultar la lista de clientes registrados.                                                                        |
| RF-05  | El sistema debe permitir al encargado consultar el historial de operaciones de un cliente.                                                               |
### 2.1.2. Reglas de negocio

| Código | Reglas de negocio                                                                                                                                 |
| ------ | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| RN-01  | El DNI y el nombre son obligatorios para registrar un cliente.                                                                                    |
| RN-02  | El DNI debe contener exactamente ocho dígitos y ser único para cada cliente. Esta regla se aplica tanto al registro como a la corrección del DNI. |
| RN-03  | El teléfono y el nametag son opcionales. Si se proporciona un teléfono, debe contener exactamente nueve dígitos.                                  |
| RN-04  | Un cliente puede alquilar una máquina sin pertenecer a un equipo ni participar en torneos.                                                        |
## 2.2. Máquinas y tipos
### 2.2.1. Requisitos funcionales

| Código | Requisito funcional                                                                                                                             |
| ------ | ----------------------------------------------------------------------------------------------------------------------------------------------- |
| RF-06  | El sistema debe permitir al encargado registrar una máquina indicando su nombre y tipo.                                                         |
| RF-07  | El sistema debe permitir al encargado listar las máquinas y consultar su nombre, tipo, condición administrativa y disponibilidad para alquiler. |
| RF-08  | El sistema debe permitir al encargado modificar el nombre de una máquina registrada.                                                            |
| RF-09  | El sistema debe permitir al encargado cambiar la condición administrativa de una máquina, incluida la reactivación de una máquina retirada.     |
| RF-10  | El sistema debe permitir al encargado consultar y modificar la tarifa por hora de cada tipo de máquina.                                         |
### 2.2.2. Reglas de negocio

| Código | Regla de negocio                                                                                                                                                     |
| ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RN-05  | Cada máquina pertenece a un único tipo: computadora o consola.                                                                                                       |
| RN-06  | La tarifa por hora se establece por tipo de máquina y debe ser mayor que cero. Las tarifas iniciales son S/ 5,00 para computadoras y S/ 4,00 para consolas.          |
| RN-07  | La condición administrativa de una máquina puede ser habilitada, en mantenimiento o retirada.                                                                        |
| RN-08  | Una máquina está disponible para alquiler cuando está habilitada y no tiene un alquiler activo.                                                                      |
| RN-09  | Una máquina con un alquiler activo debe permanecer habilitada hasta que concluya el alquiler.                                                                        |
| RN-10  | Una máquina retirada puede volver a habilitarse. Los cambios de condición administrativa deben conservar su historial de alquileres.                                 |
| RN-11  | La modificación de una tarifa se aplica a los nuevos alquileres. Los alquileres ya registrados conservan el importe calculado con la tarifa vigente al registrarlos. |
## 2.3. Alquileres
### 2.3.1. Requisitos funcionales

| Código | Requisito funcional                                                                                                                                                                      |
| ------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RF-11  | El sistema debe permitir al encargado seleccionar un cliente registrado, una máquina disponible y la duración del alquiler.                                                              |
| RF-12  | El sistema debe calcular el importe del alquiler según la tarifa por hora y la duración seleccionada.                                                                                    |
| RF-13  | El sistema debe permitir al encargado ingresar el dinero recibido, consultar el vuelto y confirmar el pago para registrar el alquiler.                                                   |
| RF-14  | Al registrar el alquiler, el sistema debe guardar la fecha y hora de inicio y calcular la fecha y hora previstas de término.                                                             |
| RF-15  | El sistema debe permitir al encargado consultar los alquileres activos, su hora prevista de término y el historial de alquileres concluidos.                                             |
| RF-16  | El sistema debe concluir automáticamente el alquiler cuando venza el tiempo contratado. Al iniciar el programa, debe revisar los alquileres activos y concluir los que ya hayan vencido. |
| RF-17  | El sistema debe permitir al encargado finalizar anticipadamente un alquiler activo cuando el cliente se retire, previa confirmación del encargado.                                       |
### 2.3.2. Reglas de negocio

| Código | Regla de negocio                                                                                                                                                                                     |
| ------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RN-12  | Cada alquiler corresponde a un cliente registrado y a una máquina que esté disponible al iniciar la operación.                                                                                       |
| RN-13  | Cada cliente puede tener como máximo un alquiler activo a la vez.                                                                                                                                    |
| RN-14  | Cada máquina puede tener como máximo un alquiler activo a la vez.                                                                                                                                    |
| RN-15  | Las duraciones permitidas son 30 minutos o una cantidad entera de horas entre una y ocho.                                                                                                            |
| RN-16  | El importe del alquiler se calcula multiplicando la tarifa por hora por la duración en minutos y dividiendo el resultado entre 60.                                                                   |
| RN-17  | El alquiler se paga al inicio. Para activarlo, el dinero recibido debe cubrir el importe y el encargado debe confirmar el pago. El vuelto equivale al dinero recibido menos el importe del alquiler. |
| RN-18  | Un alquiler registrado puede estar activo o concluido. Cuando concluye, la máquina vuelve a estar disponible si continúa habilitada.                                                                 |
| RN-19  | La finalización anticipada requiere confirmación y no genera devolución por el tiempo sin utilizar.                                                                                                  |
| RN-20  | Los alquileres concluidos permanecen en el historial con el importe cobrado.                                                                                                                         |
## 2.4. Equipos
### 2.4.1. Requisitos funcionales

| Código | Requisito funcional                                                                                                                               |
| ------ | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| RF-18  | El sistema debe permitir al encargado crear un equipo indicando su nombre y seleccionando a sus cinco integrantes entre los clientes registrados. |
| RF-19  | El sistema debe permitir al encargado modificar el nombre del equipo y sustituir integrantes.                                                     |
| RF-20  | El sistema debe permitir al encargado listar los equipos registrados y consultar los integrantes de cada uno.                                     |
### 2.4.2. Reglas de negocio

| Código | Requisito funcional                                                                                                                                            |
| ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RN-21  | Cada equipo debe estar formado por cinco clientes registrados y distintos entre sí. Al sustituir integrantes, el equipo debe seguir cumpliendo esta condición. |
| RN-22  | La modificación de un equipo debe conservar la alineación registrada en las inscripciones anteriores.                                                          |
## 2.5. Torneos, inscripciones y partidas
### 2.5.1. Requisitos funcionales

| Código | Requisito funcional                                                                                                                                                                    |
| ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RF-21  | El sistema debe permitir al encargado crear un torneo indicando su nombre, fecha de inicio, cantidad de cupos, costo de inscripción y premio.                                          |
| RF-22  | El sistema debe permitir al encargado listar los torneos y consultar el estado, los cupos disponibles, los equipos inscritos y la alineación de cada equipo en un torneo seleccionado. |
| RF-23  | El sistema debe permitir al encargado modificar el costo de inscripción de un torneo.                                                                                                  |
| RF-24  | El sistema debe permitir al encargado inscribir un equipo en un torneo y registrar los cinco integrantes que lo representarán y el importe de la inscripción.                          |
| RF-25  | El sistema debe permitir al encargado eliminar un torneo vacío, previa confirmación.                                                                                                   |
| RF-26  | El sistema debe permitir al encargado iniciar un torneo preparado y crear sus llaves de eliminación directa con los equipos inscritos.                                                 |
| RF-27  | El sistema debe permitir al encargado consultar los enfrentamientos por ronda y registrar el ganador de cada partida.                                                                  |
| RF-28  | El sistema debe determinar qué equipos avanzan a la siguiente ronda y registrar al campeón cuando se resuelva la final.                                                                |
### 2.5.2. Reglas de negocio

| Código | Regla de negocio                                                                                                                                                          |
| ------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| RN-23  | Los cupos se cuentan por equipo. Cada torneo admite 4, 8 o 16 equipos.                                                                                                    |
| RN-24  | El premio del torneo debe ser mayor que cero.                                                                                                                             |
| RN-25  | Los estados del torneo son _Inscripciones abiertas_, _Preparado_, _En curso_ y _Finalizado_.                                                                              |
| RN-26  | Un equipo puede inscribirse mientras las inscripciones estén abiertas y quede al menos un cupo disponible. Cada equipo puede inscribirse una sola vez en el mismo torneo. |
| RN-27  | Cada inscripción fija una alineación de cinco integrantes. Un cliente solo puede representar a un equipo en el mismo torneo.                                              |
| RN-28  | El importe de cada inscripción corresponde al costo vigente al registrarla. Si ese costo cambia, las inscripciones anteriores conservan su importe.                       |
| RN-29  | Un torneo puede eliminarse mientras tenga las inscripciones abiertas y carezca de inscripciones y partidas registradas.                                                   |
| RN-30  | El torneo pasa a _Preparado_ cuando se completan los cupos y quedan definidas las alineaciones. Al iniciar la competencia, pasa a _En curso_.                             |
| RN-31  | Cada partida pertenece a un torneo y enfrenta a dos equipos distintos inscritos en ese mismo torneo.                                                                      |
| RN-32  | El ganador de una partida debe ser uno de los dos equipos enfrentados. El ganador avanza y el perdedor queda eliminado.                                                   |
| RN-33  | La ronda y el número de partida deben ser mayores que cero. Dentro de una misma ronda y torneo, cada partida debe tener un número distinto.                               |
| RN-34  | Al registrarse el ganador de la final, ese equipo queda como campeón y el torneo pasa a _Finalizado_.                                                                     |
## 2.6. Consulta de ingresos
### 2.6.1. Requisitos funcionales

| Código | Requisito funcional                                                                                                                       |
| ------ | ----------------------------------------------------------------------------------------------------------------------------------------- |
| RF-29  | El sistema debe permitir al encargado consultar los ingresos por alquileres e inscripciones, ordenados por fecha y filtrados por período. |
| RF-30  | Para el período seleccionado, el sistema debe mostrar el subtotal por alquileres, el subtotal por inscripciones y el total recaudado.     |

### 2.6.2. Reglas de negocio

| Código | Regla de negocio                                                                                                               |
| ------ | ------------------------------------------------------------------------------------------------------------------------------ |
| RN-35  | Cada cobro se contabiliza según la fecha en que se recibió y por el importe registrado en la operación.                        |
| RN-36  | El total recaudado del período se obtiene sumando los ingresos por alquileres y los ingresos por inscripciones de ese período. |
