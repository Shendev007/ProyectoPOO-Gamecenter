**GAMECENTER**

**Requisitos Funcionales del negocio**

|**Código**|**Requisito**|
| :-: | :-: |
|**RN-01**|**Gestionar los clientes del local, registrando su DNI, nombre, teléfono y nametag.**|
|**RN-02**|**Permitir buscar clientes por DNI y consultar sus datos e historial de operaciones.**|
|**RN-03**|**Gestionar las computadoras y consolas, identificando su tipo y condición administrativa.**|
|**RN-04**|**Gestionar las tarifas por hora de cada tipo de máquina.**|
|**RN-05**|**Registrar alquileres, calculando su importe según la máquina seleccionada y la duración.**|
|**RN-06**|**Gestionar el cobro del alquiler, verificar el dinero recibido y calcular el vuelto.**|
|**RN-07**|**Consultar los alquileres activos y concluidos, y controlar la disponibilidad de las máquinas.**|
|**RN-08**|**Finalizar los alquileres automáticamente al vencer su tiempo o anticipadamente mediante confirmación.**|
|**RN-09**|**Gestionar equipos y sus integrantes para participar en torneos.**|
|**RN-10**|**Gestionar torneos, incluyendo nombre, fecha de inicio, cupos, costo de inscripción, premio y estado.**|
|**RN-11**|**Registrar las inscripciones de los equipos y los integrantes que participarán en cada torneo.**|
|**RN-12**|**Gestionar las partidas y sus resultados para determinar el equipo ganador del torneo.**|
|**RN-13**|**Consultar los ingresos por alquileres e inscripciones, ordenados por fecha y filtrados por período.**|
|**RN-14**|**Conservar los registros históricos de alquileres, inscripciones y resultados de los torneos.**|

**

**Reglas de negocio: clientes**

|**Código**|**Regla**|
| :-: | :-: |
|**RG-01**|**El DNI y el nombre del cliente son obligatorios. El DNI debe contener ocho dígitos.**|
|**RG-02**|**No pueden existir dos clientes registrados con el mismo DNI.**|
|**RG-03**|**El teléfono y el nametag son opcionales. Cuando se registre un teléfono, debe contener nueve dígitos.**|
|**RG-04**|**Un cliente puede alquilar máquinas sin pertenecer a un equipo ni participar en torneos.**|

**Reglas de negocio: máquinas y tarifas**

|**Código**|**Regla**|
| :-: | :-: |
|**RG-05**|**Cada máquina pertenece a un único tipo: Computadora o Consola.**|
|**RG-06**|**La tarifa se establece por tipo de máquina. Las tarifas iniciales son S/5,00 por hora para computadoras y S/4,00 para consolas.**|
|**RG-07**|**La tarifa por hora debe ser mayor que cero.**|
|**RG-08**|**La condición administrativa de una máquina puede ser Habilitada, Mantenimiento o Retirada.**|
|**RG-09**|**Solo puede alquilarse una máquina habilitada que no tenga un alquiler activo.**|
|**RG-10**|**No se puede cambiar una máquina a mantenimiento o retirada mientras tenga un alquiler activo.**|
|**RG-11**|**Una máquina retirada puede volver a habilitarse. Su historial se conserva.**|
|**RG-12**|**Cambiar una tarifa no modifica los importes de los alquileres registrados anteriormente.**|

**

**Reglas de negocio: alquileres**

|**Código**|**Regla**|
| :-: | :-: |
|**RG-13**|**Cada alquiler corresponde a un cliente y una máquina existentes.**|
|**RG-14**|**Un cliente no puede tener más de un alquiler activo simultáneamente.**|
|**RG-15**|**Una máquina no puede tener más de un alquiler activo simultáneamente.**|
|**RG-16**|**Las duraciones permitidas son 30 minutos y períodos de una a ocho horas completas.**|
|**RG-17**|**El importe se calcula multiplicando la tarifa por hora por la duración en minutos dividida entre 60.**|
|**RG-18**|**El alquiler se paga al inicio. El dinero recibido debe ser suficiente y el registro requiere confirmar el pago.**|
|**RG-19**|**El estado del alquiler puede ser Activo o Concluido.**|
|**RG-20**|**Al vencer el tiempo, el alquiler debe concluir y la máquina debe quedar disponible si continúa habilitada.**|
|**RG-21**|**La finalización anticipada requiere confirmación y no genera devolución.**|
|**RG-22**|**Al iniciar el programa, deben revisarse y concluirse los alquileres cuyo tiempo ya haya vencido.**|
|**RG-23**|**Los alquileres concluidos conservan el importe cobrado y permanecen en el historial.**|

**

**Reglas de negocio: equipos, torneos e inscripciones**

|**Código**|**Regla**|
| :-: | :-: |
|**RG-24**|**Cada equipo debe estar formado por cinco clientes registrados.**|
|**RG-25**|**Un cliente no puede aparecer repetido dentro del mismo equipo.**|
|**RG-26**|**Los cupos del torneo representan la cantidad máxima de equipos inscritos, no la cantidad de jugadores.**|
|**RG-27**|**Según la restricción definida en la base de datos, los cupos permitidos son 4, 8 o 16 equipos.**|
|**RG-28**|**Un equipo no puede inscribirse más de una vez en el mismo torneo.**|
|**RG-29**|**No se pueden registrar inscripciones que superen los cupos del torneo.**|
|**RG-30**|**Cada inscripción debe registrar a los cinco integrantes del equipo que participarán en ese torneo.**|
|**RG-31**|**El importe de la inscripción corresponde al costo establecido para el torneo y debe conservarse como dato histórico.**|
|**RG-32**|**El premio del torneo debe ser mayor que cero.**|
|**RG-33**|**Los estados del torneo son Inscripciones abiertas, Preparado, En curso y Finalizado.**|
|**RG-34**|**Las inscripciones se realizan mientras el torneo tenga las inscripciones abiertas y existan cupos disponibles.**|
|**RG-35**|**El torneo pasa a Preparado cuando se completan sus cupos y sus participantes están definidos.**|

**

**Reglas de negocio: partidas**

|**Código**|**Regla**|
| :-: | :-: |
|**RG-36**|**Cada partida pertenece a un torneo.**|
|**RG-37**|**Las dos inscripciones enfrentadas deben ser distintas y pertenecer al mismo torneo de la partida.**|
|**RG-38**|**El ganador debe ser una de las dos inscripciones enfrentadas.**|
|**RG-39**|**El equipo que gana avanza a la siguiente ronda y el que pierde queda eliminado.**|
|**RG-40**|**No pueden existir dos partidas con el mismo número dentro de la misma ronda y torneo.**|
|**RG-41**|**El número de partida y la ronda deben ser mayores que cero.**|
|**RG-42**|**El torneo finaliza cuando se registra el resultado de la final y queda determinado su ganador.**|

